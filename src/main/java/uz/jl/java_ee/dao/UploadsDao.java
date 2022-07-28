package uz.jl.java_ee.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.jl.java_ee.configs.HibernateConfigurer;
import uz.jl.java_ee.domains.Uploads;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UploadsDao implements Dao<Uploads> {
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
        SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Uploads uploads = session.find(Uploads.class, id);
        if (Objects.nonNull(uploads))
            session.remove(uploads);
        session.getTransaction().commit();
    }

    @Override
    public List<Uploads> findAll() {
        SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        return session.createQuery("select T from Uploads T order by T.id desc ", Uploads.class).getResultList();
    }

    @Override
    public Uploads findOne(Long id) {
        return null;
    }

    public Optional<Uploads> findByGeneratedName(String filename) {
        SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        return Optional.ofNullable(
                session.createQuery("select t from Uploads t where t.generatedName = :generatedName", Uploads.class)
                        .setParameter("generatedName", filename)
                        .getSingleResultOrNull());
    }
}
