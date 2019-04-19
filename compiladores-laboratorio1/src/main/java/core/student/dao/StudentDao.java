package core.student.dao;

import model.student;

import java.sql.SQLException;

public interface StudentDao {

    /*
        Busca un estudiante en base a su identificador.
        @param id identificador del estudiante.
        @return student que posee el identificador deseado.
     */
    student findById(String id) throws SQLException;

    /*
        Crea un nuevo estudiante en la base de datos.
        @param entity datos del estudiante que se desea ingresar en la base de datos.
        @return answer que nos indica si el estudiante se ingreso correctamente o no.
     */
    String create(student entity) throws SQLException;

    /*
        Actualiza los datos del estudiante deseado.
        @param entity contiene los datos del estudiante que se desea actualizar.
     */
    void update(student entity);

    /*
        Elimina un estudiante de la base de datos.
        @param entity provee los datos del estudiante que se desea eliminar.
     */
    void remove(student entity);
}
