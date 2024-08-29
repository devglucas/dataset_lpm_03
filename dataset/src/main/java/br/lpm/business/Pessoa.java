package br.lpm.business;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private Integer idade; 
    private float altura;
    private float peso; 
    private LocalDate datanasc; 
    private EstadoCivil estadoCivil;
    private Profissao profissao;
    private FormacaoAcademica formacaoAcadem; 
    private Boolean vidasocial;
    private Boolean hobby;
    private Integer atividadeFisica; 
    private Integer estadoSaude;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(nome instanceof String) {
            if(nome.matches("[a-zA-Z]+")) {
                this.nome = nome;
            }
        }
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        if(altura > 0 && altura < 3) {
            this.altura = altura;
        }
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        if(peso > 0 && peso < 500){
            this.peso = peso;
        }
    }
    public LocalDate getDatanasc() {
        return datanasc;
    }
    public void setDatanasc(LocalDate datanasc) {
        if(datanasc.isBefore(LocalDate.now())){
            this.datanasc = datanasc;
        }
    }
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public Profissao getProfissao() {
        return profissao;
    }
    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }
    public FormacaoAcademica getFormacaoAcadem() {
        return formacaoAcadem;
    }
    public void setFormacaoAcadem(FormacaoAcademica formacaoAcadem) {
        this.formacaoAcadem = formacaoAcadem;
    }
    public Boolean getVidasocial() {
        return vidasocial;
    }
    public void setVidasocial(Boolean vidasocial) {
        this.vidasocial = vidasocial;
    }
    public Boolean getHobby() {
        return hobby;
    }
    public void setHobby(Boolean hobby) {
        this.hobby = hobby;
    }
    public Integer getAtividadeFisica() {
        return atividadeFisica;
    }
    public void setAtividadeFisica(Integer atividadeFisica) {
        if(atividadeFisica >= 0 && atividadeFisica <= 7){
            this.atividadeFisica = atividadeFisica;
        }
    }
    public Integer getEstadoSaude() {
        return estadoSaude;
    }
    public void setEstadoSaude(Integer estadoSaude) {
        if(estadoSaude >= 1 && estadoSaude <= 10) {
            this.estadoSaude = estadoSaude;
        }
        
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
}
