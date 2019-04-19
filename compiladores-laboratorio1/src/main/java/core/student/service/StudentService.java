package core.student.service;

import model.student;

import java.sql.SQLException;

public interface StudentService {
    /*
        Llama al método findById del respectivo dao para poder buscar al estudiante solicitado.
        @param id del estudiante solicitado.
        @return student un objeto con los datos del estudiante solicitado.
     */
    student findById(String id) throws SQLException;

    /*
        Llama al método create del respectivo dao para poder crear un nuevo registro del estudiante deseado.
        @param entity es un objeto student con los datos del estudiante que se desea accesar.
        @return String indicando si se pudo accesar el registro correctamente en la base de datos.
     */
    String create(student entity) throws SQLException;

    /*
        Llama al método update del respectivo dao para poder actualizar el estudiante dado.
        @param entity es un objeto student con los datos del estudiante que se desea actualizar.
     */
    void update(student entity);

    /*
        Llama al método remove del respectivo dao para poder eliminar un estudiante específico.
        @param entity es un objeto student con los datos del estudiante específico que se desea remover.
     */
    void remove(student entity);
}
