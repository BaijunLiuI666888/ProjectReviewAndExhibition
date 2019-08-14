/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javafx.scene.Node;
import musicmanager.Model.PlayList;
import musicmanager.Model.Music;
import musicmanager.Model.MusicAlbumCompare;
import musicmanager.Model.MusicArtistCompare;
import musicmanager.Model.MusicCompare;
import musicmanager.Model.MusicGenreCompare;
import musicmanager.Model.MusicList;
import musicmanager.Model.Sort;

/**
 *
 * @author LYJni
 */
public class MusicManager {

    public static void main(String[] args) {
        try {
            String filePath = "Songs.txt";
            // ini
            String name = "Blank PlayList";
            PlayList<Music> playList = null;
            MusicList list = new MusicList();

            // read file
            String musicStr = null;
            FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);
            ArrayList<Music> MusicsList = new ArrayList<Music>();
            String line;
            while ((line = br.readLine()) != null) {
                // line by line read
                System.out.println(line);
                musicStr += line;
            }
            String[] strs = musicStr.split(";");
            for (String st : strs) {
                System.out.println(st);
                String[] sts = st.split(",");
                Music mu = new Music();
                mu.setTitle(sts[0].replace("null", ""));
                mu.setArtist(sts[1]);
                mu.setGenre(sts[2]);
                mu.setDateOfRelease(sts[3]);
                mu.setAlbum(sts[4]);
                mu.setTrackNum(sts[5]);
                mu.setPlayCount(sts[6]);
                mu.setLastPlayedDate(sts[7]);
                list.add(mu);
            }
            //  list.quickSort(head);

            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.println("******************************Menu********************************");
                System.out.println("1.Add new song to list，2.delete a song，3.View All Song in natural order，4.re-organise music,5.Search，6.Play All，");
                System.out.println("7.Initialize PlayList，8.Show PlayList Name，9.Play Playlist,10.Edit Playlist，11.Delete PlayList，0.Exit and write file to new file");
                System.out.println("************************************************************");

                String input = scan.nextLine();
                System.out.println("scan:" + input);

                // 1=add song
                if ("1".equals(input)) {
                    System.out.println("Add：title");
                    String title = scan.nextLine();
                    System.out.println("Add：artist");
                    String artist = scan.nextLine();
                    System.out.println("Add：genre");
                    String genre = scan.nextLine();
                    System.out.println("Add：dateOfRelease");
                    String dateOfRelease = scan.nextLine();
                    System.out.println("Add：album");
                    String album = scan.nextLine();
                    System.out.println("Add：trackNum");
                    String trackNum = scan.nextLine();
                    System.out.println("Add：playCount");
                    String playCount = scan.nextLine();
                    System.out.println("Add：lastPlayedDate");
                    String lastPlayedDate = scan.nextLine();
                    if (title != null && artist != null && lastPlayedDate != null && genre != null && dateOfRelease != null && album != null && trackNum != null && playCount != null
                            && !"".equals(title) && !"".equals(artist) && !"".equals(genre) && !"".equals(dateOfRelease) && !"".equals(album) && !"".equals(trackNum) && !"".equals(playCount) && !"".equals(lastPlayedDate)) {
                        Music music = new Music();
                        music.setTitle(title);
                        music.setArtist(artist);
                        music.setGenre(genre);
                        music.setDateOfRelease(dateOfRelease);
                        music.setAlbum(album);
                        music.setTrackNum(trackNum);
                        music.setPlayCount(playCount);
                        music.setLastPlayedDate(lastPlayedDate);
                        list.add(music);
                        continue;
                    } else {
                        System.out.println("Wrong Input！");
                        continue;
                    }
                }

                // 2=delete
                if ("2".equals(input)) {
                    System.out.println("Delete Song：Pls enter the Song name: ignore  lower case");
                    String title = scan.nextLine();
                    if (title != null && !"".equals(title)) {
                        ArrayList<Music> musics = new ArrayList<Music>();
                        musics = list.findMusicTitle(title);
                        list.remove(musics.get(0));

//                        for (Music music : listCopy) {
//                            if (title.equalsIgnoreCase(music.getTitle())) {
//                                boolean excute = list.remove(music);
//                                if (excute) {
//                                    System.out.println(title + "Success");
//                                } else {
//                                    System.out.println(title + "Failed");
//                                }
//                            }
//                            System.out.println(music.getTitle());
//                        }
                        continue;
                    } else {
                        System.out.println("Wrong Input！");
                        continue;
                    }
                }

                // 3=all songs
                if ("3".equals(input)) {

                    System.out.println("-------arraylist---------");
                    MusicsList = list.getAllMusic();
                    list.quickSort();
                    Collections.sort(MusicsList);
                    System.out.println(MusicsList + "\n");

                    System.out.println("-------All Songs---------");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("Title: " + MusicsList.get(i).getTitle() + " /Artist: " + MusicsList.get(i).getArtist());
                    }
                    continue;
                }
                // 4 sort list by entity
                if ("4".equals(input)) {
                    MusicsList = list.getAllMusic();

                    System.out.println("-------Sort by---------");
                    System.out.println("1=Genre,2=Artist，3=Album");
                    String type = scan.nextLine();

                    if ("1".equals(type)) {
                        Collections.sort(MusicsList, new MusicGenreCompare());

                    }
                    if ("2".equals(type)) {
                        Collections.sort(MusicsList, new MusicArtistCompare());
                    }
                    if ("3".equals(type)) {
                        Collections.sort(MusicsList, new MusicAlbumCompare());
                    }

                    System.out.println("-------Result---------");
                    for (int i = 0; i < MusicsList.size(); i++) {
                        System.out.println("Title: " + MusicsList.get(i).getTitle() + " /Artist: " + MusicsList.get(i).getArtist() + " /Genre: " + MusicsList.get(i).getGenre() + " /Album: " + MusicsList.get(i).getAlbum());
                    }
                    continue;
                }

