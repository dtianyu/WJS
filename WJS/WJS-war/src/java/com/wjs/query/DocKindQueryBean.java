/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.DocKindBean;
import com.wjs.entity.DocKind;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "docKindQueryBean")
@RequestScoped
public class DocKindQueryBean {

    @EJB
    private DocKindBean docKindBean;
    private List<DocKind> entityList;

    /**
     * Creates a new instance of DocKindQueryBean
     */
    public DocKindQueryBean() {
    }
    
        
    @PostConstruct
    public void construct(){
        init();
    }
    
    @PreDestroy
    public void destory(){
        if(entityList!=null){
            getEntityList().clear();
            setEntityList(null);
        }
    }

    public void init() {
        setEntityList(docKindBean.findAll());
    }

    /**
     * @return the entityList
     */
    public List<DocKind> getEntityList() {
        return entityList;
    }

    /**
     * @param entityList the entityList to set
     */
    public void setEntityList(List<DocKind> entityList) {
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

}
