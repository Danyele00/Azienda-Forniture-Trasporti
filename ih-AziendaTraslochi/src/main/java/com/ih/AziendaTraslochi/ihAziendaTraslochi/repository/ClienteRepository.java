package com.ih.AziendaTraslochi.ihAziendaTraslochi.repository;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
