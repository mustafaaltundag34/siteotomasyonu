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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JDialog;

public class siteBlokbolumbilgiekleduzenle extends JDialog {

	private JPanel contentPane;
	private JTextField textdaireno;
	private JTextField textblokno;
	private JTextField textdairesahibi;
	private JTextField textdairekati;
	private JTextField textelektrikno;
	private JTextField textsuno;
	private JTextField textdogalgazno;
	private JTextField textoturansayisi;
	private JTextField telefon;
	private JTextField oturan;
	private JTextField tel;
	JTextArea textaciklama;
	JComboBox comboaktiflik;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteBlokbolumbilgiekleduzenle frame = new siteBlokbolumbilgiekleduzenle();
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
	public siteBlokbolumbilgiekleduzenle() {
		setModal(true);
		setResizable(false);
		setTitle("Site Bolum Bilgisi Detaylari");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 941, 404);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label100 = new JLabel("");
		label100.setHorizontalAlignment(SwingConstants.CENTER);
		label100.setOpaque(true);
		label100.setBackground(Color.WHITE);
		label100.setBounds(10, 60, 211, 296);
		Image  img=new ImageIcon(this.getClass().getResource("/key-icon.png")).getImage();
		label100.setIcon(new ImageIcon(img));
		contentPane.add(label100);
		
