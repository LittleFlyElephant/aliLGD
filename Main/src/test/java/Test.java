import database.DataBase;
import po.ActionPO;
import po.SongPO;
import util.CommonUtil;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;

/**
 * Created by raychen on 16/5/22.
 */
public class Test {

    @org.junit.Test
    public void test(){
        Main main = new Main();
        System.out.println(main.hello());
    }

    @org.junit.Test
    public void testConnect() throws Exception {
        DataBase database = DataBase.getInstance();
        database.connect();
        String sql = "SELECT * FROM songs WHERE publish_time = 20121224";
        ResultSet res = database.query(sql);
        if (res!=null){
            while (res.next()){
                String songid = res.getString("song_id");
                System.out.println(songid);
            }
        }
    }

    @org.junit.Test
    public void testActionPO() throws Exception {
        String sql = "SELECT * FROM actions WHERE Ds = 20150315";
        List<ActionPO> actions = CommonUtil.getActionFromSQL(sql);
        actions.forEach(e -> {
            System.out.println(e.getSong_id() +" -- "+ e.getPlay_time().get(Calendar.MONTH));
        });
    }

    @org.junit.Test
    public void testSongPO() throws Exception {
        String sql = "SELECT * FROM songs WHERE publish_time = 20121224";
        List<SongPO> songs = CommonUtil.getSongFromSQL(sql);
        songs.forEach(e -> {
            System.out.println(e.getSong_id() + " -- " + e.getPublish_time().get(Calendar.YEAR));
        });
    }
}
