/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.comm.SuperEJB;
import com.wjs.entity.Briefing;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author kevintung
 */
@Stateless
@LocalBean
public class BriefingBean extends SuperEJB<Briefing> {

    public BriefingBean() {
        this.className = "Briefing";
    }

    @Override
    public List<Briefing> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Briefing getNextById(String value) {
        Briefing entity = super.getNextById(value);
        if (entity == null) {
            entity = new Briefing(0, "没有了");
        }
        return entity;
    }

    @Override
    public Briefing getPrevById(String value) {
        Briefing entity = super.getPrevById(value);
        if (entity == null) {
            entity = new Briefing(0, "没有了");
        }
        return entity;
    }
}
