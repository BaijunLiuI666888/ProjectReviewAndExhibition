/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author LYJni
 */
public class Task implements Serializable {

    private int id = 0;
    private static int count = 1;
    private String author;
    private String title;
    private String content;
    private int accepterID;
    private String accepter;

    public Task(String author, String title, String content, int accepterID, String accepter) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.accepterID = accepterID;
        this.accepter = accepter;
        id = ++count;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAccepterID() {
        return accepterID;
    }

    public void setAccepterID(int accepterID) {
        this.accepterID = accepterID;
    }

    public String getAccepter() {
        return accepter;
    }

    public void setAccepter(String accepter) {
        this.accepter = accepter;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.author);
        hash = 31 * hash + Objects.hashCode(this.title);
        hash = 31 * hash + Objects.hashCode(this.content);
        hash = 31 * hash + this.accepterID;
        hash = 31 * hash + Objects.hashCode(this.accepter);
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
        final Task other = (Task) obj;
        if (this.accepterID != other.accepterID) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.accepter, other.accepter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", author=" + author + ", title=" + title + ", content=" + content + ", accepterID=" + accepterID + ", accepter=" + accepter + '}';
    }

}
