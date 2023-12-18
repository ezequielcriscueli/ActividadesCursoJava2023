package Materia;

import java.time.LocalDate;

public class Materia {
    
    private int id;
    private LocalDate fechaInscripcion;
    private String materia;
    
    public Materia (){
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInscripcion() {
        return this.fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getMateria() {
        return this.materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
