package com.cool.core.file.strategy;

import cn.hutool.core.util.StrUtil;
import com.cool.core.config.FileModeEnum;
import com.cool.core.config.OssFileProperties;
import com.cool.core.exception.CoolException;
import com.cool.core.exception.CoolPreconditions;
import com.cool.core.util.CoolSecurityUtil;
import com.cool.modules.plugin.entity.PluginInfoEntity;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

@Component("cosFileUploadStrategy")
public class CosFileUploadStrategy implements FileUploadStrategy {

    @Resource
    private OssFileProperties ossFileProperties;

    private final COSClient cosClient;

    public CosFileUploadStrategy(COSClient cosClient) {
        this.cosClient = cosClient;
    }

    @Override
    public Object upload(MultipartFile[] files, HttpServletRequest request, PluginInfoEntity pluginInfoEntity) throws IOException {
        for (MultipartFile file : files) {
            File tmpFile = null;
            try {
                String tmpFileName = StrUtil.uuid().replaceAll("-", "") + getExtensionName(Objects.requireNonNull(file.getOriginalFilename()));
                String uploadPath = "coolFile"+ File.separator + CoolSecurityUtil.getCurrentUserId() + File.separator +tmpFileName;
                tmpFile = File.createTempFile( uploadPath, null);
                file.transferTo(tmpFile);
                PutObjectRequest putObjectRequest = new PutObjectRequest(ossFileProperties.getBucket(), uploadPath, tmpFile);
                PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
                CoolPreconditions.check(putObjectResult == null, "文件上传失败，COS上传失败");
                return ossFileProperties.getDomain() + "/" + URLEncoder.encode(uploadPath, StandardCharsets.UTF_8);
            }catch (Exception e) {
                throw new CoolException("文件上传失败", e);
            }finally {
                if (tmpFile != null) {
                    tmpFile.delete();
                }
            }
        }
        throw new CoolException("文件列表为空");
    }

    @Override
    public Map<String, String> getMode(String key) {
        return Map.of("mode", FileModeEnum.LOCAL.value(),
                "type", FileModeEnum.LOCAL.type());
    }
}
