package spring.DAO;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import spring.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@Repository
public class RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Role> findAll() {
        Query query = entityManager.createQuery("FROM Role");
        return query.getResultList();
    }

    public long count() {
        return findAll().size();
    }

    public void deleteById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Role WHERE id = :id");
        query.setParameter("id",id).executeUpdate();
    }

    public void delete(Role role) {
        Query query = entityManager.createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id",role.getId()).executeUpdate();
    }

    public <S extends Role> S save(S s) {
        entityManager.persist(s);
        return s;
    }

    public Optional<Role> findById(Long aLong) {
        return Optional.ofNullable(entityManager.find(Role.class, aLong));
    }

    public Role getOne(Long id) {
        return Optional.ofNullable(entityManager.find(Role.class, id)).orElseGet(() -> new Role());
    }

    public <S extends Role> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }
}
