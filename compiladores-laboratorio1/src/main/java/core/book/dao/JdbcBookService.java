package core.book.dao;

import core.book.dao.BookDao;
import model.book;

import java.sql.*;

public class JdbcBookService implements BookDao {
    private Connection conn;

    /*
        Establece la conexión con la base de datos.
     */
    public JdbcBookService() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/Lab1_CI1322?useSSL=false";

        try {
            conn = DriverManager.getConnection(url,"root","Navigo4.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        Busca el libro con el identificador deseado.
        @param id nos indica el libro que deseamos buscar.
        @return book el cual tiene los datos del libro deseado.
     */
    public book findById(String id) throws SQLException {
        book newBook;

        Statement stmt = conn.createStatement();
        ResultSet rs;

        rs = stmt.executeQuery("SELECT * FROM BOOK WHERE id = " +id+ ";");
        rs.first();

        try {
            newBook = new book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getInt(4));
        }
        catch (SQLException e){
            newBook = new book(null, null, null, null, 0);
        }

        return newBook;
    }

    /*
        Inserta un nuevo libro en la base de datos.
        @param entity contiene los datos del libro que se desea insertar.
        @return answer nos indica si el libro se logro almacenar correctamente.
     */
    public String create(book entity){
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
            statement.executeUpdate("INSERT INTO BOOK "
                    + "VALUES ('"+entity.getId()+"', '"+entity.getName()+"', '"+entity.getAuthor()+"', '"+entity.getEdition()+"', '"+entity.getGenre()+"')");
            result = "Se pudo insertar correctamente el libro en la base de datos.";
        } catch (SQLException e) {
            e.printStackTrace();
            result = "No se pudo insertar correctamente el libro en la base de datos.";
        }

        return result;
    }

    /*
        Actualiza los datos de un libro dado.
        @param entity tiene los datos del libro que se desea actualizar.
     */
    public void update(book entity){
    }

    /*
        Elimina un libro de la base de datos.
        @param entity provee los datos del libro que se desea eliminar.
     */
    public void remove(book entity){
    }
}
