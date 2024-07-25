package model.dao.imp;

import model.dao.ToyDAO;
import model.entity.Toy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToyDAOImp implements ToyDAO {


    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thumbnail_db", "root", "root");
        return connection;
    }

    @Override
    public Toy[] getAllToys() {
        List<Toy> toys = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from toy");
            while (resultSet.next()) {
                Toy toy = new Toy(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4));
                toys.add(toy);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return toys.toArray(new Toy[0]);
    }

    @Override
    public void setToys(Toy[] toys) {
        try (Connection connection = getConnection()) {
            PreparedStatement pStatement = connection.prepareStatement("insert into toy values(?, ? , ? ,?)");
            for (Toy toy : toys) {
                pStatement.setInt(1, toy.id());
                pStatement.setString(2, toy.code());
                pStatement.setString(3, toy.name());
                pStatement.setInt(4, toy.price());
                pStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteToys(Toy[] toys) {
        try (Connection connection = getConnection()) {
            PreparedStatement pStatement = connection.prepareStatement("delete from toy where code = ?");
            for (Toy toy : toys) {
                pStatement.setString(1, toy.code());
                pStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateToys(Toy[] toys) {
        try (Connection connection = getConnection()) {
            PreparedStatement pStatement = connection.prepareStatement("update toy set name = ?, price = ? where code = ?");
            for (Toy toy : toys) {
                pStatement.setString(1, toy.name());
                pStatement.setInt(1, toy.price());
                pStatement.setString(1, toy.code());
                pStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
