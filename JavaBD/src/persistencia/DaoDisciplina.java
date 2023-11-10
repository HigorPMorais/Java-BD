package persistencia;

import java.sql.*;
import java.util.*;
import modelo.Disciplina;


public class DaoDisciplina extends Dao{
ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public ArrayList<Disciplina> carregarDisciplina(Disciplina dis){
        try {
            String sql = "select * from disciplina";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                dis.setIdDisciplina(rs.getInt("idDisciplina"));
                dis.setNome(rs.getString("nome"));
                dis.setCargaHoraria(rs.getString("cargaHoraria"));
                dis.setSemestre(rs.getString("Semestre"));

                disciplinas.add(dis);
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar a matrix do CUrso!\n" + ex.getMessage());
        }
        return disciplinas;
    }

    public Disciplina carregarCursoPorId(int idDisciplina) {
        Disciplina dis = null;
        try {
            String sql = "select * from disciplina where idDisciplina = " + idDisciplina;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                dis = new Disciplina();
                dis.setIdDisciplina(rs.getInt("idDisciplina"));
                dis.setNome(rs.getString("nome"));
                dis.setCargaHoraria(rs.getString("cargaHoraria"));
                dis.setSemestre(rs.getString("Semestres"));
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar cuereço!\n" + ex.getMessage());
        }
        return dis;
    }

    public boolean salvar(Disciplina dis) {
        try {
            String sql = """
                         INSERT INTO disciplina(
                          idDisciplina, nome, cargaHoraria, semestre )
                          VALUES (?, ?, ?, ?);""";

            PreparedStatement ps = criarPreparedStatement(sql);
            dis.setIdDisciplina(gerarProximoId("disciplina", "idDisciplina"));
            ps.setInt(1, dis.getIdDisciplina());
            ps.setString(2, dis.getNome());
            ps.setString(3, dis.getCargaHoraria());
            ps.setString(4, dis.getSemestre());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha ao salvar curso na matrix\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Disciplina dis) {
        try {
            String sql = """
                         UPDATE disciplina
                          SET nome=?, cargaHoraria=?, semestre=?
                          WHERE idDisciplina =""" + dis.getIdDisciplina();

            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, dis.getNome());
            ps.setString(2, dis.getCargaHoraria());
            ps.setString(3, dis.getSemestre());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha ao editar disciplina da Matrix\n" + ex.getMessage());
            return false;
        }
    }

    public String comandoSqlRemover(Disciplina dis) {
        return "DELETE FROM disciplina WHERE idDisciplina = " + dis.getIdDisciplina();
    }

    public boolean remover(Disciplina dis) {
        try {
            executeSql(comandoSqlRemover(dis));
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao remover disciplina da matrix\n" + e.getMessage());
            return false;
        }
    }
    
    public void listar(){
        for (Disciplina disciplina : disciplinas) {
            System.out.println("ID: " +disciplina.getIdDisciplina());
            System.out.println("Nome: "+disciplina.getNome());
            System.out.println("Carga Horaria: " + disciplina.getCargaHoraria());
            System.out.println("Semestre: " +disciplina.getSemestre());
        }
    }

}
