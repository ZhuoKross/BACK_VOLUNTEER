package com.projectSenasoft.volunteer.Repository;

import com.projectSenasoft.volunteer.Entity.CiudadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<CiudadEntity, String> {
}
