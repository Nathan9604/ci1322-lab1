package model;

public class student {
    private String id;
    private String name;
    private String last_name;
    private String num_tel;
    private int age;

    /*
        Constructor del objeto student. también le carga datos al mismo.
     */
    public student(String id, String name, String last_name, String num_tel, int age){
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.num_tel = num_tel;
        this.age = age;
    }

    /*
        Establece el id del estudiante.
        @param id que se desea establecer.
     */
    public void setId(String id){
        this.id = id;
    }

    /*
        Establece el nombre del estudiante.
        @param nombre que se desea establecer.
     */
    public void setName(String name){
        this.name = name;
    }

    /*
        Establece el apellido del estudiante.
        @param apellido que se desea establecer.
     */
    public void setLastName(String last_name){
        this.last_name = last_name;
    }

    /*
        Establece el número telefónico del estudiante.
        @param número telefónico que se desea establecer.
     */
    public void setNumTel(String num_tel){
        this.num_tel = num_tel;
    }

    /*
        Establece la edad del estudiante.
        @param edad que se desea establecer.
     */
    public void setAge(int age){
        this.age = age;
    }

    /*
        Permite conocer el id del estudiante.
        @return id del estudiante.
     */
    public String getId(){
        return this.id;
    }

    /*
        Permite conocer el nombre del estudiante.
        @return nombre del estudiante.
     */
    public String getName(){
        return name;
    }

    /*
        Permite conocer el apellido del estudiante.
        @return apellido del estudiante.
     */
    public String getLastName(){
        return last_name;
    }

    /*
        Permite conocer el número telefónico del estudiante.
        @return número telefónico del estudiante.
     */
    public String getNumTel(){
        return num_tel;
    }

    /*
        Permite conocer la edad del estudiante.
        @return edad del estudiante.
     */
    public int getAge(){
        return age;
    }
}
