/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.SystemUserBean;
import com.wjs.entity.SystemUser;
import com.wjs.lazy.SystemUserModel;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "systemUserManagedBean")
@SessionScoped
public class SystemUserManagedBean extends SuperManagedBean<SystemUser> {

    @EJB
    private SystemUserBean systemUserBean;

    @ManagedProperty("#{userManagedBean}")
    private UserManagedBean userManagedBean;

    /**
     * Creates a new instance of SystemUserManagedBean
     */
    public SystemUserManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(systemUserBean);
        setModel(new SystemUserModel(systemUserBean));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            SystemUser entity = new SystemUser();
            entity.setStatus("N");
            entity.setCreator(userManagedBean.getUserid());
            entity.setCredate(userManagedBean.getDate());
            setNewEntity(entity);
        }
    }   

    @Override
    public void verify() {

    }

    @Override
    public void unverify() {

    }

    /**
     * @return the systemUserBean
     */
    public SystemUserBean getSystemUserBean() {
        return systemUserBean;
    }

    /**
     * @param systemUserBean the systemUserBean to set
     */
    public void setSystemUserBean(SystemUserBean systemUserBean) {
        this.systemUserBean = systemUserBean;
    }

    /**
     * @return the userManagedBean
     */
    public UserManagedBean getUserManagedBean() {
        return userManagedBean;
    }

    /**
     * @param userManagedBean the userManagedBean to set
     */
    public void setUserManagedBean(UserManagedBean userManagedBean) {
        this.userManagedBean = userManagedBean;
    }

}
