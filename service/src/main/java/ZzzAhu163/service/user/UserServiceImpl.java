package ZzzAhu163.service.user;

import ZzzAhu163.base.user.*;
import ZzzAhu163.base.user.filter.UserQueryFilter;
import ZzzAhu163.mapper.user.UserGroupMapper;
import ZzzAhu163.mapper.user.UserServiceMapper;
import lombok.Data;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
  private void fillUserInfo(@NonNull User user) {
    int userId = user.getId();
    if (userId <= 0) {
      return;
    }
    List<UserGroup> userGroupList = userGroupService.queryUserGroupListByUserId(user.getId());
    if (userGroupList == null) {
      user = null;
      return;
    }
    user.setUserGroups(userGroupList);
    mergeAuthorities(user);
  }

  //合并用户的权限
  private void mergeAuthorities(User user) {
    if (user == null) {
      return;
    }
    UserRole userRole = user.getUserRole();
    if (userRole.equals(UserRole.UNKNOWN)) {
      //1、没有任何权限
      user = null;
    } else if (userRole.equals(UserRole.ROLE_NORMAL) || userRole.equals(UserRole.ROLE_ADMIN)) {
      //2、有组权限
      Set<GrantedAuthority> set = new HashSet<>();
      for (UserGroup userGroup : user.getUserGroups()) {
        set.addAll(userGroup.getAuthorities());
      }
      user.setAuthorities(new ArrayList<>(set));
    } else if (userRole.equals(UserRole.ROLE_ADMIN)) {
      //3、TODO:额外享有个人权限，暂时不支持该功能
    }
  }
}
