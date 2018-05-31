import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Gui {

	private static JFrame frame;
	public Memory m;
	private static JTextField result;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		m = new Memory();
		frame = new JFrame();
		frame.setBounds(700, 200, 472, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("Schritt");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.run();
			}
		});
		btnStart.setBounds(12, 322, 97, 25);
		frame.getContentPane().add(btnStart);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setBounds(345, 322, 97, 25);
		frame.getContentPane().add(btnClose);
		
		JButton btnResetMemory = new JButton("Reset");
		btnResetMemory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Memory.deleteThoughts();
				Level.setSchritt();
				Level.setRoutine();
			}
		});
		btnResetMemory.setBounds(121, 322, 97, 25);
		frame.getContentPane().add(btnResetMemory);
		
		/*
		JTextPane guiText = new JTextPane();
		guiText.setBounds(12, 13, 430, 206);
		frame.getContentPane().add(guiText);
		*/
		
		/*
		result = new JTextField();
		result.setBackground(SystemColor.menu);
		result.setBorder(null);
		result.setBounds(12, 236, 430, 22);
		frame.getContentPane().add(result);
		result.setColumns(10);
		*/
		setText("Hoi Adina lass uns starten :)");
	}
	
	public static void setText(String s) {
		JTextPane guiText = new JTextPane();
		guiText.setBounds(12, 13, 430, 206);
		frame.getContentPane().add(guiText);
		guiText.setText(s);
	}
	
	public static void setResulttext(String s) {
		result = new JTextField();
		result.setBackground(SystemColor.menu);
		result.setBorder(null);
		result.setBounds(12, 236, 430, 22);
		frame.getContentPane().add(result);
		result.setColumns(10);
		result.setText(s);
	}
}
