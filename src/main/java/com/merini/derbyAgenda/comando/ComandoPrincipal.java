package com.merini.derbyAgenda.comando;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ComandoPrincipal 
{
	public static void main(String[] args) 
	{
		ComandoIncluirClassificacao comando = new ComandoIncluirClassificacao();
			System.out.println("main");
		comando.processaComando("Cria Janela Inclui Classificacao");
	}

}
