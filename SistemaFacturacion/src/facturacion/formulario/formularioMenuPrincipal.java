package facturacion.formulario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class formularioMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private HashMap<String, JInternalFrame> internalFrames;

	public formularioMenuPrincipal() {
		internalFrames = new HashMap<>();
		setTitle("Sistema de Facturacion Electronica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmCrearNuevo = new JMenuItem("Crear nuevo");
		mntmCrearNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFormulario("formularioInternoCrearCliente");
			}
		});
		mnClientes.add(mntmCrearNuevo);
		
		JMenuItem mntmMostrarListaClientes = new JMenuItem("Mostrar lista de clientes");
		mnClientes.add(mntmMostrarListaClientes);
		
		JMenu mnProductos = new JMenu("Productos");
		menuBar.add(mnProductos);
		
		JMenu mnRedes = new JMenu("Redes");
		menuBar.add(mnRedes);
		
		JMenuItem mntmFacebook = new JMenuItem("Facebook");
		mntmFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFormulario("formularioInternoFacebook");
			}
		});
		mnRedes.add(mntmFacebook);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	private void abrirFormulario(String nombreFormulario) {
		JInternalFrame frame = internalFrames.get(nombreFormulario);
		if (frame == null || frame.isClosed()) {
			if ("formularioInternoCrearCliente".equals(nombreFormulario)) {
				frame = new formularioInternoCrearCliente();
			} else if ("formularioInternoFacebook".equals(nombreFormulario)) {
				frame = new formularioInternoFacebook();
			}
			if (frame != null) {
				desktopPane.add(frame);
				internalFrames.put(nombreFormulario, frame);
				frame.setVisible(true);
			}
		} else {
			try {
				frame.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
				e.printStackTrace();
			}
		}
	}
}