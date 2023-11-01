package controle;

import persistencia.DaoAluno;
import util.Input;


public class controle {
        ControleAluno controleAluno = new ControleAluno();
        DaoAluno daoAl = new DaoAluno();
        
        public void menu(){
            int alt; 
            do {                
                System.out.println("-----------   Menu   -----------");
                System.out.println("0 - Fechar programa");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Listar");
                System.out.println("3 - Atualizar");
                System.out.println("4 - Deletar");
                alt = Input.nextInt();


                switch (alt) {
                    case 1 -> controleAluno.cadastrar();
                    case 2 -> controleAluno.listar();
                    case 3 -> controleAluno.atualizar();
                    case 4 -> controleAluno.deletar();
                }
            } while (alt != 0);
            
        }
         
}
