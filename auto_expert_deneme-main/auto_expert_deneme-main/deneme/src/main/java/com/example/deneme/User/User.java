package com.example.deneme.User;

import jakarta.persistence.*;

@Entity
@Table
public class User {


    private String Name;
    private String Nachname;
    private String Username;
    private String Password;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public User(Long id, String Name, String Nachname, String Username, String Password) {
        this.id = id;
        this.Name = Name;
        this.Nachname = Nachname;
        this.Username = Username;
        this.Password = Password;
    }

    public User() {

    }

    public Long getBenutzerID() {
        return id;
    }

    public void setBenutzerID(int id) {
        this.id = (long) id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        this.Nachname = nachname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}