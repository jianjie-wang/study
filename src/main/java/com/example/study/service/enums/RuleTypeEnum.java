package com.example.study.service.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum RuleTypeEnum {

    BECOME_AMBASSADOR("BECOME_AMBASSADOR", "ADD", "获得大使"),

    ENTER("ENTER", "ADD", "顾客报名"),

    GET_VISIT("GET_VISIT", "ADD", "获得访问"),

    LOGIN("LOGIN", "ADD", "每日登陆"),

    NO1("NO1", "ADD", "当月NO1翻倍"),

    ON_DUTY("ON_DUTY", "ADD", "入职赠礼"),

    SHARE_ACTIVITY("SHARE_ACTIVITY", "ADD", "转发活动"),

    SHARE_CONTENT("SHARE_CONTENT", "ADD", "转发内容"),

    VISIT_ACTIVITY("VISIT_ACTIVITY", "ADD", "阅读活动"),

    VISIT_CONTENT("VISIT_CONTENT", "ADD", "阅读内容"),

    RECEIVE("RECEIVE", "SUBTRACT", "一键领取"),

    SYSTEM_DEDUCT("SYSTEM_DEDUCT","SUBTRACT","系统扣除"),

    SYSTEM_ADD("SYSTEM_ADD","ADD","系统增加"),

    BATCH_ADD("BATCH_ADD","ADD","批量调整"),

    BATCH_DEDUCT("BATCH_DEDUCT","SUBTRACT","批量调整"),

    ORDER_GRABBING("ORDER_GRABBING","SUBTRACT","抢单扣除"),

    ORDER_GRABBING_REWARD("ORDER_GRABBING_REWARD","ADD","抢单成功"),

    BE_OVERDUE("BE_OVERDUE","SUBTRACT","抢单逾期")

    ;

    /**
     * 枚举值
     */
    private final String code;

    private final String settleType;

    /**
     * 枚举描述
     */
    private final String message;

    /**
     * 构造一个<code>ContractStatusEnum</code>枚举对象
     *
     * @param code
     * @param message
     */
    RuleTypeEnum(String code, String settleType, String message) {
        this.code = code;
        this.settleType = settleType;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getSettleType() {
        return settleType;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code
     * @return ContractStatusEnum
     */
    public static RuleTypeEnum getByCode(String code) {
        for (RuleTypeEnum _enum : values()) {
            if (StringUtils.equals(_enum.getCode(), code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ContractStatusEnum>
     */
    public List<RuleTypeEnum> getAllEnum() {
        List<RuleTypeEnum> list = new ArrayList<RuleTypeEnum>();
        for (RuleTypeEnum _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public List<String> getAllEnumCode() {
        List<String> list = new ArrayList<>();
        for (RuleTypeEnum _enum : values()) {
            list.add(_enum.getCode());
        }
        return list;
    }
}
