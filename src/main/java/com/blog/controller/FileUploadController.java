package com.blog.controller;

import com.blog.domain.Result;
import com.blog.dto.FileDTO;
import com.blog.qiniu.service.QiNiuService;
import com.blog.util.ResultUtil;
import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import javax.xml.ws.Action;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author: yukong
 * @date: 2018/6/21 14:18
 * @description:
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private QiNiuService qiNiuService;

    @PostMapping("/qiNiu")
    public Result qiNiuFileUpload(@RequestBody  FileDTO fileDTO) throws IOException {
        BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(fileDTO.getBase64());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        Response  response = qiNiuService.uploadFile(inputStream);
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        String path = putRet.key;
        return ResultUtil.success(path);
    }

}
