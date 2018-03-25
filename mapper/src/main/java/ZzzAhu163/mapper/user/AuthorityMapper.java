package ZzzAhu163.mapper.user;

import ZzzAhu163.BaseMapper;
import ZzzAhu163.base.user.AuthorityRole;

import java.util.List;

/**
 * @author ZzzAhu163
 **/
public interface AuthorityMapper extends BaseMapper {
  /*****************************Authority****************************/
  List<AuthorityRole> queryAuthorityRoleByIdList(List<Integer> list);




  /*****************************UserGroupAuthority****************************/
  List<Integer> queryAuthorityRoleIdListByUserGroupId(int userGroupId);




  /********************************UserAuthority*******************************/

}
