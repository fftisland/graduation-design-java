package ZzzAhu163.service.user;

import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.filter.UserGroupQueryFilter;
import ZzzAhu163.base.user.filter.UserQueryFilter;
import ZzzAhu163.mapper.user.UserGroupMapper;
import lombok.Data;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 **/
@Data
@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService {
    @Resource
    private UserGroupMapper userGroupMapper;

    @Override
    public boolean insertUserGroup(UserGroup userGroup) {
        return false;
    }

    @Override
    public boolean deleteUserGroupById(int id) {
        return false;
    }

    @Override
    public boolean updateUserGroup(UserGroup userGroup) {
        return false;
    }

    @Override
    public int queryUserGroupListCount(UserGroupQueryFilter filter) {
        return userGroupMapper.queryUserGroupListCount(filter);
    }

    @Override
    public List<UserGroup> queryUserGroupList(UserGroupQueryFilter filter) {
        int count = queryUserGroupListCount(filter);
        if (count <= 0) {
            return null;
        }
        List<UserGroup> list = userGroupMapper.queryUserGroupList(filter);
        //TODO:遍历填充权限
        return list;
    }

    @Override
    public UserGroup querySimpleUserGroup(UserGroupQueryFilter filter) {
        return null;
    }
}

