/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author LYJni
 */
public class Order {
   private int orderID;
    private int userID;
    private Date orderDate;
    private String status;
    private Date ShippingDate;
    private double total;
    private double ifDis;

    public Order() {

    }

    public Order(int orderID, int userID, Date orderDate, String status, Date ShippingDate, double total, double ifDis) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.status = status;
        this.ShippingDate = ShippingDate;
        this.total = total;
        this.ifDis = ifDis;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getShippingDate() {
        return ShippingDate;
    }

    public void setShippingDate(Date ShippingDate) {
        this.ShippingDate = ShippingDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIfDis() {
        return ifDis;
    }

    public void setIfDis(double ifDis) {
        this.ifDis = ifDis;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderID != other.orderID) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ifDis) != Double.doubleToLongBits(other.ifDis)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.ShippingDate, other.ShippingDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", userID=" + userID + ", orderDate=" + orderDate + ", status=" + status + ", ShippingDate=" + ShippingDate + ", total=" + total + ", ifDis=" + ifDis + '}';
    }
    
    
}
