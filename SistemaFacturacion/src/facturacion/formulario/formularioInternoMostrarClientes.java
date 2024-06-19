package facturacion.formulario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import facturacion.dominio.Cliente;

public class formularioInternoMostrarClientes extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTable tablaClientes;

    public formularioInternoMostrarClientes(ArrayList<Cliente> clientes) {
        setTitle("Lista de Clientes");
        setBounds(100, 100, 600, 400);
        
        String[] columnas = {"Cédula", "Nombres", "Apellidos", "Dirección", "Teléfono", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        tablaClientes = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        getContentPane().add(scrollPane);
        
        for (Cliente cliente : clientes) {
            model.addRow(new Object[] {
                cliente.getCedula(),
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getEmail()
            });
        }
    }
}