/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.web;

import com.wjs.control.UserManagedBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "menuManagedBean")
@SessionScoped
public class MenuManagedBean implements Serializable {

    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean userManagedBean;

    /**
     * Creates a new instance of MenuManagedBean
     */
    public MenuManagedBean() {
    }

    private MenuModel model;

    @PostConstruct
    public void init() {

        if (getUserManagedBean() == null) {
            model = new DefaultMenuModel();
            return;
        }

        model = new DefaultMenuModel();

        if ("Admin".equals(getUserManagedBean().getCurrentUser().getUserid())) {

            DefaultMenuItem item;
            //First Submenu
            DefaultSubMenu firstSubmenu = new DefaultSubMenu("内容维护");

            item = new DefaultMenuItem("监督快讯维护");
            item.setUrl("newsAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("通知公告维护");
            item.setUrl("noticeAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("健康知识维护");
            item.setUrl("knowledgeAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("行政许可维护");
            item.setUrl("licenseAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("监督抽检维护");
            item.setUrl("inspectionAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("行政处罚维护");
            item.setUrl("punishmentAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("媒体报道维护");
            item.setUrl("mediaAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("文件下载类别");
            item.setUrl("docKindAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("文件下载维护");
            item.setUrl("documentAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("投诉举报受理");
            item.setUrl("complaintAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("其他页面维护");
            item.setUrl("pageAdmin.xhtml");
            firstSubmenu.addElement(item);

            model.addElement(firstSubmenu);

            //Second Submenu
            DefaultSubMenu secondSubmenu = new DefaultSubMenu("党建网站");

            item = new DefaultMenuItem("党建新闻");
            item.setUrl("partyNewsAdmin.xhtml");
            secondSubmenu.addElement(item);

            item = new DefaultMenuItem("文化建设");
            item.setUrl("partyDynamicAdmin.xhtml");
            secondSubmenu.addElement(item);

            item = new DefaultMenuItem("群教专栏");
            item.setUrl("partyInfoAdmin.xhtml");
            secondSubmenu.addElement(item);

            item = new DefaultMenuItem("工团信息");
            item.setUrl("partyGroupAdmin.xhtml");
            secondSubmenu.addElement(item);

            getModel().addElement(secondSubmenu);

            DefaultSubMenu thirdSubmenu = new DefaultSubMenu("系统管理");

            item = new DefaultMenuItem("账户管理");
            item.setUrl("userAdmin.xhtml");
            thirdSubmenu.addElement(item);

            item = new DefaultMenuItem("修改密码");
            item.setUrl("userPwd.xhtml");
            thirdSubmenu.addElement(item);

            getModel().addElement(thirdSubmenu);
        }

        if ("wld".equals(getUserManagedBean().getCurrentUser().getUserid())) {

            DefaultMenuItem item;
            //First Submenu
            DefaultSubMenu firstSubmenu = new DefaultSubMenu("内容维护");

            item = new DefaultMenuItem("监督快讯维护");
            item.setUrl("newsAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("健康知识维护");
            item.setUrl("knowledgeAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("媒体报道维护");
            item.setUrl("mediaAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("文件下载类别");
            item.setUrl("docKindAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("文件下载维护");
            item.setUrl("documentAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("投诉举报受理");
            item.setUrl("complaintAdmin.xhtml");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("其他页面维护");
            item.setUrl("pageAdmin.xhtml");
            firstSubmenu.addElement(item);

            model.addElement(firstSubmenu);

            //Second Submenu
            DefaultSubMenu secondSubmenu = new DefaultSubMenu("党建网站");

            item = new DefaultMenuItem("党建新闻");
            item.setUrl("partyNewsAdmin.xhtml");
            secondSubmenu.addElement(item);

            item = new DefaultMenuItem("文化建设");
            item.setUrl("partyDynamicAdmin.xhtml");
            secondSubmenu.addElement(item);

            item = new DefaultMenuItem("群教专栏");
            item.setUrl("partyInfoAdmin.xhtml");
            secondSubmenu.addElement(item);

            item = new DefaultMenuItem("工团信息");
            item.setUrl("partyGroupAdmin.xhtml");
            secondSubmenu.addElement(item);

            getModel().addElement(secondSubmenu);

            DefaultSubMenu thirdSubmenu = new DefaultSubMenu("系统管理");

            item = new DefaultMenuItem("修改密码");
            item.setUrl("userPwd.xhtml");
            thirdSubmenu.addElement(item);

            getModel().addElement(thirdSubmenu);
        }

        if ("jjy".equals(getUserManagedBean().getCurrentUser().getUserid())) {

            DefaultMenuItem item;
            //First Submenu
            DefaultSubMenu firstSubmenu = new DefaultSubMenu("内容维护");

            item = new DefaultMenuItem("投诉举报受理");
            item.setUrl("complaintAdmin.xhtml");
            firstSubmenu.addElement(item);

            model.addElement(firstSubmenu);

            DefaultSubMenu thirdSubmenu = new DefaultSubMenu("系统管理");

            item = new DefaultMenuItem("修改密码");
            item.setUrl("userPwd.xhtml");
            thirdSubmenu.addElement(item);

            getModel().addElement(thirdSubmenu);
        }

    }

    /**
     * @return the model
     */
    public MenuModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(MenuModel model) {
        this.model = model;
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
