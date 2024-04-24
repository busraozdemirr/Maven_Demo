import java.sql.*;

public class InsertAndSelect {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/veritabani_adi";
        String kullaniciAdi = "postgres";//kullanıcı adı.
        String sifre = "root";  //postGreSQL standart db sifresi
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, kullaniciAdi, sifre);
//            String createSQL = "CREATE TABLE public.tablo_adi(name character varying(255),surname character varying(255));";
//            PreparedStatement createStatement = connection.prepareStatement(createSQL);
//            createStatement.executeQuery();
//            connection.close();

            //INSERT İŞLEMİ
            String insertSQL="INSERT INTO public.tablo_adi(\n"+
                "\tname,surname)\n"+
                    "\tVALUES(?, ?);";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
            insertStatement.setString(1,"Elif");
            insertStatement.setString(2,"ER");


            int affectedRows=insertStatement.executeUpdate();
            System.out.println("insert islemi sonucunda etkilenen satır sayısı:"+affectedRows);

//            SELECT İSLEMİ
//            String selectSQL="SELECT*FROM tablo_adi";
//            PreparedStatement selectStatement=connection.prepareStatement(selectSQL);
//            ResultSet resultSet=selectStatement.executeQuery();
//         while (resultSet.next()){
//             String sutun1Degeri = resultSet.getString("name");
//             String sutun2Degeri =resultSet.getString("surname");
//             System.out.println("Name:"+sutun1Degeri+"\nsurname:"+sutun2Degeri);
////         }
         connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

