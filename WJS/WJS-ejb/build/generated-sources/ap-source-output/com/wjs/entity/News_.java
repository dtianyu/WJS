package com.wjs.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-08-27T19:49:36")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, String> news;
    public static volatile SingularAttribute<News, String> creator;
    public static volatile SingularAttribute<News, Date> optdate;
    public static volatile SingularAttribute<News, Date> credate;
    public static volatile SingularAttribute<News, String> title;
    public static volatile SingularAttribute<News, Integer> hits;
    public static volatile SingularAttribute<News, String> optuser;
    public static volatile SingularAttribute<News, String> imgfile;
    public static volatile SingularAttribute<News, Boolean> ontop;
    public static volatile SingularAttribute<News, String> cfmuser;
    public static volatile SingularAttribute<News, Integer> id;
    public static volatile SingularAttribute<News, Date> cfmdate;
    public static volatile SingularAttribute<News, String> status;

}