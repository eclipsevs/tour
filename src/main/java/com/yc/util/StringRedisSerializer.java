package com.yc.util;

import com.google.gson.Gson;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import java.nio.charset.Charset;

/**
 * @author wk
 * @date 2019/9/28  21:28
 */
public class StringRedisSerializer implements RedisSerializer<Object> {
    private final Charset charset;
    Gson gson = new Gson();
    private final String target = "\"";

    private final String replacement = "";


    public StringRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public StringRedisSerializer(Charset charset) {
        Assert.notNull(charset);
        this.charset = charset;
    }

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        String string = gson.toJson(o);
        if (string == null) {
            return null;
        }
        string = string.replace(target, replacement);
        return string.getBytes(charset);

    }

    @Override
    public String deserialize(byte[] bytes) {
        return (bytes == null ? null : new String(bytes, charset));
    }

}
