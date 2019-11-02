package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.DAO.RoleDAO;
import spring.DAO.UserDAO;
import spring.model.Role;
import spring.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO dao;

    private final RoleDAO rDao;

    PasswordEncoder encoder = new BCryptPasswordEncoder(11);

    @Autowired
    public UserServiceImpl(UserDAO dao, RoleDAO rDao) {
        this.dao = dao;
        this.rDao = rDao;
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public void add(User t) {
        t.setPassword(encoder.encode(t.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(rDao.getOne(2L));
        t.setRoles(roles);
        dao.add(t);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void updateUser(int idUser, String name,String login,String password) {
        dao.updateUser(idUser,name,login,password);
    }

    @Override
    public User getByLogin(String login) {
        return dao.getByLogin(login);
    }
}
