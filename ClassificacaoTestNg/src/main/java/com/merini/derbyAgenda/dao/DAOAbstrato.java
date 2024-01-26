package com.merini.derbyAgenda.dao;

import java.util.List;

//import javax.persistence.EntityManager;

import com.merini.derbyAgenda.modelo.Comentario;

public abstract class DAOAbstrato
{
//	protected static EntityManager em ;		
	protected static com.merini.derbyAgenda.modelo.Comentario c = new Comentario();	
	
	public DAOAbstrato()
	{
//		em  = EM.getInstance().getEm();
	}

	public abstract void editar(Object objeto) ;
	
	public void excluir(Integer id) 
	{		
		
	}

	public abstract Object gravar(Object entidade);

	public List obterTodos() {
		return null;
	}

	public abstract List obterTodosNomes() ;

	public Integer recuperaIdPorNome(String nome) {
		return null;
	}

	public Object recuperaPorNome(String nome) {
		return null;
	}

	public Object carregar(String nomeClasssificacao) {
		return null;
	}

}
