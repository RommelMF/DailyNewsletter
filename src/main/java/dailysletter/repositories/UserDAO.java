package dailysletter.repositories;

import dailysletter.models.User;

import java.util.List;

/**
 * Created by Home on 14.05.2017.
 */
public interface UserDAO {
    long insertUser(User user);
    User getUser(long id);
    boolean updateUser(User user);
    boolean deleteUser(long id);
    List<User> getAll();
}
