/*
 * To change this briefing header, choose Briefing Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.BriefingBean;
import com.wjs.entity.Briefing;
import com.wjs.lazy.BriefingModel;
import com.wjs.web.Scope;
import com.wjs.web.SuperQueryBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "briefingQueryBean")
@RequestScoped
public class BriefingQueryBean extends SuperQueryBean<Briefing> {

    @EJB
    private BriefingBean briefingBean;

    /**
     * Creates a new instance of BriefingQueryBean
     */
    public BriefingQueryBean() {
    }

    @Override
    public void init() {
        setTopList(briefingBean.findTop(8));
        model = new BriefingModel(briefingBean,Scope.Query);
        if (getId() != null) {
            setCurrentEntity(briefingBean.getById(getId()));
            if (getCurrentEntity() != null) {
                setPrev(briefingBean.getPrevById(getId()));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(briefingBean.getNextById(getId()));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            } else {
                setCurrentEntity(new Briefing(0, "没有相关资料"));
                setHasPrev(false);
                setHasNext(false);
            }

        }
    }

    @Override
    public String viewList() {
        return "briefingList";
    }

    /**
     * @return the briefingBean
     */
    public BriefingBean getBriefingBean() {
        return briefingBean;
    }

    /**
     * @param briefingBean the briefingBean to set
     */
    public void setBriefingBean(BriefingBean briefingBean) {
        this.briefingBean = briefingBean;
    }

}
