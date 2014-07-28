/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.comm;

import java.util.List;

/**
 *
 * @author C0160
 * @param <T>
 */
public interface EJBOperate<T> {

    public void delete(T entity);

    public void persist(T entity);

    public T getById(String value);

    public List<T> getByPId(String value);

    public int getRowCount();

    public List<T> retrieve();

    public List<T> retrieve(int first, int pageSize);

    public T update(T entity);

}
