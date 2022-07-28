package uz.jl.java_ee.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.jl.java_ee.configs.HibernateConfigurer;
import uz.jl.java_ee.domains.Book;
import uz.jl.java_ee.domains.Uploads;

import java.util.List;
import java.util.Optional;

public class FileStorageDao implements Dao<Uploads> {

    @Override
    public Uploads create(Uploads entity) {
        SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Uploads> findAll() {
        return null;
    }

    @Override
    public Uploads findOne(Long id) {
        return null;
    }

    public Optional<Uploads> getOneTemplateCover() {
        SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        return Optional.ofNullable(session
                .createQuery("select t from Uploads t where t.template", Uploads.class)
                .getSingleResultOrNull());
    }
}