                // 5=search
                if ("5".equals(input)) {
                    System.out.println("-------Search a Song---------");
                    System.out.println("1=by Artist，2=by Album，3=by Title");
                    String type = scan.nextLine();
                    System.out.println("-------Enter here---------");
                    String search = scan.nextLine();

                    if (search != null && !"".equals(search)) {
                        if (type.equals("1")) {
                            MusicsList = list.findMusicArtist(search);
                        } else if (type.equals("2")) {
                            MusicsList = list.findMusicAlbum(search);
                        } else if (type.equals("3")) {
                            MusicsList = list.findMusicTitle(search);
                        } else {
                            System.out.println("invalid choice please reenter");

                        }
                        System.out.println("-------Result---------");
                        if (MusicsList == null) {
                            System.out.println(" Not Found ");
                        } else {
                            for (Music m : MusicsList) {
                                System.out.println("Title: " + m.getTitle() + " /Artist: " + m.getArtist() + " /Genre: " + m.getGenre() + " /Album: " + m.getAlbum());
                            }
                        }
                        continue;
                    } else {
                        System.out.println("Wrong Input！");
                        continue;
                    }
                }

                // 6=play the song 
                if ("6".equals(input)) {
                    System.out.println("-------Start to playing---------");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("-------playing：" + list.get(i).getTitle() + "---------");
                        System.out.println("Title" + list.get(i).getTitle());
                        System.out.println("Artist" + list.get(i).getArtist());
                        System.out.println("Genre" + list.get(i).getGenre());
                        System.out.println("Release Date" + list.get(i).getDateOfRelease());
                        System.out.println("Album" + list.get(i).getAlbum());
                        System.out.println("Play Count" + list.get(i).getPlayCount());
                        System.out.println("Last play Date (FAKE)" + list.get(i).getLastPlayedDate() + "24/5/2019");
                        System.out.println("Playing...");
                        try {
                            Thread.sleep(2 * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    continue;
                }

                // 7=add playList stack
                if ("7".equals(input)) {
                    System.out.println("Enter PlayList Name！");
                    String nameInput = scan.nextLine();
                    if (nameInput == null || "".equals(nameInput)) {
                        System.out.println("Not-Null Please！");
                        continue;
                    }
                    name = nameInput;
                    playList = new PlayList<Music>();
                    System.out.println("Success！");
                    continue;
                }

                // 8=show list 
                if ("8".equals(input)) {
                    System.out.println("-------Show PlayLists---------");
                    System.out.println("PlayLists：" + name);
                    if (playList == null) {
                        System.err.println("Nothing here，add press 7 to initialize one！");
                        continue;
                    }
                    for (int i = 0; i < playList.size(); i++) {
                        Music mu = playList.get(i);
                        System.out.println(mu.getTitle());
                    }
                    continue;
                }

                // 9=play the list
                if ("9".equals(input)) {
                    if (playList == null) {
                        System.err.println("Nothing here，add press 10！");
                        continue;
                    }
                    System.out.println("-------play the list---------");
                    System.out.println("PlayList：" + name);
                    Music mm = playList.pop();
                    while (mm != null) {
                        System.out.println(mm.getTitle());
                        System.out.println("-------playing：" + mm.getTitle() + "---------");
                        System.out.println("Title" + mm.getTitle());
                        System.out.println("Artist" + mm.getArtist());
                        System.out.println("Genre" + mm.getGenre());
                        System.out.println("Release Date" + mm.getDateOfRelease());
                        System.out.println("Album" + mm.getAlbum());
                        System.out.println("Play Count" + mm.getPlayCount());
                        System.out.println("Last play Date (FAKE)" + mm.getLastPlayedDate());
                        System.out.println("Playing...");
                        try {
                            Thread.sleep(2 * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mm = playList.pop();
                    }
                    continue;
                }

                // 10=edit playlist
                if ("10".equals(input)) {
                    System.out.println("-------Edit PlayList---------");
                    System.out.println("PlayList：" + name);
                    System.out.println("Choose one：1=Add song to playlist，2=Rename the PlayList，3=Show all Song in the list");
                    String type = scan.nextLine();
                    // add
                    if ("1".equals(type)) {
                        if (playList == null) {
                            System.err.println("，initialize the playlist first press 7！");
                            continue;
                        }
                        System.out.println("enter the name you wish to add into playlist");
                        String title = scan.nextLine();
                        if (title == null || "".equals(title)) {
                            System.out.println("Wrong Input！");
                            continue;
                        }
                        MusicsList = list.findMusicTitle(title);
                        if (MusicsList != null) {
                            for (Music mu : MusicsList) {

                                playList.push(mu);
                                continue;

                            }
                        }else {
                        System.out.println("song not exist in libray");
                        }
                    }
                    // 2=delete
                    if ("n".equals(type)) {
                        if (playList == null) {
                            System.err.println("playList is blank，press 7/ 10-1 to initialize/add！");
                            continue;
                        }
                        System.out.println("enter the name you wish to delete");
                        String title = scan.nextLine();
                        if (title == null || "".equals(title)) {
                            System.out.println("Wrong input！");
                            continue;
                        }
                        for (int i = 0; i < playList.size(); i++) {
                            if (title.equalsIgnoreCase(list.get(i).getTitle())) {
                                int j = playList.search(list.get(i));
                                playList.remove(j);
                                continue;
                            }
                        }
                        System.err.println("Song not exist！");
                        continue;
                    }
                    // 2=rename
                    if ("2".equals(type)) {
                        System.out.println("enter the new name");
                        String title = scan.nextLine();
                        if (title == null || "".equals(title)) {
                            System.out.println("Wrong Input！");
                            continue;
                        }
                        name = title;
                        System.out.println("Complete！");
                        continue;
                    }
                    // 3=show all
                    if ("3".equals(type)) {
                        System.out.println("-------Show All in PlayList---------");
                        System.out.println("PlayList：" + name);
                        if (playList == null) {
                            System.err.println("PlayList is null，press 10 to edit！");
                            continue;
                        }
                        for (int i = 0; i < playList.size(); i++) {
                            Music mu = playList.get(i);
                            System.out.println(mu.getTitle() + " /Artist" + mu.getArtist());
                        }
                        continue;
                    }
                }

                // 11=delete play list
                if ("11".equals(input)) {
                    playList = null;
                    name = "";
                    System.out.println("Success！");
                    continue;
                }

                // 0=write out and exit
                if ("0".equals(input)) {
                    // write in txt
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < list.size(); i++) {
                        sb.append("title:" + list.get(i).getTitle() + ",");
                        sb.append("artist:" + list.get(i).getArtist());
                        sb.append("genre:" + list.get(i).getGenre() + ",");
                        sb.append("dateOfRelease:" + list.get(i).getDateOfRelease() + ",");
                        sb.append("album:" + list.get(i).getAlbum() + ",");
                        sb.append("trackNum:" + list.get(i).getTrackNum() + ",");
                        sb.append("playCount:" + list.get(i).getPlayCount() + ",");
                        sb.append("lastPlayedDate:" + list.get(i).getLastPlayedDate());
                        if (i < list.size() - 1) {
                            sb.append("&"+"\n");
                        }
                    }
                    File writename = new File("writeout.txt");
                    writename.createNewFile(); // new file
                    BufferedWriter out = new BufferedWriter(new FileWriter(writename));
                    out.write(sb.toString()); // 
                    out.flush(); //psuh
                    out.close();
                    System.out.println("-------file in，exit now---------");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
