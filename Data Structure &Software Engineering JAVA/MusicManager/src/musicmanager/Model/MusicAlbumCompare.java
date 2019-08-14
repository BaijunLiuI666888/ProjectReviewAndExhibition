/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmanager.Model;

import java.util.Comparator;

/**
 *
 * @author LYJni
 */
public class MusicAlbumCompare implements Comparator<Music> {

    @Override
    public int compare(Music m1, Music m2) {

        return m1.getAlbum().compareTo(m2.getAlbum());
    }

}
