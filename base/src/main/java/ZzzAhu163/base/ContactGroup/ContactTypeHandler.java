package ZzzAhu163.base.ContactGroup;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
public class ContactTypeHandler extends BaseTypeHandler<ContactType> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, ContactType contactType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, contactType.getCode());
    }

    @Override
    public ContactType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return ContactType.getContactTypeByCode(resultSet.getInt(s));
    }

    @Override
    public ContactType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return ContactType.getContactTypeByCode(resultSet.getInt(i));
    }

    @Override
    public ContactType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return ContactType.getContactTypeByCode(callableStatement.getInt(i));
    }
}
