package com.viabcp.tipocambio.service;

import com.viabcp.tipocambio.response.CambioResponse;
import com.viabcp.tipocambio.request.CambioRequest;

import io.reactivex.Single;

public interface TipoCambioService {
	Single<CambioResponse> consultarTipoCambio(CambioRequest cambioRequest);
}
