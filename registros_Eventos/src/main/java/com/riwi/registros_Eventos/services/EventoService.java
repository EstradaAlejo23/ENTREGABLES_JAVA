package com.riwi.registros_Eventos.services;

import com.riwi.registros_Eventos.entities.Evento;
import com.riwi.registros_Eventos.repositories.EventoRepository;
import com.riwi.registros_Eventos.services.abstract_service.IEventoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class EventoService implements IEventoService {

    @Autowired
    private final EventoRepository objEventoRepository;



    @Override
    public Evento save(Evento objEvento) {
        //isBefore para comparar si la fecha es despues y isAfter para comparar que sea despues
        if (objEvento.getFecha().isBefore(objEvento.getFechaSystem()) || objEvento.getCapacidad() <= 0){
            return null;
        }else{
            return this.objEventoRepository.save(objEvento);
        }
    }

    @Override
    public List<Evento> getAll() {
        return this.objEventoRepository.findAll();
    }

    @Override
    public Evento findById(String id) {
        return this.objEventoRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
        Evento evento = this.objEventoRepository.findById(id).orElseThrow();
        this.objEventoRepository.delete(evento);
    }

    @Override
    public Evento update(Evento objEvento) {
        return this.objEventoRepository.save(objEvento);
    }

    @Override
    public Page<Evento> showPage(int page, int size) {
        if(page < 0){
            page = 0;
        }

        Pageable objPage = PageRequest.of(page,size);
        return this.objEventoRepository.findAll(objPage);
    }
}
