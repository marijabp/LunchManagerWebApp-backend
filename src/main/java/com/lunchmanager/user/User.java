package com.lunchmanager.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user", uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;	
	
    private String role;
    
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 100)
    @Pattern(regexp="^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    private String email;

    private String password;
    
    @Transient
    private String passwordConfirm;

    public User () {
    }
    
    public User (Long id, String role, String email, String password, String passwordConfirm) {
    	super();
    	this.id=id;
    	this.role=role;
    	this.email=email;
    	this.password=password;
    	this.passwordConfirm=passwordConfirm;
    	
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
