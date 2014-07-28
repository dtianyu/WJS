/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.comm.SuperEJB;
import com.wjs.entity.Complaint;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class ComplaintBean extends SuperEJB<Complaint> {

    public ComplaintBean() {
        this.className = "Complaint";
    }

    @Override
    public List<Complaint> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Complaint getNextById(String value) {
        Complaint entity = super.getNextById(value);
        if (entity == null) {
            entity = new Complaint(0, "没有了");
        }
        return entity;
    }

    @Override
    public Complaint getPrevById(String value) {
        Complaint entity = super.getPrevById(value);
        if (entity == null) {
            entity = new Complaint(0, "没有了");
        }
        return entity;
    }

    public List<Complaint> findToDo() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM Complaint c WHERE c.status<>'V' ");
        Query query = em.createQuery(sb.toString()).setFirstResult(0).setMaxResults(6);
        return query.getResultList();
    }
}
