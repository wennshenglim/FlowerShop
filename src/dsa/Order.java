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
    private String Amount;
    private String pDate;
    private String time;
    private String status;

    public Order(String Orderid, String OrderDesc, Date OrderDate, String OrderTime, String Amount, String pDate, String time, String status) {
        this.Orderid = Orderid;
        this.OrderDesc = OrderDesc;
        this.OrderDate = OrderDate;
        this.OrderTime = OrderTime;
        this.Amount = Amount;
        this.pDate = pDate;
        this.time = time;
        this.status = status;
    }

    public Order() {
    }

    public String getOrderid() {
        return Orderid;
    }

    public String getOrderDesc() {
        return OrderDesc;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public String getOrderTime() {
        return OrderTime;
    }

    public String getStatus() {
        return status;
    }
    
    public String getPDate() {
        return pDate;
    }
    
    public String getTime() {
        return time;
    }

    public String getAmount() {
        return Amount;
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

    public void setOrderTime(String OrderTime) {
        this.OrderTime = OrderTime;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }
    
    
    public void setPDate(String pDate) {
        this.pDate = pDate;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
 
    @Override
    public String toString() {
        return Orderid + "\t\t" + OrderDesc + "\t\t" + OrderTime + "\t\t" + "RM " + Amount + "\t\t" + pDate + "\t\t" + time + "\t\t" + status;
    }
    
    public String toStringPD(){
        return Orderid + "\t\t" + OrderDesc + "\t\t" + OrderTime + "\t\t" + status;
    }

}
