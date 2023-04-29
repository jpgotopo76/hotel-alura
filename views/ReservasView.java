package views;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import jdbc.controller.ReservasController;
import jdbc.modelo.Reserva;
import util.ConvertirFecha;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.awt.Label;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class ReservasView extends JFrame {

	private JPanel contentPane;
	
	private ReservasController reservasController;
	public static JTextField txtValor;
	public static JDateChooser txtFechaEntrada;
	public static JDateChooser txtFechaSalida;
	public static JComboBox<String> txtFormaPago;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelAtras;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
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
	public ReservasView() {
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(255, 255, 255));
		setTitle("Reservas");
		//Instanciando la clase ReservasController en el constructor
		this.reservasController = new ReservasController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		//contentPane.add(panel);
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		// La interfáz gráfica
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setForeground(SystemColor.textHighlight);
		separator.setBounds(68, 281, 289, 11);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(68, 453, 289, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.textHighlight);
		separator_2.setBackground(SystemColor.textHighlight);
		separator_2.setBounds(68, 195, 289, 2);
		panel.add(separator_2);
		
		JLabel CheckInLb = new JLabel("Fecha de Check In");
		CheckInLb.setFont(new Font("Montserrat Medium", Font.PLAIN, 18));
		CheckInLb.setForeground(SystemColor.textInactiveText);
		CheckInLb.setBounds(68, 136, 169, 14);
		panel.add(CheckInLb);
		
		JLabel CheckOutLb = new JLabel("Fecha de Check Out");
		CheckOutLb.setForeground(SystemColor.textInactiveText);
		CheckOutLb.setFont(new Font("Montserrat Medium", Font.PLAIN, 18));
		CheckOutLb.setBounds(68, 221, 189, 14);
		panel.add(CheckOutLb);
		
		JLabel FormaDePago = new JLabel("Forma de Pago");
		FormaDePago.setBackground(new Color(158, 213, 245));
		FormaDePago.setForeground(SystemColor.textInactiveText);
		FormaDePago.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
		FormaDePago.setBounds(68, 380, 187, 24);
		panel.add(FormaDePago);
		
		JLabel TituloLb = new JLabel("Sistema de Reservas");
		TituloLb.setForeground(new Color(12, 139, 220));
		TituloLb.setFont(new Font("Montserrat", Font.BOLD, 22));
		TituloLb.setBounds(92, 54, 248, 42);
		panel.add(TituloLb);
		
		JPanel panelRight = new JPanel();
		panelRight.setForeground(new Color(15, 140, 200));
		panelRight.setBounds(430, 0, 480, 560);
		panelRight.setLayout(null);
		panel.add(panelRight);
		
		JLabel logo = new JLabel("");
		logo.setBounds(197, 69, 104, 107);
		logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/Ha-100px.png")));
		panelRight.add(logo);
		
		JLabel lblImageBackground = new JLabel("");
		lblImageBackground.setBounds(0, 140, 500, 409);
		panelRight.add(lblImageBackground);
		lblImageBackground.setBackground(Color.WHITE);
		lblImageBackground.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/reservas-img-3.png")));
		
		
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(SystemColor.textHighlight);
		separator_3.setBackground(SystemColor.textHighlight);
		separator_3.setBounds(68, 362, 289, 2);
		panelRight.add(separator_3);
			
		JLabel lblValor = new JLabel("Valor de la Reserva");
		lblValor.setBounds(72, 306, 196, 14);
		panel.add(lblValor);
		lblValor.setBackground(new Color(255, 128, 0));
		lblValor.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblValor.setForeground(SystemColor.textInactiveText);
		
		final JPanel buttonexit = new JPanel();
		buttonexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 buttonexit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		buttonexit.setLayout(null);
		buttonexit.setBounds(429, 0, 53, 36);
		buttonexit.setBackground(new Color(12, 138, 199));
		panelRight.add(buttonexit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		buttonexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Montserrat", Font.PLAIN, 18));
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);
		
		final JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		
		JLabel lblSiguiente = new JLabel("SIGUIENTE");
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.WHITE);
		lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSiguiente.setBounds(0, 0, 122, 35);
		
		//Campos que guardaremos en la base de datos
		txtFechaEntrada = new JDateChooser();
		txtFechaEntrada.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				procesarReserva(txtFechaEntrada, txtFechaSalida);
			}
		});
		txtFechaEntrada = new JDateChooser();
		txtFechaSalida = new JDateChooser();
		txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaEntrada.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaEntrada.setBounds(68, 161, 289, 35);
		txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaEntrada.setBackground(Color.WHITE);
		txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(txtFechaEntrada);
		
		txtFechaSalida = new JDateChooser();
		txtFechaSalida.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaSalida.setBounds(68, 246, 289, 35);
		txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
		txtFechaSalida.setBackground(Color.WHITE);
		txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				//Activa el evento, después del usuario seleccionar las fechas se debe calcular el valor de la reserva
			}
		});
		txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtFechaSalida);
		
		txtValor = new JTextField();
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(78, 328, 99, 33);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(68, 417, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo", "Yape"}));
		panel.add(txtFormaPago);
		
		JPanel btnsiguiente = new JPanel();
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ReservasView.txtFechaEntrada.getDate() != null && ReservasView.txtFechaSalida.getDate() != null) {		
					//RegistroHuesped registro = new RegistroHuesped(0);
					//registro.setVisible(true);
					guardarReserva();
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
				}
			}						
		});
		btnsiguiente.setLayout(null);
		btnsiguiente.setBackground(SystemColor.textHighlight);
		btnsiguiente.setBounds(238, 493, 122, 35);
		panel.add(btnsiguiente);
		btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		// Agregar etiqueta de texto al botón
		JLabel btnText = new JLabel("Siguiente");
		btnText.setForeground(Color.WHITE);
		btnText.setFont(new Font("Montserrat", Font.BOLD, 14));
		btnText.setHorizontalAlignment(SwingConstants.CENTER);
		btnText.setBounds(0, 0, btnsiguiente.getWidth(), btnsiguiente.getHeight());
		btnsiguiente.add(btnText);
	}
	
	private double calcularPrecio(int numDias) {
	    double tasaDia = 500.0; // Tasa por día
	    return numDias * tasaDia;
	  }
	public void procesarReserva(JDateChooser txtFechaEntrada, JDateChooser txtFechaSalida) {
	    BigDecimal tasaPorDia = new BigDecimal("500.00");
	    BigDecimal tasaTotal = new BigDecimal(0.0);
	    
	    // Verificar si ambas fechas son no nulas
	    if (txtFechaEntrada.getDate() != null && txtFechaSalida.getDate() != null) {
	        // Convertir las fechas a objetos LocalDate
	        LocalDate fechaEntrada = ConvertirFecha.convertirDateALocalDate(txtFechaEntrada.getDate());
	        LocalDate fechaSalida = ConvertirFecha.convertirDateALocalDate(txtFechaSalida.getDate());
	        
	        // Calcular la diferencia de días
	        long diferenciaEnDias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
	        
	        // Calcular la tasa total de la reserva
	        tasaTotal = tasaPorDia.multiply(BigDecimal.valueOf(diferenciaEnDias));
	        txtValor.setText(tasaTotal.toString());
	        
	        // Hacer algo con la tasa total
	        System.out.println("La tasa total de la reserva es: " + tasaTotal);
	    } else if (txtFechaEntrada.getDate() == null && txtFechaSalida.getDate() == null) {
	        JOptionPane.showMessageDialog(null, "Debes seleccionar una fecha de entrada y una fecha de salida.");
	    } else if (txtFechaEntrada.getDate() == null) {
	        JOptionPane.showMessageDialog(null, "Debes seleccionar una fecha de entrada.");
	    } else if (txtFechaSalida.getDate() == null) {
	        JOptionPane.showMessageDialog(null, "Debes seleccionar una fecha de salida.");
	    }
	}

	
	
	private void guardarReserva() {
		String FechaE = ((JTextField)txtFechaEntrada.getDateEditor().getUiComponent()).getText();
		String FechaS = ((JTextField)txtFechaSalida.getDateEditor().getUiComponent()).getText();
		Reserva nuevaReserva = new Reserva(java.sql.Date.valueOf(FechaE), java.sql.Date.valueOf(FechaS),txtValor.getText(), txtFormaPago.getSelectedItem().toString());
		reservasController.guardar(nuevaReserva);
		
		JOptionPane.showMessageDialog(contentPane, "Reserva Guardada Exitosamente, id: " + nuevaReserva.getId_Reserva());
		
		RegistroHuesped huesped = new RegistroHuesped(nuevaReserva.getId_Reserva());
		huesped.setVisible(true);
		dispose();
	}
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
	}

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
