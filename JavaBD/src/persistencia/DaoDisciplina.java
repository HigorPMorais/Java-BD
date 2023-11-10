package persistencia;

import java.sql.*;
import modelo.Curso;
import modelo.Disciplina;


public class DaoDisciplina extends Dao{

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
            Integer FK = cu.getIdCurso();
            String sql = """
                         INSERT INTO disciplina(
                         nome, cargaHoraria, semestre,FK_idCurso )
                         VALUES (?, ?, ?, ?);""";

            PreparedStatement ps = criarPreparedStatement(sql);
            dis.setIdDisciplina(gerarProximoId("disciplina", "idDisciplina"));
            ps.setString(1, dis.getNome());
            ps.setString(2, dis.getCargaHoraria());
            ps.setString(3, dis.getSemestre());
            ps.setInt(4, FK);

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
}
