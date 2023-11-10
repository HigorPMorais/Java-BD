package persistencia;

import java.sql.*;
import modelo.Aluno;
import java.util.*;

public class DaoAluno extends Dao {
    private DaoEndereco daoEndereco;
    private DaoCurso daoCurso;
    ArrayList<Aluno> listaAlunos = new ArrayList<>();
    
    public DaoAluno() {
        daoEndereco = new DaoEndereco();
        daoCurso = new DaoCurso();
    }

    public ArrayList<Aluno> carregarAlunos() {
        try {
            String sql = """
                         SELECT * FROM aluno as al
                         left join endereco as ed on idEndereco = al.FK_idEndereco
                         left join curso as cu on idCurso = al.FK_idCurso""";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Aluno p = new Aluno();
                p.setIdAluno(rs.getInt("idAluno"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));

                if (rs.getObject("idEndereco", Integer.class) != null) {
                    p.getEndereco().setIdEndereco(rs.getInt("idEndereco"));
                    p.getEndereco().setCidade(rs.getString("cidade"));
                    p.getEndereco().setRua(rs.getString("rua"));
                    p.getEndereco().setNumero(rs.getString("numero"));
                }
                if(rs.getObject("idCurso", Integer.class) != null){
                    p.getCurso().setIdCurso(rs.getInt("idCurso"));
                    p.getCurso().setNome(rs.getString("nome"));
                    p.getCurso().setCargaHoraria("cargaHoraria");
                    p.getCurso().setQtdSemestres("qtdSemestres");
                }
        
                listaAlunos.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Falha ao carregar alunos!\n" + e.getMessage());
        }
        return listaAlunos;
    }

    public Aluno carregarPorId(int idAluno) {
        Aluno cl = null;
        try {
            String sql = """
                         SELECT * FROM aluno as al
                         left join endereco as ed on idEndereco = al.FK_idEndereco 
                         left join curso as cu on idCurso = al.FK_idCurso
                         where al.idAluno = """ + idAluno;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                cl = new Aluno();
                cl.setIdAluno(rs.getInt("idAluno"));
                cl.setNome(rs.getString("nome"));
                cl.setCpf(rs.getString("cpf"));

                if (rs.getObject("idEndereco", Integer.class) != null) {
                    cl.getEndereco().setIdEndereco(rs.getInt("idEndereco"));
                    cl.getEndereco().setCidade(rs.getString("cidade"));
                    cl.getEndereco().setRua(rs.getString("rua"));
                    cl.getEndereco().setNumero(rs.getString("numero"));
                }
                if(rs.getObject("idCurso", Integer.class) != null){
                    cl.getCurso().setIdCurso(rs.getInt("idCurso"));
                    cl.getCurso().setNome(rs.getString("nome"));
                    cl.getCurso().setCargaHoraria("cargaHoraria");
                    cl.getCurso().setQtdSemestres("qtdSemestres");
                }
            }
        } catch (SQLException e) {
            System.out.println("Falha ao carregar aluno!\n"
                    + e.getMessage());
        }
        return cl;
    }

    public boolean salvar(Aluno aluno) {
        try {
            String sql = """
                         INSERT INTO aluno(
                          nome, cpf, FK_idEndereco, FK_idCurso)
                          VALUES ( ?, ?, ?, ?)""";

            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());

            if (aluno.getEndereco() != null) {
                if (aluno.getEndereco().getIdEndereco() == null || aluno.getEndereco().getIdEndereco() == 0) {
                    daoEndereco.salvar(aluno.getEndereco());
                }
                ps.setInt(3, aluno.getEndereco().getIdEndereco());
            } else {
                ps.setObject(3, null);
            }
            
            if (aluno.getCurso() != null) {
                if (aluno.getCurso().getIdCurso() == null || aluno.getCurso().getIdCurso() == 0) {
                    daoCurso.salvar(aluno.getCurso());
                }
                ps.setInt(4, aluno.getCurso().getIdCurso());
            } else {
                ps.setObject(4, null);
            }
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            try {
                getConexao().rollback();
            } catch (SQLException ex1) {
                System.out.println("Falhar ao realizar RollBack");
            }
            System.out.println("Falha ao salvar Aluno\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Aluno aluno) {
        try {
            String sql = """
                         UPDATE aluno
                         SET nome=?, cpf=?, tel=?, idEndereco=?, idCurso=? 
                          WHERE idAluno= """ + aluno.getIdAluno();

            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());
            
            if (aluno.getEndereco() != null) {
                if (aluno.getEndereco().getIdEndereco() == null) {
                    daoEndereco.salvar(aluno.getEndereco());
                } else {
                    daoEndereco.atualizar(aluno.getEndereco());
                }
                ps.setInt(3, aluno.getEndereco().getIdEndereco());
            } else {
                ps.setObject(3, null);
            }
            
            if(aluno.getCurso() != null){
                if(aluno.getCurso().getIdCurso() == null){
                    daoCurso.salvar(aluno.getCurso());
                } else{
                    daoCurso.atualizar(aluno.getCurso());
                }
                ps.setInt(4, aluno.getCurso().getIdCurso());
            }else{
                ps.setObject(4, null);
            }

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar aluno!\n" + e.getMessage());
            return false;
        }
    }

    public boolean remover(Aluno aluno) {
        try {
            String sql = """
                         DELETE FROM aluno
                          WHERE idAluno = ?""" + aluno.getIdAluno()
                    + "; " + daoEndereco.comandoSqlRemover(aluno.getEndereco()) + daoCurso.comandoSqlRemover(aluno.getCurso());

            executeSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao remover aluno!\n" + e.getMessage());
            return false;
        }
    }
    
    public void listar(){
        listaAlunos = carregarAlunos();
        for (Aluno listaAluno : listaAlunos) {
            System.out.println("-----------------------------------------");
            listaAluno.exibir();
        }
    }    
}
