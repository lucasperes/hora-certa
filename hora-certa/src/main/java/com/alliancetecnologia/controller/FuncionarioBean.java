package com.alliancetecnologia.controller;


import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import com.alliancetecnologia.annotations.TransactionJpa;
import com.alliancetecnologia.model.FuncionarioModel;

@Named
@ViewScoped
public class FuncionarioBean extends AbstractController {
	
	private static final long serialVersionUID = -8406618786042343735L;
	
	private FuncionarioModel funcionario;
	
	private List<FuncionarioModel> funcionarios;
	
	public FuncionarioBean() {
		novo();
	}
	
	public void novo() {
		funcionario = new FuncionarioModel();
	}
	
	@TransactionJpa
	public void salvar() {
		getManager().merge(funcionario);
		addMessageInfo("Funcionario salvo com sucesso!");
		novo();
	}
	
	@TransactionJpa
	public void listar() {
		TypedQuery<FuncionarioModel> query = getManager().createQuery("select e from FuncionarioModel e", FuncionarioModel.class);
		funcionarios = query.getResultList();
	}

	public FuncionarioModel getFuncionario() {
		return funcionario;
	}
	
	public List<FuncionarioModel> getFuncionarios() {
		return funcionarios;
	}
	
}
