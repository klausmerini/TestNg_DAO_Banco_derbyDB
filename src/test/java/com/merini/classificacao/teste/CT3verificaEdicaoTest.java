package com.merini.classificacao.teste;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;
import com.merini.derbyAgenda.modelo.Classificacao;

public class CT3verificaEdicaoTest 
{
	private String corSt = "Marfim";	
	private String descricaoSt = "description edit";		
	
	@Test
	public void CT3verificaEdicao()
	{
			System.out.println("	CT3verificaEdicaoTest : classe ");
		ClassificacaoDAO dao = new ClassificacaoDAO();
		Date date = new Date();
		String nomeClasssificacaoSt = "Entretenimento1705675393503";			
			System.out.println("carregar "+nomeClasssificacaoSt);	
		Classificacao classificacao = (Classificacao) dao.carregar(nomeClasssificacaoSt);		
				
		String horaSt= String.valueOf(date.getTime());
		descricaoSt = descricaoSt+String.valueOf(horaSt);
		corSt = corSt+horaSt;		
		classificacao.setDescricao(descricaoSt);
		classificacao.setCor(corSt);		
		dao.editar(classificacao);
		Classificacao classificacaoEditada = (Classificacao) dao.carregar(classificacao.getNomeclassificacao());
			
			System.out.println("assert equals");
		Assert.assertEquals(descricaoSt, classificacaoEditada.getDescricao());
		Assert.assertEquals(corSt, classificacaoEditada.getCor());
	}	
		
}
