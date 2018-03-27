package ZzzAhu163.service.user;

import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.filter.UserQueryFilter;
import ZzzAhu163.mapper.user.UserGroupMapper;
import ZzzAhu163.mapper.user.UserServiceMapper;
import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
  public User queryUserById(int id) {
    return null;
  }

  @Override
  public User queryUserByName(String name) {
    return null;
  }

  @Override
  public User querySimpleUserByName(@NonNull String name) {
    UserQueryFilter filter = new UserQueryFilter();
    filter.setName(name);
    List<User> list =  querySimpleUserList(filter);
    if (list == null){
      return null;
    }
    return list.get(0);
  }

  //填充User的用户组信息
  private void fillUserInfo(@NonNull User user) throws Exception {
    if (user.getId() <= 0) {
      throw new Exception("fillUserInfo but User Id is Illegal");
    }
    int userId = user.getId();
    //TODO:填充UserGroup
    List<UserGroup> userGroupList = userGroupService.querySimpleUserGroupListByUserId(userId);
    user.setUserGroups(userGroupList);
  }
}
