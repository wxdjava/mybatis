package com.wxd.mybatis.mapper;

import com.wxd.mybatis.pojo.Log;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/5 - 11:54
 */
public interface LogMapper {
    List<Log> selectByTime(String time);
}
