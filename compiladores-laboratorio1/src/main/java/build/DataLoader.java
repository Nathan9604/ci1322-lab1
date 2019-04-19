package build;

import core.book.service.BookService;
import core.book.service.BookServiceImpĺ;
import core.read.service.ReadService;
import core.read.service.ReadServiceImpl;
import core.student.service.StudentService;
import core.student.service.StudentServiceImpl;
import model.book;
import model.read;
import model.student;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

public class DataLoader {
    private BookService bookService;
    private ReadService readService;
    private StudentService studentService;

    /*
        Constructor del objeto Data loader. Inicializa cada una de las instancias de los servicios.
     */
    public DataLoader() {
        try {
            bookService = new BookServiceImpĺ();
            readService = new ReadServiceImpl();
            studentService = new StudentServiceImpl();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*
        Busca un libro en la base de datos según el id que se ingrese como parámetro.
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fileIn = null;
        DataLoader dataLoader = new DataLoader();

        try{
            fileIn = new FileInputStream("./src/main/resources/Lab_CI1322.xls");
            POIFSFileSystem fs = new POIFSFileSystem(fileIn);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            dataLoader.loadBook(wb.getSheetAt(0));
            dataLoader.loadStudent(wb.getSheetAt(1));
            dataLoader.loadRead(wb.getSheetAt(2));
        }
        finally {
            if (fileIn != null)
                fileIn.close();
        }
    }

    /*
        Abre el archivo excel y envía cada una de las respectivas páginas a los métodos que las procesan de manera adecuada.
     */
    public static void main2(String[] args) throws IOException {
        DataLoader dataLoader = new DataLoader();
        book newBook = dataLoader.seekBook(args[0]);

        System.out.println("Book id " + newBook.getId() + ", name " + newBook.getName() + ", Author " + newBook.getAuthor() + ", genre " + newBook.getGenre() + " and edition " + newBook.getEdition() + ".");

        System.exit(0);
    }

    /*
        Crea un objeto book por cada fila que posea datos y lo envía a almacenar en la base de datos.
        @HSSFSheet La hoja del excel en donde están los datos de los libros.
     */
    public void loadBook(HSSFSheet books){
        int edition;
        int iterator = 1;
        String id;
        String name;
        String author;
        String genre;
        String result;
        HSSFRow row = books.getRow(1);
        book newBook;

        while(row != null){
            id = Integer.toString((int)row.getCell(0).getNumericCellValue());
            name = row.getCell(1).getStringCellValue();
            author = row.getCell(2).getStringCellValue();
            edition = (int) row.getCell(3).getNumericCellValue();
            genre = row.getCell(4).getStringCellValue();

            newBook = new book(id, name, author, genre, edition);

            result = bookService.create(newBook);

            System.out.println(result);

            ++iterator;
            row = books.getRow(iterator);
        }
    }

    /*
        Crea un objeto read por cada fila que posea datos y lo envía a almacenar en la base de datos.
        @HSSFSheet La hoja del excel en donde están los datos de las relaciones entre estudiante y libros.
     */
    public void loadRead(HSSFSheet reads){
        int iterator = 1;
        String student_id;
        String book_id;
        String result;
        HSSFRow row = reads.getRow(1);
        read newRead;

        while(row != null){
            student_id = Integer.toString((int)row.getCell(0).getNumericCellValue());
            book_id = Integer.toString((int)row.getCell(1).getNumericCellValue());

            newRead = new read(student_id, book_id);

            result = readService.create(newRead);

            System.out.println(result);

            ++iterator;
            row = reads.getRow(iterator);
        }
    }

    /*
        Crea un objeto student por cada fila que posea datos y lo envía a almacenar en la base de datos.
        @HSSFSheet La hoja del excel en donde están los datos de los estudiante.
     */
    public void loadStudent(HSSFSheet students)  {
        int age;
        int iterator = 1;
        String id;
        String name;
        String last_name;
        String num_tel;
        String result = "";
        HSSFRow row = students.getRow(1);
        student newStudent;

        while(row != null){
            id = Integer.toString((int)row.getCell(0).getNumericCellValue());
            name = row.getCell(1).getStringCellValue();
            last_name = row.getCell(2).getStringCellValue();
            num_tel = row.getCell(3).getStringCellValue();
            age = (int)row.getCell(4).getNumericCellValue();

            newStudent = new student(id, name, last_name, num_tel, age);

            try {
                result = studentService.create(newStudent);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println(result);

            ++iterator;
            row = students.getRow(iterator);
        }
    }

    /*
        Busca un libro dado según el id que se ingrese.
     */
    public book seekBook(String id){
        book newBook = bookService.findById(id);

        return newBook;
    }
}
