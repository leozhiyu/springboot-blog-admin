package com.blog.qiniu;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: yukong
 * @date: 2018/6/21 13:43
 * @description:
 */
@Component
@Data
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuProperties {
    private String accessKey;
    private String secretKey;
    private String bucket;
}
