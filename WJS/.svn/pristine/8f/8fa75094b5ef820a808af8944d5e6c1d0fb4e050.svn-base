/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.KnowledgeBean;
import com.wjs.entity.Knowledge;
import com.wjs.lazy.KnowledgeModel;
import com.wjs.web.SuperQueryBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "knowledgeQueryBean")
@RequestScoped
public class KnowledgeQueryBean extends SuperQueryBean<Knowledge> {

    @EJB
    private KnowledgeBean knowledgeBean;

    /**
     * Creates a new instance of KnowledgeQueryManagedBean
     */
    public KnowledgeQueryBean() {
    }

    @Override
    public void init() {
        setTopList(knowledgeBean.findTop(8));
        if (!getTopList().isEmpty()) {
            setCurrentEntity(getTopList().get(0));
        }
        setModel(new KnowledgeModel(knowledgeBean,com.wjs.web.Scope.Query));
        if (getId() != null) {
            setCurrentEntity(knowledgeBean.getById(getId()));            
            if (getCurrentEntity() != null) {
                setPrev(knowledgeBean.getPrevById(getId()));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(knowledgeBean.getNextById(getId()));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            }else{
                setCurrentEntity(new Knowledge(0, "没有相关资料"));
                setHasPrev(false);
                setHasNext(false);
            }
                
        }
    }

    @Override
    public String viewList() {
        return "knowledgeList";
    }

    /**
     * @return the knowledgeBean
     */
    public KnowledgeBean getKnowledgeBean() {
        return knowledgeBean;
    }

    /**
     * @param knowledgeBean the knowledgeBean to set
     */
    public void setKnowledgeBean(KnowledgeBean knowledgeBean) {
        this.knowledgeBean = knowledgeBean;
    }

}
