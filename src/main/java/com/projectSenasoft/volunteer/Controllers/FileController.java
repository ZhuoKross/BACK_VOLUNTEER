package com.projectSenasoft.volunteer.Controllers;


import com.projectSenasoft.volunteer.DTO.FileDTO;
import com.projectSenasoft.volunteer.DTO.ResponseFileMessage;
import com.projectSenasoft.volunteer.Services.FilesServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(path = "api/files", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")
public class FileController {

    @Autowired
    FilesServiceImp filesServiceImp;

    @PostMapping("/upload")
    public ResponseEntity<ResponseFileMessage> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {

        filesServiceImp.Store(file);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseFileMessage("Archivo Cargado Exitosamente"));

    }

    @GetMapping("/all")
    public ResponseEntity<List<FileDTO>> getAllFiles(){
        List<FileDTO> fileDTOList = filesServiceImp.getAllFiles();

        return ResponseEntity.status(HttpStatus.OK).body(fileDTOList);
    }
}
