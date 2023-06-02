package com.example.demo.banco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.Transferencia;

@Repository
public class TransferenciaRepositoryImpl implements TransferenciaRepository {

	List<Transferencia>baseDatos = new ArrayList<>();
	@Override
	public void insertar(Transferencia transferencia) {
		this.baseDatos.add(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
		
	}

	@Override
	public void eliminar(String numero) {
		Transferencia transfer = this.seleccionar(numero);
		this.baseDatos.remove(transfer);
		
	}

	@Override
	public Transferencia seleccionar(String numero) {
		Transferencia transferEncontrada = new Transferencia();
		for(Transferencia transfer:baseDatos) {
			if(numero.equals(transfer.getNumero())) {
				transferEncontrada = transfer;
			}
			
		}
		return transferEncontrada;
	}

	@Override
	public List<Transferencia> seleccionartodo() {
		// TODO Auto-generated method stub
		return baseDatos;
	}

}
