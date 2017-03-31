/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.rhecruta.core.services;

import br.edu.ifpb.dac.rhecruta.core.dao.interfaces.OfferDAO;
import br.edu.ifpb.dac.rhecruta.core.services.exceptions.EntityNotFoundException;
import br.edu.ifpb.dac.rhecruta.shared.domain.entities.Offer;
import br.edu.ifpb.dac.rhecruta.shared.interfaces.OfferService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author Pedro Arthur
 */

@Stateless
@Remote(OfferService.class)
public class OfferServiceImpl implements OfferService {
    
    @EJB
    private OfferDAO offerDAO;

    @Override
    public void save(Offer offer) {
        offerDAO.save(offer);
    }

    @Override
    public void remove(Offer offer) {
        try {
            Offer found = offerDAO.get(offer.getId());
            offerDAO.remove(found);
        } catch (NoResultException ex) {
            throw new EntityNotFoundException("You're trying to remove a non existent offer!");
        }
    }

    @Override
    public void update(Offer offer) {
        offerDAO.update(offer);
    }

    @Override
    public List<Offer> listAll() {
        return offerDAO.listAll();
    }
    
}
