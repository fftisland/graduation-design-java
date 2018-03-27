package ZzzAhu163.service;

import ZzzAhu163.AbstractTest;
import ZzzAhu163.base.baseObject.IsBuildIn;
import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.UserGroupType;
import ZzzAhu163.base.user.filter.UserGroupQueryFilter;
import ZzzAhu163.service.user.UserGroupService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZzzAhu163
 **/
@Slf4j
public class UserGroupServiceTest extends AbstractTest {
  @Resource
  private UserGroupService userGroupService;

  @Test
  public void queryUserGroupListCount(){
    UserGroupQueryFilter filter = new UserGroupQueryFilter();
    int count1 = userGroupService.queryUserGroupListCount(filter);
    log.info("结果条数1: {}", count1);

    UserGroup userGroup =
      UserGroup.builder()
      .isBuildIn(IsBuildIn.BUILD_IN)
      .userGroupType(UserGroupType.GROUP_ADMIN).build();
    filter.setUserGroup(userGroup);
    filter.setId(2);
    filter.setName("GROUP_ADMIN");
    filter.setDescription("管理员");
    int count2 = userGroupService.queryUserGroupListCount(filter);
    log.info("结果条数2：{}", count2);
  }

  @Test
  public void querySimpleUserGroupList() {
    UserGroupQueryFilter filter = new UserGroupQueryFilter();
    List<UserGroup> list = userGroupService.querySimpleUserGroupList(filter);
    log.info("查询结果列表：{}", list);
  }

  @Test
  public void queryUserGroupIdList() {
    int userId = 1;
    List<Integer> groupIdList = userGroupService.queryUserGroupIdListByUserId(userId);
    log.info("User Group Id List: {}", groupIdList);
    List<UserGroup> groupList = userGroupService.querySimpleUserGroupByIdList(groupIdList);
    log.info("User Group List： {}", groupList);
  }

  @Test
  public void querySimpleUserGroupByUserId() {
    int userId = 1;
    List<UserGroup> groupList = userGroupService.querySimpleUserGroupListByUserId(userId);
    log.info("User Group List:{}", groupList);
  }
}
