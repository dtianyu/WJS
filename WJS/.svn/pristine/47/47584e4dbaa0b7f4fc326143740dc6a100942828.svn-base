/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.entity.Knowledge;
import com.wjs.comm.SuperEJB;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class KnowledgeBean extends SuperEJB<Knowledge> {

    public KnowledgeBean() {
        this.className = "Knowledge";
    }

    @Override
    public List<Knowledge> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Knowledge getNextById(String value) {
        Knowledge entity = super.getNextById(value);
        if (entity == null) {
            entity = new Knowledge(0, "没有了");
        }
        return entity;
    }

    @Override
    public Knowledge getPrevById(String value) {
        Knowledge entity = super.getPrevById(value);
        if (entity == null) {
            entity = new Knowledge(0, "没有了");
        }
        return entity;
    }

}
