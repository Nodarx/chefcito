package com.chefcito.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private int id;

    @Column(name = "Nick_name", nullable = false, unique = true)
    private String nick;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Last_name",nullable = false)
    private String last;

    @Column(name = "Mail",nullable = false, unique = true)
    private String mail;

    @Column(name = "Role",nullable = false)
    private boolean role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.user")
    private List<Keep> keeps;

    public User(){
    }

    public User(String nick_Name, String password, String name, String last_Name, String mail, boolean role){
        setNick(nick_Name);
        setPassword(password);
        setName(name);
        setLast(last_Name);
        setMail(mail);
        setRol(role);
    }

    public int getId() {
        return id;
    }

    public String getNick(){
        return nick;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getLast(){
        return last;
    }

    public String getMail(){
        return mail;
    }

    public boolean getRole(){
        return role;
    }

    private void setNick(String nick){
        this.nick = nick;
    }

    private void setPassword(String password){
        this.password = password;
    }

    private void setName(String name){
        this.name = name;
    }

    private void setLast(String last){
        this.last = last;
    }

    private void setMail(String mail){
        this.mail = mail;
    }

    private void setRol(boolean role){
        this.role = role;
    }

}
