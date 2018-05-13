package ZzzAhu163.service.user;

import ZzzAhu163.base.authority.AuthorityQueryFilter;
import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.base.authority.DataType;
import ZzzAhu163.base.user.*;
import ZzzAhu163.base.user.filter.UserQueryFilter;
import ZzzAhu163.mapper.user.UserServiceMapper;
import lombok.Data;
import lombok.NonNull;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zzz_Ahu_163
 **/
@Service("userService")
@Data
public class UserServiceImpl implements UserService {
  @Resource
  private UserServiceMapper userServiceMapper;
  @Resource
  private UserGroupService userGroupService;
  @Resource
  private AuthorityService authorityService;

  @Override
  public int queryUserListCount(@NonNull UserQueryFilter filter) {
    return userServiceMapper.queryUserListCount(filter);
  }

  @Override
  public List<User> querySimpleUserList(@NonNull UserQueryFilter filter) {
    int count = queryUserListCount(filter);
    if (count <= 0) {
      return null;
    }
    return userServiceMapper.querySimpleUserList(filter);
  }

  @Override
  public User querySimpleUserById(int id) {
    UserQueryFilter filter = new UserQueryFilter(id);
    List<User> list = userServiceMapper.querySimpleUserList(filter);
    if (list != null) {
      return list.get(0);
    }
    return null;
  }

  //带权限的UserList
  @Override
  public List<User> queryUserList(UserQueryFilter filter) {
    return null;
  }

  //带权限的User
  @Override
  public User queryUserById(int id){
    User user = querySimpleUserById(id);
    if (user == null) {
      return null;
    }
    fillUserInfo(user);
    return user;
  }

  @Override
  public User queryUserByName(String name) {
    User simpleUser = querySimpleUserByName(name);
    if (simpleUser == null || simpleUser.getId() <= 0) {
      return null;
    }
    fillUserInfo(simpleUser);
    return simpleUser;
  }

  @Override
  public User querySimpleUserByName(@NonNull String name) {
    UserQueryFilter filter = new UserQueryFilter();
    filter.setName(name);
    List<User> list = querySimpleUserList(filter);
    if (list == null) {
      return null;
    }
    return list.get(0);
  }

  @Override
  public User querySimpleUserByEmail(String email) {
    if (StringUtils.isBlank(email)) {
      return null;
    }
    User user = new User();
    user.setEmail(email);
    UserQueryFilter filter = new UserQueryFilter(user);
    List<User> list = querySimpleUserList(filter);
    if (list == null) {
      return null;
    }
    return list.get(0);
  }

  @Override
  public Boolean insertUser(User user) {
    if (user == null || user.getId() > 0) {
      return false;
    }
    userServiceMapper.insertUser(user);
    if (user.getId() <= 0) {
      return false;
    }
    //插入到普通用户组
    List<User> userList = new ArrayList<>();
    userList.add(user);
    return userGroupService.insertUserListIntoUserGroup(userList, UserGroupType.GROUP_USER);
  }

  //填充User的用户组信息
  private void fillUserInfo(User user) {
    if (user == null || user.getId() <= 0) {
      return;
    }
    int userId = user.getId();
    List<UserGroup> userGroupList = userGroupService.queryUserGroupListByUserId(user.getId());
    if (userGroupList == null) {
      return;
    }
    user.setUserGroups(userGroupList);
    mergeAuthorities(user);
  }

  private void mergeAuthorities(User user) {
    if (user == null || user.getId() <= 0) {
      return;
    }
    UserRole userRole = user.getUserRole();
    Set<GrantedAuthority> set = new HashSet<>();
    if (UserRole.UNKNOWN.equals(userRole)) {
      //1、没有任何权限
      user.setAuthorities(null);
      return;
    }
    if (UserRole.ROLE_NORMAL.equals(userRole) || UserRole.ROLE_ADMIN.equals(userRole)) {
      //2、有组权限
      for (UserGroup userGroup : user.getUserGroups()) {
        if (CollectionUtils.isNotEmpty(userGroup.getAuthorities())) {
          set.addAll(userGroup.getAuthorities());
        }
      }
    }
    if (UserRole.ROLE_ADMIN.equals(userRole)) {
      //3、有个人权限
      List<AuthorityRole> personalRoleList =
              authorityService.queryDataAuthorityList(new AuthorityQueryFilter(DataType.USER, user.getId()));
      if (CollectionUtils.isNotEmpty(personalRoleList)) {
        set.addAll(personalRoleList);
      }
    }
    if (CollectionUtils.isNotEmpty(set)) {
      user.setAuthorities(new ArrayList<>(set));
    }
  }
}
