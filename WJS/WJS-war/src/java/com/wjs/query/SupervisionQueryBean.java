/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.SupervisionBean;
import com.wjs.entity.Supervision;
import com.wjs.lazy.SupervisionModel;
import com.wjs.web.SuperQueryBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "supervisionQueryBean")
@RequestScoped
public class SupervisionQueryBean extends SuperQueryBean<Supervision> {

    @EJB
    private SupervisionBean supervisionBean;

    /**
     * Creates a new instance of SupervisionQueryBean
     */
    public SupervisionQueryBean() {
    }

    @Override
    public void init() {
        setTopList(supervisionBean.findTop(8));
        if (!getTopList().isEmpty()) {
            setCurrentEntity(getTopList().get(0));
        }
        setModel(new SupervisionModel(supervisionBean,com.wjs.web.Scope.Query));
        if (id != null) {
            setCurrentEntity(supervisionBean.getById(id));
            if (getCurrentEntity() != null) {
                setPrev(supervisionBean.getPrevById(id));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(supervisionBean.getNextById(id));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            } else {
                setCurrentEntity(new Supervision(0, "没有相关资料"));
                setHasPrev(false);
                setHasNext(false);
            }
        }
    }

    @Override
    public String viewList() {
        return "supervisionList";
    }

    /**
     * @return the supervisionBean
     */
    public SupervisionBean getSupervisionBean() {
        return supervisionBean;
    }

    /**
     * @param supervisionBean the supervisionBean to set
     */
    public void setSupervisionBean(SupervisionBean supervisionBean) {
        this.supervisionBean = supervisionBean;
    }

}
