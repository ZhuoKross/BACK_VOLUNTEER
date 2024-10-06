package com.projectSenasoft.volunteer.Repository;

import com.projectSenasoft.volunteer.Entity.FilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilesRepository extends JpaRepository<FilesEntity, UUID> {
}
