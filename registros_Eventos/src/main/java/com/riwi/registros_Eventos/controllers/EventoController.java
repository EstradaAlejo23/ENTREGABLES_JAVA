package com.riwi.registros_Eventos.controllers;

import com.riwi.registros_Eventos.entities.Evento;
import com.riwi.registros_Eventos.services.abstract_service.IEventoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/v1/eventos")
@AllArgsConstructor
public class EventoController {

    @Autowired
    private final IEventoService objIEventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> getAll(){
        return ResponseEntity.ok(this.objIEventoService.getAll());
    }

    @GetMapping("/pagina")
    public ResponseEntity<Page<Evento>> showEventos(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "2")int size){
        return ResponseEntity.ok(this.objIEventoService.showPage(page - 1,size));
    }


    @PostMapping
    public ResponseEntity<Evento> insert(
            @RequestBody Evento objEvento) {
        return ResponseEntity.ok(this.objIEventoService.save(objEvento));
    }

    @GetMapping(path = ("/{id}"))
    public ResponseEntity<Evento> get(@PathVariable String id){
        return ResponseEntity.ok(this.objIEventoService.findById(id));
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Evento> update(@RequestBody Evento objEvento,//para obtener los datos actualizados
                                          @PathVariable String id){ //para obtener el id que viene en URL
        objEvento.setId(id);
        return ResponseEntity.ok(this.objIEventoService.update(objEvento));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.objIEventoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
