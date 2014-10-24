/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.lazy;

import com.wjs.entity.SystemUser;
import com.wjs.comm.SuperEJB;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author kevintung
 */
public class SystemUserModel extends LazyDataModel<SystemUser> {

    protected SuperEJB sessionBean;
    private List<SystemUser> dataList;

    public SystemUserModel() {

    }

    public SystemUserModel(SuperEJB sessionBean) {
        this.sessionBean = sessionBean;
    }

    @Override
    public void setRowIndex(int rowIndex) {
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
        }
    }

    @Override
    public SystemUser getRowData(String rowKey) {
        for (SystemUser entity : getDataList()) {
            if (entity.getUserid().equals(rowKey)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(SystemUser entity) {
        return entity.getUserid();
    }

    @Override
    public List<SystemUser> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        setDataList(sessionBean.findAll(first, pageSize));
        this.setRowCount(sessionBean.getRowCount());
        return this.getDataList();
    }

    /**
     * @return the dataList
     */
    public List<SystemUser> getDataList() {
        return dataList;
    }

    /**
     * @param dataList the dataList to set
     */
    public void setDataList(List<SystemUser> dataList) {
        this.dataList = dataList;
    }

}
