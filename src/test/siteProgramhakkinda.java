package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JDialog;

public class siteProgramhakkinda extends JDialog {

	private JPanel contentPane;
	private JTextField txtDocDrPnar;
	private JTextField txtHukukBurosuOtomasyonu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteProgramhakkinda frame = new siteProgramhakkinda();
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
	public siteProgramhakkinda() {
		setModal(true);
		setResizable(false);
		setTitle("Hakkimizda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 524);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Developer Ekibimiz :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 100, 202, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblUygulamaAdimiz = new JLabel("Proje Adi :");
		lblUygulamaAdimiz.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUygulamaAdimiz.setBounds(10, 60, 202, 26);
		contentPane.add(lblUygulamaAdimiz);
		
		JLabel lblProjeDersi = new JLabel("Proje Akademisyeni :");
		lblProjeDersi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProjeDersi.setBounds(10, 20, 202, 26);
		contentPane.add(lblProjeDersi);
		
		txtDocDrPnar = new JTextField();
		txtDocDrPnar.setBackground(Color.WHITE);
		txtDocDrPnar.setEditable(false);
		txtDocDrPnar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDocDrPnar.setText("Doc. Dr. Alpay DORUK");
		txtDocDrPnar.setHorizontalAlignment(SwingConstants.CENTER);
		txtDocDrPnar.setBounds(307, 20, 261, 26);
		contentPane.add(txtDocDrPnar);
		txtDocDrPnar.setColumns(10);
		
		txtHukukBurosuOtomasyonu = new JTextField();
		txtHukukBurosuOtomasyonu.setBackground(Color.WHITE);
		txtHukukBurosuOtomasyonu.setEditable(false);
		txtHukukBurosuOtomasyonu.setHorizontalAlignment(SwingConstants.CENTER);
		txtHukukBurosuOtomasyonu.setText("Site Otomasyonu");
		txtHukukBurosuOtomasyonu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHukukBurosuOtomasyonu.setColumns(10);
		txtHukukBurosuOtomasyonu.setBounds(307, 60, 261, 26);
		contentPane.add(txtHukukBurosuOtomasyonu);
		
		JList list = new JList();
		list.setVisibleRowCount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBackground(Color.WHITE);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Yilmaz OLMEZ", "Zerrin CERKES", "Sare OZKAN", "Devrim GUNES", "D\u00F6ne ATES", "Muhammed BEYYUD", "Hasan HACISULEYMAN", "Yunus MAZOOGLU", "Mehmet Salih OZTURK", "Mustafa ALTUNDAG"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(307, 137, 261, 292);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Tamam");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(8, 440, 560, 36);
		contentPane.add(btnNewButton);
		
		
		JLabel labelanafoto = new JLabel("");
		labelanafoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelanafoto.setOpaque(true);
		labelanafoto.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/apartment-icon.png")).getImage();
		labelanafoto.setIcon(new ImageIcon(img));
		labelanafoto.setBounds(10, 137, 277, 292);
		contentPane.add(labelanafoto);
	}
}
