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
  public void queryById() {
    int id = 1;
    User user = userService.querySimpleUserById(id);
    log.info("查询结果：{}", user);
  }

  @Test
  public void allTest() throws Exception {
    User user = userService.queryUserByName("ZzzAhu163");
    log.info("用户所有权限条数为：{}", user.getAuthorities().size());
    log.info("用户所有的权限为: {}", user.getAuthorities());
  }

  @Test
  public void queryByEmail() {
    String email = "a792356291@qq.com";
    User user = userService.querySimpleUserByEmail(email);
    log.info("查询结果{}", user);
  }

  @Test
  public void insertUser() {
    User user = new User();
    user.setName("赵子彰");
    user.setUserRole(UserRole.ROLE_NORMAL);
    user.setPassword("ZzzAhu163");
    user.setEmail("b792356291@qq.com");
    boolean result = userService.insertUser(user);
    log.info("插入结果:{}", result);
    if (result == true) {
      user = userService.queryUserByName("赵子彰");
      log.info("持久化数据：{}", user);
    }
  }

  @Test
  public void queryUserByNameTest() {
    String name = "赵子彰1";
    User user = userService.queryUserByName(name);
    log.info("查询结果: {}", user.getAuthorityForLog());
  }
}
