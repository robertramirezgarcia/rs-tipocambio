package com.viabcp.tipocambio.request;

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
public class CambioRequest implements Serializable{

        private static final long serialVersionUID = 1L;
	private BigDecimal monto;
	private String monedaOrigen;
	private String monedaDestino;
}