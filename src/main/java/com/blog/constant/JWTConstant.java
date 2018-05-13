package com.blog.constant;

/**
 * @author yukong
 * @version V1.0
 * @Description: 静态常量配置类
 * @date 2018/5/14 09:51
 **/
public class JWTConstant {

    /**
     * jwt
     *
     */
    public static final String JWT_ID = "jwt";

    /**
     * jwt_secret
     */
    public static final String JWT_SECRET = "ecut";

    /**
     * millisecond
     */

    public static final int JWT_TTL = 60*60*1000;

    /**
     * millisecond
     */
    public static final int JWT_REFRESH_INTERVAL = 55*60*1000;

    /**
     * millisecond
     */
    public static final int JWT_REFRESH_TTL = 12*60*60*1000;


}