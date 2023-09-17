package com.N1.Atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.N1.Atividade.enity.Agenda;
import com.N1.Atividade.repository.AgendaRespository;
import jakarta.transaction.Transactional;

@Service
public class AgendaService {

    @Autowired(required = false)
    private AgendaRespository  agendaRespository;

    @Transactional
    public String createagenda(Agenda agenda) {
        try {
            if (!agendaRespository.existsByNome(agenda.getnome())) {
                agenda.setId(null == agendaRespository.findMaxId() ? 0 : agendaRespository.findMaxId() + 1);
                agendaRespository.save(agenda);
                return "agenda cadastrado com sucesso.";
            } else {
                return "agenda já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Agenda> readagenda() {
        return agendaRespository.findAll();
    }

    @Transactional
    public String updateagenda(Agenda agenda) {
        if (agendaRespository.existsById(agenda.getId())) {
            try {
                Optional<Agenda> Agenda = agendaRespository.findById(agenda.getId());
                Agenda.stream().forEach(s -> {
                    Agenda agendaToBeUpdate = agendaRespository.findById(s.getId()).get();
                    agendaToBeUpdate.setnome(agenda.getnome());
                    agendaToBeUpdate.setcontato(agenda.getcontato());
                    agendaRespository.save(agendaToBeUpdate);
                });
                return "cadastro de agenda atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "agenda não existe no banco.";
        }
    }

    @Transactional
    public String deleteagenda(Agenda agenda) {
        if (agendaRespository.existsById(agenda.getId())) {
            try {
                Optional<Agenda> Agenda = agendaRespository.findById(agenda.getId());
                Agenda.stream().forEach(s -> {
                    agendaRespository.delete(s);
                });
                return "agenda deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "agenda n\u00E3o existe no banco.";
        }
    }
}