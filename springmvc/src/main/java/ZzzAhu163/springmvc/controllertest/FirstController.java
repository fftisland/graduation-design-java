package ZzzAhu163.springmvc.controllertest;

import ZzzAhu163.base.firstentity.first;
import ZzzAhu163.mapper.firstmapper.FirstMapper;
import ZzzAhu163.service.FirstService.FirstService;
import ZzzAhu163.utils.ConstValue.SharedPropertiesProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@author ZzzAhu163
 *用来测试SpringMVC项目是否部署成功
 **/

@Controller
@RequestMapping(value = "/first")
@Slf4j
public class FirstController {
  @Resource
  private SharedPropertiesProvider propertiesProvider;

  @Resource
  private FirstService service;

  @RequestMapping("/test")
  public void test(HttpServletRequest request, HttpServletResponse response) {
      first first = new first();
      first.setData(propertiesProvider.getCurrentEnv());
      boolean result = service.insertFirstData(first);
      log.info("调用 /first {}", result);
  }
}
