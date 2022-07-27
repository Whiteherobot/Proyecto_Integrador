/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Cita;
import modelo.Cliente;
import modelo.Historial;
import modelo.Ventanilla;

/**
 *
 * @author Adrian
 */
public class ControladorCliente
{
    private List<Cliente> clientesAtendidos;
    private List<Cliente> clientesAgendados;
    
    public ControladorCliente()
    {
        clientesAtendidos = new ArrayList<>();
        clientesAgendados = new ArrayList<>();
    }
    public void reload(List<Cita> citas, List<Ventanilla> ventanillas)
    {
        if (!clientesAtendidos.isEmpty())
        {
             clientesAtendidos.clear();
        }
       if (!clientesAgendados.isEmpty())
        {
             clientesAgendados.clear();
        }        
        for (Cita cita : citas)
        {
            this.setClientesAgendados(cita.getCliente());
        }
        
        for (Ventanilla ventanilla : ventanillas)
        {
            for (Historial his : ventanilla.getHitorialList())
            {
                this.setClientesAtendidos(his.getCliente());
            }
        }
    }
    
    public void UpdateCliById(int id, String newCedula, String newApellido, String newNombre, int op)
    {
        try {
            if(op ==0)
        {
            Cliente cliente = buscarAt(id);
            cliente.setCedula(newCedula);
            cliente.setApellido(newApellido);
            cliente.setNombre(newNombre);
        }
        else{
            Cliente cliente = buscarAg(id);
            cliente.setCedula(newCedula);
            cliente.setApellido(newApellido);
            cliente.setNombre(newNombre);
        }
        } catch (Exception e) {
            System.out.println("Cliente no encontrado");
        }
        
        
    }

    private Cliente buscarAt(int id)
    {  
        return clientesAtendidos.stream().filter(v -> v.getId() == (id)).findFirst().get();
    }
    private Cliente buscarAg(int id)
    {
        return clientesAgendados.stream().filter(v -> v.getId() == (id)).findFirst().get();
    }
    
    public List<Cliente> getClientesAtendidos() {
        return clientesAtendidos;
    }

    public void setClientesAtendidos(Cliente cliente) {
        this.clientesAtendidos.add(cliente);
    }

    public List<Cliente> getClientesAgendados() {
        return clientesAgendados;
    }

    public void setClientesAgendados(Cliente cliente) {
        this.clientesAgendados.add(cliente);
    }

    
}
