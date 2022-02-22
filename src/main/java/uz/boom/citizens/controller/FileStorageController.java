package uz.boom.citizens.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.boom.citizens.services.file.FileStorageService;

@Controller
public class FileStorageController {


    private final FileStorageService fileStorageService;

    @Autowired
    public FileStorageController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @RequestMapping("/uploads/{filename:.+}")
    public ResponseEntity<?> download(@PathVariable String filename) {

        Resource file = fileStorageService.getResource(filename);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


}
