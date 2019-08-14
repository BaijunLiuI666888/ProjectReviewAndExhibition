package com.mycompany.rmitaskclient;

import Model.Task;
import Model.User;
import callbackImplAndInterface.RMITaskClientImpl;
import callbackImplAndInterface.RMITaskClientInterface;
import MethodAndInterface.RMITaskInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;
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
public class RMITaskClient {

    public static void main(String[] args) {
        try {
            int portNum=0;
            String hostName = "";
            if (args.length > 0) {
                try {
                    hostName = args[0];
                } catch (NumberFormatException e) {
                    System.err.println("Argument" + args[0] + " must be an ip string.");
                    System.exit(1);
                }
            } else {

                hostName = "localhost";
            }
            if (args.length > 1) {
                try {
                    portNum = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    System.err.println("Argument" + args[0] + " must be an integer port number.");
                    System.exit(1);
                }
            } else {
                portNum = 6668;
            }

            String registryPath = "rmi://" + hostName + ":" + portNum;
            String objectLabel = "/taskManager";

            RMITaskInterface taskService = (RMITaskInterface) Naming.lookup(registryPath + objectLabel);

            RMITaskClientInterface thisClient = new RMITaskClientImpl();

            User sessionUser = null;
            while (true) {

                displayMenu();
                Scanner userInput = new Scanner(System.in);

                int choice = getNumber(userInput);

                switch (choice) {
                    case 0:
                        System.out.println("now Exit");
                        System.exit(0);
                        break;
                    case 1://register
                        if (sessionUser == null) {
                            userInput.nextLine();
                            System.out.println("please enter the username");
                            String userNamer = userInput.nextLine();

                            System.out.println("please enter the password");
                            String passwordr = userInput.nextLine();
                            User u = new User(userNamer, passwordr);
                            taskService.register(u);
                            System.out.println(taskService.getUserList());
                        } else {
                            System.out.println("please sign out");
                        }
                        break;
                    case 2: //login
                        if (sessionUser == null) {
                            userInput.nextLine();
                            System.out.println("pls enter the username ");
                            String userNameL = userInput.nextLine();
//                            userInput.nextLine();
                            System.out.println("please enter the password");
                            String passwordL = userInput.nextLine();
                            User uncofirmedUser = new User(userNameL, passwordL);
                            User res = taskService.login(uncofirmedUser);

                            if (res != null) {

                                sessionUser = new User(res.getEmail(), res.getPassword());
                                System.out.println("success" + " /your user id " + res.GetUserID());
                            } else if (res == null) {
                                System.out.println("try again");
                            }
                        } else {
                            System.out.println("please sign out");
                        }

                        break;
                    case 3: //get all tasks
                        if (sessionUser != null) {
                            System.out.println(taskService.getTasks());
                        } else {
                            System.out.println("login pls");
                        }

                        break;
                    case 4: // get your added tasks
                        if (sessionUser != null) {
                            System.out.println(taskService.getMyBidTasks(sessionUser.getEmail()));
                        } else {
                            System.out.println("login pls");
                        }

                        break;
                    case 5: //Get your accepted Tasks
                        if (sessionUser != null) {
                            System.out.println(taskService.getMyAccepedTasks(sessionUser.getEmail()));
                        } else {
                            System.out.println("login pls");
                        }
                        break;
                    case 6: //Add a Task
                        if (sessionUser != null) {
                            userInput.nextLine();
                            System.out.println("please enther the title");
                            String title = userInput.nextLine();

                            System.out.println("please enther the content");
                            String content = userInput.nextLine();

                            Task t = new Task(sessionUser.getEmail(), title, content, 0, "no accepter");
                            boolean resultADD = taskService.addTask(t);
                            if (resultADD) {
                                System.out.println(title);
                                System.out.println("ADDED");
                            } else {
                                System.out.println("PLEASE TRY AGAIN");
                            }
                        } else {
                            System.out.println("PLEASE LOGIN");
                        }
                        break;
                    case 7: //accept a Task
                        if (sessionUser != null) {
                            userInput.nextLine();
                            System.out.println("please enther the task id");
                            int tid = userInput.nextInt();
                            userInput.nextLine();
                            System.out.println("Are you sure? y/n");
                            String checkUser = userInput.nextLine();
                            if (checkUser.equalsIgnoreCase("y")) {

                                System.out.println(taskService.acceptTask(tid, sessionUser));

                            } else {
                                System.out.println("no problem");
                            }

                        } else {
                            System.out.println("PLEASE LOGIN");
                        }
                        break;
                    case 8: //delete a task
                        if (sessionUser != null) {
                            userInput.nextLine();
                            System.out.println("please enther the task id to delete");
                            int tid = userInput.nextInt();
                            userInput.nextLine();
                            System.out.println("Are you sure? y/n");
                            String checkUser = userInput.nextLine();
                            if (checkUser.equalsIgnoreCase("y")) {

                                System.out.println(taskService.deleteTask(tid, sessionUser));

                            } else {
                                System.out.println("no problem");
                            }

                        } else {
                            System.out.println("PLEASE LOGIN");
                        }
                        break;
                    case 9: //subscribe
                        taskService.registerForCallback(thisClient);

                        System.out.println("Subscribed");

                        break;
                    case 10: //un subscribe
                        taskService.unregisterForCallback(thisClient);
                        System.out.println("DisSubscribed");
                        break;
                    case 11:
                        if (sessionUser != null) {
                            System.out.println("Hello: /" + sessionUser.getEmail());
                        } else if (sessionUser == null) {
                            System.out.println("you are not loggedin");
                        }
                        break;
                    case 12:
                        sessionUser = null;

                        break;
                    default:
                        System.out.println("This is not a valid Menu Option! Please Select Another");
                        break;

                }

            }

        } catch (NotBoundException ex) {
            Logger.getLogger(RMITaskClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMITaskClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMITaskClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getNumber(Scanner keyboard) {
        boolean numberEntered = false;
        int number = 0;
        while (!numberEntered) {
            try {
                number = keyboard.nextInt();
                numberEntered = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                keyboard.nextLine();
            }
        }

        return number;
    }

    public static void displayMenu() {
        System.out.println("0) Exit");
        System.out.println("1) Register");
        System.out.println("2) Loggin");
        System.out.println("3) Get All Tasks");
        System.out.println("4) Get your added Task");
        System.out.println("5) Get your accepted Tasks");
        System.out.println("6) Add a Task");
        System.out.println("7) accept a Task");
        System.out.println("8) delete a task");
        System.out.println("9) register for notification");
        System.out.println("10) unregister for notification");
        System.out.println("11)check user state");
        System.out.println("12) signout");

    }

}
