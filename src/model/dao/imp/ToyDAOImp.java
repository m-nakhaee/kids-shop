package model.dao.imp;

import model.dao.ToyDAO;
import model.entity.Toy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToyDAOImp implements ToyDAO {
    @Override
    public Toy[] getAllToys() {
        List<Toy> toys = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thumbnail_db", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from toy");
            while (resultSet.next()) {
                Toy toy = new Toy(resultSet.getString(2), resultSet.getInt(3));
                toys.add(toy);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return toys.toArray(new Toy[0]);
    }
}
