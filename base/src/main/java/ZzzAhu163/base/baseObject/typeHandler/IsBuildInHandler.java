package ZzzAhu163.base.baseObject.typeHandler;

import ZzzAhu163.base.baseObject.IsBuildIn;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
public class IsBuildInHandler extends BaseTypeHandler<IsBuildIn>{
  @Override
  public void setNonNullParameter(PreparedStatement preparedStatement, int i, IsBuildIn isBuildIn, JdbcType jdbcType) throws SQLException {
    preparedStatement.setInt(i, IsBuildIn.getIsBuildInById(i).getCode());
  }

  @Override
  public IsBuildIn getNullableResult(ResultSet resultSet, String s) throws SQLException {
    return IsBuildIn.getIsBuildInById(resultSet.getInt(s));
  }

  @Override
  public IsBuildIn getNullableResult(ResultSet resultSet, int i) throws SQLException {
    return IsBuildIn.getIsBuildInById(resultSet.getInt(i));
  }

  @Override
  public IsBuildIn getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
    return IsBuildIn.getIsBuildInById(callableStatement.getInt(i));
  }
}
