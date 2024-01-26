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
				+ "','Azul Escuro',"
				+ " '"+descricaoSt +"')";
		registraDriveEmbeded();
		dao.gravar(sqlInsertClassif);
		registraDriveEmbeded();
		int resultado = dao.excluir(nomeClasssificacaoSt);
		Assert.assertEquals(1, resultado);	//status code 1 indica o sucesso da operação
	}	
	
	public void registraDriveEmbeded()
	{
		try {
			System.out.println("registerDriver");
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());		} 
		catch (SQLException e) {
			e.printStackTrace();		}
	}

}
	