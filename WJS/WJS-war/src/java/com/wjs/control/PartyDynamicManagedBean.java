/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.PartyDynamicBean;
import com.wjs.entity.PartyDynamic;
import com.wjs.lazy.PartyDynamicModel;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "partyDynamicManagedBean")
@SessionScoped
public class PartyDynamicManagedBean extends SuperManagedBean<PartyDynamic> {

    @EJB
    protected PartyDynamicBean partyDynamicBean;
    @ManagedProperty("#{userManagedBean}")
    protected UserManagedBean userManagedBean;

    /**
     * Creates a new instance of NewsManagedBean
     */
    public PartyDynamicManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(partyDynamicBean);
        setModel(new PartyDynamicModel(partyDynamicBean, com.wjs.web.Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            PartyDynamic entity = new PartyDynamic();
            entity.setOntop(false);
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
     * @return the partyDynamicBean
     */
    public PartyDynamicBean getPartyDynamicBean() {
        return partyDynamicBean;
    }

    /**
     * @param partyDynamicBean
     */
    public void setPartyDynamicBean(PartyDynamicBean partyDynamicBean) {
        this.partyDynamicBean = partyDynamicBean;
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

    @Override
    public String viewDetail(PartyDynamic entity) {
        if (entity != null) {
            setCurrentEntity(entity);
            return "partyDynamicView";
        }
        return "partyDynamicAdmin";
    }

}
