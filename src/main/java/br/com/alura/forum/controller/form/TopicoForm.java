package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CrusoRepository;

public class TopicoForm {

	@NotNull @NotEmpty 
//	@Length(min=5) //esta gerando erro no hibernate-validator
	private String titulo;

	@NotNull @NotEmpty
//	@Length(min=10) //esta gerando erro no hibernate-validator
	private String mensagem;

	@NotNull @NotEmpty
	private String nomeCurso;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converter(CrusoRepository cursoRepository) {
		Curso c = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, c);
	}
}