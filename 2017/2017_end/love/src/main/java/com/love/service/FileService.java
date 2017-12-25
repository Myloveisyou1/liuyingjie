package com.love.service;


import com.love.entity.FileEntity;

import java.util.List;

public interface FileService {

    boolean addFile(FileEntity entity);

    List<FileEntity> findFile(FileEntity entity);

    int updateFile(String name);
}
