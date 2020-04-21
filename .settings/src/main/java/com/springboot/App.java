package com.springboot;
 
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

 
/**
 * 项目启动类
 */
@SpringBootApplication
public class App {
    
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    /**
     * 使用bean方式注入fastjson解析器
     *
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
       // 创建fastjson对象
       FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

       FastJsonConfig confg = new FastJsonConfig();
       // 设置是否需要格式化
       confg.setSerializerFeatures(SerializerFeature.PrettyFormat);
       converter.setFastJsonConfig(confg);
       return new HttpMessageConverters(converter);
    }
 
    
}