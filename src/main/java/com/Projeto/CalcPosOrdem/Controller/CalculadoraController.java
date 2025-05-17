package com.Projeto.CalcPosOrdem.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.CalcPosOrdem.Service.Calculadora;

@RestController
@RequestMapping("/api")
public class CalculadoraController {
	
	private Calculadora calculadora;

	public CalculadoraController(Calculadora calculadora) {
		this.calculadora = calculadora;
	}
	
	@PostMapping("/calcular")
    public ResponseEntity<?> calcular(@RequestBody String expressao) {
		System.out.println("Expressão recebida: '" + expressao + "'");
		double resultado = calculadora.calcular(expressao);
		return ResponseEntity.ok(Map.of("resultado", resultado));
	}

}
