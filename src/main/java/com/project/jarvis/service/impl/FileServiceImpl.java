package com.project.jarvis.service.impl;

import com.project.jarvis.dto.project.FileContentResponse;
import com.project.jarvis.dto.project.FileNode;
import com.project.jarvis.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<FileNode> getFileTree(long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }

}
