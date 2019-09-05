/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Objects;

/**
 *
 * @author Danielhua
 */
public class Category {
    private int CategoryID;
    private String CategoryName;
    private String Description;
    
    
    
    
    public Category()
    {
        
    }

    public Category(int CategoryID, String CategoryName, String Description) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
        this.Description = Description;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.CategoryID;
        hash = 83 * hash + Objects.hashCode(this.CategoryName);
        hash = 83 * hash + Objects.hashCode(this.Description);
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
        final Category other = (Category) obj;
        if (this.CategoryID != other.CategoryID) {
            return false;
        }
        if (!Objects.equals(this.CategoryName, other.CategoryName)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Category{" + "CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + ", Description=" + Description + '}';
    }
         
}
