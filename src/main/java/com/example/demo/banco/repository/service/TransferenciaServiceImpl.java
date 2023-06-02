package com.example.demo.banco.repository.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	@Qualifier("nacional")
	private MontoDebitarService debitarService;
	@Override
	public void guardar(Transferencia transferencia) {
		this.transferenciaRepository.insertar(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.transferenciaRepository.actualizar(transferencia);
		
	}

	@Override
	public void borrar(String numero) {
		this.transferenciaRepository.eliminar(numero);
		
	}

	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.seleccionar(numero);
	}

	@Override
	public List<Transferencia> buscartodo() {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.seleccionartodo();
	}

	@Override
	public void realizar(String cuentaInicio, String cuentaFinal, BigDecimal monto) {
		Cuenta ctaInicio = this.cuentaRepository.seleccionar(cuentaInicio);
		BigDecimal saldoInicio=  ctaInicio.getSaldo();
		BigDecimal montoDebitar= this.debitarService.calcular(monto);
		
		if(montoDebitar.compareTo(saldoInicio)<=0) {
			BigDecimal nuevoSaldoInicio = saldoInicio.subtract(montoDebitar);
			ctaInicio.setSaldo(nuevoSaldoInicio);
			this.cuentaRepository.actualizar(ctaInicio);
		Cuenta ctaFinal = this.cuentaRepository.seleccionar(cuentaFinal);
		BigDecimal SaldoFinal = ctaFinal.getSaldo();
		BigDecimal nuevoSaldoFinal =SaldoFinal.add(montoDebitar);
		
		
		ctaFinal.setSaldo(nuevoSaldoFinal);
		this.cuentaRepository.actualizar(ctaFinal);
		
		Transferencia transfer = new Transferencia();
		transfer.setCuentaOrigen(ctaInicio);
		transfer.setCuentaDestino(ctaFinal);
		transfer.setMonto(montoDebitar);
		Double numero = Math.random();
		transfer.setNumero(numero.toString());
		transfer.setFecha(LocalDateTime.now());
		this.transferenciaRepository.insertar(transfer);
			
		}
		
		
		
		
	}

}
