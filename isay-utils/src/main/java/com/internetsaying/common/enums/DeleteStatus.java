package com.internetsaying.common.enums;

/**
 * 0-未删除；1-已删除
 * @author dong
 *
 */
public enum DeleteStatus {

	NOT_DEL("0","未删除"),
    ALR_DEL("1","已删除")
    ;

    public String code;

    public String value;

    private DeleteStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static DeleteStatus getByCode(String code){
        for(DeleteStatus e : values()){
            if(e.code.equals(code)){
                return e;
            }
        }
        return null;
    }

    public static String getValueByCode(String code){
        for(DeleteStatus e : values()){
            if(e.code.equals(code)){
                return e.value;
            }
        }
        return "";
    }
}
