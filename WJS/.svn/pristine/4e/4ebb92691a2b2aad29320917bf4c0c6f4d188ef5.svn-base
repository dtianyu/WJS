/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.comm.SuperEJB;
import com.wjs.entity.PartyGroup;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author kevintung
 */
@Stateless
@LocalBean
public class PartyGroupBean extends SuperEJB<PartyGroup> {

    public PartyGroupBean() {
        this.className = "PartyGroup";
    }

    @Override
    public List<PartyGroup> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PartyGroup getPrevById(String value) {
        PartyGroup entity = super.getPrevById(value);
        if (entity == null) {
            entity = new PartyGroup(0, "没有了");
        }
        return entity;
    }

    @Override
    public PartyGroup getNextById(String value) {
        PartyGroup entity = super.getNextById(value);
        if (entity == null) {
            entity = new PartyGroup(0, "没有了");
        }
        return entity;
    }

}
