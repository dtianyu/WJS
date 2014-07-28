package com.wjs.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-28T21:19:15")
@StaticMetamodel(PartyNews.class)
public class PartyNews_ { 

    public static volatile SingularAttribute<PartyNews, String> creator;
    public static volatile SingularAttribute<PartyNews, Date> optdate;
    public static volatile SingularAttribute<PartyNews, Date> credate;
    public static volatile SingularAttribute<PartyNews, String> title;
    public static volatile SingularAttribute<PartyNews, String> content;
    public static volatile SingularAttribute<PartyNews, Integer> hits;
    public static volatile SingularAttribute<PartyNews, String> optuser;
    public static volatile SingularAttribute<PartyNews, String> imgfile;
    public static volatile SingularAttribute<PartyNews, Boolean> ontop;
    public static volatile SingularAttribute<PartyNews, Integer> id;
    public static volatile SingularAttribute<PartyNews, String> cfmuser;
    public static volatile SingularAttribute<PartyNews, Date> cfmdate;
    public static volatile SingularAttribute<PartyNews, String> status;

}