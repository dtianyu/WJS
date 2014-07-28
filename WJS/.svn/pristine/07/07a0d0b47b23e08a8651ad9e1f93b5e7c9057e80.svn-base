/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.comm.SuperEJB;
import com.wjs.entity.PartyDynamic;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author kevintung
 */
@Stateless
@LocalBean
public class PartyDynamicBean extends SuperEJB<PartyDynamic> {

    public PartyDynamicBean() {
        this.className = "PartyDynamic";
    }

    @Override
    public List<PartyDynamic> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PartyDynamic getPrevById(String value) {
        PartyDynamic entity = super.getPrevById(value);
        if (entity == null) {
            entity = new PartyDynamic(0, "没有了");
        }
        return entity;
    }

    @Override
    public PartyDynamic getNextById(String value) {
        PartyDynamic entity = super.getNextById(value);
        if (entity == null) {
            entity = new PartyDynamic(0, "没有了");
        }
        return entity;
    }

}
