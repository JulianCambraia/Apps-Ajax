package br.com.julianfernando.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.julianfernando.model.Inputs;

@ManagedBean
@ApplicationScoped
public class InputsAjaxBean {
	
	private Inputs input = new Inputs();
	
	private List<Inputs> campos = new ArrayList<Inputs>();
	

	public List<Inputs> getCampos() {
		return campos;
	}

	public Inputs getInput() {
		return input;
	}

	public void setInput(Inputs input) {
		this.input = input;
	}
	
	public void enviar() {
		this.campos.add(input);
		
		this.input = new Inputs();
	}
	
	public void limpar() {
		
	}
	
	public void upperCaseEvent(ValueChangeEvent event) {
		String nome =  event.getNewValue().toString().toUpperCase();
		this.input.setNome(nome);
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public void randomSenhaValue(ValueChangeEvent event) {
		Integer senha =  (Integer.parseInt(event.getNewValue().toString()));
		Random  senhaRandom = new Random(senha);
		senha = senhaRandom.nextInt();
		this.input.setSenha(senha.toString());
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public String salvar() {
		this.campos.add(input);
		return "lista-inputs";
	}
}
