package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class siteBlokbilgiekleduzenle extends JDialog {

	private JPanel contentPane;
	private JTextField textblokadi;
	private JTextField textdiskapino;
	private JTextField textblokno;
	private JTextField textelektriktesisatno;
	private JTextField textsutesisatno;
	private JTextField textdogalgazno;
	private JComboBox textsorumlusu;
	static Connection myconn,myconna;
	static Statement mystat,mystata,mystata1;
	private JTextField blokaciklamatxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteBlokbilgiekleduzenle frame = new siteBlokbilgiekleduzenle();
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
	public siteBlokbilgiekleduzenle() {
		setModal(true);
		setResizable(false);
		setTitle("Site Blok Bilgi Detaylari");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 658, 383);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(10, 55, 193, 270);
		Image  img=new ImageIcon(this.getClass().getResource("/apartment-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Site Blok Bilgi Detaylari");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 294, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Blok Adi:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(223, 60, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTcNo = new JLabel("Dis Kapi No:");
		lblTcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo.setBounds(223, 90, 79, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblTelefon = new JLabel("Sorumlusu:");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(223, 120, 69, 14);
		contentPane.add(lblTelefon);
		
		//JLabel lblEposta = new JLabel("Blok No:");
		//lblEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		//lblEposta.setBounds(223, 150, 69, 14);
		//contentPane.add(lblEposta);
		
		JLabel lblifre = new JLabel("Elektrik Tesisat No:");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre.setBounds(223, 180, 130, 14);
		contentPane.add(lblifre);
		
		JLabel lblifre_1 = new JLabel("Su Tesisat No:");
		lblifre_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre_1.setBounds(223, 210, 130, 14);
		contentPane.add(lblifre_1);
		
		textblokadi = new JTextField();
		textblokadi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textdiskapino.requestFocus();
				}
			}
		});
		textblokadi.setBounds(400, 60, 202, 20);
		contentPane.add(textblokadi);
		textblokadi.setColumns(10);
		
		textdiskapino = new JTextField();
		textdiskapino.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textsorumlusu.requestFocus();
				}
			}
		});
		textdiskapino.setBounds(400, 90, 202, 20);
		contentPane.add(textdiskapino);
		textdiskapino.setColumns(10);
		
		//textsorumlusu = new JTextField();
		//textsorumlusu.setColumns(10);
		//textsorumlusu.setBounds(400, 120, 202, 20);
		//contentPane.add(textsorumlusu);
		
		
	     // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		textsorumlusu = new JComboBox();
		textsorumlusu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					blokaciklamatxt.requestFocus();
				}
			}
		});
		textsorumlusu.setBounds(400, 120, 202, 20);
		contentPane.add(textsorumlusu);
		 // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		
