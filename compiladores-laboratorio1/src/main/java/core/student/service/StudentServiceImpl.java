package core.student.service;

import core.student.dao.JdbcStudentService;
import core.student.dao.StudentDao;
import model.student;

import java.sql.SQLException;

public class StudentServiceImpl implements StudentService {
    private StudentDao dao;

    /*
        Constructor de la clase, inicializa el objeto dao de student.
     */
    public StudentServiceImpl() throws ClassNotFoundException {
        dao = new JdbcStudentService();
    }

    /*
        Llama al método con el mismo nombre de StudentDao en el cual se buscará al estudiante con el id requerido.
        @param id es el identificador del estudiante deseado.
        @return student que es el estudiante deseado.
    */
    public student findById(String id) throws SQLException {
        student student = dao.findById(id);
        return student;
    }

    /*
        Llama al método con el mismo nombre de StudentDao en donde se insertará un nuevo estudiante a la tabla.
        @param entity es el estudiante que se desea insertar.
        @return answer una hilera en donde se informa si se pudo insertar correctamente o no.
    */
    public String create(student entity) throws SQLException {
        String answer = dao.create(entity);
        return answer;
    }

    /*
        Llama al método con el mismo nombre de StudentDao en el cual se actualizarán los datos de un estudiante.
        @param entity un objeto student que traerá los datos para actualizar (únicamente funciona si existe el estudiante).
    */
    public void update(student entity){
        dao.update(entity);
    }

    /*
        Llama al método con el mismo nombre de StudentDao en el cual se eliminara al estudiante deseado.
        @param entity un objeto student con los datos, principalmente la llave del estudiante que se desea eliminar.
    */
    public void remove(student entity){
        dao.remove(entity);
    }
}
