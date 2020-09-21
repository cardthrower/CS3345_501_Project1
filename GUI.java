import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JTextPane;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel sortButtons = new JPanel();
		sortButtons.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		sortButtons.setBounds(10, 11, 116, 210);
		contentPane.add(sortButtons);
		sortButtons.setLayout(null);
		
		JButton btnNewButton = new JButton("Insertion Sort");
		btnNewButton.setBounds(8, 11, 99, 29);
		sortButtons.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Selection Sort");
		btnNewButton_1.setBounds(8, 51, 99, 29);
		sortButtons.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quick Sort");
		btnNewButton_2.setBounds(8, 91, 99, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sortButtons.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Heap Sort");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(8, 131, 99, 29);
		sortButtons.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Radix Sort");
		btnNewButton_4.setBounds(8, 171, 99, 29);
		sortButtons.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(136, 91, 288, 36);
		contentPane.add(panel_1);
		
		JSlider slider = new JSlider();
		panel_1.add(slider);
		slider.setMaximum(50000);
		
		JPanel winningAlgorithm = new JPanel();
		winningAlgorithm.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		winningAlgorithm.setBounds(243, 11, 103, 36);
		contentPane.add(winningAlgorithm);
		
		JTextPane txtpnWinningAlgorithm = new JTextPane();
		winningAlgorithm.add(txtpnWinningAlgorithm);
		txtpnWinningAlgorithm.setText("Winning Algorithm");
	}
}
