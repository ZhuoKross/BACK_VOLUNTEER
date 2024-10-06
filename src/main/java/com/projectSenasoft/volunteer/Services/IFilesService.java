package com.projectSenasoft.volunteer.Services;


import com.projectSenasoft.volunteer.DTO.FileDTO;
import com.projectSenasoft.volunteer.Entity.FilesEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IFilesService {

    // Permite Guardar un Archivo en la base de datos
    FilesEntity Store(MultipartFile file) throws IOException;

    // Permite Mostrar todos los archivos guardados en la base de datos
    List<FileDTO> getAllFiles ();
}
