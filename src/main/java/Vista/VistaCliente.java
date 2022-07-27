/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import controlador.ControladorAtencionCliente;
import controlador.ControladorCliente;
import controlador.ControladorHisotrial;
import java.util.Date;
import java.util.Scanner;
import modelo.Cita;
import modelo.Cliente;

/**
 *
 * @author Adrian
 */
public class VistaCliente
{
    public Scanner teclado;
    private ControladorAtencionCliente controladorAtencionCliente;
    private ControladorHisotrial controladorHisotrial;
    private ControladorCliente controladorCliente;
    
    public VistaCliente()
    {        
        teclado = new Scanner(System.in);
        controladorAtencionCliente = new ControladorAtencionCliente();
        controladorHisotrial = controladorAtencionCliente.getControladorHisotrial();
        controladorCliente=new ControladorCliente();
    }
    public void menu()
    {
      
        String op = "";
        int opc;
        do 
        {     
            do {
                 System.out.println("1. Cliente");
                 System.out.println("2. Banco");                     
                 System.out.println("0. Salir");
              op=teclado.next();  
            } while (validateOp(op) == false);            
            opc = Integer.parseInt(op);
            switch (opc) {
                case 1: menuCliente(); break;
                case 2: menuBanco(); break;                  
            }            
        }while (opc!=0 );    
        System.exit(0);
    }
    
    private void menuCliente()
    {
        String op = "";
        int opc;
        do 
        {
            do {
                System.out.println("1. Generar turno");
                System.out.println("2. Agendar cita");                  
                System.out.println("0. Atras");
                op=teclado.next();
            } while (validateOp(op) == false); 
            opc = Integer.parseInt(op);
            switch (opc) {
                case 1: generarClientes(); break;
                case 2: agendarCita(); break;
            }
            
        }while (opc!=0);
        menu();
    }
    
     private void menuBanco()
    {
       String op = "";
        int opc;
        do 
        {
            do {
                System.out.println("1. Clientes en cola"); 
                System.out.println("2. Atender a un cliente");  
                System.out.println("3. Citas pendientes"); 
                System.out.println("4. Obtener historial de ventanilla"); 
                System.out.println("5. Ver Clientes"); 
                System.out.println("0. Atras");
                op=teclado.next();
            } while (validateOp(op) == false);
            opc=Integer.parseInt(op);
            switch (opc) {
                case 1: imprimirClientes(); break;
                case 2: atenderClientes(); break;
                case 3: imprimirCitas(); break;
                case 4: getHistoryById(); break;    
                case 5: menuClientes(); break;
            }            
        }while (opc!=0);
        menu();
    }  
    private boolean validateOp(String op)
    {
        try {
            Integer.parseInt(op);
            return true;
        } catch (Exception e) {
            System.out.println("Opción invalida");
            return false;
        }
    }
    
    private void menuClientes()
    {
        String op = "";
        int opc;
        do 
        {
            do {
                System.out.println("1. Clientes Atendidos");                             
                System.out.println("2. Clientes Agendados");
                System.out.println("0. Atras");
                op=teclado.next();
            } while (validateOp(op) == false);
            opc=Integer.parseInt(op);
            switch (opc) {
                case 1: clientesAtendidos(); break;
                case 2: clientesAgendados(); break;
            }            
        }while (opc!=0);
        menuBanco();
    }   
    
    private void menuClientesAg()
    {
        String op = "";
        int opc;
        do 
        {
            do {
                System.out.println("1. Editar");
                System.out.println("0. Atras");
                op=teclado.next();
            } while (validateOp(op) == false);
            opc=Integer.parseInt(op);
            switch (opc) {
                case 1: editarAg(); break;                
            }            
        }while (opc!=0);
        menuClientes();
    }
    
