/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.PartyNewsBean;
import com.wjs.entity.PartyNews;
import com.wjs.lazy.PartyNewsModel;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "partyNewsManagedBean")
@SessionScoped
public class PartyNewsManagedBean extends SuperManagedBean<PartyNews> {

    @EJB
    protected PartyNewsBean partyNewsBean;
    @ManagedProperty("#{userManagedBean}")
    protected UserManagedBean userManagedBean;

    /**
     * Creates a new instance of NewsManagedBean
     */
    public PartyNewsManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(partyNewsBean);
        setModel(new PartyNewsModel(partyNewsBean,com.wjs.web.Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            PartyNews entity = new PartyNews();
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
     * @return the partyNewsBean
     */
    public PartyNewsBean getPartyNewsBean() {
        return partyNewsBean;
    }

    /**
     * @param partyNewsBean
     */
    public void setPartyNewsBean(PartyNewsBean partyNewsBean) {
        this.partyNewsBean = partyNewsBean;
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
    public String viewDetail(PartyNews entity) {
         if (entity != null) {
            setCurrentEntity(entity);
            return "partyNewsView";
        }
        return "partyNewsAdmin";
    }

}
