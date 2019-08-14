/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callbackImplAndInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author LYJni
 */
public class RMITaskClientImpl extends UnicastRemoteObject implements RMITaskClientInterface
{
    public RMITaskClientImpl() throws RemoteException{
    }
    
    @Override
    public void newTaskNotification(String newNoti) throws RemoteException {
        System.out.println(newNoti);
    }
}
