package mx.uv.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    
    private conexion conexion = new conexion();

    public String crearUsuario(usuario u) {

        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        String msj = "";

        con = conexion.getConnection();

        try {

            String sql = "INSERT INTO usuarios (id, email, password) VALUES (?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getEmail());
            stm.setString(3, u.getPassword());

            if( stm.executeUpdate()>0 ){

                msj = "El usuario fue agregado";

            } else {

                msj = "El usuario no se agrego";

            }

        } catch (Exception e) {
            
            e.printStackTrace();

        } finally {

            if( stm != null ) {

                try {

                    stm.close();

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

            try {

                con.close();

            } catch (Exception e) {

                e.printStackTrace();
                
            }

        }

        return msj;

    }

    public List<usuario> listaUsuario() {
        
        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;
        List<usuario> resultado = new ArrayList<>();

        con = conexion.getConnection();
        
        try {
            
            String sql = "SELECT * FROM usuarios";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {

                usuario u = new usuario(rs.getString("id"), rs.getString("email"), rs.getString("password"));
                resultado.add(u);

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (rs != null) {

                try {
                    
                    rs.close();

                } catch(SQLException e) {

                    e.printStackTrace();

                }

                rs = null;
            }

            if (stm != null) {

                try {

                    stm.close();

                } catch(SQLException e) {

                    e.printStackTrace();

                }

                stm = null;
            }

            try {

                con.close();

            } catch(Exception e) {

                e.printStackTrace();

            }

        }

        return resultado;

    }

}
