/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.ebj;

import com.wjs.entity.PageInfo;
import com.wjs.comm.EJBOperate;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kevintung
 */
@Stateless
@LocalBean
public class PageInfoBean implements EJBOperate<PageInfo> {

    @PersistenceContext(unitName = "WJS-ejbPU")
    private EntityManager em;

    @Override
    public void delete(PageInfo entity) {
        try {
            if (em.contains(entity)) {
                em.remove(entity);
            } else {
                em.remove(em.merge(entity));
            }
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    @Override
    public void persist(PageInfo entity) {
        try {
            em.persist(entity);
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    @Override
    public PageInfo getById(String value) {
        Query query = em.createNamedQuery("PageInfo.findByPage");
        query.setParameter("page", value);
        try {
            return (PageInfo) query.getSingleResult();
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    @Override
    public List<PageInfo> getByPId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PageInfo> retrieve() {
        Query query = em.createNamedQuery("PageInfo.findAll");
        return query.getResultList();
    }
    
    @Override
    public List<PageInfo> retrieve(int first, int pageSize) {
        Query query = em.createNamedQuery("PageInfo.findVerified").setFirstResult(first).setMaxResults(first + pageSize);
        return query.getResultList();
    }

    @Override
    public PageInfo update(PageInfo entity) {
        try {
            PageInfo p = em.merge(entity);
            return p;
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
