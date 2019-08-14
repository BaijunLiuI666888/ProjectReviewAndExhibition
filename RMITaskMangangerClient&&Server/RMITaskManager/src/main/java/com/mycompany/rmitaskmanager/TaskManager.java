package com.mycompany.rmitaskmanager;

import MethodAndInterface.RMITaskImpl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LYJni
 */
public class TaskManager {

    public static void main(String[] args) {
        try {
            RMITaskImpl taskObject = new RMITaskImpl();

            int portNum;
            String hostName= "localhost";
            if (args.length > 0) {
                portNum = Integer.parseInt(args[0]);
            } else {
                portNum = 6668;
            }

            startRegistry(portNum);

            String registryPath = "rmi://"+hostName+":" + portNum;
            String objectLabel = "/taskManager";

            Naming.rebind(registryPath + objectLabel, taskObject);
        } catch (RemoteException ex) {
            Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // This method starts a RMI registry on the local host, if it
    // does not already exist at the specified port number.
    private static void startRegistry(int RMIPortNum) throws RemoteException {
        try {
            // Try to get the registry at a specific port number
            // If there is no registry started on that port, an exception will be thrown
            Registry registry = LocateRegistry.getRegistry(RMIPortNum);

            registry.list();
        } catch (RemoteException ex) {
            // No valid registry at that port.
            System.out.println("no rmi registry in this port " + RMIPortNum);

            // Create a registry on the given port number
            Registry registry = LocateRegistry.createRegistry(RMIPortNum);
            System.out.println("RMI registry created at port " + RMIPortNum);
        }
    } // end startRegistry
}
