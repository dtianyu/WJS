/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.PartyInfoBean;
import com.wjs.entity.PartyInfo;
import com.wjs.lazy.PartyInfoModel;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "partyInfoManagedBean")
@SessionScoped
public class PartyInfoManagedBean extends SuperManagedBean<PartyInfo> {

    @EJB
    protected PartyInfoBean partyInfoBean;
    @ManagedProperty("#{userManagedBean}")
    protected UserManagedBean userManagedBean;

    /**
     * Creates a new instance of NewsManagedBean
     */
    public PartyInfoManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(partyInfoBean);
        setModel(new PartyInfoModel(partyInfoBean,com.wjs.web.Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            PartyInfo entity = new PartyInfo();
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
     * @return the partyInfoBean
     */
    public PartyInfoBean getPartyInfoBean() {
        return partyInfoBean;
    }

    /**
     * @param partyInfoBean
     */
    public void setPartyInfoBean(PartyInfoBean partyInfoBean) {
        this.partyInfoBean = partyInfoBean;
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
    public String viewDetail(PartyInfo entity) {
         if (entity != null) {
            setCurrentEntity(entity);
            return "partyInfoView";
        }
        return "partyInfoAdmin";
    }

}
