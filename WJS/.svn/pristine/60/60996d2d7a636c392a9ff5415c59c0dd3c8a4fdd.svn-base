/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.DocKindBean;
import com.wjs.entity.DocKind;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "docKindManagedBean")
@SessionScoped
public class DocKindManagedBean extends SuperManagedBean<DocKind> {

    @EJB
    private DocKindBean docKindBean;
    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean userManagedBean;

    /**
     * Creates a new instance of DocKindManagedBean
     */
    public DocKindManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(docKindBean);
        super.init();
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            DocKind entity = new DocKind();
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
     * @return the docKindBean
     */
    public DocKindBean getDocKindBean() {
        return docKindBean;
    }

    /**
     * @param docKindBean the docKindBean to set
     */
    public void setDocKindBean(DocKindBean docKindBean) {
        this.docKindBean = docKindBean;
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
