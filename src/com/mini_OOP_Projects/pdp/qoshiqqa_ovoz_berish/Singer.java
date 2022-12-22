package com.mini_OOP_Projects.pdp.qoshiqqa_ovoz_berish;

import java.util.Arrays;

public class Singer {

    private int singerId;
    private String singerName;
    private Songs[] songs;

    public Singer(Songs[] songs, int singerId, String singerName) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.songs = songs;
    }


    @Override
    public String toString() {
        return "Singer{" +
                "singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", songs=" + Arrays.toString(songs) +
                '}';
    }

    public Songs[] getSongs() {
        return songs;
    }

    public void setSongs(Songs[] songs) {
        this.songs = songs;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }




    //******************************************************************//******************************************************************
    //******************************************************************//******************************************************************
    //******************************************************************//******************************************************************


}
