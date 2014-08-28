/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.SupervisionBean;
import com.wjs.entity.Supervision;
import com.wjs.lazy.SupervisionModel;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "supervisionManagedBean")
@SessionScoped
public class SupervisonManagedBean extends SuperManagedBean<Supervision> {

    @EJB
    private SupervisionBean supervisionBean;
    @ManagedProperty("#{userManagedBean}")
    private UserManagedBean userManagedBean;

    /**
     * Creates a new instance of SupervisonManagedBean
     */
    public SupervisonManagedBean() {

    }

    @Override
    public void init() {
        setSessionBean(supervisionBean);
        setModel(new SupervisionModel(supervisionBean,com.wjs.web.Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            Supervision entity = new Supervision();
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
     * @return the supervisionBean
     */
    public SupervisionBean getSupervisionBean() {
        return supervisionBean;
    }

    /**
     * @param supervisionBean the supervisionBean to set
     */
    public void setSupervisionBean(SupervisionBean supervisionBean) {
        this.supervisionBean = supervisionBean;
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
    public String viewDetail(Supervision entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
