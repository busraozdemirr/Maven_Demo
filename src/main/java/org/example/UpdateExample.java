package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/veritabani_adi";
        String kullaniciAdi = "postgres";//postgresql kullanıcı adı.
        String sifre = "root";  //postGreSQL defould sifresi
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, kullaniciAdi, sifre);
            //Update işlemi
            String updateSQL = "Update tablo_adi SET name=? WHERE surname=?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setString(1, "yeni isim");
            updateStatement.setString(2, "kaya");
            int affectedRows = updateStatement.executeUpdate();
            System.out.println("update işlemi sonucunda etkilenen satır sayısı:" + affectedRows);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
