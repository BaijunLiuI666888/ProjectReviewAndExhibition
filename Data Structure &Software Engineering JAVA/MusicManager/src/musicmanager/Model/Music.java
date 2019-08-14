/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmanager.Model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author LYJni
 */
public class Music implements Serializable,  Comparable<Object> {

    private static final long serialVersionUID = 7816927114213914135L;
    private String title;
    private String artist;
    private String genre;
    private String dateOfRelease;
    private String album;
    private String trackNum;
    private String playCount;
    private String lastPlayedDate;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(String trackNum) {
        this.trackNum = trackNum;
    }

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    public String getLastPlayedDate() {
        return lastPlayedDate;
    }

    public void setLastPlayedDate(String lastPlayedDate) {
        this.lastPlayedDate = lastPlayedDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.artist);
        hash = 89 * hash + Objects.hashCode(this.genre);
        hash = 89 * hash + Objects.hashCode(this.dateOfRelease);
        hash = 89 * hash + Objects.hashCode(this.album);
        hash = 89 * hash + Objects.hashCode(this.playCount);
        hash = 89 * hash + Objects.hashCode(this.lastPlayedDate);
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
        final Music other = (Music) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.artist, other.artist)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.dateOfRelease, other.dateOfRelease)) {
            return false;
        }
        if (!Objects.equals(this.album, other.album)) {
            return false;
        }
        if (!Objects.equals(this.playCount, other.playCount)) {
            return false;
        }
        if (!Objects.equals(this.lastPlayedDate, other.lastPlayedDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Music{" + "title=" + title + ", artist=" + artist + ", genre=" + genre + ", dateOfRelease=" + dateOfRelease + ", album=" + album + ", trackNum=" + trackNum + ", playCount=" + playCount + ", lastPlayedDate=" + lastPlayedDate + '}';
    }
    public int compareTo(Object o) {

        Music song = (Music) o;
        if (this.getTitle().equalsIgnoreCase(song.getTitle())) {
            return (this.getArtist().compareToIgnoreCase(song.getArtist()));
        }
        return this.getTitle().compareToIgnoreCase(song.getTitle());
    }

}
