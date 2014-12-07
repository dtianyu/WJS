/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.HonorBean;
import com.wjs.entity.Honor;
import com.wjs.lazy.HonorModel;
import com.wjs.web.SuperQueryBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "honorQueryBean")
@RequestScoped
public class HonorQueryBean extends SuperQueryBean<Honor> {

    @EJB
    private HonorBean honorBean;

    /**
     * Creates a new instance of HonorQueryBean
     */
    public HonorQueryBean() {
    }

    @Override
    public void init() {
        setTopList(honorBean.findTop(8));
        if (!getTopList().isEmpty()) {
            setCurrentEntity(getTopList().get(0));
        }
        setModel(new HonorModel(honorBean, com.wjs.web.Scope.Query));
        if (getId() != null) {
            setCurrentEntity(honorBean.getById(getId()));
            if (getCurrentEntity() != null) {
                setPrev(honorBean.getPrevById(getId()));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(honorBean.getNextById(getId()));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            } else {
                setCurrentEntity(new Honor(0, "没有相关资料"));
                setHasPrev(false);
                setHasNext(false);
            }
        }
    }

    @Override
    public String viewList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the honorBean
     */
    public HonorBean getHonorBean() {
        return honorBean;
    }

    /**
     * @param honorBean the honorBean to set
     */
    public void setHonorBean(HonorBean honorBean) {
        this.honorBean = honorBean;
    }

}
