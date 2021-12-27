package com.viabcp.tipocambio.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_cambio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	@Column(name="valor_tipo_cambio")
	private BigDecimal valorTipoCambio;
	@Column(name="moneda_origen")
	private String monedaOrigen;
	@Column(name="moneda_destino")
	private String monedaDestino;
	
}