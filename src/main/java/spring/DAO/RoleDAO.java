package spring.DAO;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@Repository
public class RoleDAO implements JpaRepository<Role,Long> {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Role> findAll() {
        Query query = entityManager.createQuery("FROM Role");
        return query.getResultList();
    }

    @Override
    public List<Role> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Role> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public void deleteById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Role WHERE id = :id");
        query.setParameter("id",id).executeUpdate();
    }

    @Override
    public void delete(Role role) {
        Query query = entityManager.createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id",role.getId()).executeUpdate();
    }

    @Override
    public void deleteAll(Iterable<? extends Role> iterable) {
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Role> S save(S s) {
        entityManager.persist(s);
        return s;
    }

    @Override
    public <S extends Role> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Role> findById(Long aLong) {
        return Optional.ofNullable(entityManager.find(Role.class, aLong));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Role> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Role> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Role getOne(Long id) {
        return Optional.ofNullable(entityManager.find(Role.class, id)).orElseGet(() -> new Role());
    }

    @Override
    public <S extends Role> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Role> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Role> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Role> boolean exists(Example<S> example) {
        return false;
    }
}
