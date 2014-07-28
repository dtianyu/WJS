/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.PageInfoBean;
import com.wjs.entity.PageInfo;
import com.wjs.web.ManagedBeanDataOperation;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "pageInfoManagedBean")
@SessionScoped
public class PageInfoManagedBean implements ManagedBeanDataOperation<PageInfo> {

    @EJB
    private PageInfoBean pageInfoBean;

    private PageInfo currentPageInfo;
    private PageInfo newPageInfo;
    private List<PageInfo> pageInfoList;
    @ManagedProperty("#{userManagedBean}")
    private UserManagedBean userManagedBean;

    /**
     * Creates a new instance of PageInfoManagedBean
     */
    public PageInfoManagedBean() {
    }

    @PostConstruct
    public void construct() {
        init();
        create();
    }

    @PreDestroy
    public void destory() {
        if (getPageInfoList() != null) {
            getPageInfoList().clear();
            setPageInfoList(null);
        }
        setCurrentPageInfo(null);
        setNewPageInfo(null);
    }

    @Override
    public void init() {
        setPageInfoList(retrieve());
        if (!getPageInfoList().isEmpty()) {
            setCurrentPageInfo(getPageInfoList().get(0));
        }
    }

    @Override
    public void create() {
        if (getNewPageInfo() == null) {
            PageInfo entity = new PageInfo();
            entity.setStatus("N");
            entity.setCreator(getUserManagedBean().getCurrentUser().getUserid());
            entity.setCredate(getUserManagedBean().getDate());
            setNewPageInfo(entity);
        }
    }

    @Override
    public void delete(PageInfo entity) {
        if (entity != null) {
            try {
                pageInfoBean.delete(entity);
                if (getPageInfoList().contains(entity)) {
                    getPageInfoList().remove(entity);
                }
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, e.toString()));
            }
            init();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, "删除成功！"));
        }
    }

    @Override
    public void edit(PageInfo entity) {
        if (entity != null) {
            setCurrentPageInfo(entity);
        }
    }

    @Override
    public void persist() {
        if (getNewPageInfo() != null) {
            try {
                pageInfoBean.persist(getNewPageInfo());
                if (!getPageInfoList().contains(getNewPageInfo())) {
                    getPageInfoList().add(getNewPageInfo());
                }
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, e.getMessage()));
            }
            setNewPageInfo(null);
            init();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null,"更新成功！"));
        }
    }

    @Override
    public List<PageInfo> retrieve() {
        return pageInfoBean.retrieve();
    }

    @Override
    public void save() {
        if (currentPageInfo != null) {
            try {
                currentPageInfo.setOptuser(userManagedBean.getUserid());
                currentPageInfo.setOptdate(userManagedBean.getDate());
                pageInfoBean.update(getCurrentPageInfo());
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, e.getMessage()));
            }
            init();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("更新成功！"));
        }
    }

    @Override
    public void sendNotification(PageInfo entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void view(PageInfo entity) {
        if (entity != null) {
            setCurrentPageInfo(entity);
        }
    }

    @Override
    public void verify() {
        if (getCurrentPageInfo() != null) {
            getCurrentPageInfo().setCfmuser(userManagedBean.getUserid());
            getCurrentPageInfo().setCfmdate(userManagedBean.getDate());
            getCurrentPageInfo().setStatus("V");
            save();
        }
    }

    @Override
    public void unverify() {
        if (getCurrentPageInfo() != null) {
            getCurrentPageInfo().setCfmuser(null);
            getCurrentPageInfo().setCfmdate(null);
            getCurrentPageInfo().setOptuser(userManagedBean.getUserid());
            getCurrentPageInfo().setOptdate(userManagedBean.getDate());
            getCurrentPageInfo().setStatus("M");
            save();
        }
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

    /**
     * @return the newPageInfo
     */
    public PageInfo getNewPageInfo() {
        return newPageInfo;
    }

    /**
     * @param newPageInfo the newPageInfo to set
     */
    public void setNewPageInfo(PageInfo newPageInfo) {
        this.newPageInfo = newPageInfo;
    }

    /**
     * @return the pageInfoList
     */
    public List<PageInfo> getPageInfoList() {
        return pageInfoList;
    }

    /**
     * @param pageInfoList the pageInfoList to set
     */
    public void setPageInfoList(List<PageInfo> pageInfoList) {
        this.pageInfoList = pageInfoList;
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
