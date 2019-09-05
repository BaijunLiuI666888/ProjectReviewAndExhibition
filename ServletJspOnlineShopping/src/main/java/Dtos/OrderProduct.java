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
public class OrderProduct {

    private int productid;
    private int categoryid;
    private String productname;
    private String brand;
    private double weight;
    private String description;
    private int Stock;
    private Date date;
    private byte[] image1;
    private byte[] image2;
    private double price;
    private int orderid;
    private int quantity;
    private int userid;
    private Date orderdate;
    private String status;
    private Date shippingdate;
    private double total;
    private double discount;
    

    
   

    public OrderProduct() {

    }

    public OrderProduct(int productid, int categoryid, String productname, String brand, double weight, String description, int Stock, Date date, byte[] image1, byte[] image2, double price, int orderid, int quantity, int userid, Date orderdate, String status, Date shippingdate, double total, double discount) {
        this.productid = productid;
        this.categoryid = categoryid;
        this.productname = productname;
        this.brand = brand;
        this.weight = weight;
        this.description = description;
        this.Stock = Stock;
        this.date = date;
        this.image1 = image1;
        this.image2 = image2;
        this.price = price;
        this.orderid = orderid;
        this.quantity = quantity;
        this.userid = userid;
        this.orderdate = orderdate;
        this.status = status;
        this.shippingdate = shippingdate;
        this.total = total;
        this.discount = discount;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    public byte[] getImage2() {
        return image2;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getShippingdate() {
        return shippingdate;
    }

    public void setShippingdate(Date shippingdate) {
        this.shippingdate = shippingdate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.productid;
        hash = 11 * hash + this.categoryid;
        hash = 11 * hash + Objects.hashCode(this.productname);
        hash = 11 * hash + this.orderid;
        hash = 11 * hash + this.quantity;
        hash = 11 * hash + this.userid;
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
        final OrderProduct other = (OrderProduct) obj;
        if (this.productid != other.productid) {
            return false;
        }
        if (this.categoryid != other.categoryid) {
            return false;
        }
        if (this.orderid != other.orderid) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.userid != other.userid) {
            return false;
        }
        if (!Objects.equals(this.productname, other.productname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderProduct{" + "productid=" + productid + ", categoryid=" + categoryid + ", productname=" + productname + ", brand=" + brand + ", weight=" + weight + ", description=" + description + ", Stock=" + Stock + ", date=" + date + ", image1=" + image1 + ", image2=" + image2 + ", price=" + price + ", orderid=" + orderid + ", quantity=" + quantity + ", userid=" + userid + ", orderdate=" + orderdate + ", status=" + status + ", shippingdate=" + shippingdate + ", total=" + total + ", discount=" + discount + '}';
    }
    

}
