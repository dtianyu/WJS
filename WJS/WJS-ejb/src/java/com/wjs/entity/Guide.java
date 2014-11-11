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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "guide")
@XmlRootElement 
@NamedQueries({
    @NamedQuery(name = "Guide.findAll", query = "SELECT g FROM Guide g ORDER BY g.status ASC, g.credate DESC,g.id DESC"),
    @NamedQuery(name = "Guide.findById", query = "SELECT g FROM Guide g WHERE g.id = :id"),
    @NamedQuery(name = "Guide.findByPId", query = "SELECT g FROM Guide g,GuideKind k WHERE g.kind=k and k.id = :kind ORDER BY g.status ASC, g.credate DESC,g.id DESC"),
    @NamedQuery(name = "Guide.findByStatus", query = "SELECT g FROM Guide g WHERE g.status = :status"),
    @NamedQuery(name = "Guide.findNextById", query = "SELECT g FROM Guide g WHERE (g.status = 'V') and (g.id < :id) ORDER BY g.credate DESC,g.id DESC"),
    @NamedQuery(name = "Guide.findPrevById", query = "SELECT g FROM Guide g WHERE (g.status = 'V') and (g.id > :id) ORDER BY g.credate ASC"),
    @NamedQuery(name = "Guide.findRowCount", query = "SELECT count(g) FROM Guide g  "),
    @NamedQuery(name = "Guide.findTop", query = "SELECT g FROM Guide g WHERE g.ontop=true and g.status='V' ORDER BY g.credate DESC,g.id DESC  "),
    @NamedQuery(name = "Guide.findVerified", query = "SELECT g FROM Guide g WHERE g.status='V' ORDER BY g.credate DESC,g.id DESC "),
    @NamedQuery(name = "Guide.findVerifiedRowCount", query = "SELECT count(g) FROM Guide g WHERE g.status='V' ")})
public class Guide implements Serializable {
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
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "relfile")
    private String relfile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "docfile")
    private String docfile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ontop")
    private boolean ontop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hits")
    private int hits;
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
    @JoinColumn(name = "kind", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GuideKind kind;

    public Guide() {
    }

    public Guide(Integer id) {
        this.id = id;
    }

    public Guide(Integer id, String title, String relfile, String docfile, boolean ontop, int hits, String status) {
        this.id = id;
        this.title = title;
        this.relfile = relfile;
        this.docfile = docfile;
        this.ontop = ontop;
        this.hits = hits;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRelfile() {
        return relfile;
    }

    public void setRelfile(String relfile) {
        this.relfile = relfile;
    }

    public String getDocfile() {
        return docfile;
    }

    public void setDocfile(String docfile) {
        this.docfile = docfile;
    }

    public boolean getOntop() {
        return ontop;
    }

    public void setOntop(boolean ontop) {
        this.ontop = ontop;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
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

    public GuideKind getKind() {
        return kind;
    }

    public void setKind(GuideKind kind) {
        this.kind = kind;
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
        if (!(object instanceof Guide)) {
            return false;
        }
        Guide other = (Guide) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wjs.entity.Guide[ id=" + id + " ]";
    }
    
}
