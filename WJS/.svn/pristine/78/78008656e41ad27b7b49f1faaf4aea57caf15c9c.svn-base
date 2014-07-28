/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.ComplaintBean;
import com.wjs.entity.Complaint;
import com.wjs.lazy.ComplaintModel;
import com.wjs.web.SuperQueryBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "complaintQueryBean")
@RequestScoped
public class ComplaintQueryBean extends SuperQueryBean<Complaint> {

    @EJB
    protected ComplaintBean complaintBean;
    protected List<Complaint> toDoList;

    /**
     * Creates a new instance of ComplaintQueryBean
     */
    public ComplaintQueryBean() {
    }

    @Override
    public void init() {
        setTopList(complaintBean.findTop(6));
        if (!getTopList().isEmpty()) {
            setCurrentEntity(getTopList().get(0));
        }
        setModel(new ComplaintModel(complaintBean, com.wjs.web.Scope.Query));
        setToDoList(complaintBean.findToDo());
        if (getId() != null) {
            setCurrentEntity(complaintBean.getById(getId()));
            if (getCurrentEntity() != null) {
                setPrev(complaintBean.getPrevById(getId()));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(complaintBean.getNextById(getId()));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            } else {
                setCurrentEntity(new Complaint(0, "没有相关资料"));
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
     * @return the complaintBean
     */
    public ComplaintBean getComplaintBean() {
        return complaintBean;
    }

    /**
     * @param complaintBean the complaintBean to set
     */
    public void setComplaintBean(ComplaintBean complaintBean) {
        this.complaintBean = complaintBean;
    }

    /**
     * @return the toDoList
     */
    public List<Complaint> getToDoList() {
        return toDoList;
    }

    /**
     * @param toDoList the toDoList to set
     */
    public void setToDoList(List<Complaint> toDoList) {
        this.toDoList = toDoList;
    }

}
