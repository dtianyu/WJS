package com.wjs.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-16T21:52:13")
@StaticMetamodel(SystemUser.class)
public class SystemUser_ { 

    public static volatile SingularAttribute<SystemUser, String> password;
    public static volatile SingularAttribute<SystemUser, String> creator;
    public static volatile SingularAttribute<SystemUser, Date> credate;
    public static volatile SingularAttribute<SystemUser, String> userid;
    public static volatile SingularAttribute<SystemUser, Boolean> superuser;
    public static volatile SingularAttribute<SystemUser, String> email;
    public static volatile SingularAttribute<SystemUser, String> status;
    public static volatile SingularAttribute<SystemUser, String> username;

}