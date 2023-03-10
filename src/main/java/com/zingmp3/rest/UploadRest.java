package com.zingmp3.rest;

import com.zingmp3.service.CloudinaryService;
import com.zingmp3.service.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UploadRest {

    private UploadFile uploadFile = new UploadFile();

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/public/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file){
        try {
            return cloudinaryService.uploadFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
