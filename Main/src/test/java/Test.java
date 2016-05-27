import database.DataBase;
import logic.cr_main.LogicCR;
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

    @org.junit.Test
    public void testLogic() throws Exception {
        LogicCR logic = new LogicCR();
        logic.initArtists();
        logic.test();
    }

    @org.junit.Test
    public void addDate() throws Exception {
        String before = "201510";
        DataBase database = DataBase.getInstance();
        for (int i = 1; i <=31 ; i++) {
            String time = before;
            if (i<10) time += "0"+i;
            else time += i;
            String sql = "INSERT INTO date(time) VALUES ('"+time+"')";
            database.excute(sql);
        }
    }
}
