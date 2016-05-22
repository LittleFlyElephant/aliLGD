package po;

import util.TimeUtil;

import java.util.Calendar;

/**
 * Created by raychen on 16/5/22.
 */
public class SongPO {

    private String song_id;
    private String artist_id;
    private Calendar publish_time;
    private int init_play;
    private int language;
    private int gender;

    public SongPO(String song_id, String artist_id, int publish_time, int init_play, int language, int gender) {
        this.song_id = song_id;
        this.artist_id = artist_id;
        this.publish_time = TimeUtil.getTimeFromInt(publish_time);
        this.init_play = init_play;
        this.language = language;
        this.gender = gender;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }

    public void setPublish_time(Calendar publish_time) {
        this.publish_time = publish_time;
    }

    public void setInit_play(int init_play) {
        this.init_play = init_play;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSong_id() {
        return song_id;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public Calendar getPublish_time() {
        return publish_time;
    }

    public int getInit_play() {
        return init_play;
    }

    public int getLanguage() {
        return language;
    }

    public int getGender() {
        return gender;
    }
}
