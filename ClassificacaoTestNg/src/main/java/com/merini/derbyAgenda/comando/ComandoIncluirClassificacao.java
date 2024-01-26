package com.merini.derbyAgenda.comando;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;
import com.merini.derbyAgenda.modelo.Classificacao;
import com.merini.derbyAgenda.modelo.Comentario;
import com.merini.derbyAgenda.view.JanelaIncluirClassificacao;

public class ComandoIncluirClassificacao 
{
//	private static String nomeAgendaSelecionadaSt=null;
	JanelaIncluirClassificacao janelaInlcuirClassificacao;
	Comentario c = new Comentario();

	public void processaComando(String comando, Classificacao classificacao) 
	{		
		if (comando.equals("Incluir Classificacao")) 
		{
			ClassificacaoDAO daoCl = new ClassificacaoDAO();
			daoCl .gravar(classificacao);
		} 
		else 
		{
			System.out.println("Comando ERRAAdo");
		}
	}

	public void processaComando(String comando) 
	{		
		if (comando.equals("Cria Janela Inclui Classificacao")) 
		{
			c.comentaLocalizacao("processaComando()", comando);
			janelaInlcuirClassificacao = new JanelaIncluirClassificacao();				
		} 
		else 
		{
			System.out.println("Coamando errado");
		}
	}
}
