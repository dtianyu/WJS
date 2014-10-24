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
 * @author kevintung
 */
@Entity
@Table(name = "briefing")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Briefing.findAll", query = "SELECT b FROM Briefing b ORDER BY b.status ASC, b.credate DESC,b.id DESC"),
    @NamedQuery(name = "Briefing.findById", query = "SELECT b FROM Briefing b WHERE b.id = :id"),
    @NamedQuery(name = "Briefing.findByStatus", query = "SELECT b FROM Briefing b WHERE  b.status = :status"),
    @NamedQuery(name = "Briefing.findNextById", query = "SELECT b FROM Briefing b WHERE ( b.status = 'V') and ( b.id < :id) ORDER BY  b.credate DESC, b.id DESC"),
    @NamedQuery(name = "Briefing.findPrevById", query = "SELECT b FROM Briefing b WHERE ( b.status = 'V') and ( b.id > :id) ORDER BY  b.credate ASC"),
    @NamedQuery(name = "Briefing.findRowCount", query = "SELECT count(b) FROM Briefing b "),
    @NamedQuery(name = "Briefing.findTop", query = "SELECT b FROM Briefing b WHERE b.ontop=true and  b.status='V' ORDER BY  b.credate DESC, b.id DESC  "),
    @NamedQuery(name = "Briefing.findVerified", query = "SELECT b FROM Briefing b WHERE b.status='V' ORDER BY b.credate DESC, b.id DESC "),
    @NamedQuery(name = "Briefing.findVerifiedRowCount", query = "SELECT count(b) FROM Briefing b WHERE b.status='V' ")})
public class Briefing implements Serializable {
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
    @Column(name = "ontop")
    private boolean ontop;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "status")
    private String status;
    @Column(name = "hits")
    private Integer hits;
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

    public Briefing() {
    }

    public Briefing(Integer id) {
        this.id = id;
    }
    
    public Briefing(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public Briefing(Integer id, String title, String relfile, boolean ontop, String status) {
        this.id = id;
        this.title = title;
        this.relfile = relfile;
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

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
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
        if (!(object instanceof Briefing)) {
            return false;
        }
        Briefing other = (Briefing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wjs.entity.Briefing[ id=" + id + " ]";
    }
    
}
