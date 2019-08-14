/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmanager.Model;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author LYJni
 */
public class PlayList<E> extends Vector<E> implements Serializable {

    public PlayList() {
        
    }

    public E push(E item) {
        addElement(item);

        return item;
    }

    public synchronized E pop() {
        E  obj;
        int len = size();
        if (len == 0)
            return null;
        
        obj = peek();
        removeElementAt(len - 1);

        return obj;
    }

    public synchronized E peek() {
        int len = size();

        if (len == 0)
            return null;
        return elementAt(len - 1);
    }


    public synchronized int search(Object o) {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }

    private static final long serialVersionUID = 1224463164541339165L;
}
