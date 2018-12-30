package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue(value = "Admin")
@NamedQueries({ 
    @NamedQuery(name = "Admin.byUsername", query = "select r from Admin r where r.username = :uname"),
    @NamedQuery(name = "Admin.login", query = "select r from Admin r where r.username = :uname and r.password = :pw") })

public class Admin extends User {
	private static final long serialVersionUID = -3974401535925597334L;

}