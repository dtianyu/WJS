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
 * @author C0160
 */
@Entity
@Table(name = "complaint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complaint.findAll", query = "SELECT c FROM Complaint c ORDER BY c.status ASC, c.credate DESC,c.id DESC"),
    @NamedQuery(name = "Complaint.findById", query = "SELECT c FROM Complaint c WHERE c.id = :id"),
    @NamedQuery(name = "Complaint.findByStatus", query = "SELECT c FROM Complaint c WHERE c.status = :status"),
    @NamedQuery(name = "Complaint.findNextById", query = "SELECT c FROM Complaint c WHERE (c.status = 'V') and (c.id < :id) ORDER BY c.credate DESC,c.id DESC"),
    @NamedQuery(name = "Complaint.findPrevById", query = "SELECT c FROM Complaint c WHERE (c.status = 'V') and (c.id > :id) ORDER BY c.credate ASC"),
    @NamedQuery(name = "Complaint.findRowCount", query = "SELECT count(c) FROM Complaint c  "),  
    @NamedQuery(name = "Complaint.findTop", query = "SELECT c FROM Complaint c WHERE c.ontop=true and c.status='V' ORDER BY c.credate DESC,c.id DESC  "),
    @NamedQuery(name = "Complaint.findVerified", query = "SELECT c FROM Complaint c WHERE c.status='V' ORDER BY c.credate DESC,c.id DESC "),
    @NamedQuery(name = "Complaint.findVerifiedRowCount", query = "SELECT count(c) FROM Complaint c WHERE c.status='V' ")})
public class Complaint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tel")
    private String tel;
    @Size(max = 45)
    @Column(name = "mailadd")
    private String mailadd;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Column(name = "ontop")
    private Boolean ontop;
    @Size(max = 45)
    @Column(name = "result")
    private String result;
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

    public Complaint() {
    }

    public Complaint(Integer id) {
        this.id = id;
    }
    
        public Complaint(Integer id,  String title) {
        this.id = id;
        this.title = title;
    }

    public Complaint(Integer id, String name, String tel, String title, String content, String status) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMailadd() {
        return mailadd;
    }

    public void setMailadd(String mailadd) {
        this.mailadd = mailadd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Boolean getOntop() {
        return ontop;
    }

    public void setOntop(Boolean ontop) {
        this.ontop = ontop;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
        if (!(object instanceof Complaint)) {
            return false;
        }
        Complaint other = (Complaint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wjs.entity.Complaint[ id=" + id + " ]";
    }
    
}
