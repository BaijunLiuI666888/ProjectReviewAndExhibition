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
 * @author Danielhua
 */
public class User {
    private int UserID ;
    private String UserName;
    private String Password;
    private String FirstName ;
    private String LastName;
    private String Gender;
    private String Phone;
    private String Email;
    private String Address;
    private String Date ;
   private boolean ifAdmin;
   private boolean ifVip;
   
   
   
   
   public User()
   {
   
   }
      public User(int UserID, String UserName, String Password, String FirstName, String LastName, String Gender, String Phone, String Email, String Address, String Date, boolean ifAdmin, boolean ifVip) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Date = Date;
        this.ifAdmin = ifAdmin;
        this.ifVip = ifVip;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public boolean getIfAdmin() {
        return ifAdmin;
    }

    public void setIfAdmin(boolean ifAdmin) {
        this.ifAdmin = ifAdmin;
    }

    public boolean getIfVip() {
        return ifVip;
    }

    public void setIfVip(boolean ifVip) {
        this.ifVip = ifVip;
    }


    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.UserID;
        hash = 31 * hash + Objects.hashCode(this.UserName);
        hash = 31 * hash + Objects.hashCode(this.Password);
        hash = 31 * hash + Objects.hashCode(this.FirstName);
        hash = 31 * hash + Objects.hashCode(this.LastName);
        hash = 31 * hash + Objects.hashCode(this.Gender);
        hash = 31 * hash + Objects.hashCode(this.Phone);
        hash = 31 * hash + Objects.hashCode(this.Email);
        hash = 31 * hash + Objects.hashCode(this.Address);
        hash = 31 * hash + Objects.hashCode(this.Date);
        hash = 31 * hash + (this.ifAdmin ? 1 : 0);
        hash = 31 * hash + (this.ifVip ? 1 : 0);
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
        final User other = (User) obj;
        if (this.UserID != other.UserID) {
            return false;
        }
        if (this.ifAdmin != other.ifAdmin) {
            return false;
        }
        if (this.ifVip != other.ifVip) {
            return false;
        }
        if (!Objects.equals(this.UserName, other.UserName)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        if (!Objects.equals(this.FirstName, other.FirstName)) {
            return false;
        }
        if (!Objects.equals(this.LastName, other.LastName)) {
            return false;
        }
        if (!Objects.equals(this.Gender, other.Gender)) {
            return false;
        }
        if (!Objects.equals(this.Phone, other.Phone)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Address, other.Address)) {
            return false;
        }
        if (!Objects.equals(this.Date, other.Date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "UserID=" + UserID + ", UserName=" + UserName + ", Password=" + Password + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Gender=" + Gender + ", Phone=" + Phone + ", Email=" + Email + ", Address=" + Address + ", Date=" + Date + ", ifAdmin=" + ifAdmin + ", ifVip=" + ifVip + '}';
    }

   

   
    
    
 
   
    
    
           
    
    
}
