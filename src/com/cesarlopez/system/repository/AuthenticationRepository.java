package com.cesarlopez.system.repository;

import com.cesarlopez.system.config.ConexionDB;
import com.cesarlopez.system.model.User;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationRepository implements AuthenticationInterface {

    private CallableStatement callSP;
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    @Override
    public User login(String email, String password) {
        User user = null;
        try {
            callSP = conexionDB.getConnection().prepareCall("{call sp_find_user_by_login(?)}");
            callSP.setString(1, email);
            ResultSet rs = callSP.executeQuery();
            if (rs.next() && rs.getString("password").equals(password)) {
                user = new User();
                user.setName(rs.getString("name"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setUser(rs.getString("user"));
                user.setPassword(rs.getString("password"));
                user.setIdUser(rs.getString("id_user"));
            }
            rs.close();
            callSP.close();
        } catch (SQLException e) {
            System.out.println("Error en login repository");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return user;
    }
}
