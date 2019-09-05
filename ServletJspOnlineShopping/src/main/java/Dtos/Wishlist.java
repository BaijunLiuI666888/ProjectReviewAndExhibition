/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author LYJni
 */
public class Wishlist {
    private int Wid;
    private int UserID;
    private int ProID;
    
    public  Wishlist(){
    
    }

    public Wishlist(int Wid, int UserID, int ProID) {
        this.Wid = Wid;
        this.UserID = UserID;
        this.ProID = ProID;
    }

    public int getWid() {
        return Wid;
    }

    public void setWid(int Wid) {
        this.Wid = Wid;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getProID() {
        return ProID;
    }

    public void setProID(int ProID) {
        this.ProID = ProID;
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
        final Wishlist other = (Wishlist) obj;
        if (this.Wid != other.Wid) {
            return false;
        }
        if (this.UserID != other.UserID) {
            return false;
        }
        if (this.ProID != other.ProID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wishlist{" + "Wid=" + Wid + ", UserID=" + UserID + ", ProID=" + ProID + '}';
    }
    
}
