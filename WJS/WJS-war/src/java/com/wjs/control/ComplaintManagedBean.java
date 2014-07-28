/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.ComplaintBean;
import com.wjs.entity.Complaint;
import com.wjs.lazy.ComplaintModel;
import com.wjs.web.Scope;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "complaintManagedBean")
@SessionScoped
public class ComplaintManagedBean extends SuperManagedBean<Complaint> {

    @EJB
    protected ComplaintBean complaintBean;
    @ManagedProperty(value = "#{userManagedBean}")
    protected UserManagedBean userManagedBean;

    /**
     * Creates a new instance of ComplaintManagedBean
     */
    public ComplaintManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(complaintBean);
        setModel(new ComplaintModel(complaintBean, Scope.Managed));
        create();
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            Complaint entity = new Complaint();
            entity.setOntop(false);
            entity.setStatus("N");
            setNewEntity(entity);
        }
    }

    @Override
    public void persist() {
        super.persist();
        RequestContext.getCurrentInstance().execute("submitComplaint();");
    }

    @Override
    public void verify() {
        if (getCurrentEntity() != null && getUserManagedBean() != null) {
            getCurrentEntity().setStatus("V");
            getCurrentEntity().setCfmuser(getUserManagedBean().getCurrentUser().getUserid());
            getCurrentEntity().setCfmdate(getUserManagedBean().getDate());
            save();
        }
    }

    @Override
    public void unverify() {
        if (getCurrentEntity() != null && getUserManagedBean() != null) {
            getCurrentEntity().setStatus("M");
            getCurrentEntity().setOptuser(getUserManagedBean().getCurrentUser().getUserid());
            getCurrentEntity().setOptdate(getUserManagedBean().getDate());
            getCurrentEntity().setCfmuser(null);
            getCurrentEntity().setCfmdate(null);
            save();
        }
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
     * @return the userManagedBean
     */
    public UserManagedBean getUserManagedBean() {
        return userManagedBean;
    }

    /**
     * @param userManagedBean the userManagedBean to set
     */
    public void setUserManagedBean(UserManagedBean userManagedBean) {
        this.userManagedBean = userManagedBean;
    }

}
