package logic.regression;

import util.ParameterType;

import java.util.Map;

/**
 * Created by darxan on 2016/5/24.
 *
 * Predicate = history_transfer[   sigma(
 *              action_weight  * user_weight(user_id)
 *              * gmt_create_weight(gmt_create) * ds_weight(Ds)
 *             )
 *             ]   *  predict_date(predict_date) * weight_language(language) * wight_artist
 *
 * */
public class Vectors {
    private Coefficient history_transfer;
    private Coefficient action_weight;
    private Coefficient user_weight;
    private Coefficient gmt_create_weight;
    private Coefficient ds_weight;
    private Coefficient predict_date;
    private Coefficient language_weight;
    private Coefficient wight_artist;

    private Map<ParameterType,Coefficient> map;

    public Vectors(){
    }

}
