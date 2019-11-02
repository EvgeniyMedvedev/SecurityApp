package spring.DAO;

import org.springframework.stereotype.Repository;
import spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User getById(int id) {
        return Optional.ofNullable(entityManager.find(User.class, id)).orElseGet(() -> new User());
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, String name,String login,String password) {
        Query query = entityManager.createQuery("update User set name =: name,login =: login,password =: password where id =: id");
        query.setParameter("name",name).setParameter("login",login).setParameter("password",password).setParameter("id",id);
        query.executeUpdate();

    }

    @Override
    public User getByLogin(String login) {
        Query query = entityManager.createQuery("FROM User where login =: uLogin");
        Object u = query.setParameter("uLogin", login).getSingleResult();
        return (User) u;
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id",id).executeUpdate();
    }

}
