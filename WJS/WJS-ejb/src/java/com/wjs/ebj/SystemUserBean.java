/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.entity.SystemUser;
import com.wjs.comm.SuperEJB;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SystemUserBean extends SuperEJB<SystemUser> {

    public SystemUserBean(){
        this.className = "SystemUser";
    }

    @Override
    public List<SystemUser> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SystemUser getByIdAndPwd(String id, String pwd) {
        Query query = em.createNamedQuery("SystemUser.findByIdAndPwd");
        query.setParameter("userid", id);
        query.setParameter("pwd", pwd);
        try {
            return (SystemUser) query.getSingleResult();
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

}
