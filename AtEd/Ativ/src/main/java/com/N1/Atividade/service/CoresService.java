package com.N1.Atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.N1.Atividade.enity.Cores;
import com.N1.Atividade.repository.CoresRespository;
import jakarta.transaction.Transactional;

@Service
public class CoresService {

    @Autowired(required = false)
    private CoresRespository  coresRespository;

    @Transactional
    public String createcores(Cores cores) {
        try {
            if (!coresRespository.existsByNcor(cores.getncor())) {
                cores.setId(null == coresRespository.findMaxId() ? 0 : coresRespository.findMaxId() + 1);
                coresRespository.save(cores);
                return "cores cadastrado com sucesso.";
            } else {
                return "cores já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Cores> readcores() {
        return coresRespository.findAll();
    }

    @Transactional
    public String updatecores(Cores cores) {
        if (coresRespository.existsById(cores.getId())) {
            try {
                Optional<Cores> Cores = coresRespository.findById(cores.getId());
                Cores.stream().forEach(s -> {
                    Cores coresToBeUpdate = coresRespository.findById(s.getId()).get();
                    coresToBeUpdate.setncor(cores.getncor());
                    coresToBeUpdate.sethexa(cores.gethexa());
                    coresRespository.save(coresToBeUpdate);
                });
                return "cadastro de cores atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "cores não existe no banco.";
        }
    }

    @Transactional
    public String deletecores(Cores cores) {
        if (coresRespository.existsById(cores.getId())) {
            try {
                Optional<Cores> Cores = coresRespository.findById(cores.getId());
                Cores.stream().forEach(s -> {
                    coresRespository.delete(s);
                });
                return "cores deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "cores n\u00E3o existe no banco.";
        }
    }
}