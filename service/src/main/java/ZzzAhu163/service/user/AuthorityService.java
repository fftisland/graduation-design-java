package ZzzAhu163.service.user;

import ZzzAhu163.base.authority.AuthorityQueryFilter;
import ZzzAhu163.base.authority.DataType;
import ZzzAhu163.base.menu.MenuItem;
import ZzzAhu163.base.authority.AuthorityRole;

import java.util.List;

/**
 * @author ZzzAhu163
 **/
public interface AuthorityService {
  /***********************Authority*************************************/
  boolean insertAuthorityRole(AuthorityRole authorityRole);

  boolean updateAuthorityRole(AuthorityRole authorityRole);

  AuthorityRole queryAuthorityRoleByName(String name);

  List<AuthorityRole> queryAuthorityRoleList(AuthorityQueryFilter filter);

  int queryAuthorityRoleListCount(AuthorityQueryFilter filter);

  /********************Authority Map***************************/
  boolean insertDataAuthorityList(DataType dataType, int dataId, List<AuthorityRole> authorityRoleList);

  boolean insertDataAuthority(DataType dataType, int dataId, AuthorityRole authorityRole);

  boolean deleteDataAuthorityList(DataType dataType, List<Integer> dataIdList);

  int queryDataAuthorityListCount(AuthorityQueryFilter filter);

  List<AuthorityRole> queryDataAuthorityList(AuthorityQueryFilter filter);
}
