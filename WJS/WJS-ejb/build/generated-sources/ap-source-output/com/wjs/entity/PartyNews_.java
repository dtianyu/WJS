package com.wjs.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-18T00:46:17")
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