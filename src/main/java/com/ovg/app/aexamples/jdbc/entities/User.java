package com.ovg.app.aexamples.jdbc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements Entity {
    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    public User() {
        this(null, null, null);
    }

    public User(final Integer id, final String username, final String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%d => %s => spoil sécu: %s (ne pas divulguer s'il vous plait je sais pas crypter :'()",
                id, username, password);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
