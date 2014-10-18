package com.wjs.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-18T00:46:17")
@StaticMetamodel(Knowledge.class)
public class Knowledge_ { 

    public static volatile SingularAttribute<Knowledge, Integer> hits;
    public static volatile SingularAttribute<Knowledge, String> creator;
    public static volatile SingularAttribute<Knowledge, String> optuser;
    public static volatile SingularAttribute<Knowledge, Date> optdate;
    public static volatile SingularAttribute<Knowledge, Boolean> ontop;
    public static volatile SingularAttribute<Knowledge, Date> credate;
    public static volatile SingularAttribute<Knowledge, Integer> id;
    public static volatile SingularAttribute<Knowledge, String> cfmuser;
    public static volatile SingularAttribute<Knowledge, String> title;
    public static volatile SingularAttribute<Knowledge, String> content;
    public static volatile SingularAttribute<Knowledge, Date> cfmdate;
    public static volatile SingularAttribute<Knowledge, String> status;

}