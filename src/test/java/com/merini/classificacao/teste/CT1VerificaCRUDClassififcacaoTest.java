package com.merini.classificacao.teste;

import org.testng.Assert;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import org.testng.annotations.Test;

import org.testng.Assert;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;
import com.merini.derbyAgenda.modelo.Classificacao;

public class CT1VerificaCRUDClassififcacaoTest 
{

	private String JdbcUrl="jdbc:derby:agendaDerby;create=true";
	
	private String nomeClasssificacaoSt = "Entretenimento " + String.valueOf(new Date().getTime());
	private String descricaoSt = "Atividades de lazer 2";	
	private String sqlCriaTabelaClassif = "CREATE TABLE classificacao(idclassificacao INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
			+ "nomeclassificacao VARCHAR(70), cor VARCHAR(200),  descricao VARCHAR(700), PRIMARY KEY(idclassificacao))";
	private String sqlDeletaTabelaClassif = "DROP TABLE classificacao";
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

	@Test(priority=1)
	public void CT04verificaExclusao()
	{
		System.out.println("	CT4verificaExclusao()");
		ClassificacaoDAO dao = new ClassificacaoDAO();
		registraDriveEmbeded();		
		int resultado = dao.excluir(nomeClasssificacaoSt);
		Assert.assertEquals(1, resultado);	//status code 1 indica o sucesso da operação, no caso da exclusão, 1 indica o sucesso
	}	
	
	@Test (priority=2)
	public void CT2verificaRecuperaTodosOsNomesBanco()
	{
		String sqlRecuperaTodosNomesClassif = "SELECT nomeclassificacao FROM classificacao";   		
		ClassificacaoDAO dao = new ClassificacaoDAO();
			System.out.println("	CT2verificaRecuperaTodosOsNomesBanco");
		registraDriveEmbeded();
		Connection connection = dao.conecta();
		ArrayList<String> nomesClassificacao = new ArrayList<String>();
		try 
		{		
			PreparedStatement preparedStatement = connection.prepareStatement(sqlRecuperaTodosNomesClassif);
			ResultSet resultSet = preparedStatement.executeQuery();
			String name;
			while(resultSet.next())
			{
				name = resultSet.getString("nomeclassificacao").trim();
				nomesClassificacao.add(name);
					System.out.printf("nome da classificação : %s\n",name);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
				System.out.println("nome das classificações recuperado");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
//		assertEquals("Comercial", nomesClassificacao.get(0));
//		assertEquals("Comercial", nomesClassificacao.get(1));
//		assertEquals("Entretenimento", nomesClassificacao.get(4));
//		shutDown();
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
