package modelo;

public class Curso {
    private Integer idCurso;
    private String nome;
    private String cargaHoraria;
    private String qtdSemestres;

    public Curso() {
    }

    public Curso(Integer idCurso, String nome, String cargaHoraria, String qtdSemestres) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.qtdSemestres = qtdSemestres;
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
}
