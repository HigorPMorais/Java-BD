package controle;

import modelo.Curso;
import modelo.Endereco;
import persistencia.DaoCurso;
import util.Input;

public class ControleCurso {
    DaoCurso daoCurso = new DaoCurso();
    Curso cu = new Curso();
    
    public void setarDados(Curso cu){
        System.out.println("-------   Menu de Cadastro do Endereço   -------\n");
        
        System.out.println("Informe o nome da sua cidade: ");
        cu.setNome(Input.nextLine());
        System.out.println("Informe o nome da sua rua: ");
        cu.setCargaHoraria(Input.nextLine());
        System.out.println("Informe o numero de sua residencia: ");
        cu.setQtdSemestres(Input.nextLine());   
    }
    
    public Curso cadastrar(){ 
        setarDados(cu);
        daoCurso.salvar(cu);
        daoCurso.carregarCursos(cu);
        
        return cu;
    }
    
    public void listar(){
        System.out.println("-------   Listando os cursos   -------\n");
        daoCurso.listar();
    }
    
    public void atualizar(){
        System.out.println("-------   Menu de Atualização   -------\n");
        
        System.out.println("Informe o nome da sua cidade: ");
        cu.setNome(Input.nextLine());
        System.out.println("Informe o nome da sua rua: ");
        cu.setCargaHoraria(Input.nextLine());
        System.out.println("Informe o numero de sua residencia: ");
        cu.setQtdSemestres(Input.nextLine());   
        
        daoCurso.atualizar(cu);
        daoCurso.carregarCursos(cu);
    }
    
    public void remover(){
        daoCurso.remover(cu);
    }
}
