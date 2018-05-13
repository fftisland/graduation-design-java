package ZzzAhu163.service.user;

import ZzzAhu163.base.authority.AuthorityQueryFilter;
import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.base.authority.DataType;
import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.UserGroupType;
import ZzzAhu163.base.user.filter.UserGroupQueryFilter;
import ZzzAhu163.mapper.user.UserGroupMapper;
import lombok.Data;
import lombok.NonNull;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
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
  public int queryUserGroupListCount(UserGroupQueryFilter filter) {
    if (filter == null) {
      return 0;
    }
    return userGroupMapper.queryUserGroupListCount(filter);
  }

  @Override
  public List<UserGroup> querySimpleUserGroupList(UserGroupQueryFilter filter) {
    if (filter == null) {
      return null;
    }
    int count = 0;
    count = queryUserGroupListCount(filter);
    if (count <= 0) {
      return null;
    }
    return userGroupMapper.querySimpleUserGroupList(filter);
  }

  @Override
  public List<UserGroup> querySimpleUserGroupByIdList(List<Integer> idList) {
    if (CollectionUtils.isEmpty(idList)) {
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
    //TODO:好蠢的代码，以后再改。
    //先查询UserGroupIdList
    List<Integer> idList = queryUserGroupIdListByUserId(userId);
    //再根据idList查询UserGroup
    List<UserGroup> userGroupList = querySimpleUserGroupByIdList(idList);
    return userGroupList;
  }

  @Override
  public List<UserGroup> queryUserGroupListByUserId(int userId) {
    List<UserGroup> simpleUserGroupList = querySimpleUserGroupListByUserId(userId);
    if (CollectionUtils.isEmpty(simpleUserGroupList)) {
      return null;
    }
    for (UserGroup userGroup : simpleUserGroupList) {
      List<AuthorityRole> authorityRoleList =
              authorityService.queryDataAuthorityList(new AuthorityQueryFilter(DataType.USER_GROUP, userGroup.getId()));
      userGroup.setAuthorities(authorityRoleList);
    }
    return simpleUserGroupList;
  }

  @Override
  public Boolean insertUserListIntoUserGroup(List<User> userList, UserGroupType userGroupType) {
    if (CollectionUtils.isEmpty(userList)) {
      return false;
    }
    //删除没有userId的数据
    for (int i = 0; i < userList.size(); i++) {
      User user = userList.get(i);
      if (user == null || user.getId() <= 0) {
        userList.remove(i);
        i--;
      }
    }
    int userGroupId = userGroupMapper.queryUserGroupIdByType(userGroupType);
    if (userGroupId <= 0) {
      return false;
    }
    int count = userGroupMapper.insertUserListIntoUserGroup(userList, userGroupId);
    return count > 0 ? true : false;
  }

  @Override
  public Boolean insertUserIntoUserGroup(User user, UserGroupType userGroupType) {
    List<User> list = new ArrayList<>();
    list.add(user);
    return insertUserListIntoUserGroup(list, userGroupType);
  }

  @Override
  public int queryUserGroupIdByType(UserGroupType type) {
    if (type == null) {
      return 0;
    }
    return userGroupMapper.queryUserGroupIdByType(type);
  }
}

