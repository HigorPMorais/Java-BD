package controle;

import modelo.Endereco;
import persistencia.DaoEndereco;
import util.Input;

public class ControleEndereco {
    DaoEndereco daoEndereco = new DaoEndereco();
    
    public void setarDados(Endereco end){
        System.out.println("-------   Menu de Cadastro do Endereço   -------\n");
        
        System.out.println("Informe o nome da sua cidade: ");
        end.setCidade(Input.nextLine());
        System.out.println("Informe o nome da sua rua: ");
        end.setRua(Input.nextLine());
        System.out.println("Informe o numero de sua residencia: ");
        end.setNumero(Input.nextLine());   
    }
    
    public Endereco cadastrar(){
        Endereco end = new Endereco();
        setarDados(end);
        daoEndereco.salvar(end);
        daoEndereco.carregarEnderecos();
        
        return end;
    }
}
