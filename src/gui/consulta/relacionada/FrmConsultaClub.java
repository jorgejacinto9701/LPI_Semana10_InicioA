package gui.consulta.relacionada;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Club;
import model.ClubModel;
import util.FechaUtil;
import util.JComboBoxBD;

public class FrmConsultaClub extends JFrame implements ItemListener   {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JComboBoxBD cboPais;
	
	private ResourceBundle rb = ResourceBundle.getBundle("combo");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					FrmConsultaClub frame = new FrmConsultaClub();
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
	public FrmConsultaClub() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaDeCampeonatos = new JLabel("Consulta de club");
		lblConsultaDeCampeonatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeCampeonatos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConsultaDeCampeonatos.setBounds(10, 26, 834, 36);
		contentPane.add(lblConsultaDeCampeonatos);
		
		JLabel lblPais = new JLabel("Pa\u00EDs");
		lblPais.setBounds(67, 102, 46, 14);
		contentPane.add(lblPais);
		
		cboPais = new JComboBoxBD(rb.getString("SQL_PAIS"), "[Todos]");
		cboPais.addItemListener(this);
		cboPais.setBounds(148, 98, 249, 22);
		contentPane.add(cboPais);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 150, 779, 319);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Fecha Creaci\u00F3n", "Fecha Registro", "Estado","Pa\u00EDs"
			}
		));
		scrollPane.setViewportView(table);
		
	}	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboPais) {
			itemStateChangedCboPaisJComboBoxBD(e);
		}
	}
	protected void itemStateChangedCboPaisJComboBoxBD(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			String item = cboPais.getSelectedItem().toString();
			int index = cboPais.getSelectedIndex();
	
			System.out.println(">>> Item >> " + item);	
			String[] separados = item.split(":");
			
			ClubModel model =  new ClubModel();
			List<Club> lista = null;
			if (index ==0) {
				lista = new ArrayList<Club>();
			}else if (index ==1) {
				lista = model.listaTodos();
			}else {
				lista = model.listaPorPais(Integer.parseInt(separados[0]));	
			}
			
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setRowCount(0);
			
			for (Club x : lista) {
				Object[] f = {x.getIdClub(), x.getNombre(), 
							  x.getFechaCreacion(),
							  FechaUtil.getFechaYYYYMMddHHmmss(x.getFechaRegistro()), 
							  x.getEstado()==1?"Activo":"Inactivo", 
							  x.getPais().getNombre()};
				dtm.addRow(f);
			}
		}
	}
	
	
}










