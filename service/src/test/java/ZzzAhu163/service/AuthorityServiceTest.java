package ZzzAhu163.service;

import ZzzAhu163.AbstractTest;
import ZzzAhu163.base.authority.AuthorityQueryFilter;
import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.base.authority.DataType;
import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.UserGroupType;
import ZzzAhu163.service.user.AuthorityService;
import ZzzAhu163.service.user.UserGroupService;
import com.sun.jdi.IntegerType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  ZzzAhu163
 **/
@Slf4j
public class AuthorityServiceTest extends AbstractTest {
  @Resource
  private AuthorityService authorityService;
  @Resource
  private UserGroupService userGroupService;

  @Test
  public void insertAuthorityTest() {
    AuthorityRole authorityRole = new AuthorityRole();
    authorityRole.setName("ROLE_MENU_ADMIN");
    authorityRole.setDescription("菜单管理菜单权限");
    boolean result = authorityService.insertAuthorityRole(authorityRole);
    log.info("插入结果 : {} 自增主键: {}", result, authorityRole.getId());
  }

  @Test
  public void insertDataAuthorityTest() {
    int groupId = userGroupService.queryUserGroupIdByType(UserGroupType.GROUP_SUPER_ADMIN);
    List<AuthorityRole> roleList = authorityService.queryAuthorityRoleList(
            new AuthorityQueryFilter(new AuthorityRole("ROLE_ALL_ALL_ALL"))
    );
    boolean result = authorityService.insertDataAuthorityList(DataType.USER_GROUP, groupId, roleList);
    log.info("插入结果： {}", result);
  }

  @Test
  public void deleteDataAuthorityListTest() {
    int groupId = userGroupService.queryUserGroupIdByType(UserGroupType.GROUP_SUPER_ADMIN);
    List<Integer> list = new ArrayList<>();
    list.add(groupId);
    boolean result = authorityService.deleteDataAuthorityList(DataType.USER_GROUP, list);
    log.info("删除结果：{}", result);
  }

  @Test
  public void queryDataAuthorityListTest() {
    AuthorityQueryFilter filter = new AuthorityQueryFilter();
    filter.setDataType(DataType.USER_GROUP);
    int groupId = userGroupService.queryUserGroupIdByType(UserGroupType.GROUP_SUPER_ADMIN);
    filter.setDataId(groupId);
    List<AuthorityRole> list = authorityService.queryDataAuthorityList(filter);
    if (!CollectionUtils.isEmpty(list)) {
      log.info("结果条数：{}, 结果：{}", list.size(), list);
    }
  }
}
