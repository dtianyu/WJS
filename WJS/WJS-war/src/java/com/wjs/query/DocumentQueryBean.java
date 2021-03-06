/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.DocKindBean;
import com.wjs.ebj.DocumentBean;
import com.wjs.entity.Document;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "documentQueryBean")
@RequestScoped
public class DocumentQueryBean {

    @EJB
    private DocumentBean documentBean;
    @EJB
    private DocKindBean docKindBean;
    private List<Document> entityList;
    private Document currentEntity;

    /**
     * Creates a new instance of DocumentQueryBean
     */
    public DocumentQueryBean() {
    }

    @PostConstruct
    public void construct() {
        init();
    }

    @PreDestroy
    public void destory() {
        if (getEntityList() != null) {
            getEntityList().clear();
            setEntityList(null);
        }
    }

    public void init() {
        String kind = "";
        String id="";
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map map = ec.getRequestParameterMap();
        if (!map.isEmpty() && map.containsKey("kind")) {
            kind = map.get("kind").toString();
        }
        if (!map.isEmpty() && map.containsKey("id")) {
            id = map.get("id").toString();
        }
        if (kind.equals("")) {
            kind = docKindBean.findAll(0, 0).get(0).getId().toString();
        }
        if (kind != null) {
            setEntityList(getDocumentBean().getByPId(kind));
        }        
        if (!id.equals("")) {
            setCurrentEntity(getDocumentBean().getById(id));
        }
        else{
            setCurrentEntity(getEntityList().get(0));
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
     * @return the entityList
     */
    public List<Document> getEntityList() {
        return entityList;
    }

    /**
     * @param entityList the entityList to set
     */
    public void setEntityList(List<Document> entityList) {
        this.entityList = entityList;
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
     * @return the currentEntity
     */
    public Document getCurrentEntity() {
        return currentEntity;
    }

    /**
     * @param currentEntity the currentEntity to set
     */
    public void setCurrentEntity(Document currentEntity) {
        this.currentEntity = currentEntity;
    }

}
