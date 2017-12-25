package com.love.service.impl;

import com.love.entity.FileEntity;
import com.love.mapper.FileMapper;
import com.love.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private FileMapper mapper;
    @Override
    public boolean addFile(FileEntity entity) {
        return mapper.addFile(entity);
    }

    @Override
    public List<FileEntity> findFile(FileEntity entity) {

        return mapper.findFile(entity);
    }

    @Override
    public int updateFile(String name) {
        return mapper.updateFile(name);
    }
}
