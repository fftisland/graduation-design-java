package ZzzAhu163.mapper.user;

import ZzzAhu163.BaseMapper;
import ZzzAhu163.base.authority.AuthorityQueryFilter;
import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.base.authority.DataType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZzzAhu163
 **/
public interface AuthorityMapper extends BaseMapper {
  /***********************Authority*************************************/
  int insertAuthorityRole(AuthorityRole authorityRole);

  int updateAuthorityRole(AuthorityRole authorityRole);


  List<AuthorityRole> queryAuthorityRoleList(AuthorityQueryFilter filter);

  int queryAuthorityRoleListCount(AuthorityQueryFilter filter);

  /********************Authority Map***************************/
  int insertDataAuthorityList(@Param("dataType") DataType dataType,
                              @Param("dataId") int dataId,
                              @Param("authorityRoleList") List<AuthorityRole> authorityRoleList);

  int deleteDataAuthorityList(@Param("dataType") DataType dataType, @Param("dataIdList") List<Integer> dataIdList);

  int queryDataAuthorityListCount(AuthorityQueryFilter filter);

  List<AuthorityRole> queryDataAuthorityList(AuthorityQueryFilter filter);
}
