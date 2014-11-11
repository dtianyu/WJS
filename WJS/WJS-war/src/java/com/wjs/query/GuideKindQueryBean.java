/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.GuideKindBean;
import com.wjs.entity.GuideKind;
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
@ManagedBean(name = "guideKindQueryBean")
@RequestScoped
public class GuideKindQueryBean {
    @EJB
    private GuideKindBean guideKindBean;

    private List<GuideKind> entityList;

    /**
     * Creates a new instance of GuideKindQueryBean
     */
    public GuideKindQueryBean() {
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
        setEntityList(guideKindBean.findAll());
    }

    /**
     * @return the entityList
     */
    public List<GuideKind> getEntityList() {
        return entityList;
    }

    /**
     * @param entityList the entityList to set
     */
    public void setEntityList(List<GuideKind> entityList) {
        this.entityList = entityList;
    }

    /**
     * @return the guideKindBean
     */
    public GuideKindBean getGuideKindBean() {
        return guideKindBean;
    }

    /**
     * @param guideKindBean the guideKindBean to set
     */
    public void setGuideKindBean(GuideKindBean guideKindBean) {
        this.guideKindBean = guideKindBean;
    }

}
