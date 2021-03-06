/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.InspectionBean;
import com.wjs.entity.Inspection;
import com.wjs.lazy.InspectionModel;
import com.wjs.web.SuperQueryBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "inspectionQueryBean")
@RequestScoped
public class InspectionQueryBean extends SuperQueryBean<Inspection> {
    
    @EJB
    private InspectionBean inspectionBean;

    /**
     * Creates a new instance of NewsManagedBean
     */
    public InspectionQueryBean() {
    }

    @Override
    public void init() {
        setTopList(getInspectionBean().findTop(8));
        if (!getTopList().isEmpty()) {
            setCurrentEntity(getTopList().get(0));
        }
        setModel(new InspectionModel(getInspectionBean(),com.wjs.web.Scope.Query));
        if (getId() != null) {
            setCurrentEntity(getInspectionBean().getById(getId()));
            if (getCurrentEntity() != null) {
                setPrev(getInspectionBean().getPrevById(getId()));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(getInspectionBean().getNextById(getId()));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            } else {
                setCurrentEntity(new Inspection(0, "没有相关资料"));
                setHasPrev(false);
                setHasNext(false);
            }
        }
    }

    @Override
    public String viewList() {
        return "inspectionList.xhtml";
    }

    /**
     * @return the inspectionBean
     */
    public InspectionBean getInspectionBean() {
        return inspectionBean;
    }

    /**
     * @param inspectionBean
     */
    public void setInspectionBean(InspectionBean inspectionBean) {
        this.inspectionBean = inspectionBean;
    }

}
