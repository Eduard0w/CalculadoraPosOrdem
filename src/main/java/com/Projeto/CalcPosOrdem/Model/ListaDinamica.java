package com.Projeto.CalcPosOrdem.Model;

public class ListaDinamica<T> {
	private No<T> prim;
	private No<T> ulti;
	
	public ListaDinamica() {
		this.prim = null;
		this.ulti = null;
	}
	
	
	public void adicionar(T dado) {
		No<T> novoNo = new No<>(dado);
		if(isEmpty()) {
			prim = novoNo;
		}else {
			ulti.setProx(novoNo);
		}
		ulti = novoNo;
	}
	
	public T retirar() {
		if(isEmpty()) {
			return null;
		} 
		
		T dado = prim.getDado();
		prim = prim.getProx();
		if(prim == null) {
			ulti = null;
		}
		
		return dado;
	}
	
	
	public boolean isEmpty() {
		return prim == null;
	}
	
	public void limpar() {
		prim = null;
		ulti = null;
	}
	
}
