package com.project.jarvis.service;

import com.project.jarvis.dto.project.FileContentResponse;
import com.project.jarvis.dto.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(long projectId, Long userId);
    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
