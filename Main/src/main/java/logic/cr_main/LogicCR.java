package logic.cr_main;

import database.DataBase;
import po.ActionPO;
import po.SongPO;
import util.CommonUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by raychen on 16/5/23.
 */
public class LogicCR {

    List<String> allArtists;

    public LogicCR() {
        allArtists = new LinkedList<>();
    }

    public void initArtists(){
        String sql = "SELECT * FROM songs";
        List<SongPO> songs = CommonUtil.getSongFromSQL(sql);
        Map<String, List<SongPO>> map = songs.stream()
                .collect(Collectors.groupingBy(songPO -> songPO.getArtist_id()));
        map.forEach((aid, songList) -> {
            allArtists.add(aid);
        });
        System.out.println("there are artists: "+allArtists.size());
    }

    public void test(){
//        String sql = "select * from actions where Ds = '20150301'";
//        List<ActionPO> allActions = CommonUtil.getActionFromSQL(sql);
//        Collections.sort(allActions, new Comparator<ActionPO>() {
//            @Override
//            public int compare(ActionPO o1, ActionPO o2) {
//                return o1.getPlay_time().compareTo(o2.getPlay_time());
//            }
//        });
//        System.out.println(allActions.size());
//        allActions.forEach(e -> {
//            System.out.println(e.getCollect_time().get(Calendar.MONTH)+"-"+e.getCollect_time().get(Calendar.DATE)+":"+e.getType().toString());
//        });
        //计算x月01日的数据,测试
        String ds_before = "20150";
        String ds_after = "01";
        for (int i = 0; i < allArtists.size(); i++) {
            String artist = allArtists.get(i);
            for (int j = 3; j <= 8; j++) {
                String ds = ds_before+j+ds_after;
                String sql = "SELECT * FROM actions WHERE Ds = '"+ds+"' AND song_id IN (SELECT song_id FROM songs WHERE artist_id = '"+artist+"')";
                List<ActionPO> actions = CommonUtil.getActionFromSQL(sql);
                System.out.print(actions.size()+" ");
            }
            System.out.println();
        }
//        String ds = "20150301";
//        String artist = "0c80008b0a28d356026f4b1097041689";
//        String sql = "SELECT * FROM actions WHERE Ds = '"+ds+"' AND song_id IN (SELECT song_id FROM songs WHERE artist_id = '"+artist+"')";
//        List<ActionPO> actionPOs = CommonUtil.getActionFromSQL(sql);
//        System.out.println(actionPOs.size());
    }

}
