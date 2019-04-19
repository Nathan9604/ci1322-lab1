package core.read.service;

import core.read.dao.JdbcReadService;
import core.read.dao.ReadDao;
import model.read;

import java.sql.SQLException;


public class ReadServiceImpl implements ReadService {
    private ReadDao dao;

    /*
        Constructor de la clase, inicializa el objeto dao de read.
     */
    public ReadServiceImpl() throws ClassNotFoundException {
        dao = new JdbcReadService();
    }

    /*
        Llama al método con el mismo nombre de ReadDao en el cual se buscará la relación del estudiante con el libro en base a sus id y la retornará.
        @return read relación entre estudiante y libro.
    */
    public read findById(String id_book, String id_student) throws SQLException {
        read read = dao.findById(id_book, id_student);
        return read;
    }

    /*
        Llama al método con el mismo nombre de ReadDao en donde se insertará una nueva relación entre estudiante y libro en la tabla read.
        @param entity es la relación entre el estudiante y el libro que será insertada en la base de  datos.
        @return answer una hilera en donde se informa si se pudo insertar correctamente o no.
    */
    public String create(read entity){
        String answer = dao.create(entity);
        return answer;
    }

    /*
        Llama al método con el mismo nombre de ReadDao en el cual se actualizarán los datos de la relación entre el estudiante y el libro.
        @param entity un objeto read que traerá los datos para actualizar la relación.
    */
    public void update(read entity){
        dao.update(entity);
    }

    /*
        Llama al método con el mismo nombre de ReadDao en el cual se eliminara la relación entre estudiante y libro deseada.
        @param entity un objeto read con los datos que se desean eliminar.
    */
    public void remove(read entity){
        dao.remove(entity);
    }
}
