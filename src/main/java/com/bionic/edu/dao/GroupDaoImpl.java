package com.bionic.edu.dao;

import com.bionic.edu.entity.Group;
import com.bionic.edu.entity.Students;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Group group) {
        em.persist(group);
    }

    @Override
    public List<Group> getAll() {
            String txt = "SELECT u FROM Group u";
            TypedQuery<Group> querry = em.createQuery(txt, Group.class);
            return querry.getResultList();
    }

    @Override
    public Group findById(int id) {
        return em.find(Group.class, id);
    }

    @Override
    public void update(Group group1) {
        Group group2 = em.find(Group.class, group1.getGroup_id());
        if (group2 != null) {
            em.merge(group1);
        }
    }
}
