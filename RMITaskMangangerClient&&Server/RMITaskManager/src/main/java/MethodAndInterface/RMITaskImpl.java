/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MethodAndInterface;

import callbackImplAndInterface.RMITaskClientInterface;
import Model.Task;
import Model.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author LYJni
 */
public class RMITaskImpl extends UnicastRemoteObject implements RMITaskInterface {

    private final ArrayList<Task> taskList = new ArrayList();
    private final ArrayList<User> userList = new ArrayList();
    private final ArrayList<RMITaskClientInterface> clientList = new ArrayList();
    private User sessionUser = null;

    public RMITaskImpl() throws RemoteException {

    }

    @Override
    public boolean addTask(Task t) throws RemoteException {
        boolean added = false;
        Task newTask = new Task(t.getAuthor(), t.getTitle(), t.getContent(), t.getAccepterID(), t.getAccepter());
        synchronized (taskList) {
            added = taskList.add(newTask);
        }
        if (added) {
            synchronized (clientList) {
                for (RMITaskClientInterface client : clientList) {
                    client.newTaskNotification("New task added: " + newTask);
                }
            }
        }
        return added;
    }

    @Override
    public String getTasks() throws RemoteException {
        String tasks = "";
        String result = "";
        int id = 0;
        String accecpter = "";
        synchronized (taskList) {

            for (int i = 0; i < taskList.size(); i++) {
                id = taskList.get(i).getId();
                accecpter = " /" + taskList.get(i).getAccepter() + " /task title: ";
                tasks = taskList.get(i).getTitle() + "\n";
                result = result + id + accecpter + tasks;
            }
        }
        return result;
    }

    @Override
    public String register(User u) throws RemoteException {
        User newUser = new User(u.getEmail(), u.getPassword());
        synchronized (userList) {

            userList.add(newUser);
            return "success";

        }
    }

    @Override
    public String getUserList() throws RemoteException {

        String username = "";
        String password = "";
        int uid = 0;
        String result = "";
        synchronized (userList) {

            for (int i = 0; i < userList.size(); i++) {
                uid = userList.get(i).GetUserID();
                username = " /User: " + userList.get(i).getEmail() + " /password: ";
                password = userList.get(i).getPassword() + "\n";
                result = result + uid + username + password;
            }
        }
        return result;

    }

    @Override
    public User login(User u) throws RemoteException {

        synchronized (userList) {
            if (u != null && userList.contains(u)) {
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).getEmail().equals(u.getEmail())) {
                        return userList.get(i);
                    }
                }

            }

        }
        return null;
    }

    @Override
    public boolean registerForCallback(RMITaskClientInterface client) throws RemoteException {
        synchronized (clientList) {
            if (client != null && !clientList.contains(client)) {
                clientList.add(client);
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean unregisterForCallback(RMITaskClientInterface client) throws RemoteException {
        synchronized (clientList) {
            if (client != null && clientList.contains(client)) {
                clientList.remove(client);
                return true;
            }
            return false;
        }
    }

    @Override
    public String getMyBidTasks(String email) throws RemoteException {
        String tasks = "";

        String result = "";
        int id = 0;
        String accecpter = "";
        synchronized (taskList) {

            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getAuthor().equals(email)) {
                    id = taskList.get(i).getId();
                    accecpter = " /" + taskList.get(i).getAccepter() + " /task title: ";
                    tasks = taskList.get(i).getTitle() + "\n";
                    result = result + id + accecpter + tasks;
                }
            }
        }
        return result;
    }

    @Override
    public String getMyAccepedTasks(String email) throws RemoteException {
        String tasks = "";

        String result = "";
        int id = 0;
        String accecpter = "";
        synchronized (taskList) {

            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getAccepter().equals(email)) {
                    id = taskList.get(i).getId();
                    accecpter = "accepter: /" + taskList.get(i).getAccepter() + " /task title: ";
                    tasks = taskList.get(i).getTitle() + "\n";
                    result = result + "task" + id + accecpter + tasks;
                }
            }
        }
        return result;
    }

    @Override
    public String acceptTask(int tid, User u) throws RemoteException {
        String task = "";

        synchronized (taskList) {

            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getId() == tid) {
                    taskList.get(i).setAccepterID(u.GetUserID());
                    taskList.get(i).setAccepter(u.getEmail());
                    task = "your accepted task: " + taskList.get(i).toString();
                    synchronized (clientList) {
                        for (RMITaskClientInterface client : clientList) {
                            client.newTaskNotification("New task accepted: /" + taskList.get(i).toString());
                        }
                    }
                } else {
                    task = "not done";

                }
            }
        }
        return task;
    }

    @Override
    public String deleteTask(int id, User u) throws RemoteException {
        String t = "";
        String title="";
        synchronized (taskList) {

            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getAuthor().equals(u.getEmail()) && taskList.get(i).getId() == id) {
                    title = taskList.get(i).getTitle();
                    taskList.remove(i);
                    t = "done";
                    synchronized (clientList) {
                        for (RMITaskClientInterface client : clientList) {
                            client.newTaskNotification("Task deleted: /" + title);
                        }
                    }
                } else {
                    t = "no privilege";

                }
            }
        }
        return t;
    }
}
