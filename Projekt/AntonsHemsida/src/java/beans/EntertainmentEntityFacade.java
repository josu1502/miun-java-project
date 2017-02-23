/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.entities.EntertainmentEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Joakim
 */
@Stateless
public class EntertainmentEntityFacade extends AbstractFacade<EntertainmentEntity> {

    @PersistenceContext(unitName = "AntonsHemsidaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntertainmentEntityFacade() {
        super(EntertainmentEntity.class);
    }
    
}
