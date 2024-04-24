package com.riwi.registros_Eventos.services.abstract_service;

import com.riwi.registros_Eventos.entities.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IEventoService {
    public Evento save(Evento objEvento);
    public List<Evento> getAll();
    public Evento findById(String id);
    public void delete(String id);
    public Evento update(Evento objEvento);

    public Page<Evento> showPage(int page,int size);

}
