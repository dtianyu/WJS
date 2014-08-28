/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.DocumentBean;
import com.wjs.entity.Document;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "documentManagedBean")
@SessionScoped
public class DocumentManagedBean extends SuperManagedBean<Document> {

    @EJB
    private DocumentBean documentBean;
    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean userManagedBean;

    /**
     * Creates a new instance of DocumentManagedBean
     */
    public DocumentManagedBean() {
    }
    
    @Override
    public void init(){
        setSessionBean(documentBean);
        super.init();
    }

    @Override
    public void create() {
         if (getNewEntity() == null) {
            Document entity = new Document();
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
     * @return the documentBean
     */
    public DocumentBean getDocumentBean() {
        return documentBean;
    }

    /**
     * @param documentBean the documentBean to set
     */
    public void setDocumentBean(DocumentBean documentBean) {
        this.documentBean = documentBean;
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
    public String viewDetail(Document entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
