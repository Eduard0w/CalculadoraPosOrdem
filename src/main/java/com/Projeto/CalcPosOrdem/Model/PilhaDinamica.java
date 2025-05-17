package com.Projeto.CalcPosOrdem.Model;

public class PilhaDinamica<T> {
	private No<T> topo;

	public PilhaDinamica() {
		this.topo = null;
	}
	
	public void empilhar(T dado) {
		No<T> novoNo = new No<>(dado);
		novoNo.setProx(topo);
		topo = novoNo;
	}
	
	public T desempilhar() {
		if(isEmpty()) {
			return null;
		}
		
		T dado = topo.getDado();
		topo = topo.getProx();		
		return dado;
	}
	
	public T Topo() {
		if(isEmpty()) {
			return null;
		}
		return topo.getDado();
	}
	
	public boolean isEmpty() {
		return topo == null;
	}
	
	public void limpar() {
		topo = null;
	}
}
