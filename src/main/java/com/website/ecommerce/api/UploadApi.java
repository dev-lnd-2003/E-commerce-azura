package com.website.ecommerce.api;

import com.website.ecommerce.utils.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class UploadApi {

    private CloudinaryService cloudinaryService;

    public UploadApi(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/public/upload-file")
    public String uploadFile(@RequestParam("file") MultipartFile file){
        try {
            return cloudinaryService.uploadFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
