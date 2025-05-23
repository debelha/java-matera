package com.matera.ContaService.repository;

import com.matera.ContaService.model.Pix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PixRepository extends JpaRepository<Pix, UUID> {

    Optional<Pix> findByIdempotencia(final String idempotencia);
}
