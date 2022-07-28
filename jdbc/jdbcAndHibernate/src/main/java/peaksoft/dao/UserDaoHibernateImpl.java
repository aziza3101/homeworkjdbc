package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private final EntityManagerFactory entityManagerFactory = Util.createEntityManagerFactory();

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("""
                    create table if not exists users(
                    id serial primary key,
                    name varchar(50),
                    last_name varchar(50),
                    age int);""").executeUpdate();

            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void removeUserById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<User> allUsers = entityManager.createQuery("select u from User u", User.class).getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();

        return allUsers;
    }

    @Override
    public void cleanUsersTable() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createNativeQuery("truncate table users").executeUpdate();
        System.out.println("Successfully truncate table!!");
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public void close() throws Exception {
        entityManagerFactory.close();
    }
}