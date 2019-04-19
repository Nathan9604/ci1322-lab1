package core.book.service;

import model.book;

public interface BookService {
    /*
        Llama al método findById del respectivo dao para poder buscar al libro solicitado.
        @param id del libro solicitado.
        @return book un objeto con los datos del libro solicitado.
     */
    book findById(String id);

    /*
        Llama al método create del respectivo dao para poder crear un nuevo registro del libro deseado.
        @param entity es un objeto book con los datos del libro que se desea accesar.
        @return String indicando si se pudo accesar el registro correctamente en la base de datos.
     */
    String create(book entity);

    /*
        Llama al método update del respectivo dao para poder actualizar el libro dado.
        @param entity es un objeto book con los datos del libro que se desea actualizar.
     */
    void update(book entity);

    /*
        Llama al método remove del respectivo dao para poder eliminar un libro específico.
        @param entity es un objeto book con los datos del libro específico que se desea remover.
     */
    void remove(book entity);
}
