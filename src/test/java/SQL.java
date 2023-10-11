import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/database";
        String user = "root";
        String password = "1234";

        try {
            // драйвер JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // соединение с базой данных
            Connection connection = DriverManager.getConnection(url, user, password);

            // Создаем объект для выполнения SQL-запросов
            Statement statement = connection.createStatement();

            // Создание юзера с параметрами
            //String insertQuery = "INSERT INTO user (idUser, name, surname) VALUES (7, 'Leo', 'Di Kaprio')";
            //int rowsAffected = statement.executeUpdate(insertQuery);
/**
            if (rowsAffected > 0) {
                System.out.println("Пользователь успешно создан.");
            } else {
                System.out.println("Ошибка при создании пользователя.");
            }
 */

            //String insertQuery = "INSERT INTO user (name, surname) VALUES ('Leo1', 'Di Kaprio 1')";
            //int rowsAffected = statement.executeUpdate(insertQuery);

                 //if (rowsAffected > 0) {
                 //System.out.println("Пользователь успешно создан.");
                 //} else {
                 //System.out.println("Ошибка при создании пользователя.");
                 //}

            /**
                 int userIdToDelete = 10;
            // Выполняем SQL-запрос для удаления пользователя по его ID
            String deleteQuery = "DELETE FROM user WHERE idUser = " + userIdToDelete;
            int rowsAffectedDelete = statement.executeUpdate(deleteQuery);

            if (rowsAffectedDelete > 0) {
                System.out.println("Пользователь успешно удален.");
            } else {
                System.out.println("Пользователь с ID " + userIdToDelete + " не найден.");
            }
             */

            // Выполняем SQL-запрос для выборки данных из таблицы
            String query = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(query);

            int count = 0;

            while (resultSet.next()) {
                // Извлекаем значения столбцов по их именам или индексам
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                System.out.println("ID: " + id + ", Name: " + name + " Surname: " + surname);
                count++;
            }
            System.out.println("Count of users: " + count);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
