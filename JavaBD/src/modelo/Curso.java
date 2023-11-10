package modelo;

import java.util.ArrayList;

public class Curso {
    private Integer idCurso;
    private String nome;
    private String cargaHoraria;
    private String qtdSemestres;
    private Disciplina disciplina;
   

    public Curso() {
        disciplina = new Disciplina();
    }

    public Curso(Integer idCurso, String nome, String cargaHoraria, String qtdSemestres, Disciplina disciplina) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.qtdSemestres = qtdSemestres;
        this.disciplina = disciplina;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getQtdSemestres() {
        return qtdSemestres;
    }

    public void setQtdSemestres(String qtdSemestres) {
        this.qtdSemestres = qtdSemestres;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    
   
    
    
    public void exibir(){
        System.out.println("\nInformacoes do Curso");
        System.out.println("idCurso: " +idCurso + 
                "\nNome: " + nome + 
                "\nCarga Horaria: " +cargaHoraria+
                "\nQuantidade de Semestres: " + qtdSemestres);
    }
}
