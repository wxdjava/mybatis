package org.god.ibatis.utils;

import java.io.InputStream;

/**
 * 这个工具类专门完成类路径中资源的加载
 * @author wangxuedeng
 * @date 2023/2/1 - 18:53
 */
public class Resources {
    /**
     * 工具类中的构造方法都是私有化的
     */
    private Resources(){}

    /**
     * 从类路径中加载资源
     * @param resource 放在类路径中的资源文件
     * @return 指向资源文件的一个输入流
     */
    public static InputStream getResourceAsStream(String resource){
        return ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
    }
}
