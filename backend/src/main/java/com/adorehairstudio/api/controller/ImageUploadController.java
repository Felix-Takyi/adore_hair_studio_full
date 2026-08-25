package com.adorehairstudio.api.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/images")
public class ImageUploadController {

    private final Cloudinary cloudinary;

    public ImageUploadController(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "No file selected"));
        }

        String type = file.getContentType();

        if (type == null ||
                !(type.equals("image/jpeg")
                        || type.equals("image/png")
                        || type.equals("image/webp"))) {

            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Only JPG, PNG and WEBP images are allowed"));
        }

        try {
            Map result = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap(
                            "folder", "adore-hair-studio/wigs",
                            "resource_type", "image"
                    )
            );

            return ResponseEntity.ok(
                    Map.of(
                            "url", result.get("secure_url"),
                            "publicId", result.get("public_id")
                    )
            );

        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Image upload failed"));
        }
    }
}
