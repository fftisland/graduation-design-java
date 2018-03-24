package ZzzAhu163.mapper.user.typehandler;

import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.UserGroupType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Zzz_Ahu_163
 **/

@MappedJdbcTypes(JdbcType.INTEGER)
public class GroupTypeHandler extends BaseTypeHandler<UserGroupType> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UserGroupType userGroupType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, userGroupType.getCode());
    }

    @Override
    public UserGroupType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return UserGroupType.getUserGroupTypeById(resultSet.getInt(s));
    }

    @Override
    public UserGroupType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return UserGroupType.getUserGroupTypeById(resultSet.getInt(i));
    }

    @Override
    public UserGroupType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return UserGroupType.getUserGroupTypeById(callableStatement.getInt(i));
    }
}
