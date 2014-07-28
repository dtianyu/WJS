/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjs.convert;

import com.wjs.ebj.DocKindBean;
import com.wjs.entity.DocKind;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author C0160
 */
@FacesConverter("docKindConverter")
public class DocKindConverter implements Converter {
    
    DocKindBean docKindBean = lookupDocKindBeanBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("")) {
            return null;
        } else {
            try {
                DocKind entity = docKindBean.getById(value);
                if (entity != null) {
                    return entity;
                } else {
                    return null;
                }
            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid entity"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return ((DocKind) value).getId().toString();
        }
    }

    private DocKindBean lookupDocKindBeanBean() {
        try {
            Context c = new InitialContext();
            return (DocKindBean) c.lookup("java:global/WJS/WJS-ejb/DocKindBean!com.wjs.ebj.DocKindBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
