/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wjs.ebj;

import com.wjs.comm.SuperEJB;
import com.wjs.entity.GuideKind;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author kevintung
 */
@Stateless
@LocalBean
public class GuideKindBean extends SuperEJB<GuideKind>{

    public GuideKindBean(){
        this.className="GuideKind";
    }
    
    @Override
    public List<GuideKind> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
