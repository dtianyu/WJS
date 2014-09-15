/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.KnowledgeBean;
import com.wjs.entity.Knowledge;
import com.wjs.lazy.KnowledgeModel;
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
@ManagedBean(name = "knowledgeManagedBean")
@SessionScoped
public class KnowledgeManagedBean extends SuperManagedBean<Knowledge> {

    @EJB
    private KnowledgeBean knowledgeBean;
    @ManagedProperty(value = "#{userManagedBean}")
    protected UserManagedBean userManagedBean;

    /**
     * Creates a new instance of KnowledgeManagedBean
     */
    public KnowledgeManagedBean() {

    }

    @Override
    public void init() {
        setSessionBean(getKnowledgeBean());
        setModel(new KnowledgeModel(knowledgeBean,Scope.Managed));       
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            Knowledge entity = new Knowledge();
            entity.setOntop(true);
            entity.setHits(0);
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
     * @return the knowledgeBean
     */
    public KnowledgeBean getKnowledgeBean() {
        return knowledgeBean;
    }

    /**
     * @param knowledgeBean the knowledgeBean to set
     */
    public void setKnowledgeBean(KnowledgeBean knowledgeBean) {
        this.knowledgeBean = knowledgeBean;
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
    public String viewDetail(Knowledge entity) {
        if (entity != null) {
            setCurrentEntity(entity);
            return "knowledgeView";
        }
        return "knowledgeAdmin";
    }

}
