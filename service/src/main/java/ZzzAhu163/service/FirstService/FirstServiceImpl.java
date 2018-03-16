package ZzzAhu163.service.FirstService;

import ZzzAhu163.base.firstentity.first;
import ZzzAhu163.mapper.firstmapper.FirstMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("FirstService")
public class FirstServiceImpl implements FirstService {
  @Resource
  FirstMapper firstMapper;

  @Override
  public boolean insertFirstData(first first) {
    return firstMapper.insertFirstData(first) == 1;
  }
}
