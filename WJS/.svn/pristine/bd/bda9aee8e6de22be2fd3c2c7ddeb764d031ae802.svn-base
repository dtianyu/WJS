/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevintung
 */
@Entity
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n  ORDER BY n.status ASC,n.credate DESC,n.id DESC "),
    @NamedQuery(name = "News.findById", query = "SELECT n FROM News n WHERE n.id = :id"),
    @NamedQuery(name = "News.findByStatus", query = "SELECT n FROM News n WHERE n.status = :status"),
    @NamedQuery(name = "News.findNextById", query = "SELECT n FROM News n WHERE (n.status = 'V') and (n.id < :id) ORDER BY n.credate DESC,n.id DESC"),
    @NamedQuery(name = "News.findPrevById", query = "SELECT n FROM News n WHERE (n.status = 'V') and (n.id > :id) ORDER BY n.credate ASC"),
    @NamedQuery(name = "News.findRowCount", query = "SELECT count(n) FROM News n "),
    @NamedQuery(name = "News.findTop", query = "SELECT n FROM News n WHERE n.ontop=true and n.status='V' ORDER BY n.credate DESC ,n.id DESC "),
    @NamedQuery(name = "News.findTopHasImg", query = "SELECT n FROM News n WHERE n.ontop=true and n.status='V' and (n.imgfile is not null) and n.imgfile<>'' ORDER BY n.credate DESC ,n.id DESC "),
    @NamedQuery(name = "News.findVerified", query = "SELECT n FROM News n WHERE n.status='V' ORDER BY n.credate DESC,n.id DESC "),
    @NamedQuery(name = "News.findVerifiedRowCount", query = "SELECT count(n) FROM News n WHERE n.status='V'")
})
public class News implements Serializable {

    @Column(name = "hits")
    private Integer hits;

    @Size(max = 40)
    @Column(name = "imgfile")
    private String imgfile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ontop")
    private boolean ontop;
    @Size(max = 2)
    @Column(name = "status")
    private String status;
    @Size(max = 20)
    @Column(name = "optuser")
    private String optuser;
    @Size(max = 20)
    @Column(name = "creator")
    private String creator;
    @Column(name = "credate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credate;
    @Size(max = 20)
    @Column(name = "cfmuser")
    private String cfmuser;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "news")
    private String news;
    @Column(name = "optdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date optdate;

    public News() {
    }

    public News(Integer id) {
        this.id = id;
    }

    public News(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public News(Integer id, String title, String news) {
        this.id = id;
        this.title = title;
        this.news = news;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public Date getOptdate() {
        return optdate;
    }

    public void setOptdate(Date optdate) {
        this.optdate = optdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wjs.entity.News[ id=" + id + " ]";
    }

    public String getImgfile() {
        return imgfile;
    }

    public void setImgfile(String imgfile) {
        this.imgfile = imgfile;
    }

    public boolean getOntop() {
        return ontop;
    }

    public void setOntop(boolean ontop) {
        this.ontop = ontop;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOptuser() {
        return optuser;
    }

    public void setOptuser(String optuser) {
        this.optuser = optuser;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

}
