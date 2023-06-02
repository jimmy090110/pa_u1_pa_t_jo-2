package com.example.demo.banco.repository;

import java.util.List;

import com.example.demo.banco.repository.modelo.Cuenta;

public interface CuentaRepository {
	public void insertar(Cuenta cuenta);
	public void actualizar(Cuenta cuenta);
	public void eliminar(String numero);
	public Cuenta seleccionar(String numero);
	
	public List<Cuenta>seleccioarTodo();
	
	

}
