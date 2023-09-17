package com.N1.Atividade.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.N1.Atividade.enity.Agenda;
import com.N1.Atividade.service.AgendaService;

@RestController
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createagenda", method = RequestMethod.POST)
    public String createagenda(@RequestBody Agenda agenda) {
        return agendaService.createagenda(agenda);
    }

    @RequestMapping(value = "readagenda", method = RequestMethod.GET)
    public List<Agenda> readagenda() {
    return agendaService.readagenda();
    }

    @RequestMapping(value = "updateagenda", method = RequestMethod.PUT)
    public String updatagenda(@RequestBody Agenda agenda) {
        return agendaService.updateagenda(agenda);
    }

    @RequestMapping(value = "deleteagenda", method = RequestMethod.DELETE)
    public String deleteagenda(@RequestBody Agenda agenda) {
        return agendaService.deleteagenda(agenda);
    }
}
