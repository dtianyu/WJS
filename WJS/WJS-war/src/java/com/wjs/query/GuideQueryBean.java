/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.GuideBean;
import com.wjs.ebj.GuideKindBean;
import com.wjs.entity.Guide;
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
@ManagedBean(name = "guideQueryBean")
@RequestScoped
public class GuideQueryBean {

    @EJB
    private GuideKindBean guideKindBean;
    @EJB
    private GuideBean guideBean;

    private List<Guide> entityList;
    private Guide currentEntity;

    /**
     * Creates a new instance of GuideQueryBean
     */
    public GuideQueryBean() {
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
        String id = "";
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map map = ec.getRequestParameterMap();
        if (!map.isEmpty() && map.containsKey("kind")) {
            kind = map.get("kind").toString();
        }
        if (!map.isEmpty() && map.containsKey("id")) {
            id = map.get("id").toString();
        }
        if (kind.equals("")) {
            kind = guideKindBean.findAll(0, 0).get(0).getId().toString();
        }
        if (kind != null) {
            setEntityList(guideBean.getByPId(kind));
        }
        if (!id.equals("")) {
            setCurrentEntity(guideBean.getById(id));
        } else {
            setCurrentEntity(getEntityList().get(0));
        }
    }

    /**
     * @return the entityList
     */
    public List<Guide> getEntityList() {
        return entityList;
    }

    /**
     * @param entityList the entityList to set
     */
    public void setEntityList(List<Guide> entityList) {
        this.entityList = entityList;
    }

    /**
     * @return the docKindBean
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

    /**
     * @return the currentEntity
     */
    public Guide getCurrentEntity() {
        return currentEntity;
    }

    /**
     * @param currentEntity the currentEntity to set
     */
    public void setCurrentEntity(Guide currentEntity) {
        this.currentEntity = currentEntity;
    }

    /**
     * @return the guideBean
     */
    public GuideBean getGuideBean() {
        return guideBean;
    }

    /**
     * @param guideBean the guideBean to set
     */
    public void setGuideBean(GuideBean guideBean) {
        this.guideBean = guideBean;
    }

}
