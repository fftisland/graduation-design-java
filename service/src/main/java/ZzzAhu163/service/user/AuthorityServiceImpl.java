package ZzzAhu163.service.user;

import ZzzAhu163.base.user.AuthorityRole;
import ZzzAhu163.mapper.user.AuthorityMapper;
import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.zip.Inflater;

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
    //根据UserGroupId查询权限idList
    List<Integer> authorityIdList = queryAuthorityIdListByUserGroupId(userGroupId);
    //根据权限的idList查询权限
    List<AuthorityRole> authorityRoleList = queryAuthorityListByIdList(authorityIdList);
    return authorityRoleList;
  }

  @Override
  public List<Integer> queryAuthorityIdListByUserGroupId(int userGroupId) {
    if (userGroupId <= 0) {
      return null;
    }
    return authorityMapper.queryAuthorityRoleIdListByUserGroupId(userGroupId);
  }

  @Override
  public List<AuthorityRole> queryAuthorityListByIdList(@NonNull List<Integer> idList) {
    if (idList.size() <= 0) {
      return null;
    }
    return authorityMapper.queryAuthorityRoleByIdList(idList);
  }
}
