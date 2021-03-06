/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.control;

import com.wjs.ebj.LicenseBean;
import com.wjs.entity.License;
import com.wjs.lazy.LicenseModel;
import com.wjs.web.Scope;
import com.wjs.web.SuperManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author C0160
 */
@ManagedBean
@SessionScoped
public class LicenseManagedBean extends SuperManagedBean<License> {

    @EJB
    private LicenseBean licenseBean;
    @ManagedProperty(value = "#{userManagedBean}")
    protected UserManagedBean userManagedBean;

    /**
     * Creates a new instance of LicenseManagedBean
     */
    public LicenseManagedBean() {
    }

    @Override
    public void init() {
        setSessionBean(licenseBean);
        setModel(new LicenseModel(licenseBean, Scope.Managed));
    }

    @Override
    public void create() {
        if (getNewEntity() == null) {
            License entity = new License();
            entity.setOntop(true);
            entity.setStatus("N");
            entity.setCreator(getUserManagedBean().getCurrentUser().getUserid());
            entity.setCredate(getUserManagedBean().getDate());
            setNewEntity(entity);
        }
    }

    @Override
    public void verify() {
        if (getCurrentEntity() != null) {
            getCurrentEntity().setStatus("V");
            getCurrentEntity().setCfmuser(getUserManagedBean().getCurrentUser().getUserid());
            getCurrentEntity().setCfmdate(getUserManagedBean().getDate());
            save();
        }
    }

    @Override
    public void unverify() {
        if (getCurrentEntity() != null) {
            getCurrentEntity().setStatus("M");
            getCurrentEntity().setOptuser(getUserManagedBean().getCurrentUser().getUserid());
            getCurrentEntity().setOptdate(getUserManagedBean().getDate());
            getCurrentEntity().setCfmuser(null);
            getCurrentEntity().setCfmdate(null);
            save();
        }
    }

    /**
     * @return the licenseBean
     */
    public LicenseBean getLicenseBean() {
        return licenseBean;
    }

    /**
     * @param licenseBean the licenseBean to set
     */
    public void setLicenseBean(LicenseBean licenseBean) {
        this.licenseBean = licenseBean;
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

    @Override
    public String viewDetail(License entity) {
        if (entity != null) {
            setCurrentEntity(entity);
            return "licenseView";
        }
        return "licenseAdmin";
    }

}
