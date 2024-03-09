package com.merini.classificacao.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;
import com.merini.derbyAgenda.modelo.Classificacao;

public class CT1verificaInclusaoTest 
{
	private String JdbcUrl="jdbc:derby:agendaDerby;create=true";
	
	private String nomeClasssificacaoSt = "Entretenimento " + String.valueOf(new Date().getTime());
	private String descricaoSt = "Atividades de lazer 2";	
	private String sqlInsertClassif = "INSERT INTO classificacao(nomeclassificacao, cor, descricao) values "
			+ "('"+nomeClasssificacaoSt
			+ "','Azul Escuro',"
			+ " '"+descricaoSt+"')";

	@Test(priority=0)
	public void CT1verificaInclusaoBancoTest()
	{		
			System.out.println("	CT1verificaInclusao()");
		int resultado=0;
		try 
		{
			registraDriveEmbeded();			
			Connection connection = DriverManager.getConnection(JdbcUrl);
				System.out.println("conectado, incluindo : "+nomeClasssificacaoSt);
			Statement stmt = connection.createStatement();
			resultado = stmt.executeUpdate(sqlInsertClassif); //(sqlCriaTabelaClassif);//
				System.out.println("registro classificação inserido, int retornado : "+String.valueOf(resultado));
			stmt.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}		
		Assert.assertEquals(1, resultado);
		verificaInclusao();
	}
	
	public void verificaInclusao()
	{		
			System.out.println("CT1verificaInclusao() asserts");
		ClassificacaoDAO dao = new ClassificacaoDAO();
			System.out.println("carregar "+nomeClasssificacaoSt);
		Classificacao classificacao = (Classificacao) dao.carregar(nomeClasssificacaoSt);
		Assert.assertEquals(descricaoSt, classificacao.getDescricao());
		Assert.assertEquals("Azul Escuro", classificacao.getCor());
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
