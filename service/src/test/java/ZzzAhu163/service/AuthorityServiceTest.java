package ZzzAhu163.service;

import ZzzAhu163.AbstractTest;
import ZzzAhu163.base.user.AuthorityRole;
import ZzzAhu163.service.user.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author  ZzzAhu163
 **/
@Slf4j
public class AuthorityServiceTest extends AbstractTest {
  @Resource
  private AuthorityService authorityService;

  @Test
  public void queryAuthorityIdListByUserGroupId() {
    int userGroupId = 2;
    List<Integer> idList = authorityService.queryAuthorityIdListByUserGroupId(userGroupId);
    log.info("查询结果：{}", idList);
  }

  @Test
  public void queryAuthorityListByIdList() {
    int userGroupId = 2;
    List<Integer> idList = authorityService.queryAuthorityIdListByUserGroupId(userGroupId);
    log.info("查询结果：{}", idList);
    List<AuthorityRole> roleList = authorityService.queryAuthorityListByIdList(idList);
    log.info("权限列表：{}", roleList);
  }

  @Test
  public void queryAuthorityListByUserGroupId() {
    int userGroupId = 2;
    List<AuthorityRole> roleList = authorityService.queryAuthorityListByUserGroupId(userGroupId);
    log.info("权限列表：{}" , roleList);
  }
}
