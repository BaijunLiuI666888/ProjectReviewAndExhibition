/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.User;
import java.util.List;

/**
 *
 * @author Danielhua
 */
public interface UserDaoInterface {
   
    public int register(String userName ,String password , String firstName , String lastName ,String gender,String phone  ,String email,String address);
    
     public User checkLogin(String uname, String pword);
   
      public User getUserById(int id);
      public List<User> getAllUsers();
     
     public int editUserDetails(int id, String uName, String fName, String lName, String password, String phone, String gender, String address,String email);
     
      public boolean findUserByUsername(String UserName);
             public boolean DeleteUser (int id);
}


