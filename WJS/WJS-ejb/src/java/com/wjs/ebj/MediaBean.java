/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wjs.ebj;

import com.wjs.comm.SuperEJB;
import com.wjs.entity.Media;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author kevintung
 */
@Stateless
@LocalBean
public class MediaBean extends SuperEJB<Media> {
    
    public MediaBean(){
        this.className="Media";
    }

    @Override
    public List<Media> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
