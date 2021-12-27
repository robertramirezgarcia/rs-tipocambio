package com.viabcp.tipocambio.response;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CambioResponse implements Serializable{

private static final long serialVersionUID = 1L;

	private String estado;
	private BigDecimal monto;
	private BigDecimal montoConTipoCambio;
	private String monedaOrigen;
	private String monedaDestino;
	private BigDecimal valorTipoCambio;

}
