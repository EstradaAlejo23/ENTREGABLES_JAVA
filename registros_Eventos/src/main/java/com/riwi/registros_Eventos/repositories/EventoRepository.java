package com.riwi.registros_Eventos.repositories;

import com.riwi.registros_Eventos.entities.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento,String> {

    public List<Evento> findByNombre(String nombre);

}
