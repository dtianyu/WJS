/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.comm.SuperEJB;
import com.wjs.entity.Guide;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author kevintung
 */
@Stateless
@LocalBean
public class GuideBean extends SuperEJB<Guide> {
    
    public GuideBean(){
        this.className="Guide";
    }

    @Override
    public List<Guide> getByPId(String value) {
        Query query = em.createNamedQuery(getClassName() + ".findByPId");
        query.setParameter("kind", Integer.parseInt(value));
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
