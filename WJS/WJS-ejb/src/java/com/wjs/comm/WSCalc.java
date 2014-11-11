/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.comm;

import com.wjs.ebj.SystemUserBean;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author kevintung
 */
@WebService(serviceName = "WSCalc")
@Stateless()
public class WSCalc {
    @EJB
    private SystemUserBean systemUserBean;

    public WSCalc() {

    }

    
    
    /**
     * Web 服务操作
     */
    @WebMethod(operationName = "calc")
    public int calc(@WebParam(name = "x") int x, @WebParam(name = "y") int y) {
        //TODO write your implementation code here:
        return (x + y);
    }

    /**
     * Web 服务操作
     */
    @WebMethod(operationName = "getUser")
    public String getUser() {
        return  systemUserBean.findAll().toString();
    }

    /**
     * @return the systemUserBean
     */
    public SystemUserBean getSystemUserBean() {
        return systemUserBean;
    }

    /**
     * @param systemUserBean the systemUserBean to set
     */
    public void setSystemUserBean(SystemUserBean systemUserBean) {
        this.systemUserBean = systemUserBean;
    }

    /**
     * Web 服务操作
     * @return 
     */
    @WebMethod(operationName = "getUserArray")
    public String getUserArray() {
        //TODO write your implementation code here:
        return Arrays.toString(systemUserBean.findAll().toArray());
    }
}
