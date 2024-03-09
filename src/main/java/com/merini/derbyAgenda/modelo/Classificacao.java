package com.merini.derbyAgenda.modelo;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

import java.io.Serializable;
/**
 *
 * @author Klaus
 */

public class Classificacao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idclassificacao;
    private String nomeclassificacao;
    private String cor;
    private String descricao;
    
    public Classificacao() {
    	System.out.println("Modelo.Classificacao.Construtor sem parametros");
	}
    
    public Classificacao(String nomeClassificacao, String descricao) 
    {
    	setNomeclassificacao(nomeClassificacao);
    	setDescricao(descricao);
    }

    public Classificacao(Integer idclassificacao) {
        this.idclassificacao = idclassificacao;
    }

    public Integer getIdclassificacao() {
        return idclassificacao;
    }

    public void setIdclassificacao(Integer idclassificacao) {
        this.idclassificacao = idclassificacao;
    }

    public String getNomeclassificacao() {
        return nomeclassificacao;
    }

    public void setNomeclassificacao(String nomeclassificacao) {
        this.nomeclassificacao = nomeclassificacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idclassificacao != null ? idclassificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classificacao)) {
            return false;
        }
        Classificacao other = (Classificacao) object;
        if ((this.idclassificacao == null && other.idclassificacao != null) || (this.idclassificacao != null && !this.idclassificacao.equals(other.idclassificacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Classificacao[ idclassificacao=" + idclassificacao + " ]";
    }
    
}
