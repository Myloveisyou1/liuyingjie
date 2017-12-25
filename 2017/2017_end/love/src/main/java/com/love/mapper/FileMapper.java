package com.love.mapper;

import com.love.entity.FileEntity;
import com.love.utils.SimpleInsertLangDriver;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FileMapper {

    @Insert("insert into l_file (#{entity})")
    @Lang(SimpleInsertLangDriver.class)
    boolean addFile(FileEntity entity);

    @Select("select * from l_file where status=#{status}")
    List<FileEntity> findFile(FileEntity entity);

    @Update("update l_file set status=1 where name=#{name}")
    int updateFile(String name);
}
