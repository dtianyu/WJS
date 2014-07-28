/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.InspectionBean;
import com.wjs.entity.Inspection;
import com.wjs.lazy.InspectionModel;
import com.wjs.web.Scope;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "inspectionManagedBean")
@SessionScoped
public class InspectionManagedBean extends SuperManagedBean<Inspection> {

    @EJB
    private InspectionBean inspectionBean;
    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean userManagedBean;

    /**
     * Creates a new instance of InspectionManagedBean
     */
    public InspectionManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(inspectionBean);
        setModel(new InspectionModel(inspectionBean, Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            Inspection entity = new Inspection();
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
            getCurrentEntity().setCfmuser(getUserManagedBean().getCurrentUser().getUserid());
            getCurrentEntity().setCfmdate(getUserManagedBean().getDate());
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
     * @return the inspectionBean
     */
    public InspectionBean getInspectionBean() {
        return inspectionBean;
    }

    /**
     * @param inspectionBean the inspectionBean to set
     */
    public void setInspectionBean(InspectionBean inspectionBean) {
        this.inspectionBean = inspectionBean;
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
