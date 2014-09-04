package com.wjs.entity;

import com.wjs.entity.Document;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-03T19:40:02")
@StaticMetamodel(DocKind.class)
public class DocKind_ { 

    public static volatile SingularAttribute<DocKind, String> creator;
    public static volatile SingularAttribute<DocKind, String> optuser;
    public static volatile SingularAttribute<DocKind, Date> optdate;
    public static volatile ListAttribute<DocKind, Document> documentList;
    public static volatile SingularAttribute<DocKind, String> kind;
    public static volatile SingularAttribute<DocKind, Boolean> ontop;
    public static volatile SingularAttribute<DocKind, Date> credate;
    public static volatile SingularAttribute<DocKind, String> cfmuser;
    public static volatile SingularAttribute<DocKind, Integer> id;
    public static volatile SingularAttribute<DocKind, Date> cfmdate;
    public static volatile SingularAttribute<DocKind, String> status;

}