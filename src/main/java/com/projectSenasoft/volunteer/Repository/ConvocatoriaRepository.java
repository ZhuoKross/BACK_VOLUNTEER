package com.projectSenasoft.volunteer.Repository;

import com.projectSenasoft.volunteer.Entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projectSenasoft.volunteer.Entity.convocatoriaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ConvocatoriaRepository extends JpaRepository<convocatoriaEntity, String> {

    @Query("SELECT c FROM convocatoriaEntity e JOIN e.categorias c WHERE e.idConvocatoria = :id")
    public List<CategoriaEntity> findAssociatedCategory (@Param("id") String idConvocatoria);
}
