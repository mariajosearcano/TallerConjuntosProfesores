
package logica;

import bean.Profesor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class LProfesor {
    
    private ArrayList<Profesor> arrayListTiempoCompleto, arrayListCatedra, arrayListOcasionales;

    public LProfesor() {
        arrayListTiempoCompleto = new ArrayList<>();
        arrayListCatedra = new ArrayList<>();
        arrayListOcasionales = new ArrayList<>();
    }

    public LProfesor(ArrayList<Profesor> arrayListTiempoCompleto, ArrayList<Profesor> arrayListCatedra, ArrayList<Profesor> arrayListOcasionales) {
        this.arrayListTiempoCompleto = arrayListTiempoCompleto;
        this.arrayListCatedra = arrayListCatedra;
        this.arrayListOcasionales = arrayListOcasionales;
    }

    public ArrayList<Profesor> getArrayListTiempoCompleto() {
        return arrayListTiempoCompleto;
    }

    public void setArrayListTiempoCompleto(ArrayList<Profesor> arrayListTiempoCompleto) {
        this.arrayListTiempoCompleto = arrayListTiempoCompleto;
    }

    public ArrayList<Profesor> getArrayListCatedra() {
        return arrayListCatedra;
    }

    public void setArrayListCatedra(ArrayList<Profesor> arrayListCatedra) {
        this.arrayListCatedra = arrayListCatedra;
    }

    public ArrayList<Profesor> getArrayListOcasionales() {
        return arrayListOcasionales;
    }

    public void setArrayListOcasionales(ArrayList<Profesor> arrayListOcasionales) {
        this.arrayListOcasionales = arrayListOcasionales;
    }

    public void leer(){
        String nombreArchivo = ".\\src\\registros\\Profesores.txt";
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                guardar(linea.split("::"));
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }  
    
    public void guardar(String[] registro){
        String[] tipo = registro[6].split("-");
        Profesor profesor = crear(registro, tipo);
        for(int j = 0; j < tipo.length; j++){
            switch(tipo[j]){
                case "Tiempo Completo": 
                    arrayListTiempoCompleto.add(profesor);
                    break;
                case "Cátedra": 
                    arrayListCatedra.add(profesor);
                    break;
                case "Ocasional": 
                    arrayListOcasionales.add(profesor);
                    break;
                default: 
                    System.out.println("Mira bien papito");
                    break;
            }
        }
    }
    
    public Profesor crear(String[] registro, String[] tipo){
        return new Profesor(Long.parseLong(registro[0]), registro[1], registro[2], registro[3], registro[4], registro[5], tipo, Byte.parseByte(registro[7]), Byte.parseByte(registro[8]));
    }
    
    public int contar(HashSet<Profesor> hashSet){
        int contador = 0;
        for(Profesor profesor : hashSet){
            contador++;
        }
        return contador;
    }
    
    public HashSet diferencia(String tipo, HashSet<Profesor> hashSetTipo){
        switch(tipo){
            case "Tiempo Completo": 
                hashSetTipo = new HashSet(arrayListTiempoCompleto);
                hashSetTipo.removeAll(arrayListCatedra);
                hashSetTipo.removeAll(arrayListOcasionales);
                break;
            case "Cátedra": 
                hashSetTipo = new HashSet(arrayListCatedra);
                hashSetTipo.removeAll(arrayListTiempoCompleto);
                hashSetTipo.removeAll(arrayListOcasionales);
                break;
            case "Ocasional": 
                hashSetTipo = new HashSet(arrayListOcasionales);
                hashSetTipo.removeAll(arrayListTiempoCompleto);
                hashSetTipo.removeAll(arrayListCatedra);
                break;
            default: 
                System.out.println("Mira bien papito");
                break;
        }
        return hashSetTipo;
    }
    
    public HashSet<Profesor> hombresMujeres(ArrayList<Profesor> array, String sexo){
    	HashSet<Profesor> separados = new HashSet<Profesor>();
    	HashSet<Profesor> hash= new HashSet<Profesor>(array);
    	for(Profesor prof:hash)
    	{
    		if(prof.getSexo().equals(sexo))
    		{
    			separados.add(prof);
    		}
    	}
    	return separados;
    }
    

    public HashSet<Profesor> facultad(HashSet<Profesor> hash, String facultad)
    {
    	HashSet<Profesor> separados = new HashSet<Profesor>();
    	for(Profesor prof:hash)
    	{
    		if(prof.getFacultad().equals(facultad))
    		{
    			separados.add(prof);
    		}
    	}
    	return separados;
    }
    
    public HashSet<Profesor> titulo(HashSet<Profesor> hash, String titulo)
    {
    	HashSet<Profesor> separados = new HashSet<Profesor>();
    	for(Profesor prof:hash)
    	{
    		if(prof.getTitulo().equals(titulo))
    		{
    			separados.add(prof);
    		}
    	}
    	return separados;
    }
    
    public String hashString(HashSet<Profesor> hash )
    {
    	String s="";
    	for(Profesor prof: hash)
    	{
    		s+= prof.toString() + "\n";
    	}
    	return s;		
    }
    
    public HashSet interseccion(String tipo, HashSet<Profesor> hashSetTipo){
        switch(tipo){
            case "Tiempo Completo-Cátedra": 
                hashSetTipo = new HashSet(arrayListTiempoCompleto);
                hashSetTipo.retainAll(arrayListCatedra);
                break;
            case "Tiempo Completo-Ocasional":
                hashSetTipo = new HashSet(arrayListTiempoCompleto);
                hashSetTipo.retainAll(arrayListOcasionales);
                break;
            case "Cátedra-Ocasional":
                hashSetTipo = new HashSet(arrayListCatedra);
                hashSetTipo.retainAll(arrayListOcasionales);
                break;
            case "Tiempo Completo-Cátedra-Ocasional":
                hashSetTipo = new HashSet(arrayListTiempoCompleto);
                hashSetTipo.retainAll(arrayListCatedra);
                hashSetTipo.retainAll(arrayListOcasionales);
                break;
            default: 
                System.out.println("Mira bien papito");
                break;
        }
        return hashSetTipo;
    }
    
    public HashSet union(HashSet<Profesor> hashSetTotal){
        hashSetTotal.addAll(arrayListTiempoCompleto);
        hashSetTotal.addAll(arrayListCatedra);
        hashSetTotal.addAll(arrayListOcasionales);
        return hashSetTotal;
    }
    
    
    
}
