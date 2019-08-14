/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MethodAndInterface;

import Model.Task;
import Model.User;
import callbackImplAndInterface.RMITaskClientInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author LYJni
 */
public interface RMITaskInterface extends Remote {

    public boolean addTask(Task t) throws RemoteException;

    public String getTasks() throws RemoteException;

    public String getMyBidTasks(String email) throws RemoteException;

     public String getMyAccepedTasks(String email) throws RemoteException;

    public String acceptTask(int tid, User u) throws RemoteException;

     public String deleteTask(int id, User u) throws RemoteException;

    public String register(User u) throws RemoteException;

     public User login(User u) throws RemoteException;

    public boolean registerForCallback(RMITaskClientInterface client) throws RemoteException;

    public boolean unregisterForCallback(RMITaskClientInterface client) throws RemoteException;

    public String getUserList() throws RemoteException;
}
