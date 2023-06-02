package com.example.demo.banco.repository.service;

import java.util.List;

import com.example.demo.banco.repository.modelo.Cuenta;

public interface CuentaService {
	public void guardar(Cuenta cuenta);
	public void actualizar(Cuenta cuenta);
	public void borrar(String numero);
	public Cuenta buscar(String numero);
	
	public List<Cuenta>buscarTodo();

}
