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
    private List<Document> topPPTList;

    /**
     * Creates a new instance of DocKindQueryBean
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
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map map = ec.getRequestParameterMap();
        if (!map.isEmpty() && map.containsKey("kind")) {
            kind = map.get("kind").toString();
        }
        if (kind.equals("")) {
            kind = docKindBean.findAll(0, 1).get(0).getId().toString();
        }
        if (kind != null) {
            setEntityList(getDocumentBean().getByPId(kind));
        }
        setTopPPTList(getDocumentBean().getByPId("3").subList(0, 8));
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
     * @return the topPPTList
     */
    public List<Document> getTopPPTList() {
        return topPPTList;
    }

    /**
     * @param topPPTList the topPPTList to set
     */
    public void setTopPPTList(List<Document> topPPTList) {
        this.topPPTList = topPPTList;
    }

}
