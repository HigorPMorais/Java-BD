package controle;


import modelo.Disciplina;
import persistencia.DaoDisciplina;
import util.Input;


public class ControleDisciplina {

    DaoDisciplina daoDisciplina = new DaoDisciplina();
    Disciplina dis = new Disciplina();
    
    public void setarDados(Disciplina dis){
        System.out.println("-------   Menu de Cadastro de Disciplina   -------\n");
        
        System.out.println("Informe o nome da disciplina: ");
        dis.setNome(Input.nextLine());
        System.out.println("Informe a Carga Horaria: ");
        dis.setCargaHoraria(Input.nextLine());
        System.out.println("Informe o Semestre: ");
        dis.setSemestre(Input.nextLine());   
    }
    
    public Disciplina cadastrar(){ 
        setarDados(dis);
        daoDisciplina.salvar(dis);
        daoDisciplina.carregarDisciplina(dis);
        
        return dis;
    }
    
    public void listar(){
        System.out.println("-------   Listando as Disciplinas   -------\n");
        daoDisciplina.listar();
    }
    
    public void atualizar(){
        System.out.println("-------   Menu de Atualização   -------\n");
        
        System.out.println("Informe o nome da disciplina: ");
        dis.setNome(Input.nextLine());
        System.out.println("Informe a Carga Horaria: ");
        dis.setCargaHoraria(Input.nextLine());
        System.out.println("Informe o Semestre: ");
        dis.setSemestre(Input.nextLine());   
        
        daoDisciplina.atualizar(dis);
        daoDisciplina.carregarDisciplina(dis);
    }
    
    public void remover(){
        daoDisciplina.remover(dis);
    }
}

