package com.wjs.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-03T19:40:02")
@StaticMetamodel(Notice.class)
public class Notice_ { 

    public static volatile SingularAttribute<Notice, Integer> hits;
    public static volatile SingularAttribute<Notice, String> creator;
    public static volatile SingularAttribute<Notice, String> optuser;
    public static volatile SingularAttribute<Notice, Date> optdate;
    public static volatile SingularAttribute<Notice, Boolean> ontop;
    public static volatile SingularAttribute<Notice, Date> credate;
    public static volatile SingularAttribute<Notice, Integer> id;
    public static volatile SingularAttribute<Notice, String> cfmuser;
    public static volatile SingularAttribute<Notice, String> title;
    public static volatile SingularAttribute<Notice, String> content;
    public static volatile SingularAttribute<Notice, Date> cfmdate;
    public static volatile SingularAttribute<Notice, String> status;

}