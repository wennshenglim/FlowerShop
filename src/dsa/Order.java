/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.sql.Time;
import java.util.Date;

public class Order {
    private String Orderid;
    private String OrderDesc;
    private Date OrderDate;
    private String OrderTime;
    private String status;

    public Order(String Orderid, String Cart, Date OrderDate, String OrderTime, String status) {
        this.Orderid = Orderid;
        this.OrderDesc = Cart;
        this.OrderDate = OrderDate;
        this.OrderTime = OrderTime;
        this.status = status;
    }

    public Order(String Orderid) {
        this.Orderid = Orderid;
    }

    public String getOrderDesc() {
        return OrderDesc;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public String getOrderid() {
        return Orderid;
    }

    public String getOrderTime() {
        return OrderTime;
    }

    public void setOrderid(String Orderid) {
        this.Orderid = Orderid;
    }
    
    public void setOrderDesc(String OrderDesc) {
        this.OrderDesc = OrderDesc;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderTime(String OrderTime) {
        this.OrderTime = OrderTime;
    }
    
    public String getStatus() {
        return status;
    }

    @Override
    public java.lang.String toString() {
        return Orderid + "\t\t" + OrderDesc + "\t\t" + OrderTime + "\t\t" + status;
    }

}
