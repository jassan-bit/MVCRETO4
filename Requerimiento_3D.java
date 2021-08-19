package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        Connection connection = JDBCUtilities.getConnection();
        
        ArrayList<Requerimiento_3Vo> listado_registros_rq3 = new ArrayList<Requerimiento_3Vo>();
        String sql = "SELECT p.ID_Proyecto, mc.Nombre_Material " +
        "FROM Proyecto p JOIN Compra c ON (p.ID_Proyecto = c.ID_Proyecto) " +
        "JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion) " +
        "WHERE p.ID_Proyecto BETWEEN 20 and 35 " +
        "ORDER BY p.ID_Proyecto ASC;";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Requerimiento_3Vo requerimiento3 = new Requerimiento_3Vo();
                requerimiento3.setIdProyecto(rs.getInt("ID_Proyecto"));
                requerimiento3.setMaterial(rs.getString("Nombre_Material"));
                listado_registros_rq3.add(requerimiento3);
            }
        }
        return listado_registros_rq3;
    }
}