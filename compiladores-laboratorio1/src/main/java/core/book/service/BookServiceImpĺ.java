package core.book.service;

import core.book.dao.BookDao;
import core.book.dao.JdbcBookService;
import model.book;

import java.sql.SQLException;

public class BookServiceImpĺ implements BookService {
    private BookDao dao;

    /*
        Constuctor, crea la instancia de BookDao.
     */
    public BookServiceImpĺ() throws ClassNotFoundException {
        dao = new JdbcBookService();
    }

    /*
        Llama al método del mismo nombre de BookDao en el que se buscará un libro con un id específico.
        @param id el identificador del libro deseado.
        @return book el libro deseado.
     */
    public book findById(String id) {
        book book = null;

        try {
            book = dao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    /*
        Llama al método del mismo nombre de BookDao en donde se insertará en la base de datos un nuevo objeto libro.
        @param entity el objeto book que se desea insertar en la tabla.
        @return answer una hilera que indica si el objeto se inserto correctamente o no en la tabla.
     */
    public String create(book entity){
        String answer = dao.create(entity);
        return answer;
    }

    /*
        Llama al método del mismo nombre de BookDao en donde se actualizarán los datos de un libro.
        @param entity libro que se desea actualizar en la base de datos.
     */
    public void update(book entity){
        dao.create(entity);
    }

    /*
        Llama al método del mismo nombre de BookDao en donde se eliminará un libro de la base.
        @param entity datos del libro que se desea eliminar.
     */
    public void remove(book entity){
        dao.remove(entity);
    }
}
