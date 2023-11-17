package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Users;
import model.Games;

public class Controller {
    public class Table {
        public String[] columns;
        public String[][] data;

        public Table(String[] columns, String[][] data) {
            this.columns = columns;
            this.data = data;
        }
    }

    private DatabaseHandler conn = new DatabaseHandler();

    public Controller() { }

    public boolean gameBought(String idUser, String idGame) {
        try {
            conn.open();

            Statement statement = conn.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `transactions` WHERE user_id=" + idUser + " AND id_game=" + idGame);

            if (!result.isBeforeFirst()) {
                return null;
            }

            while(result.next()) {
                Games game = new Games(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("genre"),
                    result.getInt("price")
                );
                games.add(game);
            }

            result.close();
            conn.close();
            
            return games.toArray(new Games[games.size()]);
    }

    public int buyGame(String idUser, String idGame) {
        try {
            conn.open();

            Statement statement = conn.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `games`");

            if (!result.isBeforeFirst()) {
                return null;
            }

            while(result.next()) {
                Games game = new Games(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("genre"),
                    result.getInt("price")
                );
                games.add(game);
            }

            result.close();
            conn.close();
            
            return games.toArray(new Games[games.size()]);
    }

    public Games[] getGames() {
        ArrayList<Games> games = new ArrayList<>();

        try {
            conn.open();

            Statement statement = conn.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `games`");

            if (!result.isBeforeFirst()) {
                return null;
            }

            while(result.next()) {
                Games game = new Games(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("genre"),
                    result.getInt("price")
                );
                games.add(game);
            }

            result.close();
            conn.close();
            
            return games.toArray(new Games[games.size()]);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Users login(String email, String password) {
        try {
            conn.open();

            Statement statement = conn.connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT * FROM `users` WHERE `email`='" + email + "' AND `password`='"
                            + password + "'");

            Users user = null;

            if (!result.isBeforeFirst()) {
                return null;
            }

            result.next();
            user = new Users(
                result.getInt("id"),
                result.getString("name"),
                result.getString("email"),
                result.getString("password")
            );

            conn.close();
            
            return user;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public Table getTransactions(String idUser) {
        try {
            conn.open();

            String sql = "SELECT " + 
            "transactions.id AS 'id', " +
            "transactions.user_id AS 'user_id', " +
            "users.name AS 'user_name', " +
            "transactions.game_id AS 'game_id', " +
            "games.name AS 'game_name', " +
            "games.price AS 'total_price' " +
            "FROM transactions " +
            "JOIN users ON users.id = transactions.user_id " +
            "JOIN games ON games.id = transactions.game_id " +
            "WHERE transactions.user_id = '1';";

            Statement statement = conn.connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            String[] column = new String[] { "id", "user_id", "user_name", "game_id", "game_name", "total_price" };
            String[][] data = new String[100][6];
            int counter = 0;
            while (result.next()) {
                data[counter][0] = result.getString("id");
                data[counter][1] = result.getString("user_id");
                data[counter][2] = result.getString("user_name");
                data[counter][3] = result.getString("game_id");
                data[counter][4] = result.getString("game_name");
                data[counter][5] = result.getString("total_price");
                counter++;
            }

            statement.close();
            conn.close();

            return new Table(column, data);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
