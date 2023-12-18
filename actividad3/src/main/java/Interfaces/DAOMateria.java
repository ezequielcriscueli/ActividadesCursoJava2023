package Interfaces;

import Materia.Materia;

public interface DAOMateria {
    
    public boolean agregar (Materia materia);
    
    public boolean modificar (Materia materia);
    
    public boolean eliminar (Materia materia);
    
    public void buscar (Materia materia);
    
}
