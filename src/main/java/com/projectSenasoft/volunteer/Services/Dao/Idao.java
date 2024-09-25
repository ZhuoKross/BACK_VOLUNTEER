package com.projectSenasoft.volunteer.Services.Dao;

import com.projectSenasoft.volunteer.Entity.UsuarioEntity;

import java.util.List;

public interface Idao <T, ID>{

    // Método para obtener una lista de todas las instancias de una entidad en la base de datos.
    public List<T> findAll();

    // Método para obtener una instancia específica de la entidad basada en un identificador único.
    public T getById(ID id);

    // Método para actualizar una instancia existente de la entidad en la base de datos.
    public void update(T entity);

    // Método para guardar una instancia de la entidad en la base de datos.
    public void save(T entity);

    // Método para eliminar una instancia existente de la entidad de la base de datos.
    public void delete(T entity);

    // Método para crear una nueva instancia de la entidad en la base de datos.
    public void create(T entity);
}
