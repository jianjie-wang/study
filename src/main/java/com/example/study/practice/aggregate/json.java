package com.example.study.practice.aggregate;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-10-24 00:16
 **/
public class json {



    public static void main(String[] args) {

            String str = "{\"reqCode\":0,\"reqMsg\":null,\"reqPageInfo\":{\"PageAmount\":2,\"PageIndex\":1,\"PageSize\":50}," +
                    "\"reqBody\":{\"ActivityList\":[{\"dActivityID\":\"9237b6fa-53eb-ea11-8129-e4a0e1ba1e2f\",\"dActivityName\":\"“配件之和”无忧券C\",\"dActivityCode\":\"MA202008310001\",\"dActivityStartTime\":\"2020/8/30 16:00:00\",\"dActivityStopTime\":\"2020/11/29 16:00:00\"," +
                    "\"dMainpackageList\":[{\"mCardName\":\"“配件之和”无忧券C\",\"mCardID\":\"3043dcc2-53eb-ea11-8129-e4a0e1ba1e2f\",\"mCardCode\":\"MT202008310001\",\"mCardQty\":1,\"mCardTimes\":1,\"mCardPrice\":0.0,\"mCardValidity\":0,\"mCardStartTime\":\"2020-08-31\",\"mCardStopTime\":\"\",\"mCardRightsClass\":\"滤芯券\"}]," +
                    "\"dScopeList\":null},{\"dActivityID\":\"d31a1079-1ee8-ea11-8129-e4a0e1ba1e2f\",\"dActivityName\":\"无忧卡测试\",\"dActivityCode\":\"MA202008270001\",\"dActivityStartTime\":\"2020/8/25 16:00:00\",\"dActivityStopTime\":\"2020/8/30 16:00:00\"," +
                    "\"dMainpackageList\":[{\"mCardName\":\"无忧卡券测试\",\"mCardID\":\"756722cd-1ee8-ea11-8129-e4a0e1ba1e2f\",\"mCardCode\":\"MT202008270001\",\"mCardQty\":1,\"mCardTimes\":1,\"mCardPrice\":0.0,\"mCardValidity\":0,\"mCardStartTime\":\"\",\"mCardStopTime\":\"\",\"mCardRightsClass\":\"滤芯券\"}],\"dScopeList\":null}]}}";

            JSONObject data = JSONObject.parseObject(str);
            JSONObject reqBody = data.getJSONObject("reqBody");
            System.out.println(reqBody.toString());

            if (reqBody != null) {
                JSONArray activityArray = reqBody.getJSONArray("ActivityList");//获取活动数组
                for (int i = 0; i < activityArray.size(); i++) {
                    JSONObject activityJson = activityArray.getJSONObject(i);
                    String activityId = activityJson.getString("dActivityID");
                    System.out.println(activityId);

                    if (activityJson != null) {
                        JSONArray cardArray = activityJson.getJSONArray("dMainpackageList");//获取卡券数组
                        for (int j = 0; j < cardArray.size(); j++) {
                            JSONObject cardJson = cardArray.getJSONObject(j);
                            System.out.println((String) cardJson.get("mCardName"));

                        }
                    }
                }
        }
    }
    public String string(String string){

//        String chinese = CharacterEncodingConvert.unicodeToChinese(StringEscapeUtils.escapeJava(activity));
        JSONObject data = JSONObject.parseObject(string);
        JSONObject reqBody = data.getJSONObject("reqBody");
        if (reqBody != null) {
            JSONArray activityArray = reqBody.getJSONArray("ActivityList");//获取活动数组
            for (int i = 0; i < activityArray.size(); i++) {
                JSONObject activityJson = activityArray.getJSONObject(i);
                String activityId = activityJson.getString("dActivityID");
                System.out.println(activityId);

                if (activityJson != null) {
                    JSONArray cardArray = activityJson.getJSONArray("dMainpackageList");//获取卡券数组
                    for (int j = 0; j < cardArray.size(); j++) {
                        JSONObject cardJson = cardArray.getJSONObject(j);
                        System.out.println((String) cardJson.get("mCardName"));

                    }
                }
            }
        }
        return reqBody.toJSONString();
    }
}
