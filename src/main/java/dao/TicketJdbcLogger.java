package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketJdbcLogger implements TicketDAO {

    List<Ticket> tickets = new ArrayList<Ticket>();
    Settings settings = Settings.getInstance();
    Connection connection;

    public TicketJdbcLogger() {
        try {
            Class.forName(settings.value("jdbc.driver_class"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTicket(Ticket ticket) {
        String sql = "INSERT INTO tickets values (?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.setString(2, ticket.getType());
            preparedStatement.setString(3, ticket.getDate());
            preparedStatement.setString(4, ticket.getTime());
            preparedStatement.setFloat(5, ticket.getPayment());
            preparedStatement.setInt(6, ticket.getQuantity());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> selectAll() {

        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery("SELECT * FROM tickets")) {
            while (rs.next()) {
                tickets.add(new Ticket(rs.getInt("id"), rs.getString("type"), rs.getString("date"), rs.getString("time"), rs.getFloat("payment"), rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public void deleteAll() {
        String sql = "DELETE FROM tickets";
        try(Statement statement = connection.createStatement()){
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
