/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import modelo.Cliente;
import modelo.Ventanilla;
import modelo.Historial;

/**
 *
 * @author Adrian
 */
public class ControladorHisotrial
{
    private List<Ventanilla> ventanillaList;
    
    public ControladorHisotrial()
    {
        ventanillaList = new ArrayList<>();     
        for (int i = 0; i<3; i++)
        {            
            ventanillaList.add(new  Ventanilla(i));
        }
    }    

    
    public void agregar(int ventanilla, int tiempo, Cliente cliente)
    {
        Historial hisotrial = new Historial(tiempo, cliente);      
        ventanillaList.get(ventanilla).addHistorial(hisotrial);
    }
    
    public Ventanilla getHistoryById(int id)
    {
        return ventanillaList.get(id);
    }
    
  
    public List<Historial> orderByTiempo(int ventanilla)
    {
        List<Ventanilla> aux = ventanillaList;
        aux.get(ventanilla).getHitorialList().sort(Comparator.comparing(Historial::getTiempo));      
        return aux.get(ventanilla).getHitorialList();
    }
    
    public List<Historial> orderByNombre(int ventanilla)
    {
        List<Ventanilla> aux = ventanillaList;
        aux.get(ventanilla).getHitorialList().sort(Comparator.comparing(Historial::getNombre));      
        return aux.get(ventanilla).getHitorialList();
    }
    
    public List<Historial> orderByApellido(int ventanilla)
    {
        List<Ventanilla> aux = ventanillaList;
        aux.get(ventanilla).getHitorialList().sort(Comparator.comparing(Historial::getApellido));      
        return aux.get(ventanilla).getHitorialList(); 
    }
    public void orderByAtendidos()
    {   
        List<Ventanilla> aux = ventanillaList;
        aux.sort(Comparator.comparing(Ventanilla::getSize).reversed());      
        
        for(Ventanilla v : aux)
        {
            System.out.println(v.getAtenciones());
        }
    }

    public List<Ventanilla> getVentanillaList() {
        return ventanillaList;
    }
    
    
            
}
