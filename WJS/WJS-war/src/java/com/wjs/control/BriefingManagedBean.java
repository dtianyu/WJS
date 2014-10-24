/*
 * To change this briefing header, choose Briefing Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.BriefingBean;
import com.wjs.entity.Briefing;
import com.wjs.lazy.BriefingModel;
import com.wjs.web.Scope;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author C0160
 */
@ManagedBean
@SessionScoped
public class BriefingManagedBean extends SuperManagedBean<Briefing> {

    @EJB
    private BriefingBean briefingBean;
    @ManagedProperty(value = "#{userManagedBean}")
    protected UserManagedBean userManagedBean;

    /**
     * Creates a new instance of BriefingManagedBean
     */
    public BriefingManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(briefingBean);
        setModel(new BriefingModel(briefingBean, Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            Briefing entity = new Briefing();
            entity.setOntop(true);
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
     * @return the briefingBean
     */
    public BriefingBean getBriefingBean() {
        return briefingBean;
    }

    /**
     * @param briefingBean the briefingBean to set
     */
    public void setBriefingBean(BriefingBean briefingBean) {
        this.briefingBean = briefingBean;
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
    public String viewDetail(Briefing entity) {
        if (entity != null) {
            setCurrentEntity(entity);
            return "briefingView";
        }
        return "briefingAdmin";
    }

}
