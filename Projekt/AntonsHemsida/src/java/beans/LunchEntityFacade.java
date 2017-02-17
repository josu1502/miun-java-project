/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.entities.LunchEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maski
 */
@Stateless
public class LunchEntityFacade extends AbstractFacade<LunchEntity> {

    @PersistenceContext(unitName = "AntonsHemsidaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LunchEntityFacade() {
        super(LunchEntity.class);
    }
    
}
