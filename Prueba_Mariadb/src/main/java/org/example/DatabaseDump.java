package org.example;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatabaseDump {

    // Configuración de conexión (MISMOS datos que tu application.properties)
    private static final String HOST = "serverless-europe-west3.sysp0000.db2.skysql.com";
    private static final String PORT = "4068";
    private static final String USER = "dbpgf14695271";
    private static final String PASSWORD = "tLlTOXnUs2SFtWgV30q8V]Rh";
    private static final String DB_NAME = "FuegoyPan";

    // Tablas a exportar
    private static final String[] TABLES = {
            "users",
            "ingredients",
            "products",
            "stock_ingredient",
            "recipe",
            "sales",
            "sale_lines",
            "stock_movement"
    };

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("🗄️  HERRAMIENTA DE DUMP - BASE DE DATOS FUEGOYPAN");
        System.out.println("=".repeat(70));

        // Generar nombre de archivo con fecha
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "fuegoypan_dump_" + timestamp + ".sql";

        String url = String.format("jdbc:mariadb://%s:%s/%s?sslMode=REQUIRED", HOST, PORT, DB_NAME);

        try (Connection conn = DriverManager.getConnection(url, USER, PASSWORD);
             PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            System.out.println("\n✅ Conectado a: " + DB_NAME);
            System.out.println("📁 Archivo de salida: " + fileName);

            // ==========================================
            // CABECERA DEL DUMP
            // ==========================================
            writer.println("-- ============================================");
            writer.println("-- DUMP DE BASE DE DATOS: " + DB_NAME);
            writer.println("-- Fecha: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            writer.println("-- Host: " + HOST);
            writer.println("-- ============================================");
            writer.println();
            writer.println("SET FOREIGN_KEY_CHECKS=0;");
            writer.println("SET NAMES utf8mb4;");
            writer.println();

            // ==========================================
            // EXPORTAR CADA TABLA
            // ==========================================
            for (String table : TABLES) {
                try {
                    exportTable(conn, writer, table);
                    System.out.println("✅ Tabla exportada: " + table);
                } catch (SQLException e) {
                    System.out.println("⚠️  Tabla omitida (no existe): " + table);
                }
            }

            // ==========================================
            // CIERRE DEL DUMP
            // ==========================================
            writer.println();
            writer.println("SET FOREIGN_KEY_CHECKS=1;");
            writer.println();
            writer.println("-- ============================================");
            writer.println("-- FIN DEL DUMP");
            writer.println("-- ============================================");

            System.out.println("\n" + "=".repeat(70));
            System.out.println("✅ DUMP COMPLETADO EXITOSAMENTE");
            System.out.println("📁 Archivo guardado: " + fileName);
            System.out.println("=".repeat(70));

        } catch (SQLException e) {
            System.err.println("\n❌ Error de conexión SQL: " + e.getMessage());
            System.err.println("   SQL State: " + e.getSQLState());
            System.err.println("   Error Code: " + e.getErrorCode());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("\n❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Exporta una tabla completa (estructura + datos)
     */
    private static void exportTable(Connection conn, PrintWriter writer, String tableName) throws SQLException {

        // ==========================================
        // 1. EXPORTAR ESTRUCTURA DE LA TABLA
        // ==========================================
        writer.println("-- --------------------------------------------");
        writer.println("-- TABLA: " + tableName);
        writer.println("-- --------------------------------------------");

        // Obtener CREATE TABLE
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE " + tableName)) {

            if (rs.next()) {
                String createTable = rs.getString(2);
                writer.println("DROP TABLE IF EXISTS `" + tableName + "`;");
                writer.println(createTable + ";");
                writer.println();
            }
        }

        // ==========================================
        // 2. EXPORTAR DATOS
        // ==========================================
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName)) {

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            // Obtener nombres de columnas
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = meta.getColumnName(i);
            }

            int rowCount = 0;
            StringBuilder insert = new StringBuilder();

            while (rs.next()) {
                insert.setLength(0);
                insert.append("INSERT INTO `").append(tableName).append("` (");

                // Columnas
                for (int i = 0; i < columnCount; i++) {
                    insert.append("`").append(columnNames[i]).append("`");
                    if (i < columnCount - 1) insert.append(", ");
                }

                insert.append(") VALUES (");

                // Valores
                for (int i = 0; i < columnCount; i++) {
                    Object value = rs.getObject(i + 1);

                    if (value == null) {
                        insert.append("NULL");
                    } else if (value instanceof String) {
                        // Escapar comillas simples
                        String escaped = value.toString().replace("'", "''");
                        insert.append("'").append(escaped).append("'");
                    } else if (value instanceof Timestamp) {
                        insert.append("'").append(value.toString()).append("'");
                    } else if (value instanceof java.time.LocalDateTime) {
                        insert.append("'").append(value.toString()).append("'");
                    } else if (value instanceof java.time.LocalDate) {
                        insert.append("'").append(value.toString()).append("'");
                    } else {
                        insert.append(value.toString());
                    }

                    if (i < columnCount - 1) insert.append(", ");
                }

                insert.append(");");
                writer.println(insert.toString());
                rowCount++;
            }

            writer.println();
            System.out.println("   └─ " + rowCount + " registros exportados");
        }
    }
}