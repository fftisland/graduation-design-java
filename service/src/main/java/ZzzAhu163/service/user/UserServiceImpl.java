package ZzzAhu163.service.user;

import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.filter.UserQueryFilter;
import ZzzAhu163.mapper.user.UserServiceMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 *@author Zzz_Ahu_163
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserServiceMapper userServiceMapper;

    @Override
    public int queryUserListCount(@NonNull UserQueryFilter filter) {
        return userServiceMapper.queryUserListCount(filter);
    }

    @Override
    public List<User> queryUserList(@NonNull UserQueryFilter filter) {
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
        return users.get(0);
    }

    @Override
    public User queryUserAll(@NonNull UserQueryFilter filter) {
        User user = queryUser(filter);
        if (user == null) {
            return null;
        }
        return user;
    }
}