//		textblokno = new JTextField();
//		textblokno.setColumns(10);
//		textblokno.setBounds(400, 150, 202, 20);
//		contentPane.add(textblokno);
		
		textelektriktesisatno = new JTextField();
		textelektriktesisatno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textsutesisatno.requestFocus();
				}
			}
		});
		textelektriktesisatno.setColumns(10);
		textelektriktesisatno.setBounds(400, 180, 202, 20);
		contentPane.add(textelektriktesisatno);
		
		
		textsutesisatno = new JTextField();
		textsutesisatno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textdogalgazno.requestFocus();
				}
			}
		});
		textsutesisatno.setColumns(10);
		textsutesisatno.setBounds(400, 210, 202, 20);
		contentPane.add(textsutesisatno);
		
		JLabel lblDoalgazTesisatNo = new JLabel("Dogalgaz Tesisat No:");
		lblDoalgazTesisatNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDoalgazTesisatNo.setBounds(223, 240, 130, 14);
		contentPane.add(lblDoalgazTesisatNo);
		
		textdogalgazno = new JTextField();
		textdogalgazno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textblokadi.requestFocus();
				}
			}
		});
		textdogalgazno.setColumns(10);
		textdogalgazno.setBounds(400, 240, 202, 20);
		contentPane.add(textdogalgazno);
		
		JLabel lblAciklama = new JLabel("Aciklama :");
		lblAciklama.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAciklama.setBounds(223, 151, 130, 14);
		contentPane.add(lblAciklama);
		
		blokaciklamatxt = new JTextField();
		blokaciklamatxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textelektriktesisatno.requestFocus();
				}
			}
		});
		blokaciklamatxt.setColumns(10);
		blokaciklamatxt.setBounds(400, 151, 202, 20);
		contentPane.add(blokaciklamatxt);
		
		
		JButton btnekle = new JButton("Kaydet");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textblokadi.getText().equals("")) ||(textsorumlusu.getSelectedItem().equals("")))
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					String sorgu_kaydet="insert into siteblokbilgi(Blokaciklama,Blokdiskapino,Blokadi,Bloksorumlusu,Blokortakelektriktesisatno,Blokortaksutesisatno,Blokortakdogalgaztesisatno,Blokadres,Blokilce,Bloksehir,Bloksiteadi)values('"+blokaciklamatxt.getText() +"','"+textdiskapino.getText() +"','"+ textblokadi.getText()+"','"+textsorumlusu.getSelectedItem().toString() +"','"+textelektriktesisatno.getText()+"','"+textsutesisatno.getText()+"','"+textdogalgazno.getText()+"','','','','')";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Islem Basarili");
							 
							
							
							//siteBlokbilgi frame = new siteBlokbilgi();
							//frame.show();
							//frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							dispose(); 
						 
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 						
				}
				
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(223, 292, 108, 33);
		if (siteBlokbilgi.id==0) contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//siteBlokbilgi form = new siteBlokbilgi();
			//form.show();
			//form.setLocationRelativeTo(null);
			dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(473, 292, 112, 33);
		contentPane.add(btnvazgec);
		

		
		JButton btnNewButton = new JButton("Temizle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textblokadi.setText("");
				textdiskapino.setText("");
				//textsorumlusu.setText("");
				//textblokno.setText("");
				textelektriktesisatno.setText("");
				textsutesisatno.setText("");
				textdogalgazno.setText("");
				blokaciklamatxt.setText("");
			}
		});
		btnNewButton.setBounds(340, 292, 112, 33);
		contentPane.add(btnNewButton);
		

		JButton btnDuzenle = new JButton("Guncelle");
		btnDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((textblokadi.getText().equals("")) ||(textsorumlusu.getSelectedItem().equals("")))
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					 
					 
					String sorgu_guncelle="update  siteblokbilgi set Blokaciklama='"+blokaciklamatxt.getText() +"',Blokdiskapino='"+textdiskapino.getText() +"',Blokadi='"+ textblokadi.getText()+"',Bloksorumlusu='"+textsorumlusu.getSelectedItem().toString() +"',Blokortakelektriktesisatno='"+textelektriktesisatno.getText()+"',Blokortaksutesisatno='"+textsutesisatno.getText()+"',Blokortakdogalgaztesisatno='"+textdogalgazno.getText()+"',Blokadres='',Blokilce='',Bloksehir='',Bloksiteadi='' where BlokID='"+siteBlokbilgi.id_sakla+"'";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_guncelle);
							JOptionPane.showMessageDialog(null,"Islem Basarili");
							 
							
							
							siteBlokbilgi frame = new siteBlokbilgi();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							dispose(); 
						 
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 						
						
				 
				 
				}
				
			}
		});
		btnDuzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDuzenle.setBounds(223, 292, 108, 33);
		
		if (siteBlokbilgi.id==0) contentPane.add(btnekle);
		else {
			textblokadi.enable(false);
			contentPane.add(btnDuzenle);
		}
	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			 
				siteBlokbilgi.id_sakla=siteBlokbilgi.id;
				siteBlokbilgi.id=0;
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();
				
				ResultSet rsa1 = null;
				textsorumlusu.removeAllItems();   
				
				ResultSet rs = null;
				try {
					
					myconna=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					String listele_personel="Select * From sitepersonelbilgi";
					mystata1=myconna.createStatement();
					rsa1=mystata1.executeQuery(listele_personel);
					
					while(rsa1.next())
					{  //veritabanýndaki avukat ad ve soyadlar otomatik combobox'a geliyor. //Ve öyle ekletiyoruz veritabanýna
						textsorumlusu.addItem(rsa1.getString("Personeladsoyad"));
						
					}
					//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement
					
					String listele="Select * From siteblokbilgi where BlokID='"+siteBlokbilgi.id_sakla+"'";
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					if(rs.next())
					{ 
						
						textblokadi.setText(rs.getString("Blokadi"));
						textdiskapino.setText(rs.getString("Blokdiskapino"));
						textsorumlusu.setSelectedItem(rs.getString("Bloksorumlusu"));
						//textblokno.setText(rs.getString("Blokno"));
						textelektriktesisatno.setText(rs.getString("Blokortakelektriktesisatno"));
						textsutesisatno.setText(rs.getString("Blokortaksutesisatno"));
						textdogalgazno.setText(rs.getString("Blokortakdogalgaztesisatno"));
						blokaciklamatxt.setText(rs.getString("blokaciklama"));
						 
				 
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
	
	}
}
