package uz.jl.java_ee.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.jl.java_ee.configs.HibernateConfigurer;
import uz.jl.java_ee.domains.Book;

import java.util.List;
import java.util.Objects;


/**
 * @author "Elmurodov Javohir"
 * @since 26/07/22/11:51 (Tuesday)
 * java-ee/IntelliJ IDEA
 */

public class BookDao implements Dao<Book> {

    @Override
    public Book create(Book entity) {
        SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Long id) {
        SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Book book = session.find(Book.class, id);
        if (Objects.nonNull(book))
            session.remove(book);
        session.getTransaction().commit();
    }

    @Override
    public List<Book> findAll() {
        SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        return session.createQuery("select T from Book T order by T.id desc ", Book.class).getResultList();
    }

    @Override
    public Book findOne(Long id) {
        return null;
    }
}
