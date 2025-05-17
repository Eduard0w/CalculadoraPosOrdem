package com.Projeto.CalcPosOrdem.Model;

public class No<T> {
	private T dado; 
	private No<T> prox;
	
	public No(T dado) {
		this.dado = dado;
		this.prox = null;
	}

	public T getDado() {
		return dado;
	}

	public No<T> getProx() {
		return prox;
	}

	public void setProx(No<T> prox) {
		this.prox = prox;
	}
	
	
}
