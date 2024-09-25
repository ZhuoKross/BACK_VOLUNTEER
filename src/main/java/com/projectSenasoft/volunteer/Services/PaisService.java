package com.projectSenasoft.volunteer.Services;

import com.projectSenasoft.volunteer.Entity.PaisEntity;
import com.projectSenasoft.volunteer.Entity.UsuarioEntity;
import com.projectSenasoft.volunteer.Repository.PaisRepository;
import com.projectSenasoft.volunteer.Services.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService implements Idao<PaisEntity, String> {

    @Autowired
    PaisRepository paisRepository;

    @Override
    public List<PaisEntity> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public PaisEntity getById(String idPais) {
        Optional<PaisEntity> optionalPaisEntity = paisRepository.findById(idPais);

        return optionalPaisEntity.orElse(null);
    }

    @Override
    public void update(PaisEntity paisEntity) {
        paisRepository.save(paisEntity);
    }

    @Override
    public void save(PaisEntity paisEntity) {
        paisRepository.save(paisEntity);
    }


    @Override
    public void delete(PaisEntity paisEntity){
        paisRepository.delete(paisEntity);
    }

    public void delete(String idPais) {
        paisRepository.deleteById(idPais);
    }

    @Override
    public void create(PaisEntity paisEntity) {
        paisRepository.save(paisEntity);
    }
}
