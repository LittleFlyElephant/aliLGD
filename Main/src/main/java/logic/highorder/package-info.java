/**
 *
 * Created by darxan on 2016/5/24.
 * 回归模型包：
 * 影响 num-song-played   预测结果的参数集包括：
 *
 * 操作影响参数：
     * 加权历史操作影响，（针对相应用户加权，针对操作时间加权）
 *
 * 歌曲影响参数：
     * 发布时间
     * 初始播放记录
     * 语言
 * 预测日期
 *
 * 预测函数
 * Predicate = T[   sigma(
         *              history_action * action_weight * user_weight(user_id)
         *              * gmt_create_weight(gmt_create) * Ds_weight(Ds)
         *             )
 *             ]   *  Transform_predict_date(predict_date) * weight_language(language)
 *
 */
package logic.highorder;

/**
 * 考虑的因素：
 *          某一用户对某一首歌播放量越多，可能会导致听腻。
 */