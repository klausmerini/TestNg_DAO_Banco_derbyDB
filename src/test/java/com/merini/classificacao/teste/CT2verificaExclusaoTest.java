package com.merini.classificacao.teste;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;

public class CT2verificaExclusaoTest 
{
	private String sqlInsertClassifParte1 = "INSERT INTO classificacao(nomeclassificacao, cor, descricao) values ";
	private String corSt = "teste exclusao description";	
	private String descricaoSt = "teste exclusao description";		

	@Test
	public void CT04verificaExclusao()
	{
			System.out.println("	CT4verificaExclusao : classe  ");
		ClassificacaoDAO dao = new ClassificacaoDAO();
		
		Date date = new Date();
		String horaSt= String.valueOf(date.getTime());
		String nomeClasssificacaoSt = "Entretenimento excl "+horaSt;		
		String sqlInsertClassif = sqlInsertClassifParte1 
				+ "('"+nomeClasssificacaoSt
				+ "','"+corSt+"',"
				+ " '"+descricaoSt +"')";
		
		dao.gravar(sqlInsertClassif);
		int resultado = dao.excluir(nomeClasssificacaoSt);
		
		Assert.assertEquals(1, resultado);	//status code 1 indica o sucesso da operação
	}	
	
}
	