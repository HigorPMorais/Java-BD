package controle;

import modelo.Aluno;
import persistencia.DaoAluno;
import util.Input;

public class ControleAluno {
    DaoAluno daoAluno = new DaoAluno();
    ControleEndereco controlEnd = new ControleEndereco();
    ControleCurso ControlCu = new ControleCurso();
    
    
    public void setarDados(Aluno al){
        System.out.println("-------   Menu de Cadastro do Aluno   -------");
        System.out.println("Insira o seu nome: ");
        al.setNome(Input.nextLine());
        System.out.println("Insira o seu CPF: ");
        al.setCpf(Input.nextLine());
        
        al.setEndereco(controlEnd.cadastrar());
        al.setCurso(ControlCu.cadastrar());
        
        
    }
    
    public void cadastrar(){
         Aluno al = new Aluno();
         setarDados(al);
         daoAluno.salvar(al);
         daoAluno.carregarAlunos();
    }
    
    public void listar(){
        daoAluno.listar();
    }
    
    public void deletar(){
        System.out.println("Informe a ID do aluno que voce deseja remover: ");
        int resp = Input.nextInt();
        
        Aluno al = daoAluno.carregarPorId(resp);
        daoAluno.remover(al);
    }
    
    public void atualizar(){
        System.out.println("Informe a ID do aluno que voce deseja atualizar: ");
        int resp = Input.nextInt();
        
        Aluno al = daoAluno.carregarPorId(resp);
        daoAluno.atualizar(al);
    }
    
}
