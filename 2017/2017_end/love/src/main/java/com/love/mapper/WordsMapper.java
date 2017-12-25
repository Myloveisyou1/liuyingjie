package com.love.mapper;

import com.love.entity.WordsEntity;
import com.love.utils.SimpleInsertLangDriver;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2017/12/19 0019 16:28
 */
public interface WordsMapper {

    @Insert("insert into l_words (#{vo})")
    @Lang(SimpleInsertLangDriver.class)
    boolean addWords(WordsEntity vo);
}
