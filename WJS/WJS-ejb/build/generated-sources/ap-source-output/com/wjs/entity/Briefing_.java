package com.wjs.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-24T23:22:44")
@StaticMetamodel(Briefing.class)
public class Briefing_ { 

    public static volatile SingularAttribute<Briefing, String> creator;
    public static volatile SingularAttribute<Briefing, Date> optdate;
    public static volatile SingularAttribute<Briefing, Date> credate;
    public static volatile SingularAttribute<Briefing, String> title;
    public static volatile SingularAttribute<Briefing, String> content;
    public static volatile SingularAttribute<Briefing, Integer> hits;
    public static volatile SingularAttribute<Briefing, String> optuser;
    public static volatile SingularAttribute<Briefing, String> relfile;
    public static volatile SingularAttribute<Briefing, Boolean> ontop;
    public static volatile SingularAttribute<Briefing, Integer> id;
    public static volatile SingularAttribute<Briefing, String> cfmuser;
    public static volatile SingularAttribute<Briefing, Date> cfmdate;
    public static volatile SingularAttribute<Briefing, String> status;

}