/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.PartyDynamicBean;
import com.wjs.entity.PartyDynamic;
import com.wjs.lazy.PartyDynamicModel;
import com.wjs.web.SuperQueryBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "partyDynamicQueryBean")
@RequestScoped
public class PartyDynamicQueryBean extends SuperQueryBean<PartyDynamic> {

    @EJB
    private PartyDynamicBean partyDynamicBean;


    public PartyDynamicQueryBean() {
    }

    @Override
    public void init() {
        setTopList(getPartyDynamicBean().findTop(8));
        if (!getTopList().isEmpty()) {
            setCurrentEntity(getTopList().get(0));
        }
        setModel(new PartyDynamicModel(getPartyDynamicBean(),com.wjs.web.Scope.Query));
        if (getId() != null) {
            setCurrentEntity(getPartyDynamicBean().getById(getId()));
            if (getCurrentEntity() != null) {
                getCurrentEntity().setHits(getCurrentEntity().getHits()+1);
                getPartyDynamicBean().update(getCurrentEntity());
                setPrev(getPartyDynamicBean().getPrevById(getId()));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(getPartyDynamicBean().getNextById(getId()));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            } else {
                setCurrentEntity(new PartyDynamic(0, "没有相关资料"));
                setHasPrev(false);
                setHasNext(false);
            }
        }
    }

    @Override
    public String viewList() {
        return "partyDynamicList";
    }

    /**
     * @return the partyDynamicBean
     */
    public PartyDynamicBean getPartyDynamicBean() {
        return partyDynamicBean;
    }

    /**
     * @param partyGroupBean the partyDynamicBean to set
     */
    public void setPartyDynamicBean(PartyDynamicBean partyGroupBean) {
        this.partyDynamicBean = partyGroupBean;
    }


}
