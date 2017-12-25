package com.love.service.impl;

import com.love.entity.WordsEntity;
import com.love.mapper.WordsMapper;
import com.love.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Descript:数据库words表操作
 * @Author: liuyingjie
 * @Date: create in 2017/12/19 0019 16:24
 */
@Service
public class WordsServiceImpl implements WordsService{

    @Autowired
    private WordsMapper mapper;

    @Override
    public boolean addWords(WordsEntity vo) {

        return mapper.addWords(vo);
    }
}
