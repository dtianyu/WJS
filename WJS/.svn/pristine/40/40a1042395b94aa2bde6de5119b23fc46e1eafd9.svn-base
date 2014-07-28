/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.PartyNewsBean;
import com.wjs.entity.PartyNews;
import com.wjs.lazy.PartyNewsModel;
import com.wjs.web.SuperQueryBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "partyNewsQueryBean")
@RequestScoped
public class PartyNewsQueryBean extends SuperQueryBean<PartyNews> {

    @EJB
    private PartyNewsBean partyNewsBean;
        private List<PartyNews> topNewsHasImg;


    public PartyNewsQueryBean() {
    }

    @Override
    public void init() {
        setTopList(getPartyNewsBean().findTop(8));
        if (!getTopList().isEmpty()) {
            setCurrentEntity(getTopList().get(0));
        }
        setModel(new PartyNewsModel(getPartyNewsBean(),com.wjs.web.Scope.Query));
        setTopNewsHasImg(partyNewsBean.findTopHasImg(6));
        if (getId() != null) {
            setCurrentEntity(getPartyNewsBean().getById(getId()));
            if (getCurrentEntity() != null) {
                getCurrentEntity().setHits(getCurrentEntity().getHits()+1);
                getPartyNewsBean().update(getCurrentEntity());
                setPrev(getPartyNewsBean().getPrevById(getId()));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(getPartyNewsBean().getNextById(getId()));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            } else {
                setCurrentEntity(new PartyNews(0, "没有相关资料"));
                setHasPrev(false);
                setHasNext(false);
            }
        }
    }

    @Override
    public String viewList() {
        return "partyNewsList";
    }

    /**
     * @return the partyNewsBean
     */
    public PartyNewsBean getPartyNewsBean() {
        return partyNewsBean;
    }

    /**
     * @param partyNewsBean the partyNewsBean to set
     */
    public void setPartyNewsBean(PartyNewsBean partyNewsBean) {
        this.partyNewsBean = partyNewsBean;
    }

    /**
     * @return the topNewsHasImg
     */
    public List<PartyNews> getTopNewsHasImg() {
        return topNewsHasImg;
    }

    /**
     * @param topNewsHasImg the topNewsHasImg to set
     */
    public void setTopNewsHasImg(List<PartyNews> topNewsHasImg) {
        this.topNewsHasImg = topNewsHasImg;
    }



}
