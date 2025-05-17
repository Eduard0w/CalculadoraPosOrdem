package com.Projeto.CalcPosOrdem.Service;

import org.springframework.stereotype.Service;

import com.Projeto.CalcPosOrdem.Exception.DivisaoPorZeroException;
import com.Projeto.CalcPosOrdem.Exception.ExpressaoInvalidaException;
import com.Projeto.CalcPosOrdem.Model.ListaDinamica;
import com.Projeto.CalcPosOrdem.Model.PilhaDinamica;

@Service
public class Calculadora {
	
	public double calcular(String expressao) {
		ListaDinamica<String> Lista = new ListaDinamica<>();
		PilhaDinamica<Double> Pilha = new PilhaDinamica<>();
		
		String[] tokens = expressao.trim().split("\\s+");
		for(String token : tokens) {
			Lista.adicionar(token);
		}
		
		while(!Lista.isEmpty()) {
			String token = Lista.retirar();
			
			if(isNumero(token)) {
				Pilha.empilhar(Double.parseDouble(token));
			}else if(isOperador(token)) {
				if (Pilha.isEmpty()) throw new ExpressaoInvalidaException("Operandos insuficientes.");
                double b = Pilha.desempilhar();
                if (Pilha.isEmpty()) throw new ExpressaoInvalidaException("Operandos insuficientes.");
                double a = Pilha.desempilhar();
                
                double resultado;
                switch(token) {
	                case "+": resultado = a + b;break;
	                case "-": resultado = a - b;break;
	                case "*": resultado = a * b;break;
	                case "/":
	                	if (b == 0) throw new DivisaoPorZeroException();
	                	resultado = a / b;
	                	break;
	                case "%": resultado = a % b;break;
	                default: throw new ExpressaoInvalidaException("Operador inválido: " + token);
                }
                Pilha.empilhar(resultado);
			} else {
				 throw new ExpressaoInvalidaException("Token inválido: " + token);
			}
		}
		
		if (Pilha.isEmpty() || Pilha.Topo() == null) {
            throw new ExpressaoInvalidaException("Expressão malformada.");
        }
		
		double resultadoFinal = Pilha.desempilhar();
		
		if (!Pilha.isEmpty()) {
            throw new ExpressaoInvalidaException("Expressão inválida: operandos excedentes.");
        }

        return resultadoFinal;
	}
	
	public boolean isNumero(String n) {
		 try {
	            Double.parseDouble(n);
	            return true;
	        } catch (NumberFormatException ex) {
	            return false;
	        }
	}
	
	public boolean isOperador(String n) {
		 return n.matches("[+\\-*/%]");
	}
}
