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
@Table(name = "document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d ORDER BY d.status ASC, d.credate DESC,d.id DESC"),
    @NamedQuery(name = "Document.findById", query = "SELECT d FROM Document d WHERE d.id = :id"),
    @NamedQuery(name = "Document.findByPId", query = "SELECT d FROM Document d,DocKind k WHERE d.kind=k and k.id = :kind ORDER BY d.status ASC, d.credate DESC,d.id DESC"),
    @NamedQuery(name = "Document.findByStatus", query = "SELECT d FROM Document d WHERE d.status = :status"),
    @NamedQuery(name = "Document.findNextById", query = "SELECT d FROM Document d WHERE (d.status = 'V') and (d.id < :id) ORDER BY d.credate DESC,d.id DESC"),
    @NamedQuery(name = "Document.findPrevById", query = "SELECT d FROM Document d WHERE (d.status = 'V') and (d.id > :id) ORDER BY d.credate ASC"),
    @NamedQuery(name = "Document.findRowCount", query = "SELECT count(d) FROM Document d  "),
    @NamedQuery(name = "Document.findTop", query = "SELECT d FROM Document d WHERE d.ontop=true and d.status='V' ORDER BY d.credate DESC,d.id DESC  "),
    @NamedQuery(name = "Document.findVerified", query = "SELECT d FROM Document d WHERE d.status='V' ORDER BY d.credate DESC,d.id DESC "),
    @NamedQuery(name = "Document.findVerifiedRowCount", query = "SELECT count(d) FROM Document d WHERE d.status='V' ")})
public class Document implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "hits")
    private int hits;

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
    @Size(max = 200)
    @Column(name = "relfile")
    private String relfile;
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
    @JoinColumn(name = "kind", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocKind kind;

    public Document() {
    }

    public Document(Integer id) {
        this.id = id;
    }

    public Document(Integer id, String title, boolean ontop, int hits, String status) {
        this.id = id;
        this.title = title;
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

    public DocKind getKind() {
        return kind;
    }

    public void setKind(DocKind kind) {
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
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wjs.entity.Document[ id=" + id + " ]";
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

}
