package core.read.service;

import model.read;

import java.sql.SQLException;

public interface ReadService {
    /*
        Llama al método findById del respectivo dao para poder buscar la relación entre estudiante y libro solicitada.
        @param id_book identificador del libro solicitado.
        @para id_student identificador del estudiante solicitado.
        @return read un objeto con los datos de la relación entre el estudiante y el libro solicitados.
     */
    read findById(String id_book, String id_student) throws SQLException;

    /*
        Llama al método create del respectivo dao para poder crear un nuevo registro de la relación entre estudiante y libro deseado.
        @param entity es un objeto read con los identificadores del estudiante y el libro que se desean relacionar.
        @return String indicando si se pudo accesar el registro correctamente en la base de datos.
     */
    String create(read entity);

    /*
        Llama al método update del respectivo dao para poder actualizar la relación entre estudiante y libro dada.
        @param entity es un objeto read con los datos de la relación entre estudiante y libro que se desea actualizar.
     */
    void update(read entity);

    /*
        Llama al método remove del respectivo dao para poder eliminar una relación entre un estudiante y un libro específica.
        @param entity es un objeto read con los datos de la relación específica que se desea remover.
     */
    void remove(read entity);
}
