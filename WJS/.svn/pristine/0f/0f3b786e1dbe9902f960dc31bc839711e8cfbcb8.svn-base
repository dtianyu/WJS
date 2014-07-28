/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.comm.SuperEJB;
import com.wjs.entity.PartyInfo;
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
public class PartyInfoBean extends SuperEJB<PartyInfo> {

    public PartyInfoBean() {
        this.className = "PartyInfo";
    }

    @Override
    public List<PartyInfo> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PartyInfo getPrevById(String value) {
        PartyInfo entity = super.getPrevById(value);
        if (entity == null) {
            entity = new PartyInfo(0, "没有了");
        }
        return entity;
    }

    @Override
    public PartyInfo getNextById(String value) {
        PartyInfo entity = super.getNextById(value);
        if (entity == null) {
            entity = new PartyInfo(0, "没有了");
        }
        return entity;
    }

}
