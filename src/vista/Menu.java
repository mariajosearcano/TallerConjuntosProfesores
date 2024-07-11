
package vista;

import javax.swing.JOptionPane;
import logica.LProfesor;

public class Menu {
        
    private VProfesor vprofesor;

    public Menu() {
        vprofesor = new VProfesor();
    }

    public Menu(VProfesor vprofesor) {
        this.vprofesor = vprofesor;
    }

    public VProfesor getVprofesor() {
        return vprofesor;
    }

    public void setVprofesor(VProfesor vprofesor) {
        this.vprofesor = vprofesor;
    }
    
    
   
    public void menuPrincipal(){
        int opcion = 0;
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Ingreso
                                                                        2. Profesores tiempo completo
                                                                        3. Profesores catedra
                                                                        4. Profesores ocasionales
                                                                        5. Total de profesores
                                                                        6. Profesores tiempo completo y catedra
                                                                        7. Profesores ocasionales y de catedra
                                                                        8. Profesores catedra, tiempo completo y ocasionales
                                                                        9. Cantidad hombres y mujeres por cada contrato
                                                                        10.Listar y contar profesores por cada tipo de facultad
                                                                        11.Listar y contar profesores por titulo
                                                                        0. Salir
                                                                        
                                                                    """, "Menu Principal", JOptionPane.QUESTION_MESSAGE));
            
            switch(opcion){
                case 1: 
                	vprofesor.ingreso();
                    //
                    break;
                case 2: 
                    vprofesor.listarContarDiferencia("Tiempo Completo", "Lista y total profesores que son de tiempo completo solamente");
                    break;
                case 3:
                    vprofesor.listarContarDiferencia("Cátedra", "Lista y total profesores que son de catedra solamente");
                    break;
                case 4:
                    vprofesor.listarContarDiferencia("Ocasional", "Lista y total profesores que son ocasionales solamente");
                    break;
                case 5:
                    vprofesor.listarContar("Lista y total de profesores");
                    break;
                case 6:
                    vprofesor.listarContarInterseccion("Tiempo Completo-Cátedra", "Lista y total profesores de tiempo completo y catedra");
                    break;
                case 7:
                    vprofesor.listarContarInterseccion("Cátedra-Ocasional", "Lista y total profesores ocasionales y de catedra");
                    break;
                case 8:
                    vprofesor.listarContarInterseccion("Tiempo Completo-Cátedra-Ocasional", "Lista y total profesores de Catedra, tiempo completo y ocasionales");
                    break;
                case 9:
                	vprofesor.hombresMujeres("Tiempo Completo", vprofesor.getLprofesor().getArrayListTiempoCompleto());
                	vprofesor.hombresMujeres("Cátedra", vprofesor.getLprofesor().getArrayListCatedra());
                	vprofesor.hombresMujeres("Ocasional", vprofesor.getLprofesor().getArrayListOcasionales());
                    break;
                case 10:
                	vprofesor.faculdad("Ingeniería");
                	vprofesor.faculdad("Deportes");
                	vprofesor.faculdad("Comunicación");
                	vprofesor.faculdad("Administración");
                	vprofesor.faculdad("Idiomas");
                	vprofesor.faculdad("Ciencias Básicas");
                    break;
                case 11:
                	vprofesor.titulo("Pregrado");
                	vprofesor.titulo("Especialista");
                	vprofesor.titulo("Maestría");
                	vprofesor.titulo("Doctorado");
                	break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saldra del programa, hasta la proxima", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
    
}
