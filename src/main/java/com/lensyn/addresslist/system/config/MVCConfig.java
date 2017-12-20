package com.lensyn.addresslist.system.config;

import com.google.gson.*;
import com.lensyn.usercenter.security.client.system.config.ClientCommonWebMvcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by huanghongxi on 2017/8/21.
 * Gson和Swagger集成
 */
@Configuration
public class MVCConfig extends ClientCommonWebMvcConfig {

    /**
     * 使用GSON作为转换器
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MyGsonHttpMessageConverter());
    }

    //swagger适配
    class MyGsonHttpMessageConverter extends GsonHttpMessageConverter {

        private GsonBuilder gb = new GsonBuilder();
        MyGsonHttpMessageConverter() {
            gb.setDateFormat("yyyy-MM-dd HH:mm:ss");

            gb.registerTypeAdapter(Json.class, new SpringfoxJsonToGsonAdapter());
            setGson(gb.create());

        }
    }

    class SpringfoxJsonToGsonAdapter implements JsonSerializer<Json> {
        @Override
        public JsonElement serialize(Json json, Type type, JsonSerializationContext jsonSerializationContext) {
            final JsonParser parser = new JsonParser();
            return parser.parse(json.value());
        }
    }


}