package logic.linear;

import po.ActionPO;
import po.SongPO;
import util.ActionType;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;

/**
 * Created by darxan on 2016/5/25.
 */
public class Updater {


    public final static int days = (31+30+31+30+31+31)/2;
    private final static int action_types = 3;

    /**
     * 一个BigDecimal数组中表示的是：
     * 从预测的当天开始往前days天，该种类的action的在每一天所对应的权重
     */
    private BigDecimal[] playedWeight;
    private BigDecimal[] downloadWeight;
    private BigDecimal[] starWeight;
    private Map<ActionType,BigDecimal[]> actionWeight;


    public Updater(){
        playedWeight = new BigDecimal[days];
        downloadWeight = new BigDecimal[days];
        starWeight = new BigDecimal[days];
        for(int i =0; i<days; ++i){
            playedWeight[i] = new BigDecimal(2);
            downloadWeight[i] = new BigDecimal(2);
            starWeight[i] = new BigDecimal(1);
        }
        actionWeight.put(ActionType.PLAY,playedWeight);
        actionWeight.put(ActionType.DOWNLOAD,downloadWeight);
        actionWeight.put(ActionType.STAR,starWeight);
    }


    public void update(
            Collection<ActionPO> trainData, SongPO songPO, Map<Calendar,Long> testData){

    }


    /**
     * 向量乘以向量
     * @param actionPOs
     * @param songPO
     * @return
     */
    private BigDecimal calculateActions(Collection<ActionPO> actionPOs,SongPO songPO){
        BigDecimal result = new BigDecimal(0);
        for (ActionPO actionPO:actionPOs) {
              int index = getIndexByDate(actionPO.getPlay_time());
              BigDecimal[] currentActionWeight = actionWeight.get(actionPO.getType());
              result = result.add(currentActionWeight[index]);
        }
        return result;
    }


    private int getIndexByDate(Calendar calendar){
        return 0;
    }


}
