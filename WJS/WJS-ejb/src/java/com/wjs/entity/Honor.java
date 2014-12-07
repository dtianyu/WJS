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
import javax.persistence.Lob;
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
 * @author kevindong
 */
@Entity
@Table(name = "honor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Honor.findAll", query = "SELECT m FROM Honor m ORDER BY m.status ASC,m.credate DESC,m.id DESC"),
    @NamedQuery(name = "Honor.findById", query = "SELECT m FROM Honor m WHERE m.id = :id"),
    @NamedQuery(name = "Honor.findByStatus", query = "SELECT m FROM Honor m WHERE m.status = :status"),
    @NamedQuery(name = "Honor.findNextById", query = "SELECT m FROM Honor m WHERE (m.status = 'V') and (m.id < :id) ORDER BY m.credate DESC,m.id DESC"),
    @NamedQuery(name = "Honor.findPrevById", query = "SELECT m FROM Honor m WHERE (m.status = 'V') and (m.id > :id) ORDER BY m.credate ASC"),
    @NamedQuery(name = "Honor.findRowCount", query = "SELECT count(m) FROM Honor m "),
    @NamedQuery(name = "Honor.findTop", query = "SELECT m FROM Honor m WHERE m.ontop=true and m.status='V' ORDER BY m.credate DESC ,m.id DESC "),
    @NamedQuery(name = "Honor.findVerified", query = "SELECT m FROM Honor m WHERE m.status='V' ORDER BY m.credate DESC,m.id DESC "),
    @NamedQuery(name = "Honor.findVerifiedRowCount", query = "SELECT count(m) FROM Honor m WHERE m.status='V' ")
})
public class Honor implements Serializable {

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
    @Size(min = 1, max = 45)
    @Column(name = "uploadfile")
    private String uploadfile;
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ontop")
    private boolean ontop;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "status")
    private String status;
    @Size(max = 20)
    @Column(name = "creator")
    private String creator;
    @Column(name = "credate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credate;
    @Size(max = 20)
    @Column(name = "optuser")
    private String optuser;
    @Column(name = "optdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date optdate;
    @Size(max = 20)
    @Column(name = "cfmuser")
    private String cfmuser;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;

    public Honor() {
    }

    public Honor(Integer id) {
        this.id = id;
    }

    public Honor(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Honor(Integer id, String title, String uploadfile, boolean ontop, String status) {
        this.id = id;
        this.title = title;
        this.uploadfile = uploadfile;
        this.ontop = ontop;
        this.status = status;
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

    public String getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(String uploadfile) {
        this.uploadfile = uploadfile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getOptuser() {
        return optuser;
    }

    public void setOptuser(String optuser) {
        this.optuser = optuser;
    }

    public Date getOptdate() {
        return optdate;
    }

    public void setOptdate(Date optdate) {
        this.optdate = optdate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Honor)) {
            return false;
        }
        Honor other = (Honor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wjs.entity.Honor[ id=" + id + " ]";
    }

}
