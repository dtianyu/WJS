/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.query;

import com.wjs.ebj.NewsBean;
import com.wjs.entity.News;
import com.wjs.lazy.NewsModel;
import com.wjs.web.SuperQueryBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kevintung
 */
@ManagedBean(name = "newsQueryBean")
@RequestScoped
public class NewsQueryBean extends SuperQueryBean<News> {

    @EJB
    protected NewsBean newsBean;
    private List<News> topNewsHasImg;

    /**
     * Creates a new instance of NewsManagedBean
     */
    public NewsQueryBean() {
    }

    @Override
    public void init() {
        setTopList(getNewsBean().findTop(8));
        if (!getTopList().isEmpty()) {
            setCurrentEntity(getTopList().get(0));
        }
        setModel(new NewsModel(getNewsBean(),com.wjs.web.Scope.Query));
        setTopNewsHasImg(newsBean.findTopHasImg(6));
        if (getId() != null) {
            setCurrentEntity(getNewsBean().getById(getId()));
            if (getCurrentEntity() != null) {
                getCurrentEntity().setHits(getCurrentEntity().getHits()+1);
                newsBean.update(getCurrentEntity());
                setPrev(getNewsBean().getPrevById(getId()));
                if (prev.getId() == 0) {
                    setHasPrev(false);
                } else {
                    setHasPrev(true);
                }
                setNext(getNewsBean().getNextById(getId()));
                if (next.getId() == 0) {
                    setHasNext(false);
                } else {
                    setHasNext(true);
                }
            } else {
                setCurrentEntity(new News(0, "没有相关资料"));
                setHasPrev(false);
                setHasNext(false);
            }
        }
    }

    @Override
    public String viewList() {
        return "newsList.xhtml";
    }

    /**
     * @return the newsBean
     */
    public NewsBean getNewsBean() {
        return newsBean;
    }

    /**
     * @param newsBean the newsBean to set
     */
    public void setNewsBean(NewsBean newsBean) {
        this.newsBean = newsBean;
    }

    /**
     * @return the topNewsHasImg
     */
    public List<News> getTopNewsHasImg() {
        return topNewsHasImg;
    }

    /**
     * @param topNewsHasImg the topNewsHasImg to set
     */
    public void setTopNewsHasImg(List<News> topNewsHasImg) {
        this.topNewsHasImg = topNewsHasImg;
    }

}
