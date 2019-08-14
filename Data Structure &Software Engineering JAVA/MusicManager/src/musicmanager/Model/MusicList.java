/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmanager.Model;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import javafx.scene.Node;

/**
 *
 * @author LYJni
 */
public class MusicList implements Serializable {

    private Node first;
    private Node last;
    private int size;
//    @SuppressWarnings("unchecked")
//    private MusicList superClone() {
//        try {
//            return (MusicList) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new InternalError();
//        }
//    }
//
//    
//    //  copy of 2 waylinked list
//    
//    public Object clone() {
//        MusicList clone = superClone();
//
//        clone.first = clone.last = null;
//        clone.size = 0;
//        
//
//        for (Node x = first; x != null; x = x.next)
//            clone.add(x.data);
//
//        return clone;
//    }

    public MusicList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(Music data) {
        Node newNode = new Node(data) {
        };
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void addFirst(Music data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void addPos(int pos, Music data) {
        if (pos > size || pos < 0) {
            throw new IndexOutOfBoundsException();
        } else if (pos == 0) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            if (pos == size) {
                last.next = newNode;
                last = newNode;
            } else {
                Node current = first;
                for (int i = 0; i < pos - 1; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            size++;
        }
    }

    public Music get(int pos) {
        if (isEmpty() || pos >= size || pos < 0) {
            throw new IndexOutOfBoundsException();
        } else if (pos == 0) {
            return first.data;
        } else if (pos == size - 1) {
            return last.data;
        } else {

            Node current = first;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }

            return current.data;
        }
    }

    public Music set(int position, Music data) {
        if (isEmpty() || position >= size || position < 0) {
            throw new IndexOutOfBoundsException();
        } else if (position == 0) {
            return first.data;
        } else if (position == size - 1) {
            return last.data;
        } else {
            Node current = first;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            Music oldData = current.data;
            current.data = data;
            return oldData;
        }
    }

    public int indexOf(Music data) {

        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(data)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public void removeFirst() {

        if (first != null) {
            first = first.next;
        }
        if (first == null) {
            last = null;
        }
        size--;
    }

    public void removeLast() {
        if (first == null) {
            return;
        } else if (first.equals(last)) {
            first = null;
            last = null;
            size--;
        } else {
            Node current = first;
            while (current.next != last) {
                current = current.next;
            }
            last = current;
            current.next = null;
            size--;
        }
    }

    public Music remove(int index) {

        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            Music temp = first.data;
            removeFirst();
            return temp;
        } else {
            Node current = first;
            for (int i = 0; i < index - 1; i++) {
                if (current == null) {
                    throw new IndexOutOfBoundsException();
                }
                current = current.next;
            }
            Music temp = current.next.data;
            current.next = current.next.next;
            if (current.next == null) {
                last = current;
            }
            size--;
            return temp;
        }
    }

    public Music remove(Music data) {

        int index = indexOf(data);
        return remove(index);
    }

    public int size() {
        return size;
    }

    public int lastIndexOf(Music data) {

        Node current = first;
        int lastPosition = -1;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(data)) {
                lastPosition = i;
            }
            current = current.next;
        }
        return lastPosition;
    }

    public ArrayList<Music> getAllMusic() {

        ArrayList<Music> all = new ArrayList<>();
        Node current = first;
        int lastPosition = -1;
        for (int i = 0; i < size; i++) {
            all.add(current.data);
            current = current.next;
        }
        if (all.isEmpty()) {
            return null;
        }
        return all;
    }

    public ArrayList<Music> findMusicTitle(String data) {

        ArrayList<Music> allSongs = new ArrayList<>();
        Node current = first;
        int lastPosition = -1;
        for (int i = 0; i < size; i++) {

            if (current.data.getTitle().equalsIgnoreCase(data)) {
                allSongs.add(current.data);
            }
            current = current.next;
        }
        if (allSongs.isEmpty()) {
            return null;
        }
        return allSongs;
    }

    public ArrayList<Music> findMusicAlbum(String data) {

        ArrayList<Music> allMusic = new ArrayList<>();
        Node cc = first;
        int lastPosition = -1;
        for (int i = 0; i < size; i++) {
            if (cc.data.getAlbum().equalsIgnoreCase(data)) {
                allMusic.add(cc.data);
            }
            cc = cc.next;
        }
        if (allMusic.isEmpty()) {
            return null;
        }
        return allMusic;
    }

    public ArrayList<Music> findMusicArtist(String data) {

        ArrayList<Music> allMusic = new ArrayList<>();
        Node cc = first;
        int lastPosition = -1;
        for (int i = 0; i < size; i++) {
            if (cc.data.getArtist().equalsIgnoreCase(data)) {
                allMusic.add(cc.data);
            }
            cc = cc.next;
        }
        if (allMusic.isEmpty()) {
            return null;
        }
        return allMusic;
    }

    public ArrayList<Music> findMusicGenre(String data) {

        ArrayList<Music> allMusic = new ArrayList<>();
        Node cc = first;
        int lastPosition = -1;
        for (int i = 0; i < size; i++) {
            if (cc.data.getGenre().equalsIgnoreCase(data)) {
                allMusic.add(cc.data);
            }
            cc = cc.next;
        }
        if (allMusic.isEmpty()) {
            return null;
        }
        return allMusic;
    }

    public boolean contains(Music data) {

        return indexOf(data) != -1;
    }

    public Music getByIndex(int index) {

        if (isEmpty() || index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    public void leftRotate() {

        Node temp = first;
        removeFirst();
        add(temp.data);
    }

    private static class Node {

        private Music data;
        private Node next;
        private Node prev;

        public Node(Music data) {
            next = null;
            prev = null;
            this.data = data;
        }

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasPrev() {
            return prev != null;
        }
    }

    Node partition(Node l, Node h) {
        // set pivot as h element 
        Music x = h.data;

        // similar to i = l-1 for array implementation 
        Node i = l.prev;

        // Similar to "for (int j = l; j <= h- 1; j++)" 
        for (Node j = l; j != h; j = j.next) {
            if (j.data.getTitle().compareTo(x.getTitle()) < 0) {
                // Similar to i++ for array 
                i = (i == null) ? l : i.next;
                Music temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i == null) ? l : i.next;  // Similar to i++ 
        Music temp = i.data;
        i.data = h.data;
        h.data = temp;
        return i;
    }

    /* A recursive implementation of quicksort for linked list */
    void _quickSort(Node l, Node h) {
        if (h != null && l != h && l != h.next) {
            Node temp = partition(l, h);
            _quickSort(l, temp.prev);
            _quickSort(temp.next, h);
        }
    }

    Node lastNode(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public void quickSort() {
        // Find last node 
        // Node head = lastNode(first);

        // Call the recursive QuickSort 
        _quickSort(first, last);
    }

    //*****************************************************************************************
    Node split(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }

    public Node mergeSort() {
        if (first == null || first.next == null) {
            return first;
        }
        Node second = split(first);

        // Recur for left and right halves 
        first = mergeSort();
        second = mergeSort();

        // Merge the two sorted halves 
        return merge(first, second);
    }

    // Function to merge two linked lists 
    Node merge(Node first, Node second) {
        // If first linked list is empty 
        if (first == null) {
            return second;
        }

        // If second linked list is empty 
        if (second == null) {
            return first;
        }

        // Pick the smaller value 
        if (first.data.getTitle().compareTo(second.data.getTitle()) < 0) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

}
