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
	@Test
	public void CT3verificaEdicao()
	{
			System.out.println("	CT3verificaEdicaoTest : classe ");
		ClassificacaoDAO dao = new ClassificacaoDAO();
		Date date = new Date();
		String horaSt= String.valueOf(date.getTime());
		String nomeClasssificacaoSt = "Entretenimento1705675393503";
			System.out.println("carregar "+nomeClasssificacaoSt);
		registraDriveEmbeded();	
		Classificacao classificacao = (Classificacao) dao.carregar(nomeClasssificacaoSt);		
		registraDriveEmbeded();
		String descricaoSt="descrição editada "+String.valueOf(horaSt);		
		classificacao.setDescricao(descricaoSt);
		dao.editar(classificacao);
		registraDriveEmbeded();
		Classificacao classificacaoEditada = (Classificacao) dao.carregar(classificacao.getNomeclassificacao());
			System.out.println("assert equals");
		Assert.assertEquals(descricaoSt, classificacaoEditada.getDescricao());
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
