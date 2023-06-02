package com.example.demo.banco.repository.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.banco.repository.modelo.Transferencia;

public interface TransferenciaService {
	public void guardar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public void borrar(String numero);
	public Transferencia buscar(String numero);
	public List<Transferencia> buscartodo();
	
	public void realizar(String cuentaInicio, String cuentaFinal, BigDecimal monto);
	

}
