package com.internetsaying.common.enums;

/**
 * 友情链接：0-未处理；1-不通过；2-通过
 * @author 001977
 *
 */
public enum FriendStatus {

    NOT_DEAL("0","未出账，待统计"),
    NOT_PASS("1","已统计，待发出"),
    PASS("2","已发出，待对方核对")
    ;

    public String code;

    public String value;

    private FriendStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static FriendStatus getByCode(String code){
        for(FriendStatus e : values()){
            if(e.code.equals(code)){
                return e;
            }
        }
        return null;
    }

    public static String getValueByCode(String code){
        for(FriendStatus e : values()){
            if(e.code.equals(code)){
                return e.value;
            }
        }
        return "";
    }
}
