/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wjs.ebj;

import com.wjs.comm.SuperEJB;
import com.wjs.entity.Honor;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author kevintung
 */
@Stateless
@LocalBean
public class HonorBean extends SuperEJB<Honor> {
    
    public HonorBean(){
        this.className="Honor";
    }

    @Override
    public List<Honor> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
