package com.viabcp.tipocambio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.viabcp.tipocambio.entity.TipoCambio;

@Repository
public interface TipoCambioRepository extends CrudRepository<TipoCambio, Long>{

	Optional<TipoCambio> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
	Optional<TipoCambio> findByMonedaOrigen(String monedaOrigen);
}