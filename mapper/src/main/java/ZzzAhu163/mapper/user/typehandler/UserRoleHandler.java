package ZzzAhu163.mapper.user.typehandler;

import ZzzAhu163.base.user.UserRole;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.*;

/**
 * @author ZzzAhu163
 **/
@MappedJdbcTypes(JdbcType.INTEGER)
public class UserRoleHandler extends BaseTypeHandler<UserRole> {
  @Override
  public void setNonNullParameter(PreparedStatement preparedStatement, int i, UserRole userRole, JdbcType jdbcType) throws SQLException {
    preparedStatement.setInt(i, userRole.getCode());
  }

  @Override
  public UserRole getNullableResult(ResultSet resultSet, String s) throws SQLException {
    return UserRole.getUserRoleByCode(resultSet.getInt(s));
  }

  @Override
  public UserRole getNullableResult(ResultSet resultSet, int i) throws SQLException {
    return UserRole.getUserRoleByCode(resultSet.getInt(i));
  }

  @Override
  public UserRole getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
    return UserRole.getUserRoleByCode(callableStatement.getInt(i));
  }
}
