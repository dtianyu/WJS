/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.NoticeBean;
import com.wjs.entity.Notice;
import com.wjs.lazy.NoticeModel;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "noticeManagedBean")
@SessionScoped
public class NoticeManagedBean extends SuperManagedBean<Notice> {

    @EJB
    protected NoticeBean noticeBean;
    @ManagedProperty("#{userManagedBean}")
    protected UserManagedBean userManagedBean;

    /**
     * Creates a new instance of NoticeManagedBean
     */
    public NoticeManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(getNoticeBean());
        setModel(new NoticeModel(noticeBean, com.wjs.web.Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            Notice entity = new Notice();
            entity.setOntop(false);
            entity.setHits(0);
            entity.setStatus("N");
            entity.setCreator(getUserManagedBean().getCurrentUser().getUserid());
            entity.setCredate(getUserManagedBean().getDate());
            setNewEntity(entity);
        }
    }

    @Override
    public void sendNotification(Notice entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verify() {
        if (getCurrentEntity() != null) {
            getCurrentEntity().setStatus("V");
            getCurrentEntity().setCfmuser(userManagedBean.getUserid());
            getCurrentEntity().setCfmdate(userManagedBean.getDate());
            save();
        }
    }

    @Override
    public void unverify() {
        if (getCurrentEntity() != null) {
            getCurrentEntity().setStatus("M");
            getCurrentEntity().setCfmuser(null);
            getCurrentEntity().setCfmdate(null);
            getCurrentEntity().setOptuser(userManagedBean.getUserid());
            getCurrentEntity().setOptdate(userManagedBean.getDate());
            save();
        }
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

    /**
     * @return the noticeBean
     */
    public NoticeBean getNoticeBean() {
        return noticeBean;
    }

    /**
     * @param noticeBean the noticeBean to set
     */
    public void setNoticeBean(NoticeBean noticeBean) {
        this.noticeBean = noticeBean;
    }

    @Override
    public String viewDetail(Notice entity) {
        if (entity != null) {
            setCurrentEntity(entity);
            return "noticeView";
        }
        return "noticeAdmin";
    }

}
