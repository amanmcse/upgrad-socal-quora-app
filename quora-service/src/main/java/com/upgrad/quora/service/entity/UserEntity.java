package com.upgrad.quora.service.entity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/** Adil by Adil **/
//The object of this class maps with database table "users"
//Following is the "users" table schema from, quora.sql
/*
        id SERIAL
        uuid VARCHAR(200) NOT NULL
        firstName VARCHAR(30) NOT NULL
        lastName VARCHAR(30) NOT NULL
        userName VARCHAR(30) UNIQUE NOT NULL
        email VARCHAR(50) UNIQUE NOT NULL
        password VARCHAR(255) NOT NULL
        salt VARCHAR(200) NOT NULL
        country VARCHAR(30)
        aboutMe VARCHAR(50)
        dob VARCHAR(30)
        role VARCHAR(30)
        contactNumber VARCHAR(30)
        PRIMARY KEY (id)
 */



@Entity
//The table to be mapped to the database is defined as users and since there is no schema defined in quora.sql,hence the schema is defined to be public
@Table(name = "users", schema = "public")
@NamedQueries(
        {
        @NamedQuery(name = "userByEmail", query = "select u from UserEntity u where u.email = :email"),
        @NamedQuery(name = "userByName", query = "select u from UserEntity u where u.userName = :userName"),
        @NamedQuery(name ="userByUuid",query="select u from UserEntity u where u.uuid =:uuid")
        }
)

public class UserEntity implements Serializable {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "uuid")
        @NotNull
        @Size(max = 200)
        private String uuid;

        @Column(name = "firstname")
        @NotNull
        @Size(max = 30)
        private String firstName;

        @Column(name = "lastname")
        @NotNull
        @Size(max = 30)
        private String lastName;

        @Column(name = "username")
        @NotNull
        @Size(max = 200)
        private String userName;

        @Column(name = "email")
        @NotNull
        @Size(max = 50)
        private String email;

        @Column(name = "password")
        @NotNull
        @Size(max = 255)
        private String password;

        @Column(name = "salt")
        @NotNull
        @Size(max = 200)
        private String salt;

        @Column(name = "country")
        @Size(max = 30)
        private String country;

        @Column(name = "aboutme")
        @Size(max = 50)
        private String aboutMe;

        @Column(name = "dob")
        @Size(max = 30)
        private String dob;

        @Column(name = "role")
        @Size(max = 30)
        private String role;

        @Column(name = "contactnumber")
        @Size(max = 30)
        private String contactNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
