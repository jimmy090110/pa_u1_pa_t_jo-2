package com.example.demo.banco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.Cuenta;

@Repository
public class CuentaRepositoryImpl implements CuentaRepository {
	
	List<Cuenta>baseDatos = new ArrayList<>();

	@Override
	public void insertar(Cuenta cuenta) {
		this.baseDatos.add(cuenta);
		
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		this.eliminar(cuenta.getNumero());
		this.insertar(cuenta);
		
		
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		Cuenta cuent = this.seleccionar(numero);
		this.baseDatos.remove(cuent);
		
	}

	@Override
	public Cuenta seleccionar(String numero) {
		Cuenta cuenEncontrada = new Cuenta();
		for(Cuenta cuen : baseDatos) {
			if(numero.equals(cuen.getNumero())) {
				cuenEncontrada= cuen;
			}
			
			
			
		}
		return cuenEncontrada;
	}

	@Override
	public List<Cuenta> seleccioarTodo() {
		// TODO Auto-generated method stub
		return baseDatos;
	}

}
