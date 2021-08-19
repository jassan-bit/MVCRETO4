package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {

    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        Connection connection = JDBCUtilities.getConnection();

        ArrayList<Requerimiento_1Vo> listado_registros_rq1 = new ArrayList<Requerimiento_1Vo>();

        String sql = "SELECT Ciudad_Residencia, ROUND(AVG(Salario)) Promedio " +
        "FROM Lider GROUP BY Ciudad_Residencia HAVING Promedio < 500000 " +
        "ORDER BY Promedio DESC;";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Requerimiento_1Vo requerimiento1 = new Requerimiento_1Vo();
                requerimiento1.setCiudadResidencia(rs.getString("Ciudad_REsidencia"));
                requerimiento1.setPromedio(rs.getDouble("Promedio"));
                listado_registros_rq1.add(requerimiento1);
            }
        }
        return listado_registros_rq1;
    }
}
© 2021 GitHub, Inc.