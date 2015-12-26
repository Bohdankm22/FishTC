package com.bionic.edu.dao;

import com.bionic.edu.entity.Groups;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Groups groups) {
        em.persist(groups);
    }

    @Override
    public List<Groups> getAll() {
            String txt = "SELECT u FROM Groups u";
            TypedQuery<Groups> querry = em.createQuery(txt, Groups.class);
            return querry.getResultList();
    }

    @Override
    public Groups findById(int id) {
        return em.find(Groups.class, id);
    }

    @Override
    public void update(Groups groups1) {
        Groups groups2 = em.find(Groups.class, groups1.getGroups_id());
        if (groups2 != null) {
            em.merge(groups1);
        }
    }

    @Override
    public Groups findByName(String name) {
        String txt = "SELECT u FROM Groups u WHERE u.Groups_Number='" + name + "'";
        TypedQuery<Groups> query = em.createQuery(txt, Groups.class);
        Groups groups = null;
        try {
            groups = query.getSingleResult();
        } catch (NoResultException e) {
//            LOG.info("Couldn't find any result on " + query);
        }
        return groups;
    }
}
