package logic.dx_util;

import database.DataBase;
import logic.cr_util.TimeUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by darxan on 2016/5/27.
 */
public class DataUtil_dx {

    public static final Calendar initTime= util.TimeUtil.getTimeFromInt(20150301);
    public static final Calendar startTime= util.TimeUtil.getTimeFromInt(20150901);
    public static final Calendar endTime= util.TimeUtil.getTimeFromInt(20151030);

    //拿学习样本
    public static List<Sample_dx> getSamples(String song_id){
        DataBase dataBase = DataBase.getInstance();
        String sql = "SELECT * FROM table_name WHERE song_id = '"+song_id+"' ORDER BY date";
        int sum = 0;
        List<Sample_dx> samples = new LinkedList<>();
        ResultSet rs = dataBase.query(sql);
        if (rs!=null){
            try {
                while (rs.next()){
                    sum += rs.getInt("number");
                    Sample_dx sp = new Sample_dx(sum);
                    sp.x[1] = TimeUtil.getInterval(
                            initTime,
                            util.TimeUtil.getTimeFromInt(rs.getInt("date"))
                    );
                    samples.add(sp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return samples;
    }

}
