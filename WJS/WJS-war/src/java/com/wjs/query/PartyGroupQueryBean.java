/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.PartyGroupBean;
import com.wjs.entity.PartyGroup;
import com.wjs.lazy.PartyGroupModel;
import com.wjs.web.SuperQueryBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "partyGroupQueryBean")
@RequestScoped
public class PartyGroupQueryBean extends SuperQueryBean<PartyGroup> {

    @EJB
    private PartyGroupBean partyGroupBean;


    public PartyGroupQueryBean() {
    }

    @Override
    public void init() {
        setTopList(getPartyGroupBean().findTop(8));
        if (!getTopList().isEmpty()) {
            setCurrentEntity(getTopList().get(0));
        }
        setModel(new PartyGroupModel(getPartyGroupBean(),com.wjs.web.Scope.Query));
        if (getId() != null) {
            setCurrentEntity(getPartyGroupBean().getById(getId()));
            if (getCurrentEntity() != null) {
                getCurrentEntity().setHits(getCurrentEntity().getHits()+1);
                getPartyGroupBean().update(getCurrentEntity());
                setPrev(getPartyGroupBean().getPrevById(getId()));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(getPartyGroupBean().getNextById(getId()));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            } else {
                setCurrentEntity(new PartyGroup(0, "没有相关资料"));
                setHasPrev(false);
                setHasNext(false);
            }
        }
    }

    @Override
    public String viewList() {
        return "partyGroupList";
    }

    /**
     * @return the partyGroupBean
     */
    public PartyGroupBean getPartyGroupBean() {
        return partyGroupBean;
    }

    /**
     * @param partyGroupBean the partyGroupBean to set
     */
    public void setPartyGroupBean(PartyGroupBean partyGroupBean) {
        this.partyGroupBean = partyGroupBean;
    }


}
