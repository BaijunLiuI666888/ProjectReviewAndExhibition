/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callbackImplAndInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author LYJni
 */
public interface RMITaskClientInterface extends Remote
{
    public void newTaskNotification(String neNoti) throws RemoteException; 
}
