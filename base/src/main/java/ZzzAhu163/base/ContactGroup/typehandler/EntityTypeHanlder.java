package ZzzAhu163.base.ContactGroup.typehandler;

import ZzzAhu163.base.ContactGroup.EntityType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
public class EntityTypeHanlder extends BaseTypeHandler<EntityType> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, EntityType entityType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, entityType.getCode());
    }

    @Override
    public EntityType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return EntityType.getEntityTypeByCode(resultSet.getInt(s));
    }

    @Override
    public EntityType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return EntityType.getEntityTypeByCode(resultSet.getInt(i));
    }

    @Override
    public EntityType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return EntityType.getEntityTypeByCode(callableStatement.getInt(i));
    }
}
