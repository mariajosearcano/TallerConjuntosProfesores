
package vista;

import bean.Profesor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.LProfesor;

public class VProfesor {
    
    private LProfesor lprofesor;

    public VProfesor() {
        lprofesor = new LProfesor();
    }

    public VProfesor(LProfesor lprofesor) {
        this.lprofesor = lprofesor;
    }

    public LProfesor getLprofesor() {
        return lprofesor;
    }

    public void setLprofesor(LProfesor lprofesor) {
        this.lprofesor = lprofesor;
    }
    
    public String concatenar(Collection<Profesor> collectionProfesores){
        String cadena = "";
        for(Profesor profesor : collectionProfesores){
            cadena += profesor.toString() + "\n";
        }
        return cadena;
    }
    
    public String concatenar(String titulo, String cadena, String numero){
        return titulo + "\n" + cadena + "\n" + numero + " PROFESOR(ES)";
    }
    
    public void mostrar(String cadena){
        JOptionPane.showMessageDialog(null, cadena, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void listarContarDiferencia(String tipo, String titulo){
        HashSet<Profesor> hashSetTipo = new HashSet<>();
        hashSetTipo = lprofesor.diferencia(tipo, hashSetTipo);
        String numero = crearNumeros(lprofesor.contar(hashSetTipo));
        String cadena = concatenar(hashSetTipo);
        mostrar(concatenar(titulo, cadena, numero));
    }
    
    public void listarContar(String titulo){
        HashSet<Profesor> hashSetTotal = new HashSet<>();
        hashSetTotal = lprofesor.union(hashSetTotal);
        String numero = crearNumeros(lprofesor.contar(hashSetTotal));
        String cadena = concatenar(hashSetTotal);
        mostrar(concatenar(titulo, cadena, numero));
    }
    
    public void listarContarInterseccion(String tipo, String titulo){
        HashSet<Profesor> hashSetTipo = new HashSet<>();
        hashSetTipo = lprofesor.interseccion(tipo, hashSetTipo);
        String numero = crearNumeros(lprofesor.contar(hashSetTipo));
        String cadena = concatenar(hashSetTipo);
        mostrar(concatenar(titulo, cadena, numero));
    }
    
    public String crearNumeros(int numero){
        final String[] UNIDADES = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        final String[] DECENAS = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};
        final String[] DECENAS2 = {"", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        final String[] CENTENAS = {"", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"};
        return convertir(numero, UNIDADES, DECENAS, DECENAS2, CENTENAS);
    }
    
    public String convertir(int numero, String[] UNIDADES, String[] DECENAS, String[] DECENAS2, String[] CENTENAS){
        if (numero < 10) {
            return UNIDADES[numero];
        } else if (numero < 20) {
            return DECENAS[numero - 10];
        } else if (numero < 100) {
            int unidades = numero % 10;
            int decenas = numero / 10;
            if (unidades == 0) {
                return DECENAS2[decenas];
            } else {
                return DECENAS2[decenas] + " y " + UNIDADES[unidades];
            }
        } else if (numero < 1000) {
            int unidades = numero % 10;
            int decenas = (numero % 100) / 10;
            int centenas = numero / 100;
            if (unidades == 0 && decenas == 0) {
                return CENTENAS[centenas];
            } else {
                return CENTENAS[centenas] + " " + convertir(numero % 100, UNIDADES, DECENAS, DECENAS2, CENTENAS);
            }
        } else {
            return "Número fuera de rango";
        }
    }
    
    
    public void mostrar(String cadena, String titulo){
        JOptionPane.showMessageDialog(null, cadena, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void hombresMujeres(String s, ArrayList<Profesor> array) {
    	String cadena="";
    	HashSet<Profesor> hombres =lprofesor.hombresMujeres(array,"Masculino");
    	HashSet<Profesor> mujeres =lprofesor.hombresMujeres(array,"Femenino");
    	cadena= "\n"+"Profesores de "+ s+" : " +hombres.size()+"\n";
    	cadena+=lprofesor.hashString(hombres)+"\n";
    	cadena+= "\n"+"Profesoras de "+ s +" : "+ mujeres.size()+"\n";
    	cadena+=lprofesor.hashString(mujeres);
    	
    	mostrar(cadena, s);
    }
    
    public void faculdad(String facultad)
    {	
    	String cadena="";
    	 HashSet<Profesor> hashSet = new HashSet<>();
         hashSet = lprofesor.union(hashSet);
         HashSet<Profesor> facul =lprofesor.facultad(hashSet, facultad);
         cadena= "\n"+"Profesores de "+ facultad+" : " + facul.size()+"\n";
     	cadena+=lprofesor.hashString(facul)+"\n";
     	mostrar(cadena, facultad);
    }
    
    public void titulo(String titulo)
    {	
    	String cadena="";
    	 HashSet<Profesor> hashSet = new HashSet<>();
         hashSet = lprofesor.union(hashSet);
         HashSet<Profesor> titul =lprofesor.titulo(hashSet,titulo);
         cadena= "\n"+"Profesores de "+ titulo+" : " + titul.size()+"\n";
     	cadena+=lprofesor.hashString(titul)+"\n";
     	mostrar(cadena, titulo);
    }
    
    public void ingreso(){
    	JTextField cedula= new JTextField(), nombres = new JTextField(), asignaturas = new JTextField(), horas = new JTextField() ,fecha = new JTextField();
    	JCheckBox tiempoc= new JCheckBox("Tiempo Completo"), catedra= new JCheckBox("Cátedra"), ocasional= new JCheckBox("Ocasional"); 
    	JComboBox<String> sexo = new JComboBox<>();
        sexo.addItem("SELECCIONE");
        sexo.addItem("Masculino");
        sexo.addItem("Femenino");
        JComboBox<String> facultad = new JComboBox<>();
        facultad.addItem("SELECCIONE");
        facultad.addItem("Ingeniería");
        facultad.addItem("Deportes");
        facultad.addItem("Comunicación");
        facultad.addItem("Administración");
        facultad.addItem("Idiomas");
        facultad.addItem("Ciencias Básicas");
        JComboBox<String> titulo = new JComboBox<>();
        titulo.addItem("SELECCIONE");
        titulo.addItem("Pregrado");
        titulo.addItem("Especialista");
        titulo.addItem("Maestría");
        titulo.addItem("Doctorado");
        Object[] mensaje = {
        	"Cedula", cedula,
            "Nombres", nombres,
            "Sexo", sexo ,
            "Facultad", facultad,
            "Titulo", titulo,
            "Cantidad de Asignaturas", asignaturas,
            "Cantidad Horas", horas,
            "Fecha Nacimiento", fecha,
            "Tipo de contrato", tiempoc,
            catedra,ocasional    
        };
        String tipo="";
        boolean cancel= false, val= false;
        do {
        	
        	int opcion= JOptionPane.showConfirmDialog(null, mensaje, "Formulario de registro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        	if(opcion == JOptionPane.OK_OPTION)
        	{
	        	
	        		tipo=this.tipoc(tiempoc, catedra, ocasional);
	        		if(tipo.equals("")) {
	        			JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de contrato para poder continuar" , "Advertencia", JOptionPane.WARNING_MESSAGE);    
	        		}
	        		else
	        		{
	        			val=true;
	        			
	        		}
	        	
        	}
        	else
        	{
        		cancel=true;
        		
        	}
        	
        }while(!cancel && !validar(cancel,val,cedula.getText(),nombres.getText(), asignaturas.getText(), horas.getText(), fecha.getText()) );
        if(!cancel) {
	        String[] registro= {cedula.getText(),nombres.getText(), sexo.getSelectedItem().toString(), facultad.getSelectedItem().toString(),titulo.getSelectedItem().toString(),fecha.getText(),tipo, asignaturas.getText(), horas.getText()};
	        lprofesor.guardar(registro);
        }
    }
    
    public String tipoc(JCheckBox tiempoc, JCheckBox catedra,JCheckBox ocasional) {
    	String tipo="";
    	if(tiempoc.isSelected() && catedra.isSelected() && ocasional.isSelected())
        {
        	tipo="Tiempo Completo-Cátedra-Ocasional";
        }
        if(tiempoc.isSelected() && catedra.isSelected() && !ocasional.isSelected())
        {
        	tipo="Tiempo Completo-Cátedra";
        }
        if(tiempoc.isSelected() && !catedra.isSelected() && ocasional.isSelected())
        {
        	tipo="Tiempo Completo-Ocasional";
        }
        if(!tiempoc.isSelected() && catedra.isSelected() && ocasional.isSelected())
        {
        	tipo="Cátedra-Ocasional";
        }
        if(tiempoc.isSelected() && !catedra.isSelected() && !ocasional.isSelected())
        {
        	tipo="Tiempo Completo";
        }
        if(!tiempoc.isSelected() && catedra.isSelected() && !ocasional.isSelected())
        {
        	tipo="Cátedra";
        }
        if(!tiempoc.isSelected() && !catedra.isSelected() && ocasional.isSelected())
        {
        	tipo="Ocasional";
        }
    	return tipo;
    	
    }
    
    public boolean validar(boolean cancel,boolean val,String cedula, String nombres,String asignaturas, String horas, String fecha ) {
    	
    	if(!cancel && val) {
    	
    	String regex ="^(\\d{7,10})$";
    	String regex2 ="^(([a-z A-Z]{2,}\\s){1,3}[a-z A-Z]{2,})$";
    	String regex3 ="^([1-9]|10)$";
    	String regex4 ="^([1-9]|1[0-9]|20)$";
    	String regex5 ="^(((0[1-9]|1[0-9]|2[0-9]|3[0-1])/(01|03|05|07|08|10|12)/(19[0-9]{2}|20([0-1][0-9]|2[0-3])))|((0[1-9]|1[0-9]|2[0-9]|30)/(04|06|09|11)/(19[0-9]{2}|20([0-1][0-9]|2[0-3])))|((0[1-9]|1[0-9]|2[0-8])/(02)/(19[0-9]{2}|20([0-1][0-9]|2[0-3])))|((0[1-9]|1[0-9]|2[0-9])/(02)/(19([13579][26]|[02468][48])|20([02][48]|[1][26]))))$";
    	
   	 
    	if(Pattern.matches(regex, cedula)){
            if(Pattern.matches(regex2, nombres)) {
            	if(Pattern.matches(regex3, asignaturas)){
            		if(Pattern.matches(regex4, horas)){
            			if(Pattern.matches(regex5, fecha)){
                    		return true;
                    	}
                    	else
                    	{
                    		JOptionPane.showMessageDialog(null, "La fecha debe estar escrita DD/MM/AAAA o el mes no tiene ese numero de dias" , "Advertencia", JOptionPane.WARNING_MESSAGE);   
                    	}
                	}
                	else
                	{
                		JOptionPane.showMessageDialog(null, "El numero de horas es un numero entre 1 y 20" , "Advertencia", JOptionPane.WARNING_MESSAGE);   
                	}
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "El numero de asignaturas es un numero entre 1 y 10" , "Advertencia", JOptionPane.WARNING_MESSAGE);   
            	}
            }
            else
            {
            	JOptionPane.showMessageDialog(null, "El nombre debe de estar compuesto por un nombre y apellido como minimo" , "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
    		
    	}
    	else
    	{
    		 JOptionPane.showMessageDialog(null, "La cedula debe ser un numero entre 7 y 10 caracteres" , "Advertencia", JOptionPane.WARNING_MESSAGE);
             
    	}
		return false;
    	
    	}
    	return false;
    }
    
}
