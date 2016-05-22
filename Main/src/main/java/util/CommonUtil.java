package util;

import database.DataBase;
import po.ActionPO;
import po.SongPO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by raychen on 16/5/22.
 */
public class CommonUtil {

    public static List<ActionPO> getActionFromSQL(String sql){
        List<ActionPO> actionPOs = new LinkedList<ActionPO>();

        DataBase dataBase = DataBase.getInstance();
        ResultSet res = dataBase.query(sql);
        if (res!=null){
            try {
                while (res.next()){
                    actionPOs.add(new ActionPO(
                            res.getString("user_id"),
                            res.getString("song_id"),
                            res.getLong("gmt_create"),
                            res.getInt("action_type"),
                            res.getInt("Ds")
                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return actionPOs;
    }

    public static List<SongPO> getSongFromSQL(String sql){
        List<SongPO> songPOs = new LinkedList<>();

        DataBase dataBase = DataBase.getInstance();
        ResultSet res = dataBase.query(sql);
        if (res!=null){
            try {
                while (res.next()){
                    songPOs.add(new SongPO(
                            res.getString("song_id"),
                            res.getString("artist_id"),
                            res.getInt("publish_time"),
                            res.getInt("song_init_plays"),
                            res.getInt("Language"),
                            res.getInt("Gender")
                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return songPOs;
    }
}
