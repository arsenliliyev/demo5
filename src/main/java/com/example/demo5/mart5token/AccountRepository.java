package com.example.demo5.mart5token;

//import com.example.prodem.model.Account;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountRepository {


    public Brand getAccountById(long id) {
        Brand brend = null;
        try {



            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Connection connection = DriverManager.getConnection(url, "postgres", "saxon1876");
            String sql = "SELECT * FROM cars.brands where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id1 = rs.getInt("id");
                String name1 = rs.getString("name");
                brend = new Brand(id1, name1);
            }


            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return brend;


    }

    public Brand saveAccount(Brand newAccount) {

        int id=0;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Connection connection = DriverManager.getConnection(url, "postgres", "saxon1876");
            String sql = "insert into cars.brands values(nextval('cars.brands_id_seq'), ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newAccount.getName());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            // Get the ID of the newly inserted row
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return getAccountById(id);




    }
}
