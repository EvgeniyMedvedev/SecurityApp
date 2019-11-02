package spring.DAO;

import spring.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAll() ;

    void add(User t);

    User getById(int id) ;

    void delete(int id);

    void updateUser(int idUser, String name, String login, String password);

    User getByLogin(String login);
}
