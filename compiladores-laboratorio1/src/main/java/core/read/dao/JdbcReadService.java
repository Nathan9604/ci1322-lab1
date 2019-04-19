package core.read.dao;

import core.read.dao.ReadDao;
import model.book;
import model.read;

import java.sql.*;

public class JdbcReadService implements ReadDao {
    private Connection conn;

    /*
        Establece la conexión con la base de datos.
     */
    public JdbcReadService() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/Lab1_CI1322?useSSL=false";
        try {
            conn = DriverManager.getConnection(url,"root","Navigo4.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        Busca una relación existente del estudiante con el libro dado.
        @param id_book nos indica el libro que deseamos buscar en la relación.
        @param id_student nos indica el estudiante que deseamos buscar en la relación.
        @return read la relación deseada entre el estudiante y el libro.
     */
    public read findById(String id_book, String id_student) throws SQLException {
        read newRead;

        Statement stmt = conn.createStatement();
        ResultSet rs;

        rs = stmt.executeQuery("SELECT * FROM READ WHERE student_id = " +id_student+ " AND book_id = " +id_book+ ";");
        rs.first();

        try {
            newRead = new read(rs.getString(1), rs.getString(2));
        }
        catch (SQLException e){
            newRead = new read(null, null);
        }

        return newRead;
    }

    /*
        Inserta una nueva relación entre un libro y un estudiante en la base de datos.
        @param entity contiene los datos de la relación que se desea crear.
        @return answer nos indica si la relación se logro almacenar correctamente.
     */
    public String create(read entity){
        String result;

        // create a Statement from the connection
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // insert the data
        try {
            statement.executeUpdate("INSERT INTO READ_ALREADY "
                    + "VALUES ('"+entity.getStudentId()+"', '"+entity.getBookId()+"')");
            result = "Se pudo insertar correctamente la relación entre estudiante y libro en la base de datos.";
        } catch (SQLException e) {
            e.printStackTrace();
            result = "No se pudo insertar correctamente la relación entre estudiante y libro en la base de datos.";
        }

        return result;
    }

    /*
        Actualiza los datos de una relación dada.
        @param entity tiene los datos de la relación que se desea actualizar.
     */
    public void update(read entity){

    }

    /*
        Elimina los datos de una relación entre estudiante y libro.
        @param entity provee los datos de la relación que se desea eliminar.
     */
    public void remove(read entity){

    }
}
