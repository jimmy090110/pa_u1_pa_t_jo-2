package com.example.demo.banco.repository.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("nacional")
public class MontoDebitarNacionalService implements MontoDebitarService {

	@Override
	public BigDecimal calcular(BigDecimal monto) {
		// TODO Auto-generated method stub
		return monto;
	}

}
