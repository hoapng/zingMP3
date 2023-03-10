package com.zingmp3.service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class UploadFile {

    public String upload(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream("uploads/files/"+convFile);
        fos.write(file.getBytes());
        fos.close();
        return "http://localhost:8080/uploads/files/"+convFile.getName();
    }
}
