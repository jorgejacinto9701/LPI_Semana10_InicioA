package gui.consulta.relacionada;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class FrmConsultaClub extends JFrame   {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


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
		setBounds(100, 100, 608, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaDeCampeonatos = new JLabel("Consulta de club");
		lblConsultaDeCampeonatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeCampeonatos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConsultaDeCampeonatos.setBounds(10, 26, 572, 36);
		contentPane.add(lblConsultaDeCampeonatos);
		
	}	
}










