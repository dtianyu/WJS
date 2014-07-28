/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.PartyInfoBean;
import com.wjs.entity.PartyInfo;
import com.wjs.lazy.PartyInfoModel;
import com.wjs.web.SuperQueryBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "partyInfoQueryBean")
@RequestScoped
public class PartyInfoQueryBean extends SuperQueryBean<PartyInfo> {

    @EJB
    private PartyInfoBean partyInfoBean;

    public PartyInfoQueryBean() {
    }

    @Override
    public void init() {
        setTopList(getPartyInfoBean().findTop(8));
        if (!getTopList().isEmpty()) {
            setCurrentEntity(getTopList().get(0));
        }
        setModel(new PartyInfoModel(getPartyInfoBean(),com.wjs.web.Scope.Query));
        if (getId() != null) {
            setCurrentEntity(getPartyInfoBean().getById(getId()));
            if (getCurrentEntity() != null) {
                getCurrentEntity().setHits(getCurrentEntity().getHits()+1);
                getPartyInfoBean().update(getCurrentEntity());
                setPrev(getPartyInfoBean().getPrevById(getId()));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(getPartyInfoBean().getNextById(getId()));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            } else {
                setCurrentEntity(new PartyInfo(0, "没有相关资料"));
                setHasPrev(false);
                setHasNext(false);
            }
        }
    }

    @Override
    public String viewList() {
        return "partyInfoList";
    }

    /**
     * @return the partyInfoBean
     */
    public PartyInfoBean getPartyInfoBean() {
        return partyInfoBean;
    }

    /**
     * @param partyInfoBean the partyInfoBean to set
     */
    public void setPartyInfoBean(PartyInfoBean partyInfoBean) {
        this.partyInfoBean = partyInfoBean;
    }



}
