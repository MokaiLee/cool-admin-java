package com.cool.core.config;

import com.cool.core.exception.CoolPreconditions;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CosConfig {

    @Resource
    private OssFileProperties ossFileProperties;

    @Bean
    public COSClient getClient() {
        CoolPreconditions.checkEmpty(ossFileProperties.getAccessKeyId(), "请配置腾讯云COS的AccessKeyId");
        CoolPreconditions.checkEmpty(ossFileProperties.getAccessKeySecret(), "请配置腾讯云COS的AccessKeySecret");
        CoolPreconditions.checkEmpty(ossFileProperties.getBucket(), "请配置腾讯云COS的Bucket");
        CoolPreconditions.checkEmpty(ossFileProperties.getEndpoint(), "请配置腾讯云COS的Region-Endpoint");
        CoolPreconditions.checkEmpty(ossFileProperties.getDomain(), "请配置腾讯云COS的域名");
        // 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(ossFileProperties.getAccessKeyId(),ossFileProperties.getAccessKeySecret());
        // 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(ossFileProperties.getEndpoint()));
        // 生成cos客户端
        return new COSClient(cred, clientConfig);
    }
}
