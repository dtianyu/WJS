/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.entity.License;
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
public class LicenseBean extends SuperEJB<License> {

    public LicenseBean() {
        this.className = "License";
    }

    @Override
    public List<License> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public License getPrevById(String value) {
        License entity = super.getPrevById(value);
        if (entity == null) {
            entity = new License(0, "没有了");
        }
        return entity;
    }

    @Override
    public License getNextById(String value) {
        License entity = super.getNextById(value);
        if (entity == null) {
            entity = new License(0, "没有了");
        }
        return entity;
    }

}
