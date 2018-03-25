package ZzzAhu163.service.user;

import ZzzAhu163.base.user.AuthorityRole;
import ZzzAhu163.mapper.user.AuthorityMapper;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZzzAhu163
 **/
@Data
@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {
  @Resource
  private AuthorityMapper authorityMapper;

  @Override
  public List<AuthorityRole> queryAuthorityListByUserGroupId(int userGroupId) {
    if (userGroupId <= 0) {
      return null;
    }
    List<Integer> authorityIdList = authorityMapper.queryAuthorityRoleIdListByUserGroupId(userGroupId);
    if (CollectionUtils.isEmpty(authorityIdList)) {
      return null;
    }
    List<AuthorityRole> authorityRoleList = authorityMapper.queryAuthorityRoleByIdList(authorityIdList);
    if(CollectionUtils.isEmpty(authorityRoleList)) {
      return null;
    }
    return authorityRoleList;
  }
}
