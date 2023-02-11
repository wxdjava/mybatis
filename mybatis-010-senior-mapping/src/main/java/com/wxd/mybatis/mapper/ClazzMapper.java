package com.wxd.mybatis.mapper;

import com.wxd.mybatis.pojo.Clazz;

/**
 * @author wangxuedeng
 * @date 2023/2/10 - 21:01
 */
public interface ClazzMapper {

    Clazz selectByIdStep(Integer cid);

    Clazz selectByIdWithCollection(Integer id);

    Clazz selectByIdWithStep(Integer cid);

}
