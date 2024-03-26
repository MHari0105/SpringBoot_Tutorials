package com.myproject.DemoBackend.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Getter
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeResource {

//    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads";

    @Value("${file.upload.directory}")
    private String uploadDirectory;

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException {
        List<String> fileNames = new ArrayList<>();

        for (MultipartFile multipartFile: multipartFiles) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            Path fileStorage = get(getUploadDirectory(), fileName).toAbsolutePath().normalize();
            copy(multipartFile.getInputStream(), fileStorage, REPLACE_EXISTING);
            fileNames.add(fileName);
        }

        return ResponseEntity.ok().body(fileNames);
    }

}
