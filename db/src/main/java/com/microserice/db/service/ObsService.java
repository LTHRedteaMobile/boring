package com.microserice.db.service;

import com.google.common.base.Strings;
import com.obs.services.ObsClient;
import com.obs.services.model.GetObjectRequest;
import com.obs.services.model.ObsObject;
import com.obs.services.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;

/**
 * @author Alex Liu
 * @date 2021/03/19
 */
@Service
@Slf4j
@Conditional(ObsServiceCondition.class)
public class ObsService implements StorageService {

    @Value("${obs.bucket.name}")
    private String obsBucketName;
    @Value("${obs.accessKey}")
    private String accessKey;
    @Value("${obs.secretKey}")
    private String secretKey;
    @Value("${obs.endPoint}")
    private String endPoint;
    @Value("${obs.defaultDir.path}")
    private String defaultDirPath;

    private String urlPrefix;
    private ObsClient obsClient;

    @PostConstruct
    public void init() throws Exception {
        obsClient = new ObsClient(accessKey,secretKey,endPoint);
        urlPrefix = endPoint.replace("obs", obsBucketName + ".obs").concat(":443/");
 /*       System.out.println(urlPrefix);
        uploadFile("test2", new File("/Users/redtea 1/Desktop/sec.asc"));
        InputStream input = downloadInputStream( null,"test/lth-test-file", 20L, 50L);
        byte[] b = new byte[1024];
        File file = new File("sec.asc");
        file.createNewFile();
        FileOutputStream bos = new FileOutputStream(file);
        int len;
        while ((len=input.read(b)) != -1){
            bos.write(b, 0, len);
        }

        bos.close();
        input.close();*/
    }

    @Override
    public void print() {
        System.out.println("ObsService");
    }

    /**
     * 上传文件到默认文件夹中
     *
     * @param objectKey OBS上文件存储的名称
     * @param originFile 源文件
     *
     * @return 文件下载URL
     */
    public String uploadFile(String objectKey, File originFile) {
        return uploadFile(null, objectKey, originFile);
    }

    /**
     * 上传文件到指定文件夹中
     *
     * @param dirPath 对象所存放的桶文件夹路径
     * @param objectKey OBS上文件存储的名称
     * @param file 源文件
     *
     * @return 文件下载URL
     */
    public String uploadFile(String dirPath, String objectKey, File file) {
        String bucketDirPath = Strings.isNullOrEmpty(dirPath) ? defaultDirPath : dirPath;
        PutObjectResult result = obsClient.putObject(obsBucketName, bucketDirPath.concat("/").concat(objectKey), file);
        System.out.println(result);
        String downloadUrl = result.getObjectUrl();
        log.info("文件[{}]上传完成，下载地址 = [{}]", objectKey, downloadUrl);
        return downloadUrl;
    }

    /**
     * 从输入流中读取内容并上传文件到默认文件夹中
     *
     * @param objectKey OBS上文件存储的名称
     * @param stream 文件内容输入流
     *
     * @return 文件下载URL
     */
    public String uploadFile(String objectKey, InputStream stream) {
        return uploadFile(null, objectKey, stream);
    }

    /**
     * 从输入流中读取内容并上传文件到指定文件夹中
     * 如果不指定文件夹路径，则会上传到项目配置的默认文件夹中
     *
     * @param dirPath 对象所存放的桶文件夹路径
     * @param objectKey OBS上文件存储的名称
     * @param stream 文件内容输入流
     *
     * @return 文件下载URL
     */
    public String uploadFile(String dirPath, String objectKey, InputStream stream) {
        String bucketDirPath = Strings.isNullOrEmpty(dirPath) ? defaultDirPath : dirPath;
        PutObjectResult result =
                obsClient.putObject(obsBucketName, bucketDirPath.concat("/").concat(objectKey), stream);
        String downloadUrl = result.getObjectUrl();
        log.info("文件[{}]上传完成，下载地址 = [{}]", objectKey, downloadUrl);
        return downloadUrl;
    }

    /**
     * 从OBS下载指定OBS Key的文件，并以输入流的形式返回
     *
     * @param objectKey 文件的OBS Key
     *
     * @return 文件内容输入流
     */
    public InputStream downloadInputStream(String objectKey) {
       return downloadInputStream(null, objectKey);
    }

    /**
     * 从OBS下载指定OBS Key的文件，并以输入流的形式返回
     * 如果没有指定dirPath，则直接使用objectKey去获取
     *
     * @param dirPath OBS Key所在的文件夹
     * @param objectKey 文件的OBS Key
     *
     * @return 文件内容输入流
     */
    public InputStream downloadInputStream(String dirPath, String objectKey) {
       return downloadInputStream(dirPath, objectKey, null, null);
    }

    /**
     * 从OBS下载指定OBS Key的文件，并从指定的起始位置开始已下载，以输入流的形式返回
     *
     * @param objectKey 文件的OBS Key
     * @param startPosition 需下载的部分的起始位置
     *
     * @return 文件内容输入流
     */
    public InputStream downloadInputStream(String objectKey, Long startPosition) {
        return downloadInputStream(null, objectKey, startPosition, null);
    }

    /**
     * 从OBS下载指定OBS Key的文件，并从指定的起始位置开始已下载，以输入流的形式返回
     *
     * @param dirPath OBS Key所在的文件夹
     * @param objectKey 文件的OBS Key
     * @param startPosition 需下载的部分的起始位置
     *
     * @return 文件内容输入流
     */
    public InputStream downloadInputStream(String dirPath, String objectKey, Long startPosition) {
        return downloadInputStream(dirPath, objectKey, startPosition, null);
    }

    /**
     * 从OBS下载指定OBS Key的文件，并以输入流的形式返回
     * 如果没有指定dirPath，则直接使用objectKey去获取
     * 如果设定了文件起始位置与截止位置，则只下载规定范围内的文件
     *
     * @param dirPath OBS Key所在的文件夹
     * @param objectKey 文件的OBS Key
     * @param startPosition 文件内容起始位置
     * @param endPosition 文件内容截止位置
     *
     * @return 文件内容输入流
     */
    public InputStream downloadInputStream(String dirPath, String objectKey, Long startPosition, Long endPosition) {
        String fullKey = Strings.isNullOrEmpty(dirPath) ? objectKey : dirPath.concat("/").concat(objectKey);
        GetObjectRequest getObjectRequest = new GetObjectRequest(obsBucketName, fullKey);
        if (startPosition != null) {
            getObjectRequest.setRangeStart(startPosition);
        }
        if (endPosition != null) {
            getObjectRequest.setRangeEnd(endPosition);
        }
        ObsObject obsObject = obsClient.getObject(getObjectRequest);
        log.info("文件[{}]下载完成 ; startPosition = [{}], endPosition = [{}]", fullKey, startPosition, endPosition);
        return obsObject.getObjectContent();
    }

    /**
     * 使用URL从OBS下载存储的文件，并以输入流的形式返回
     *
     * @param downloadUrl 文件在OBS中的存放URL路径
     *
     * @return 文件内容输入流
     */
    public InputStream downloadInputStreamByUrl(String downloadUrl) {
        String key = getObjectKeyFromUrl(downloadUrl);
        return downloadInputStream(key);
    }

    /**
     * 从OBS下载URL转换得到OBS存储Key
     *
     * @param downloadUrl 下载URL
     *
     * @return 返回OBS存储Key
     */
    public String getObjectKeyFromUrl(String downloadUrl) {
        downloadUrl.replaceAll("%2F", "/");
        return downloadUrl.replace(urlPrefix, "");
    }
}
