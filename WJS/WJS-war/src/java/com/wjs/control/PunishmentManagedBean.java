/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.PunishmentBean;
import com.wjs.entity.Punishment;
import com.wjs.lazy.PunishmentModel;
import com.wjs.web.SuperManagedBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;

/**
 *
 * @author C0160
 */
@Named(value = "punishmentManagedBean")
@SessionScoped
public class PunishmentManagedBean extends SuperManagedBean<Punishment> {

    @EJB
    protected PunishmentBean punishmentBean;
    @ManagedProperty("#{userManagedBean}")
    protected UserManagedBean userManagedBean;

    /**
     * Creates a new instance of PunishmentManagedBean
     */
    public PunishmentManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(punishmentBean);
        setModel(new PunishmentModel(punishmentBean, com.wjs.web.Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            Punishment entity = new Punishment();
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
            getCurrentEntity().setCfmuser(null);
            getCurrentEntity().setCfmdate(null);
            getCurrentEntity().setOptuser(userManagedBean.getUserid());
            getCurrentEntity().setOptdate(userManagedBean.getDate());
            save();
        }
    }

    /**
     * @return the punishmentBean
     */
    public PunishmentBean getPunishmentBean() {
        return punishmentBean;
    }

    /**
     * @param punishmentBean the punishmentBean to set
     */
    public void setPunishmentBean(PunishmentBean punishmentBean) {
        this.punishmentBean = punishmentBean;
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
