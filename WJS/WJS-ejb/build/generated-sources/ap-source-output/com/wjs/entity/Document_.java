package com.wjs.entity;

import com.wjs.entity.DocKind;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-24T23:22:44")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, String> creator;
    public static volatile SingularAttribute<Document, Date> optdate;
    public static volatile SingularAttribute<Document, DocKind> kind;
    public static volatile SingularAttribute<Document, Date> credate;
    public static volatile SingularAttribute<Document, String> title;
    public static volatile SingularAttribute<Document, String> content;
    public static volatile SingularAttribute<Document, Integer> hits;
    public static volatile SingularAttribute<Document, String> optuser;
    public static volatile SingularAttribute<Document, String> relfile;
    public static volatile SingularAttribute<Document, Boolean> ontop;
    public static volatile SingularAttribute<Document, Integer> id;
    public static volatile SingularAttribute<Document, String> cfmuser;
    public static volatile SingularAttribute<Document, Date> cfmdate;
    public static volatile SingularAttribute<Document, String> status;

}