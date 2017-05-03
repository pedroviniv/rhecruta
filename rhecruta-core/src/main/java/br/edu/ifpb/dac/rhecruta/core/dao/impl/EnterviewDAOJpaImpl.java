/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.rhecruta.core.dao.impl;

import br.edu.ifpb.dac.rhecruta.core.dao.interfaces.EnterviewDAO;
import br.edu.ifpb.dac.rhecruta.shared.domain.entities.Administrator;
import br.edu.ifpb.dac.rhecruta.shared.domain.entities.Enterview;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pedro Arthur
 */
@Local(EnterviewDAO.class)
@Stateless
public class EnterviewDAOJpaImpl implements EnterviewDAO {
    
    @PersistenceContext(unitName = "rhecruta-pu")
    private EntityManager manager;

    @Override
    public List<Enterview> listAll() {
        TypedQuery<Enterview> query = manager
                .createQuery("SELECT e FROM Enterview e", Enterview.class);
        return query.getResultList();
    }

    @Override
    public Enterview findById(Long id) {
        return manager.find(Enterview.class, id);
    }

    @Override
    public void save(Enterview obj) {
        manager.persist(obj);
    }

    @Override
    public void update(Enterview obj) {
        manager.merge(obj);
    }

    @Override
    public List<Enterview> listByAppraiser(Administrator appraiser) {
        TypedQuery<Enterview> query = manager.createQuery("SELECT e FROM Enterview e"
                + " WHERE :appraiser MEMBER OF e.offer.administrators", 
                Enterview.class)
                .setParameter("appraiser", appraiser);
        return query.getResultList();
    }
    
}