package ZzzAhu163.service.user;

import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.filter.UserGroupQueryFilter;
import ZzzAhu163.mapper.user.UserGroupMapper;
import lombok.Data;
import lombok.NonNull;
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
  @Resource
  private AuthorityService authorityService;

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
  public int queryUserGroupListCount(@NonNull UserGroupQueryFilter filter) {
    return userGroupMapper.queryUserGroupListCount(filter);
  }

  @Override
  public List<UserGroup> querySimpleUserGroupList(@NonNull UserGroupQueryFilter filter) {
    int count = 0;
    count = queryUserGroupListCount(filter);
    if (count <= 0) {
      return null;
    }
    return userGroupMapper.querySimpleUserGroupList(filter);
  }

  @Override
  public List<UserGroup> querySimpleUserGroupByIdList(@NonNull List<Integer> idList) {
    if (idList.size() == 0) {
      return null;
    }
    return userGroupMapper.querySimpleUserGroupListByIdList(idList);
  }

  @Override
  public List<Integer> queryUserGroupIdListByUserId(int userId) {
    if (userId <= 0) {
      return null;
    }
    return userGroupMapper.queryUserGroupIdListByUserId(userId);
  }

  @Override
  public List<UserGroup> querySimpleUserGroupListByUserId(int userId) {
    //先查询UserGroupIdList
    List<Integer> idList = queryUserGroupIdListByUserId(userId);
    //再根据idList查询UserGroup
    List<UserGroup> userGroupList = querySimpleUserGroupByIdList(idList);
    return userGroupList;
  }
}

