package gui.crud.relacionada;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import util.JComboBoxBD;
import java.awt.Color;

public class FrmCrudClub extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtFecha;
	private JButton btnIngresar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JCheckBox chkEstado;
	// -1 indica que no se ha selecionado nada en la grilla o Jtable
	int idSeleccionado = -1;

	int hoveredRow = -1, hoveredColumn = -1;
	private JComboBoxBD cboPais;
	private ResourceBundle rb = ResourceBundle.getBundle("combo");
	private JLabel lblMantenimientoClub;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudClub frame = new FrmCrudClub();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCrudClub() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(50, 95, 130, 14);
		contentPane.add(lblNombre);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de creaci\u00F3n");
		lblFechaDeNacimiento.setBounds(50, 135, 130, 14);
		contentPane.add(lblFechaDeNacimiento);

		txtNombre = new JTextField();
		txtNombre.setBounds(219, 92, 322, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtFecha = new JTextField();
		txtFecha.setBounds(219, 132, 186, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(FrmCrudClub.class.getResource("/iconos/add.gif")));
		btnIngresar.setBounds(637, 83, 130, 30);
		contentPane.add(btnIngresar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmCrudClub.class.getResource("/iconos/edit.gif")));
		btnActualizar.setBounds(637, 168, 130, 30);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmCrudClub.class.getResource("/iconos/delete.gif")));
		btnEliminar.setBounds(637, 127, 130, 30);
		contentPane.add(btnEliminar);
		
		chkEstado = new JCheckBox("Activo");
		chkEstado.setSelected(true);
		chkEstado.setBounds(218, 214, 97, 30);
		contentPane.add(chkEstado);
		
		JLabel lblPas = new JLabel("Pa\u00EDs");
		lblPas.setBounds(50, 176, 130, 14);
		contentPane.add(lblPas);
		
		cboPais = new JComboBoxBD(rb.getString("SQL_PAIS"));
		cboPais.setBounds(219, 172, 322, 22);
		getContentPane().add(cboPais);
		
		lblMantenimientoClub = new JLabel("Mantenimiento Club");
		lblMantenimientoClub.setOpaque(true);
		lblMantenimientoClub.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoClub.setForeground(Color.WHITE);
		lblMantenimientoClub.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoClub.setBackground(Color.RED);
		lblMantenimientoClub.setBounds(23, 11, 744, 59);
		contentPane.add(lblMantenimientoClub);
		


	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	void limpiarCajasTexto() {
		txtNombre.setText("");
		txtFecha.setText("");
		txtNombre.requestFocus();
	}
}



