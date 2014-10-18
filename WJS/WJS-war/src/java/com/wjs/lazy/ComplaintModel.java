/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.lazy;

import com.wjs.ebj.ComplaintBean;
import com.wjs.entity.Complaint;
import com.wjs.web.Scope;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author C0160
 */
public class ComplaintModel extends LazyDataModel<Complaint> {

    ComplaintBean sessionBean;
    protected List<Complaint> dataList;
    protected Scope scope;

    public ComplaintModel() {

    }

    public ComplaintModel(ComplaintBean sessionBean, Scope scope) {
        this.sessionBean = sessionBean;
        this.scope = scope;
    }

    @Override
    public void setRowIndex(int rowIndex) {
        /*
         * The following is in ancestor (LazyDataModel):
         * this.rowIndex = rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
         */
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
        }
    }

    @Override
    public Complaint getRowData(String rowKey) {
        for (Complaint entity : dataList) {
            if (entity.getId().toString().equals(rowKey)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(Complaint entity) {
        return entity.getId();
    }

    @Override
    public List<Complaint> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        switch (this.scope) {
            case Managed:
                setDataList(sessionBean.findAll(first, pageSize));
                setRowCount(sessionBean.getRowCount());
                break;
            case Query:
                setDataList(sessionBean.retrieve(first, pageSize));
                setRowCount(sessionBean.getVerifiedRowCount());
                break;
        }
        return this.dataList;
    }

    /**
     * @return the dataList
     */
    public List<Complaint> getDataList() {
        return dataList;
    }

    /**
     * @param dataList the dataList to set
     */
    public void setDataList(List<Complaint> dataList) {
        this.dataList = dataList;
    }

    /**
     * @return the scope
     */
    public Scope getScope() {
        return scope;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(Scope scope) {
        this.scope = scope;
    }

}
