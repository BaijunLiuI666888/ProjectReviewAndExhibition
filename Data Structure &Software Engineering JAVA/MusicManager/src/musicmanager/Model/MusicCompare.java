/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmanager.Model;

import java.util.Comparator;
import musicmanager.Model.Music;

/**
 *
 * @author LYJni
 */
public class MusicCompare implements Comparator<Music>{

    @Override
        public int compare(Music m1, Music m2) { 
  
            // for comparison 
            int NameCompare = m1.getTitle().compareTo(m2.getTitle()); 
            int ArtCompare = m1.getArtist().compareTo(m2.getArtist()); 
  
            // 2-level comparison using if-else block 
            if (NameCompare == 0) { 
                return ((ArtCompare == 0) ? NameCompare : ArtCompare); 
            } else { 
                return NameCompare; 
            } 
        }
    
    

}
