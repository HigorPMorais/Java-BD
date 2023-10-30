package modelo;
 
public class Aluno {
    private Integer idAluno;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private Curso curso;

    public Aluno() {
        this.endereco = new Endereco();
        this.curso = new Curso();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    }

    public Aluno(Integer idAluno, String nome, String cpf, Endereco endereco, Curso curso) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.curso = curso;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void Exibir(){
        System.out.println("idAluno = "+ idAluno +
                            "\nNome: " +nome +
                            "\nCPF: "+cpf +
                            "Endereco: " + endereco +
                            "Curso: " + curso);
    }
}
