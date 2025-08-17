package com.caribe.sur.controller.admin.tools;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.caribe.sur.enumerators.listFromClass.UrlFromPages;
import com.caribe.sur.model.Backup;
import com.caribe.sur.repository.PlanesRepository;
import com.caribe.sur.repository.UsersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(UrlFromPages.URL_ADMIN_API_SECURITY_COPY)
public class IOInformation {
    @Autowired
    private PlanesRepository planesRepository;
    @Autowired
    private UsersRepository userRepository;

    @GetMapping(UrlFromPages.URL_ADMIN_SECURITY_LOCAL_BACKUP)
    public ResponseEntity<Resource> backupInformation() throws JsonProcessingException {
        Backup backup = new Backup();
        backup.setPlanes(planesRepository.findAll());
        backup.setUsers(userRepository.findAll());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBackup = objectMapper.writeValueAsString(backup);

        ByteArrayResource resource = new ByteArrayResource(jsonBackup.getBytes());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=backup.json")
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(resource.contentLength())
                .body(resource);

    }

    @PostMapping(UrlFromPages.URL_POST_ADMIN_SECURITY_COPY_RESTORE)
    public ResponseEntity<String> importBackup(@RequestParam("file") MultipartFile file) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Backup backup = objectMapper.readValue(file.getInputStream(), Backup.class);

            planesRepository.deleteAll();
            userRepository.deleteAll();

            planesRepository.saveAll(backup.getPlanes());
            userRepository.saveAll(backup.getUsers());

            return ResponseEntity.ok("Backup restored successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("The file is not a valid backup");
        }

    }

}
