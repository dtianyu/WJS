/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.entity.Notice;
import com.wjs.comm.SuperEJB;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author kevintung
 */
@Stateless
@LocalBean
public class NoticeBean extends SuperEJB<Notice> {

    public NoticeBean() {
        this.className = "Notice";
    }

    @Override
    public List<Notice> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Notice getNextById(String value) {
        Notice entity = super.getNextById(value);
        if (entity == null) {
            entity = new Notice(0, "没有了");
        }
        return entity;
    }

    @Override
    public Notice getPrevById(String value) {
        Notice entity = super.getPrevById(value);
        if (entity == null) {
            entity = new Notice(0, "没有了");
        }
        return entity;
    }

}
