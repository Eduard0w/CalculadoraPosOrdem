package com.Projeto.CalcPosOrdem.Exception;

@SuppressWarnings("serial")
public class DivisaoPorZeroException extends RuntimeException {
	public DivisaoPorZeroException() {
		super("Erro: divisão por zero!");
	}
}
