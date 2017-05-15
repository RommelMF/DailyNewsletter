package dailysletter.repositories.impl;

import dailysletter.models.User;
import dailysletter.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Home on 14.05.2017.
 */
@Component
@Transactional
public class UserRepositoryImpl implements UserDAO{
    private static final String usersTable = "users";
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public long insertUser(User user) {
        String sql = "INSERT INTO" + usersTable + "(name, email, login, password) VALUES (:name, :email, :login, :password)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", user.getName());
        params.addValue("email", user.getEmail());
        params.addValue("login", user.getLogin());
        params.addValue("password", user.getPassword());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sql,params,keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public User getUser(long id) {
        String sql = "SELECT * FROM" + usersTable + "WHERE user_id = :user_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", id);

        return jdbcTemplate.queryForObject(sql, params, new UserRowMapper());
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE" + usersTable + "SET name = :name, email = :email, login = :login, password = :password WHERE user_id = :user_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", user.getId());
        params.addValue("name", user.getName());
        params.addValue("email", user.getEmail());
        params.addValue("login", user.getLogin());
        params.addValue("password", user.getPassword());
        int result = jdbcTemplate.update(sql, params);

        if(result == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(long id) {
        String sql = "DELETE FROM" + usersTable + "WHERE user_id = :user_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        int result = jdbcTemplate.update(sql, params);
        if (result == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
//        TODO implements method
        return null;
    }

    private static final class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }
}
