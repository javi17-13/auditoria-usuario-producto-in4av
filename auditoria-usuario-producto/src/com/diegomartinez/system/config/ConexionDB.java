package com.diegomartinez.system.config;

public class ConexionDB {
    
    private static ConexionDB instanciaConexionDB;
    
    private ConexionDB() {
    
    }

    public void connect(String a1, String a2, String a3) {
        try {
            connect(Enviroment.USER, Enviroment.PASSWORD, Enviroment.DATA_BASE);
        } catch (Exception e) {
        
        }
    }
}
