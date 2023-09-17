package com.N1.Atividade.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.N1.Atividade.enity.Cores;
import com.N1.Atividade.service.CoresService;

@RestController
public class CoresController {

    @Autowired
    private CoresService coresService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createcores", method = RequestMethod.POST)
    public String createcores(@RequestBody Cores cores) {
        return coresService.createcores(cores);
    }

    @RequestMapping(value = "readcores", method = RequestMethod.GET)
    public List<Cores> readcores() {
    return coresService.readcores();
    }

    @RequestMapping(value = "updatecores", method = RequestMethod.PUT)
    public String updatcores(@RequestBody Cores cores) {
        return coresService.updatecores(cores);
    }

    @RequestMapping(value = "deletecores", method = RequestMethod.DELETE)
    public String deletecores(@RequestBody Cores cores) {
        return coresService.deletecores(cores);
    }
}
