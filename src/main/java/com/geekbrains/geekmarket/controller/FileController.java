package com.geekbrains.geekmarket.controller;

import com.geekbrains.geekmarket.model.FileSaveRequest;
import com.geekbrains.geekmarket.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public Boolean saveString(@RequestBody FileSaveRequest request) {
        try {
            fileService.save(request.getText(), request.getName());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @GetMapping(value = "/{fileName}", produces = "application/octet-stream")
    public byte[] getFile(@PathVariable String fileName) {
        try {
            return fileService.getFileData(fileName);
        } catch (IOException e) {
            return new byte[] {};
        }
    }

}
