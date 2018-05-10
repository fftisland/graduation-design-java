package ZzzAhu163.service.user;

import ZzzAhu163.base.authority.AuthorityQueryFilter;
import ZzzAhu163.base.authority.DataType;
import ZzzAhu163.base.menu.MenuItem;
import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.mapper.user.AuthorityMapper;
import lombok.Data;
import lombok.NonNull;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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
  public boolean insertAuthorityRole(AuthorityRole authorityRole) {
    if (authorityRole == null || authorityRole.getId() > 0) {
      return false;
    }
    return authorityMapper.insertAuthorityRole(authorityRole) == 1 ? true : false;
  }

  @Override
  public boolean updateAuthorityRole(AuthorityRole authorityRole) {
    if (authorityRole == null || authorityRole.getId() <= 0) {
      return false;
    }
    return authorityMapper.updateAuthorityRole(authorityRole) == 1 ? true : false;
  }

  @Override
  public AuthorityRole queryAuthorityRoleByName(String name) {
    if (StringUtils.isEmpty(name)) {
      return null;
    }
    List<AuthorityRole> list = queryAuthorityRoleList(new AuthorityQueryFilter(new AuthorityRole(name)));
    if (CollectionUtils.isEmpty(list)) {
      return null;
    }
    return list.get(0);
  }

  @Override
  public List<AuthorityRole> queryAuthorityRoleList(AuthorityQueryFilter filter) {
    if (filter == null) {
      return null;
    }
    int count = queryAuthorityRoleListCount(filter);
    if (count <= 0) {
      return null;
    }
    List<AuthorityRole> list = authorityMapper.queryAuthorityRoleList(filter);
    return CollectionUtils.isEmpty(list) ? null : list;
  }

  @Override
  public int queryAuthorityRoleListCount(AuthorityQueryFilter filter) {
    if (filter == null) {
      return 0;
    }
    return authorityMapper.queryAuthorityRoleListCount(filter);
  }


  @Override
  public boolean insertDataAuthorityList(DataType dataType, int dataId, List<AuthorityRole> authorityRoleList) {
    if (dataType == null || dataId <= 0 || CollectionUtils.isEmpty(authorityRoleList)) {
      return false;
    }
    for (AuthorityRole role : authorityRoleList) {
      if (role == null || role.getId() <= 0) {
        return false;
      }
    }
    return authorityMapper.insertDataAuthorityList(dataType, dataId, authorityRoleList) > 0 ? true : false;
  }

  @Override
  public boolean insertDataAuthority(DataType dataType, int dataId, AuthorityRole authorityRole) {
    List<AuthorityRole> list = new ArrayList<>();
    list.add(authorityRole);
    return insertDataAuthorityList(dataType, dataId, list);
  }

  @Override
  public boolean deleteDataAuthorityList(DataType dataType, List<Integer> dataIdList) {
    if (dataType == null || CollectionUtils.isEmpty(dataIdList)) {
      return false;
    }
    return authorityMapper.deleteDataAuthorityList(dataType, dataIdList) > 0 ? true : false;
  }

  @Override
  public int queryDataAuthorityListCount(AuthorityQueryFilter filter) {
    if (filter == null) {
      return 0;
    }
    return authorityMapper.queryDataAuthorityListCount(filter);
  }

  @Override
  public List<AuthorityRole> queryDataAuthorityList(AuthorityQueryFilter filter) {
    int count = queryDataAuthorityListCount(filter);
    if (count <= 0) {
      return null;
    }
    List<AuthorityRole> list = authorityMapper.queryDataAuthorityList(filter);
    return CollectionUtils.isEmpty(list) ? null : list;
  }
}
