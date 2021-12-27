package com.viabcp.tipocambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viabcp.tipocambio.response.CambioResponse;
import com.viabcp.tipocambio.service.TipoCambioService;
import com.viabcp.tipocambio.request.CambioRequest;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@RestController
@RequestMapping(value = "/api/tipocambio")
public class TipoCambioController {

@Autowired
private TipoCambioService tipoCambioService;	
	
@PostMapping(value = "/consultar")
public Single<ResponseEntity<CambioResponse>> consultarTipoCambio(@RequestBody CambioRequest cambioRequest) {
        return tipoCambioService.consultarTipoCambio(cambioRequest)
                .subscribeOn(Schedulers.io())
                .map(s -> ResponseEntity.ok(s));
    }
}
