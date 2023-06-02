package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.repository.service.CuentaService;
import com.example.demo.banco.repository.service.TransferenciaService;

@SpringBootApplication
public class PaU1PaTJo2Application implements CommandLineRunner {
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	@Autowired
	private CuentaService cuentaService;

	public static void main(String[] args) {
		SpringApplication.run(PaU1PaTJo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cuenta cuent1 = new Cuenta();
		cuent1.setNumero("12");
		cuent1.setCedulaPropietario("12334");
		cuent1.setTipo("A");
		cuent1.setSaldo(new BigDecimal(400));
		 this.cuentaService.guardar(cuent1);
		
		Cuenta cuent2 = new Cuenta();
		cuent2.setNumero("34");
		cuent2.setCedulaPropietario("567");
		cuent2.setTipo("C");
		cuent2.setSaldo(new BigDecimal(500));
		 this.cuentaService.guardar(cuent2);
		 
		 //Transferencia transfer = new Transferencia();
		 
		 this.transferenciaService.realizar(cuent1.getNumero(), cuent2.getNumero(), new BigDecimal(15));
		 System.out.println(cuent1.getSaldo());
		 System.out.println(cuent2.getSaldo());
		
		
		
		
		
	}

}
