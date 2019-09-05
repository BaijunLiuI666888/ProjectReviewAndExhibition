/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Objects;

/**
 *
 * @author LYJni
 */
public class CategoryProduct {

    private int productID;
    private int categoryID;
    private String productName;
    private String categoryName;
    private String brand;
    private double weight;
    private String pDescription;
    private String cDescription;
    private int stock;
    private String date;
    private byte[] image1;
    private byte[] image2;
    private double Price;
    
        public CategoryProduct(){
    
    
    }

    public CategoryProduct(int productID, int categoryID, String productName, String categoryName, String brand, double weight, String pDescription, String cDescription, int stock, String date, byte[] image1, byte[] image2, double Price) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.categoryName = categoryName;
        this.brand = brand;
        this.weight = weight;
        this.pDescription = pDescription;
        this.cDescription = cDescription;
        this.stock = stock;
        this.date = date;
        this.image1 = image1;
        this.image2 = image2;
        this.Price = Price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final CategoryProduct other = (CategoryProduct) obj;
        if (this.productID != other.productID) {
            return false;
        }
        if (this.categoryID != other.categoryID) {
            return false;
        }
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.categoryName, other.categoryName)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CategoryProduct{" + "productID=" + productID + ", categoryID=" + categoryID + ", productName=" + productName + ", categoryName=" + categoryName + ", brand=" + brand + ", weight=" + weight + ", pDescription=" + pDescription + ", cDescription=" + cDescription + ", stock=" + stock + ", date=" + date + ", image1=" + image1 + ", image2=" + image2 + ", Price=" + Price + '}';
    }
    
}
