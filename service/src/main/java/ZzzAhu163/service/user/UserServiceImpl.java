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
 *@author Zzz_Ahu_163
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
        return userServiceMapper.queryUserList(filter);
    }

    @Override
    public User queryUser(@NonNull  UserQueryFilter filter) {
        List<User> users = queryUserList(filter);
        if (users == null) {
            return null;
        }
        //填充UserGroup
        User user = users.get(0);
        List<Integer> idList = queryUserGroupIdListById(user.getId());
        //带权限的UserGroup
        List<UserGroup> groupList = userGroupService.queryUserGroupList(idList);
        user.setUserGroups(groupList);
        return user;
    }

    @Override
    public User queryUserAll(@NonNull UserQueryFilter filter) {
        User user = queryUser(filter);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public List<Integer> queryUserGroupIdListById(int userId) {
        return userServiceMapper.queryUserGroupIdListById(userId);
    }

  @Override
  public List<User> queryUserList(UserQueryFilter filter) {
    return null;
  }
}
