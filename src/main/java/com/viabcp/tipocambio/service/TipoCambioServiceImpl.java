package com.viabcp.tipocambio.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viabcp.tipocambio.entity.TipoCambio;
import com.viabcp.tipocambio.repository.TipoCambioRepository;
import com.viabcp.tipocambio.response.CambioResponse;
import com.viabcp.tipocambio.request.CambioRequest;

import io.reactivex.Single;

@Service
public class TipoCambioServiceImpl implements TipoCambioService{
	
	@Autowired
	private TipoCambioRepository tipoCambioRepository;
	
	@Override
	public Single<CambioResponse> consultarTipoCambio(CambioRequest cambioRequest){
		System.out.println(cambioRequest.toString());
		Optional<TipoCambio> lstResTipoCambio = tipoCambioRepository
                .findByMonedaOrigenAndMonedaDestino(cambioRequest.getMonedaOrigen(), cambioRequest.getMonedaDestino());
		
		return Single.create(singleSubscriber -> {
		           	List<TipoCambio> listResultado = new ArrayList<TipoCambio>();
		           	if(lstResTipoCambio.isPresent()) listResultado.add(lstResTipoCambio.get());
		            
		           	CambioResponse cambioResponse = new CambioResponse();
		           	if(!listResultado.isEmpty()) {
	                    BigDecimal montoConTipoCambio = cambioRequest.getMonto().divide(listResultado.get(0).getValorTipoCambio());
	                    BigDecimal valorTipoCambio = listResultado.get(0).getValorTipoCambio();
	                    cambioResponse.setMontoConTipoCambio(montoConTipoCambio);
	                    cambioResponse.setValorTipoCambio(valorTipoCambio);
	                    cambioResponse.setEstado("OK");
		           	} else {
		           		cambioResponse.setEstado("ERROR");
		           	}
		           	cambioResponse.setMonto(cambioRequest.getMonto());
                    cambioResponse.setMonedaOrigen(cambioRequest.getMonedaOrigen());
                    cambioResponse.setMonedaDestino(cambioRequest.getMonedaDestino());
                    singleSubscriber.onSuccess(cambioResponse);
                });
	}
}

