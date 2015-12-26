package com.bionic.edu.dao;

import com.bionic.edu.entity.Specialization;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SpecializationDaoImpl implements SpecializationDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Specialization specialization) {
        em.persist(specialization);
    }

    @Override
    public List<Specialization> getAll() {
        String txt = "SELECT u FROM Specialization u";
        TypedQuery<Specialization> querry = em.createQuery(txt, Specialization.class);
        return querry.getResultList();
    }

    @Override
    public Specialization findById(int id) {
        return em.find(Specialization.class, id);
    }

    @Override
    public void update(Specialization specialization1) {
        Specialization specialization2 = em.find(Specialization.class, specialization1.getSpecialization_id());
        if (specialization2 != null) {
            em.merge(specialization1);
        }
    }
}
