    package org.example;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.Statement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    public class Main {

        // Configuración
        private static final String HOST = "serverless-europe-west3.sysp0000.db2.skysql.com";
        private static final String PORT = "4068";
        private static final String USER = "dbpgf14695271";
        private static final String PASSWORD = "tLlTOXnUs2SFtWgV30q8V]Rh";
        private static final String DB_NAME = "FuegoyPan";

        public static void main(String[] args) {

            // ✅ Paso 1: Conectar al servidor (sin DB) para crear la base de datos si no existe
            String urlServer = String.format("jdbc:mariadb://%s:%s/?requireSSL=true&useSSL=true", HOST, PORT);

            try (Connection connServer = DriverManager.getConnection(urlServer, USER, PASSWORD)) {
                System.out.println("✓ Conectado al servidor. Verificando base de datos...");

                try (Statement stmt = connServer.createStatement()) {
                    stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS `" + DB_NAME + "`");
                    System.out.println("✓ Base de datos '" + DB_NAME + "' lista.");
                }
            } catch (SQLException e) {
                System.err.println("❌ Error al verificar la DB: " + e.getMessage());
                return;
            }

            // ✅ Paso 2: Conectar a la base de datos específica
            String urlDB = String.format("jdbc:mariadb://%s:%s/%s?requireSSL=true&useSSL=true",
                    HOST, PORT, DB_NAME);

            // ✅ Paso 3: Arreglar la tabla recipe
            System.out.println("\n🔧 Arreglando tabla recipe...");

            try (Connection conn = DriverManager.getConnection(urlDB, USER, PASSWORD);
                 Statement stmt = conn.createStatement()) {

                // 1. Eliminar clave primaria compuesta si existe
                try {
                    stmt.executeUpdate("ALTER TABLE recipe DROP PRIMARY KEY");
                    System.out.println("✓ Clave primaria eliminada");
                } catch (SQLException e) {
                    System.out.println("ℹ Clave primaria ya eliminada o no existía: " + e.getMessage());
                }

                // 2. Agregar columna id autoincremental como nueva PK
                try {
                    stmt.executeUpdate("ALTER TABLE recipe ADD COLUMN id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST");
                    System.out.println("✓ Columna 'id' agregada a recipe como PRIMARY KEY");
                } catch (SQLException e) {
                    System.out.println("ℹ Columna 'id' ya existe o hubo error: " + e.getMessage());
                }

                // 3. Agregar índice único para evitar duplicados (opcional pero recomendado)
                try {
                    stmt.executeUpdate("ALTER TABLE recipe ADD UNIQUE KEY unique_product_ingredient (product_id, ingredient_id)");
                    System.out.println("✓ Índice único agregado");
                } catch (SQLException e) {
                    System.out.println("ℹ Índice ya existe: " + e.getMessage());
                }

                // 4. Verificar estructura final
                ResultSet rs = stmt.executeQuery("DESCRIBE recipe");
                System.out.println("\n📋 Estructura actual de 'recipe':");
                System.out.println("Field | Type | Null | Key | Default | Extra");
                System.out.println("------|------|------|-----|---------|------");
                while (rs.next()) {
                    System.out.printf("%s | %s | %s | %s | %s | %s%n",
                            rs.getString("Field"),
                            rs.getString("Type"),
                            rs.getString("Null"),
                            rs.getString("Key"),
                            rs.getString("Default"),
                            rs.getString("Extra")
                    );
                }

                // 5. Verificar datos existentes
                rs = stmt.executeQuery("SELECT COUNT(*) as total FROM recipe");
                if (rs.next()) {
                    System.out.println("\n📊 Registros en recipe: " + rs.getInt("total"));
                }

            } catch (SQLException e) {
                System.err.println("❌ Error al arreglar recipe: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("\n✅ Proceso finalizado. Ahora puedes ejecutar tu aplicación Spring Boot.");
        }
    }