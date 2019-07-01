package com.service.impl;

import com.mapper.NumMapper;
import com.pojo.TestNum;
import com.service.NumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumServiceImpl implements NumService {

    public NumMapper numMapper;

    public List<TestNum> getNum() throws Exception {
        return numMapper.getNum();
    }
}