     private void menuClientesAt()
    {
        String op = "";
        int opc;
        do 
        {
            do {
                System.out.println("1. Editar");
                System.out.println("0. Atras");
                op=teclado.next();
            } while (validateOp(op) == false);
            opc=Integer.parseInt(op);
            switch (opc) {
                case 1: editarAt(); break;                
            }            
        }while (opc!=0);
        menuClientes();
    }
    
   
    private void agendarCita()
    {
        System.out.println("Ingrese su número de cedula: ");
        String cedula = teclado.next();
        System.out.println("Ingrese su nombre: ");
        String nombre = teclado.next();
        System.out.println("Ingrese su apellido: ");
        String apellido = teclado.next();
        String fechString = "";
        do 
        {
            System.out.println("Ingrese la fecha en formato (dd/MM)");
            fechString = teclado.next();  
        } while (controladorAtencionCliente.validarFecha(fechString) == false);
       
        var fechaString = fechString.split("/");        
        Date fecha = new Date(2022,Integer.parseInt(fechaString[0]) , Integer.parseInt(fechaString[1]));
        controladorAtencionCliente.agendarCita(nombre, apellido, cedula, fecha);       
    }
    
    
    private  void generarClientes()
    {
        System.out.println("Ingrese su numero de cedula");
        String cedula = teclado.next();
        System.out.println("Ingrese su nombre");
        String nombre = teclado.next();
        System.out.println("Ingrese su apellido");
        String apellido = teclado.next();
        controladorAtencionCliente.agregarClientes(nombre, apellido, cedula);
    }
    private void imprimirClientes()
    {
        for( Cliente cliente : controladorAtencionCliente.getColaCliente())
        {
            System.out.println(cliente);
        }
    }
    private void imprimirCitas()
    {
        for (Cita cita : controladorAtencionCliente.getCitas())
        {
            System.out.println(cita);
        }
    }
    private void atenderClientes()
    {
        controladorAtencionCliente.atenderCliente();
    }
    
    private void getHistoryById()
    {
        
        String op = "";
        int opc;
        do 
        {
            do {
                System.out.println("1. Ordenar por tiempo de atención");
                System.out.println("2. Ordenar por nombre del cliente");
                System.out.println("3. Ordenar por Apellido");
                System.out.println("4. Ordenar por atenciones");
                System.out.println("0. Atras");
                op=teclado.next();
            } while (validateOp(op) == false);
            opc=Integer.parseInt(op);
            switch (opc) {
                case 1: orderByTime(); break;     
                case 2: orderByNombre(); break;
                case 3: orderByApellido(); break;
                case 4: orderByAtencion(); break;
            }            
        }while (opc!=0);
        menuBanco();
    }
    
    private void orderByTime()
    {
        System.out.println("Ingrese el número de ventanilla");
        int ventanilla = teclado.nextInt();
        System.out.println("ventanilla " + ventanilla);
        System.out.println(controladorHisotrial.orderByTiempo(ventanilla));
    }
    
    private void orderByNombre()
    {
        System.out.println("Ingrese el número de ventanilla");
        int ventanilla = teclado.nextInt();
        System.out.println("ventanilla " + ventanilla);
        System.out.println(controladorHisotrial.orderByNombre(ventanilla));
    }    
    private void orderByApellido()
    {
       System.out.println("Ingrese el número de ventanilla");
        int ventanilla = teclado.nextInt();
        System.out.println("ventanilla " + ventanilla);
        System.out.println(controladorHisotrial.orderByApellido(ventanilla)); 
    }
    private void orderByAtencion()
    {
      controladorHisotrial.orderByAtendidos();
    }  
    
    private void editarAt()
    {        
        System.out.println("Ingrese el id del cliente a editar");  
        int id = teclado.nextInt();
        System.out.println("Ingrese un nuevo número de cedula"); 
        String newCedula = teclado.next();
        System.out.println("Ingrese un nuevo nombre"); 
        String newNombre = teclado.next();
        System.out.println("Ingrese un nuevo apellido"); 
        String newApellido = teclado.next();
        controladorCliente.UpdateCliById(id, newCedula, newApellido, newNombre, 0);
        realoadClients();
        clientesAtendidos();        
        menuClientes();
    }
    
    private void editarAg()
    {        
        System.out.println("Ingrese el id del cliente a editar");  
        int id = teclado.nextInt();
        System.out.println("Ingrese un nuevo número de cedula"); 
        String newCedula = teclado.next();
        System.out.println("Ingrese un nuevo nombre"); 
        String newNombre = teclado.next();
        System.out.println("Ingrese un nuevo apellido"); 
        String newApellido = teclado.next();
        controladorCliente.UpdateCliById(id, newCedula, newApellido, newNombre, 1);
        realoadClients();
        clientesAgendados();        
        menuClientes();
    }
    
    private void realoadClients()
    {
        controladorCliente.reload(controladorAtencionCliente.getCitas(), controladorAtencionCliente.getControladorHisotrial().getVentanillaList());
    }
     private void clientesAtendidos()
    {        
        realoadClients();
        System.out.println("Cleintes atendidos");        
        System.out.println(controladorCliente.getClientesAtendidos());        
        menuClientesAt();
    }
    
     private void clientesAgendados()
     {
        realoadClients();
        System.out.println("Cleintes agendados");
        System.out.println(controladorCliente.getClientesAgendados());
        menuClientesAg();
     }
}