package po;

import util.ActionType;
import util.TimeUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by raychen on 16/5/22.
 */
public class ActionPO {
    private String user_id;
    private String song_id;
    private Calendar play_time;
    private ActionType type;
    private Calendar collect_time;

    public ActionPO(String user_id, String song_id, long play_time, int type, int collect_time) {
        this.user_id = user_id;
        this.song_id = song_id;

        Date time = new Date(play_time*1000);
        this.play_time = Calendar.getInstance();
        this.play_time.setTime(time);

        this.collect_time = TimeUtil.getTimeFromInt(collect_time);

        switch (type){
            case 1: this.type = ActionType.PLAY;break;
            case 2: this.type = ActionType.DOWNLOAD;break;
            case 3: this.type = ActionType.STAR;break;
            default: break;
        }
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public void setPlay_time(Calendar play_time) {
        this.play_time = play_time;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public void setCollect_time(Calendar collect_time) {
        this.collect_time = collect_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getSong_id() {
        return song_id;
    }

    public Calendar getPlay_time() {
        return play_time;
    }

    public ActionType getType() {
        return type;
    }

    public Calendar getCollect_time() {
        return collect_time;
    }
}
