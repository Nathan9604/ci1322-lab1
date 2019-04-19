package core.read.dao;


import model.read;

import java.sql.SQLException;

public interface ReadDao {

    /*
        Busca una relación existente del estudiante con el libro dado.
        @param id_book nos indica el libro que deseamos buscar en la relación.
        @param id_student nos indica el estudiante que deseamos buscar en la relación.
        @return read la relación deseada entre el estudiante y el libro.
     */
    read findById(String id_book, String id_student) throws SQLException;

    /*
        Inserta una nueva relación entre un libro y un estudiante en la base de datos.
        @param entity contiene los datos de la relación que se desea crear.
        @return answer nos indica si la relación se logro almacenar correctamente.
     */
    String create(read entity);

    /*
        Actualiza los datos de una relación dada.
        @param entity tiene los datos de la relación que se desea actualizar.
     */
    void update(read entity);

    /*
        Elimina los datos de una relación entre estudiante y libro.
        @param entity provee los datos de la relación que se desea eliminar.
     */
    void remove(read entity);
}