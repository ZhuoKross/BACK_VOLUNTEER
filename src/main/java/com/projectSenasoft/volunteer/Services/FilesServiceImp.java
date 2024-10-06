package com.projectSenasoft.volunteer.Services;

import com.projectSenasoft.volunteer.DTO.FileDTO;
import com.projectSenasoft.volunteer.Entity.FilesEntity;
import com.projectSenasoft.volunteer.Repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilesServiceImp implements IFilesService{

    @Autowired
    FilesRepository filesRepository;


    @Override
    public FilesEntity Store(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        FilesEntity filesEntity = FilesEntity.builder()
                .fileName(filename)
                .data(file.getBytes())
                .build();
        return filesRepository.save(filesEntity);
    }

    @Override
    public List<FileDTO> getAllFiles() {
        List<FileDTO> fileDTOList = filesRepository.findAll().stream().map(Dbfile -> {
                    String FileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("api/files/")
                        .path(Dbfile.getId().toString())
                        .toUriString();

                    return FileDTO.builder()
                            .name(Dbfile.getFileName())
                            .url(FileUri)
                            .size(Dbfile.getData()).build();

        }).collect(Collectors.toList());

        return fileDTOList;
    }
}
