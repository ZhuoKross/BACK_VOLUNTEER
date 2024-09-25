package com.projectSenasoft.volunteer.Repository;


import com.projectSenasoft.volunteer.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {
}
