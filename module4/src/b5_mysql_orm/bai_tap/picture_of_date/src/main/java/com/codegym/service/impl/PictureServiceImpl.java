package com.codegym.service.impl;

import com.codegym.model.PictureData;
import com.codegym.service.PictureService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PictureServiceImpl implements PictureService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PictureData> findAll() {
        String queryStr = "SELECT c FROM PictureData AS c";
        TypedQuery<PictureData> query = entityManager.createQuery(queryStr, PictureData.class);
        return query.getResultList();
    }

    @Override
    public PictureData save(PictureData pictureData) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            PictureData origin = new PictureData();
            origin.setAuthor(pictureData.getAuthor());
            origin.setPoint(pictureData.getPoint());
            System.out.println(pictureData.getFeedback());
            origin.setFeedback(pictureData.getFeedback());
            session.save(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
