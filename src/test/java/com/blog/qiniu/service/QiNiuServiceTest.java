package com.blog.qiniu.service;

import com.blog.qiniu.service.impl.QiNiuServiceImpl;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author: yukong
 * @date: 2018/6/21 13:56
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class QiNiuServiceTest {
    @Autowired
    private QiNiuServiceImpl qiNiuService;
    @Test
    public void uploadFile() throws QiniuException {
        String fileName = "/Users/kumataira/Downloads/IMG_6708.JPG";
        File file = new File(fileName);
        assertTrue(file.exists());
        Response response = qiNiuService.uploadFile(file);
        assertTrue(response.isOK());
        //解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        System.out.println(putRet.key);//根据 http://域名/key 就能访问文件
    }
}