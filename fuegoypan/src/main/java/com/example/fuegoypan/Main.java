package com.example.fuegoypan; // Ajusta esto a tu paquete real

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // ================= CONFIGURACIÓN =================
    private static final String URL = "jdbc:mariadb://127.0.0.1:3306/fuegoypan";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String OUTPUT_FILE = "C:\\Users\\usuario\\Desktop\\fuegoypan_backup.sql";
    // =================================================

    public static void main(String[] args) {
        System.out.println("🚀 Iniciando backup de fuegoypan...");

        try {
            // Cargar el driver de MariaDB (ya incluido en tu proyecto Spring Boot)
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ No se encontró el driver. Asegúrate de ejecutar esto dentro del proyecto Spring Boot.");
            e.printStackTrace();
            return;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {

            System.out.println("✅ Conectado a la base de datos.");

            // Cabecera del archivo SQL
            writer.write("-- Backup generado automáticamente\n");
            writer.write("-- Base de datos: fuegoypan\n");
            writer.write("SET FOREIGN_KEY_CHECKS = 0;\n\n");

            // 1. Obtener lista de tablas
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet tables = meta.getTables(null, null, "%", new String[]{"TABLE"});

            List<String> tableNames = new ArrayList<>();
            while (tables.next()) {
                tableNames.add(tables.getString("TABLE_NAME"));
            }
            System.out.println("📋 Tablas encontradas: " + tableNames.size());

            // 2. Procesar cada tabla
            for (String tableName : tableNames) {
                System.out.println("📦 Procesando: " + tableName);

                // A) Estructura (CREATE TABLE)
                writeCreateTable(conn, writer, tableName);

                // B) Datos (INSERT INTO)
                writeTableData(conn, writer, tableName);

                writer.write("\n");
            }

            writer.write("SET FOREIGN_KEY_CHECKS = 1;\n");
            System.out.println("\n✅ ¡ÉXITO! Backup guardado en: " + OUTPUT_FILE);

        } catch (SQLException | IOException e) {
            System.err.println("❌ Error durante el backup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Escribe la sentencia CREATE TABLE
    private static void writeCreateTable(Connection conn, BufferedWriter writer, String tableName) throws SQLException, IOException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE `" + tableName + "`");

        if (rs.next()) {
            String createSQL = rs.getString(2);
            writer.write("-- Estructura: " + tableName + "\n");
            writer.write("DROP TABLE IF EXISTS `" + tableName + "`;\n");
            writer.write(createSQL + ";\n\n");
        }
        rs.close();
        stmt.close();
    }

    // Escribe los INSERT con los datos
    private static void writeTableData(Connection conn, BufferedWriter writer, String tableName) throws SQLException, IOException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM `" + tableName + "`");
        ResultSetMetaData rsMeta = rs.getMetaData();
        int columnCount = rsMeta.getColumnCount();

        int rows = 0;
        while (rs.next()) {
            StringBuilder insert = new StringBuilder("INSERT INTO `" + tableName + "` (");

            // Nombres de columnas
            for (int i = 1; i <= columnCount; i++) {
                insert.append("`").append(rsMeta.getColumnName(i)).append("`");
                if (i < columnCount) insert.append(", ");
            }
            insert.append(") VALUES (");

            // Valores
            for (int i = 1; i <= columnCount; i++) {
                Object value = rs.getObject(i);
                if (value == null) {
                    insert.append("NULL");
                } else if (value instanceof Number || value instanceof Boolean) {
                    insert.append(value);
                } else {
                    // Escapar strings para SQL
                    String escaped = value.toString()
                            .replace("\\", "\\\\")
                            .replace("'", "''"); // Escape estándar SQL
                    insert.append("'").append(escaped).append("'");
                }
                if (i < columnCount) insert.append(", ");
            }
            insert.append(");\n");
            writer.write(insert.toString());
            rows++;
        }
        System.out.println("   ↳ " + rows + " filas exportadas.");
        rs.close();
        stmt.close();
    }
}