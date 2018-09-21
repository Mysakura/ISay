package com.internetsaying.common.enums;

/**
 * 上传路径标识
 * @author 001977
 *
 */
public enum UploadPathEnum {

	USER_TEMP("user_temp","user_photo/temp/"),	// 用户头像
	USER("user","user_photo/"),					// 用户头像、背景
    PAY("pay","pay_photo/"),					// 支付图片
    POST("post","post_photo/"),					// 文章图片
    COMMENT("comment","comment_photo/"),		// 评论回复图片
    MESSAGE("message","message_photo/")			// 留言回复图片
    ;

    public String code;

    public String value;

    private UploadPathEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static UploadPathEnum getByCode(String code){
        for(UploadPathEnum e : values()){
            if(e.code.equals(code)){
                return e;
            }
        }
        return null;
    }

    public static String getValueByCode(String code){
        for(UploadPathEnum e : values()){
            if(e.code.equals(code)){
                return e.value;
            }
        }
        return "";
    }
}
