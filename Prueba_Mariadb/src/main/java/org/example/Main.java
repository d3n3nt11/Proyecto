package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    // Configuración
    private static final String HOST = "serverless-europe-west2.sysp0000.db2.skysql.com";
    private static final String PORT = "4086";
    private static final String USER = "dbpgf40733334";
    private static final String PASSWORD = "gvUXCh7USAaJt4FOk@Hymbrc9";
    private static final String DB_NAME = "FuegoyPan";

    public static void main(String[] args) {

        // Paso 1: Conectar al servidor (sin DB) para crear la base de datos
        String urlServer = String.format("jdbc:mariadb://%s:%s/?requireSSL=true&useSSL=true", HOST, PORT);

        try (Connection connServer = DriverManager.getConnection(urlServer, USER, PASSWORD)) {

            System.out.println("✓ Conectado al servidor. Creando base de datos...");

            // Crear la base de datos si no existe
            try (Statement stmt = connServer.createStatement()) {
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS `" + DB_NAME + "`");
                System.out.println("✓ Base de datos '" + DB_NAME + "' lista.");
            }

        } catch (SQLException e) {
            System.err.println("Error al crear la DB: " + e.getMessage());
            return;
        }

        // Paso 2: Conectar a la base de datos específica
        String urlDB = String.format("jdbc:mariadb://%s:%s/%s?requireSSL=true&useSSL=true",
                HOST, PORT, DB_NAME);

        try (Connection conn = DriverManager.getConnection(urlDB, USER, PASSWORD)) {

            System.out.println("✓ ¡Conexión exitosa a la base de datos '" + DB_NAME + "'!");

            // Prueba: Crear tabla y hacer INSERT/SELECT
            try (Statement stmt = conn.createStatement()) {

                // Crear tabla de prueba
                String createTable = """
                    CREATE TABLE IF NOT EXISTS usuarios (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL,
                        email VARCHAR(100),
                        fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                    )
                    """;
                stmt.executeUpdate(createTable);
                System.out.println("✓ Tabla 'usuarios' creada/verificada.");

                // Insertar dato de prueba
                //stmt.executeUpdate("INSERT INTO usuarios (nombre, email) VALUES ('Test User', 'test@example.com')");
                //System.out.println("✓ Registro de prueba insertado.");

                // Consultar datos
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
                System.out.println("\n📋 Datos en la tabla 'usuarios':");
                System.out.println("ID | Nombre | Email | Fecha");
                System.out.println("---|--------|-------|------");

                while (rs.next()) {
                    System.out.printf("%d | %s | %s | %s%n",
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("email"),
                            rs.getTimestamp("fecha_registro")
                    );
                }

            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}