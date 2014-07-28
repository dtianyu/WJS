/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wjs.ebj;

import com.wjs.comm.SuperEJB;
import com.wjs.entity.DocKind;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author kevintung
 */
@Stateless
@LocalBean
public class DocKindBean extends SuperEJB<DocKind>{

    public DocKindBean(){
        this.className="DocKind";
    }
    
    @Override
    public List<DocKind> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