		JLabel lblNewLabel = new JLabel("Site Bolum Bilgisi Detaylari");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 294, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bolum Adi veya No: *");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(231, 90, 144, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTcNo = new JLabel("Blok Adi: *");
		lblTcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo.setBounds(231, 60, 69, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblTelefon = new JLabel("Bolum Sahibi:");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(231, 120, 90, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblEposta = new JLabel("Daire Kati:");
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEposta.setBounds(231, 240, 76, 14);
		contentPane.add(lblEposta);
		
		JLabel lblifre = new JLabel("Aktiflik:");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre.setBounds(231, 270, 69, 14);
		contentPane.add(lblifre);
		
		JLabel lblifre_1 = new JLabel("Aciklama:");
		lblifre_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre_1.setBounds(559, 180, 69, 14);
		contentPane.add(lblifre_1);
		
		textdaireno = new JTextField();
		textdaireno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textdairesahibi.requestFocus();
				}
			}
		});
		textdaireno.setBounds(385, 90, 164, 20);
		contentPane.add(textdaireno);
		textdaireno.setColumns(10);
		
		textblokno = new JTextField();
		textblokno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textdaireno.requestFocus();
				}
			}
		});
		textblokno.setEditable(false);
		textblokno.setEnabled(false);
		//textblokno.setEnabled(false);
		textblokno.setBounds(385, 60, 164, 20);
		contentPane.add(textblokno);
		textblokno.setColumns(10);
		
		textdairesahibi = new JTextField();
		textdairesahibi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					telefon.requestFocus();
				}
			}
		});
		textdairesahibi.setColumns(10);
		textdairesahibi.setBounds(385, 120, 164, 20);
		contentPane.add(textdairesahibi);
		
		textdairekati = new JTextField();
		textdairekati.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (textdairekati.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboaktiflik.requestFocus();
				}
			}
		});
		textdairekati.setHorizontalAlignment(SwingConstants.RIGHT);
		textdairekati.setText("0");
		textdairekati.setColumns(10);
		textdairekati.setBounds(385, 240, 164, 20);
		contentPane.add(textdairekati);
		
		comboaktiflik = new JComboBox();
		comboaktiflik.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textelektrikno.requestFocus();
				}
			}
		});
		comboaktiflik.setModel(new DefaultComboBoxModel(new String[] {"BOS", "DOLU"}));
		comboaktiflik.setBounds(385, 270, 164, 22);
		contentPane.add(comboaktiflik);
 
		
		textaciklama = new JTextArea();
			contentPane.add(textaciklama);
			textaciklama.addKeyListener(new KeyAdapter() {
		        @Override
		        public void keyTyped(KeyEvent e) {
		            if (textaciklama.getText().length() >= 100 ) // limit to 3 characters
		                e.consume();
		        }
				@Override
				public void keyPressed(KeyEvent e) {

					if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textblokno.requestFocus();
					}
				}
		    });
			JScrollPane scroll = new JScrollPane(textaciklama);
			scroll.setBounds(721, 180, 170, 74);                     // <-- THIS
		    getContentPane().add(scroll);
		    setLocationRelativeTo ( null );
		    textaciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
		    textaciklama.setLineWrap(true); //satir sonu bir alta almak icin
		
		
		JLabel lblElektrikTesisatNo = new JLabel("Elektrik Tesisat No:");
		lblElektrikTesisatNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblElektrikTesisatNo.setBounds(559, 60, 116, 14);
		contentPane.add(lblElektrikTesisatNo);
		
		JLabel lblSuTesisatNo = new JLabel("Su Tesisat No:");
		lblSuTesisatNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSuTesisatNo.setBounds(559, 90, 116, 14);
		contentPane.add(lblSuTesisatNo);
		
		JLabel lblDoalgazTesisatNo = new JLabel("Dogalgaz Tesisat No:");
		lblDoalgazTesisatNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDoalgazTesisatNo.setBounds(559, 120, 133, 14);
		contentPane.add(lblDoalgazTesisatNo);
		
		JLabel lblOturanSays = new JLabel("Oturan Sayisi:");
		lblOturanSays.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOturanSays.setBounds(559, 150, 116, 14);
		contentPane.add(lblOturanSays);
		
		textelektrikno = new JTextField();
		textelektrikno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textsuno.requestFocus();
				}
			}
		});
		textelektrikno.setBounds(721, 60, 170, 20);
		contentPane.add(textelektrikno);
		textelektrikno.setColumns(10);
		
		textsuno = new JTextField();
		textsuno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textdogalgazno.requestFocus();
				}
			}
		});
		textsuno.setBounds(721, 90, 170, 20);
		contentPane.add(textsuno);
		textsuno.setColumns(10);
		
		textdogalgazno = new JTextField();
		textdogalgazno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textoturansayisi.requestFocus();
				}
			}
		});
		textdogalgazno.setBounds(721, 120, 170, 20);
		contentPane.add(textdogalgazno);
		textdogalgazno.setColumns(10);
		
		textoturansayisi = new JTextField();
		textoturansayisi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (textoturansayisi.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textaciklama.requestFocus();
				}
			}
		});
		textoturansayisi.setHorizontalAlignment(SwingConstants.RIGHT);
		textoturansayisi.setText("0");
		textoturansayisi.setBounds(721, 150, 170, 20);
		contentPane.add(textoturansayisi);
		textoturansayisi.setColumns(10);
		
		JLabel lblSahipTel = new JLabel("Sahip Telefon:");
		lblSahipTel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSahipTel.setBounds(231, 150, 90, 14);
		contentPane.add(lblSahipTel);
		
		telefon = new JTextField();
		telefon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (telefon.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					oturan.requestFocus();
				}
			}
		});
		telefon.setColumns(10);
		telefon.setBounds(385, 150, 164, 20);
		contentPane.add(telefon);
		
		JLabel lblBolumOturan = new JLabel("Kiraci Adi Soyadi :");
		lblBolumOturan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBolumOturan.setBounds(231, 180, 120, 14);
		contentPane.add(lblBolumOturan);
		
		JLabel lblOturanTelefon = new JLabel("Oturan Telefon:");
		lblOturanTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOturanTelefon.setBounds(231, 210, 120, 14);
		contentPane.add(lblOturanTelefon);
		
		oturan = new JTextField();
		oturan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					tel.requestFocus();
				}
			}
		});
		oturan.setColumns(10);
		oturan.setBounds(385, 180, 164, 20);
		contentPane.add(oturan);
		
		tel = new JTextField();
		tel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (tel.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textdairekati.requestFocus();
				}
			}
		});
		tel.setColumns(10);
		tel.setBounds(385, 210, 164, 20);
		contentPane.add(tel);
		
		JButton btnekle = new JButton("Kaydet");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(textblokno.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					 
					String aktiflik =comboaktiflik.getSelectedItem().toString(); 
					String sorgu_kaydet="insert into sitebolumbilgi(Blokadi,Blokbolumadi,Bolumsahibi,Bolumoturankisi,Bolumaciklama,Bolumkati,Bolumaktiflik,Bolumotopark1,Bolumotopark2,Bolumotopark3,Bolumelektriktesisatno,Bolumsutesisatno,Bolumdogalgaztesisatno,Bolumpaftano,Bolumoturansayisi,Bolumsahibitelefon,Bolumoturankisitelefon)values('"+textblokno.getText() +"','"+ textdaireno.getText()+"','"+textdairesahibi.getText() +"','"+ oturan.getText()+"','"+ textaciklama.getText()+"','"+textdairekati.getText()+"','"+aktiflik+"','','','','"+textelektrikno.getText()+"','"+textsuno.getText()+"','"+textdogalgazno.getText()+"','','"+textoturansayisi.getText()+"','"+telefon.getText()+"','"+tel.getText()+"')";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Islem Basarili");
							 
							
							
							//siteBlokbolumbilgi frame = new siteBlokbolumbilgi();
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
		btnekle.setBounds(235, 323, 108, 33);
		
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//siteBlokbolumbilgi form = new siteBlokbolumbilgi();
				//form.show();
				//form.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(493, 323, 108, 33);
		contentPane.add(btnvazgec);
		

		
		JButton temizle = new JButton("Temizle");
		temizle.setFont(new Font("Tahoma", Font.BOLD, 14));
		temizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textblokno.setText("");
				//textdaireno.setText("");
				textdairesahibi.setText("");
				telefon.setText("");
				oturan.setText("");
				tel.setText("");
				textdairekati.setText("");
				 
 
				textelektrikno.setText("");
				textsuno.setText("");
				textdogalgazno.setText("");
				textoturansayisi.setText("");
				textaciklama.setText("");
			}
		});
		temizle.setBounds(375, 323, 108, 33);
		contentPane.add(temizle);
		
		JButton btnDuzenle = new JButton("Guncelle");
		btnDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textblokno.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					 
					String aktiflik =comboaktiflik.getSelectedItem().toString(); 
					String sorgu_kaydet="update  sitebolumbilgi set Blokadi='"+textblokno.getText()+"',Blokbolumadi='"+textdaireno.getText()+"',Bolumsahibi='"+textdairesahibi.getText()+"',Bolumoturankisi='"+oturan.getText()+"',Bolumaciklama='"+textaciklama.getText()+"',Bolumkati='"+textdairekati.getText()+"',Bolumaktiflik='"+aktiflik+"',Bolumotopark1='',Bolumotopark2='',Bolumotopark3='',Bolumelektriktesisatno='"+textelektrikno.getText()+"',Bolumsutesisatno='"+textsuno.getText()+"',Bolumdogalgaztesisatno='"+textdogalgazno.getText()+"',Bolumpaftano='',Bolumoturansayisi='"+textoturansayisi.getText()+"',Bolumsahibitelefon='"+telefon.getText()+"',Bolumoturankisitelefon='"+tel.getText()+"'  where BolumId='"+siteBlokbolumbilgi.id_sakla+"'";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
							 
							
							
							//siteBlokbolumbilgi frame = new siteBlokbolumbilgi();
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
		btnDuzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDuzenle.setBounds(235, 323, 108, 33);
		if(siteBlokbolumbilgi.id==0) {
			textblokno.setText(siteBlokbolumbilgi.id_al);
			contentPane.add(btnekle);
		}
		else {
			textdaireno.enable(false);
			contentPane.add(btnDuzenle);
		}
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			 
				siteBlokbolumbilgi.id_sakla=siteBlokbolumbilgi.id;
				siteBlokbolumbilgi.id=0;
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();
				
				ResultSet rs = null;
				try {
					
					String listele="Select * From sitebolumbilgi where BolumId='"+siteBlokbolumbilgi.id_sakla+"'";
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					if(rs.next())
					{ 
						
						textblokno.setText(rs.getString("Blokadi"));
						textdaireno.setText(rs.getString("Blokbolumadi"));
						textdairesahibi.setText(rs.getString("Bolumsahibi"));
						telefon.setText(rs.getString("Bolumsahibitelefon"));
						oturan.setText(rs.getString("Bolumoturankisi"));
						tel.setText(rs.getString("Bolumoturankisitelefon"));
						textdairekati.setText(rs.getString("Bolumkati"));
						 
							String aktif=rs.getString("Bolumaktiflik");
								if(aktif.equals("BOS"))
								{
									comboaktiflik.setSelectedIndex(0);
								}
								else
								{
									comboaktiflik.setSelectedIndex(1);
								}
						textelektrikno.setText(rs.getString("Bolumelektriktesisatno"));
						textsuno.setText(rs.getString("Bolumsutesisatno"));
						textdogalgazno.setText(rs.getString("Bolumdogalgaztesisatno"));
						textoturansayisi.setText(rs.getString("Bolumoturansayisi"));
						textaciklama.setText(rs.getString("Bolumaciklama"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
	}
}
