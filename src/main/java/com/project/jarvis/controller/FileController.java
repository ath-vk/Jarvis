package com.project.jarvis.controller;

import com.project.jarvis.dto.project.FileContentResponse;
import com.project.jarvis.dto.project.FileNode;
import com.project.jarvis.dto.project.FileTreeResponse;
import com.project.jarvis.service.FileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectid}/files")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FileController {

    FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable long projectId) {
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileTree(projectId, userId));
    }

    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @PathVariable String path
    ) {
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileContent(projectId, path, userId));
    }


}
