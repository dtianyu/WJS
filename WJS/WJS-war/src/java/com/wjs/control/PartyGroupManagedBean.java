/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.PartyGroupBean;
import com.wjs.entity.PartyGroup;
import com.wjs.lazy.PartyGroupModel;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "partyGroupManagedBean")
@SessionScoped
public class PartyGroupManagedBean extends SuperManagedBean<PartyGroup> {

    @EJB
    protected PartyGroupBean partyGroupBean;
    @ManagedProperty("#{userManagedBean}")
    protected UserManagedBean userManagedBean;

    /**
     * Creates a new instance of NewsManagedBean
     */
    public PartyGroupManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(partyGroupBean);
        setModel(new PartyGroupModel(partyGroupBean,com.wjs.web.Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            PartyGroup entity = new PartyGroup();
            entity.setOntop(false);
            entity.setStatus("N");
            entity.setHits(0);
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
     * @return the partyGroupBean
     */
    public PartyGroupBean getPartyGroupBean() {
        return partyGroupBean;
    }

    /**
     * @param partyGroupBean
     */
    public void setPartyGroupBean(PartyGroupBean partyGroupBean) {
        this.partyGroupBean = partyGroupBean;
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
    public String viewDetail(PartyGroup entity) {
          if (entity != null) {
            setCurrentEntity(entity);
            return "partyGroupView";
        }
        return "partyGroupAdmin";
    }

}
