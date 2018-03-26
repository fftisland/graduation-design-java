package ZzzAhu163.service;

import ZzzAhu163.AbstractTest;
import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserRole;
import ZzzAhu163.base.user.filter.UserQueryFilter;
import ZzzAhu163.service.user.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import javax.annotation.Resource;
import java.util.List;

@Data
@Slf4j
public class UserServiceTest extends AbstractTest {
  @Resource
  private UserService userService;


  @Test
  public void queryCount() {
    UserQueryFilter filter = new UserQueryFilter();
    int count = userService.queryUserListCount(filter);
    log.info("全部结果条数：{}", count);
    User user = User.builder()
      .email("zhaozizhang@corp.netease.com")
      .password("zzzlyy")
      .userRole(UserRole.ROLE_ADMIN).build();
    filter.setId(1);
    filter.setName("ZzzAhu163");
    filter.setUser(user);
    count = userService.queryUserListCount(filter);
    log.info("结果条数：{}", count);
  }

  @Test
  public void queryList() {
    UserQueryFilter filter = new UserQueryFilter();
    int count = userService.queryUserListCount(filter);
    log.info("filter：{}", filter.toString());
    List<User> userList = userService.querySimpleUserList(filter);
    if (userList == null) {
      log.info("无查询结果");
      return;
    }
    log.info("结果条数：{}", count);
    log.info("结果列表：{}", userList.toString());
  }

  @Test
  public void queryIdListTest() {
    List<Integer> idList =
  }

}
