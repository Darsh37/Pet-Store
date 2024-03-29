package com.petstoreapp.petapp.PetControlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.petstoreapp.petapp.Services.FileService;

@RestController
public class FileController {

    @Autowired
    public FileService fileService;

    @PostMapping("products/{id}/upload")
    public ResponseEntity<?> upload(@PathVariable Integer id, @RequestParam("file") MultipartFile file){
     return ResponseEntity.ok(this.fileService.fileUpload(id, file));
    }

    @GetMapping("products/download/{fileName}")
    public ResponseEntity<?> download(@PathVariable String fileName){
        Resource resource = this.fileService.fileDownload(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"").body(resource);

    }
       
}
