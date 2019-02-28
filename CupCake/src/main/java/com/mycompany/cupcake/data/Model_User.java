package com.mycompany.cupcake.data;

/**
 * @author Camilla
 */
public class Model_User {
    private int userID;
    private String userName;
    private String password;
    private double balance;
    private String email;
    private Role role;

    public Model_User() {
    }

    public Model_User(int userID, String userName, String password, double balance, String email, Role role) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.balance = balance;
        this.email = email;
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
}

enum Role {
    ADMIN, USER;
}