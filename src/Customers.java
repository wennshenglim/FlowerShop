/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wennshenglim
 */
public class Customers {
    
    private String username, name, password, email, phoneNo, address, corporateName;

    public Customers(String username, String name, String password, String email, String phoneNo, String address) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public Customers(String username, String name, String password, String email, String phoneNo, String corporateName, String address) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNo = phoneNo;
        this.corporateName = corporateName;
        this.address = address;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}

