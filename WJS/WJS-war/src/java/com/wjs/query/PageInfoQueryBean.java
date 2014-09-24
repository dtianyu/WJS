/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.PageInfoBean;
import com.wjs.entity.PageInfo;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "pageInfoQueryBean")
@RequestScoped
public class PageInfoQueryBean {

    @EJB
    private PageInfoBean pageInfoBean;
    private PageInfo currentPageInfo;

    /**
     * Creates a new instance of PageInfoQueryBean
     */
    public PageInfoQueryBean() {
    }

    @PostConstruct
    public void construct() {
        init();
    }

    @PreDestroy
    public void destroy() {
        setCurrentPageInfo(null);
    }

    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        String page = fc.getViewRoot().getViewId();
        setCurrentPageInfo(pageInfoBean.getById(page.substring(1)));
    }

    /**
     * @return the currentPageInfo
     */
    public PageInfo getCurrentPageInfo() {
        return currentPageInfo;
    }

    /**
     * @param currentPageInfo the currentPageInfo to set
     */
    public void setCurrentPageInfo(PageInfo currentPageInfo) {
        this.currentPageInfo = currentPageInfo;
    }

}
