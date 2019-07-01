package com.mapper;

import com.pojo.TestNum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NumMapper {
    //    获取数据库数字
    List<TestNum> getNum() throws Exception;
}