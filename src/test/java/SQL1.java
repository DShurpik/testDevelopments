import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQL1 {
    public static void main(String[] args) {
        // JDBC URL, пользователь и пароль к базе данных MySQL
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
            String insertQuery = "INSERT INTO user (id, name, surname) VALUES (10, 'Leo', 'Di Kaprio')";
            int rowsAffected = statement.executeUpdate(insertQuery);

            if (rowsAffected > 0) {
                System.out.println("Пользователь успешно создан.");
            } else {
                System.out.println("Ошибка при создании пользователя.");
            }

            // Выполняем SQL-запрос для выборки данных из таблицы
            String query = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(query);

            List<Integer> userIdsToDelete = new ArrayList<>();

            while (resultSet.next()) {
                // Извлекаем значения столбцов по их именам или индексам
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                System.out.println("ID: " + id + ", Name: " + name + ", Surname: " + surname);

                // Добавляем ID пользователя для удаления в список
                userIdsToDelete.add(id);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
