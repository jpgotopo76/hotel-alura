package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class ReservaWindow {

	private JFrame frmReservas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaWindow window = new ReservaWindow();
					window.frmReservas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReservaWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReservas = new JFrame();
		frmReservas.setTitle("Reservas");
		frmReservas.setBounds(100, 100, 910, 560);
		frmReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReservas.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmReservas.getContentPane().add(panel, BorderLayout.NORTH);
	}

}
