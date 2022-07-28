package uz.jl.java_ee.dao;

import org.hibernate.Session;
import uz.jl.java_ee.configs.HibernateConfigurer;
import uz.jl.java_ee.domains.Uploads;

import java.util.List;
import java.util.Optional;

public class FileStorageDao implements Dao<Uploads> {

    @Override
    public Uploads create(Uploads entity) {
        Session session = HibernateConfigurer.getSession();
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
        Session session = HibernateConfigurer.getSession();
        return Optional.ofNullable(session
                .createQuery("select t from Uploads t where t.template", Uploads.class)
                .getSingleResultOrNull());
    }
}
