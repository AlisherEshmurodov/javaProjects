package com.mini_OOP_Projects.pdp.qoshiqqa_ovoz_berish;

import java.util.Scanner;

public class Songs {

    private int songId;
    private String songName;
    private int voteNumber;

    public Songs(int songId, String songName) {
        this.songId = songId;
        this.songName = songName;
    }

    public void addVoid(){
        this.voteNumber += 1;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "singId=" + songId +
                ", songName='" + songName + '\'' +
                ", voteNumber=" + voteNumber +
                '}';
    }

    public int getSingId() {
        return songId;
    }

    public void setSingId(int singId) {
        this.songId = singId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getVoteNumber() {
        return voteNumber;
    }

    public void setVoteNumber(int voteNumber) {
        this.voteNumber = voteNumber;
    }


    //********************************************************//********************************************************
    //********************************************************//********************************************************
    //********************************************************//********************************************************




}
