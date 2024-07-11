
package bean;

import java.time.LocalDate;
import java.util.Arrays;

public class Profesor {
    
    private long cedula;
    private String nombreCompleto, sexo, facultad, titulo, fechaNacimiento;
    private String[] tipo;
    private byte cantidadAsignaturas, cantidadHoras;

    public Profesor() {
        tipo = new String[3];
    }

    public Profesor(long cedula, String nombreCompleto, String sexo, String facultad, String titulo, String fechaNacimiento, String[] tipo, byte cantidadAsignaturas, byte cantidadHoras) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.sexo = sexo;
        this.facultad = facultad;
        this.titulo = titulo;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
        this.cantidadAsignaturas = cantidadAsignaturas;
        this.cantidadHoras = cantidadHoras;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String[] getTipo() {
        return tipo;
    }

    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    public byte getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }

    public void setCantidadAsignaturas(byte cantidadAsignaturas) {
        this.cantidadAsignaturas = cantidadAsignaturas;
    }

    public byte getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(byte cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.cedula ^ (this.cedula >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        return this.cedula == other.cedula;
    }

    
    
    @Override
    public String toString() {
        return "Profesor{" + "cedula=" + cedula + ", nombreCompleto=" + nombreCompleto + ", sexo=" + sexo + ", facultad=" + facultad + ", titulo=" + titulo + ", fechaNacimiento=" + fechaNacimiento + ", tipo=" + tipoAString(tipo) + ", cantidadAsignaturas=" + cantidadAsignaturas + ", cantidadHoras=" + cantidadHoras + '}';
    }

    public String tipoAString(String[] tipo){
        int i = 0;
        String cadena = "";
        
        while(i != tipo.length){
            cadena += tipo[i] + ",";
            
            i++;
        }
        
        return cadena.substring(0, cadena.length() - 1);
    }
    
}
