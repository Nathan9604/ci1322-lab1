package core.student.dao;

import core.student.dao.StudentDao;
import model.book;
import model.student;

import java.sql.*;

public class JdbcStudentService implements StudentDao {
    private Connection conn;

    /*
        Establece la conexión con la base de datos.
     */
    public JdbcStudentService() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/Lab1_CI1322?useSSL=false";
        try {
            conn = DriverManager.getConnection(url,"root","Navigo4.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        Busca un estudiante en base a su identificador.
        @param id identificador del estudiante.
        @return student que posee el identificador deseado.
     */
    public student findById(String id) throws SQLException {
        student newStudent;

        Statement stmt = conn.createStatement();
        ResultSet rs;

        rs = stmt.executeQuery("SELECT * FROM STUDENT WHERE id = " +id+ "");
        rs.first();

        try {
            newStudent = new student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
        }
        catch(SQLException e) {
            newStudent = new student(null, null, null, null, 0);
        }

        return newStudent;
    }

    /*
        Crea un nuevo estudiante en la base de datos.
        @param entity datos del estudiante que se desea ingresar en la base de datos.
        @return answer que nos indica si el estudiante se ingreso correctamente o no.
     */
    public String create(student entity) throws SQLException {
        String result;

        // create a Statement from the connection
        Statement statement = conn.createStatement();

        // insert the data
        try {
            statement.executeUpdate("INSERT INTO STUDENT "
                    + "VALUES ('"+entity.getId()+"', '"+entity.getName()+"', '"+entity.getLastName()+"', '"+entity.getNumTel()+"', '"+entity.getAge()+"')");
            result = "Se pudo insertar correctamente el estudiante en la base de datos.";
        } catch (SQLException e) {
            e.printStackTrace();
            result = "No se pudo insertar correctamente el estudiante en la base de datos.";
        }

        return result;
    }

    /*
        Actualiza los datos del estudiante deseado.
        @param entity contiene los datos del estudiante que se desea actualizar.
     */
    public void update(student entity){
    }

    /*
        Elimina un estudiante de la base de datos.
        @param entity provee los datos del estudiante que se desea eliminar.
     */
    public void remove(student entity){
    }
}
