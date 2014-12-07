/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.HonorBean;
import com.wjs.entity.Honor;
import com.wjs.lazy.HonorModel;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean
@SessionScoped
public class HonorManagedBean extends SuperManagedBean<Honor> {

    @EJB
    private HonorBean honorBean;
    @ManagedProperty("#{userManagedBean}")
    private UserManagedBean userManagedBean;

    public HonorManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(getHonorBean());
        setModel(new HonorModel(getHonorBean(), com.wjs.web.Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            Honor entity = new Honor();
            entity.setOntop(true);
            entity.setStatus("N");
            entity.setCreator(getUserManagedBean().getCurrentUser().getUserid());
            entity.setCredate(getUserManagedBean().getDate());
            setNewEntity(entity);
        }
    }

    @Override
    public void verify() {
        if (getCurrentEntity() != null) {
            getCurrentEntity().setStatus("V");
            getCurrentEntity().setCfmuser(userManagedBean.getUserid());
            getCurrentEntity().setCfmdate(userManagedBean.getDate());
            save();
        }
    }

    @Override
    public void unverify() {
        if (getCurrentEntity() != null) {
            getCurrentEntity().setStatus("M");
            getCurrentEntity().setOptuser(getUserManagedBean().getCurrentUser().getUserid());
            getCurrentEntity().setOptdate(getUserManagedBean().getDate());
            getCurrentEntity().setCfmuser(null);
            getCurrentEntity().setCfmdate(null);
            save();
        }
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

    /**
     * @return the honorBean
     */
    public HonorBean getHonorBean() {
        return honorBean;
    }

    /**
     * @param honorBean the honorBean to set
     */
    public void setHonorBean(HonorBean honorBean) {
        this.honorBean = honorBean;
    }

    @Override
    public String viewDetail(Honor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
