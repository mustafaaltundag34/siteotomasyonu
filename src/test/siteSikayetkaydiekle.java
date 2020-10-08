package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class siteSikayetkaydiekle extends JDialog {

	private JPanel contentPane;
	//private JTextField adsoyad;

	private JTextField aksiyon;
	private JTextField irtibatbilgi;
	
	private JComboBox blokaditxt;
	private JComboBox blokbolumaditxt;
	private JComboBox adsoyad;
	private JComboBox sikayetialan;

	JComboBox comboaktiflik;
	JTextArea aciklama;
	private JTextField islemnotxt;
//	private JTextField textField;
	static Connection myconn,myconna;
	static Statement mystat,mystata,mystata1,mystata2,mystata3;

	
	private JComboBox hatirlattxt;
	private JComboBox zaman;
	private JTextField hakedistxt;
	private JTextField logkullaniciadi;
	private JTextField logzamani;
	private JTextField logaciklama;
	private JTextField logkullaniciyetkisi;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteSikayetkaydiekle frame = new siteSikayetkaydiekle();
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
	public siteSikayetkaydiekle() {
		setModal(true);
		setResizable(false);
		setTitle("Sikayet Kaydi Ekle Duzenle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1063, 556);
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
		label.setBounds(10, 52, 267, 451);
		Image  img=new ImageIcon(this.getClass().getResource("/folder-documents-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Sikayet Kaydi Ekle Duzenle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 294, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Blok Bolum Adi: *");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(311, 114, 118, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTcNo = new JLabel("Bolum Sakin Ad Soyad:");
		lblTcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo.setBounds(311, 144, 153, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblTelefon = new JLabel("Sikayeti Alan Personel : ");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(311, 174, 172, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblEposta = new JLabel("Sikayet Zamani:");
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEposta.setBounds(311, 204, 118, 14);
		contentPane.add(lblEposta);
		
		JLabel lblifre = new JLabel("Alinan Aksiyon:");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre.setBounds(311, 332, 139, 14);
		contentPane.add(lblifre);
		
		JLabel lblifre_1 = new JLabel("Detayli Sikayet:");
		lblifre_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre_1.setBounds(311, 235, 153, 14);
		contentPane.add(lblifre_1);
		
		//blokno = new JTextField();
		//blokno.setBounds(388, 115, 156, 20);
		//contentPane.add(blokno);
		//blokno.setColumns(10);
		
		
	     // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		blokbolumaditxt = new JComboBox();
		blokbolumaditxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				adsoyad.removeAllItems();
				ResultSet rsa3 = null;
				try {
					myconn=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					String listele="Select * From sitebolumsakinbilgi where Blokbolumadi='"+blokbolumaditxt.getSelectedItem().toString()+"'";
					mystat=myconn.createStatement();
					rsa3=mystat.executeQuery(listele);
					
					while(rsa3.next())
					 	{  //veritabanýndaki avukat ad ve soyadlar otomatik combobox'a geliyor. //Ve öyle ekletiyoruz veritabanýna
					 		adsoyad.addItem(rsa3.getString("Bolumsakinadsoyad"));
						
					 }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			}
		});
		blokbolumaditxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					adsoyad.requestFocus();
				}
			}
		});
		blokbolumaditxt.setBounds(493, 114, 156, 20);
	    contentPane.add(blokbolumaditxt);
		  // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		
		//adsoyad = new JTextField();
		//adsoyad.setBounds(388, 145, 156, 20);
		//contentPane.add(adsoyad);
		//adsoyad.setColumns(10);
		
	     // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		adsoyad = new JComboBox();
		adsoyad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					sikayetialan.requestFocus();
				}
			}
		});
		adsoyad.setBounds(493, 144, 156, 20);
	    contentPane.add(adsoyad);
		  // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		
		//sikayetialan = new JTextField();
		//sikayetialan.setColumns(10);
		//sikayetialan.setBounds(388, 175, 156, 20);
		//contentPane.add(sikayetialan);
		
	     // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		sikayetialan = new JComboBox();
		sikayetialan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					aciklama.requestFocus();
					
				}
			}
			
		});
		sikayetialan.setBounds(493, 174, 156, 20);
		contentPane.add(sikayetialan);
		 // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
			
		
		//zaman = new JTextField();
		//zaman.setEditable(false);
		//zaman.setEnabled(false);
		//zaman.setColumns(10);
		//zaman.setBounds(474, 204, 156, 20);
		//contentPane.add(zaman);
		
	    JDateChooser zaman = new JDateChooser();
	    zaman.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					aciklama.requestFocus();
				}
	    	}
	    });
	    zaman.setBounds(493, 204, 156, 20);
	    zaman.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(zaman);
		
		//textField = new JTextField();
		//textField.setColumns(10);
		//textField.setBounds(388, 84, 156, 20);
		//contentPane.add(textField);
		
	     // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		blokaditxt = new JComboBox();		 
		blokaditxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				blokbolumaditxt.removeAllItems(); 
				 blokbolumaditxt.setVisible(true);
				
				
				//blokbolumaditxt.removeAll(); 
				ResultSet rs = null;
				
				try {
					myconn=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					String listele="Select * From sitebolumbilgi where Blokadi='"+blokaditxt.getSelectedItem().toString()+"'";
					mystat=myconn.createStatement();
					rs=mystat.executeQuery(listele);
					
					while(rs.next())
					 	{  //veritabanýndaki avukat ad ve soyadlar otomatik combobox'a geliyor. //Ve öyle ekletiyoruz veritabanýna
						blokbolumaditxt.addItem(rs.getString("Blokbolumadi"));
						
					 }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			}
			@Override
			public void focusGained(FocusEvent e) {
			 
			}
		});
		blokaditxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					blokbolumaditxt.requestFocus();
				}
			}
		});
		blokaditxt.setBounds(493, 83, 156, 20);
	    contentPane.add(blokaditxt);
		  // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		
		aciklama = new JTextArea();
		contentPane.add(aciklama);
		aciklama.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (aciklama.getText().length() >= 100 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					irtibatbilgi.requestFocus();
				}
			}
	    });
		JScrollPane scroll = new JScrollPane(aciklama);
		scroll.setBounds(493, 235, 156, 53);                     // <-- THIS
	    getContentPane().add(scroll);
	    setLocationRelativeTo ( null );
	    aciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    aciklama.setLineWrap(true); //satir sonu bir alta almak icin
		
		
		
		aksiyon = new JTextField();
		aksiyon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboaktiflik.requestFocus();
				}
			}
		});
		aksiyon.setColumns(10);
		aksiyon.setBounds(493, 332, 156, 20);
		contentPane.add(aksiyon);
		
		JLabel lblSonDurum = new JLabel("Son Durum:");
		lblSonDurum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSonDurum.setBounds(311, 362, 139, 14);
		contentPane.add(lblSonDurum);
		
		JLabel lblIrtibatBilgisi = new JLabel("Irtibat Bilgisi:");
		lblIrtibatBilgisi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIrtibatBilgisi.setBounds(311, 302, 108, 14);
		contentPane.add(lblIrtibatBilgisi);
		
		irtibatbilgi = new JTextField();
		irtibatbilgi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					aksiyon.requestFocus();
				}
			}
		});
		irtibatbilgi.setColumns(10);
		irtibatbilgi.setBounds(493, 302, 156, 20);
		contentPane.add(irtibatbilgi);
		
		comboaktiflik = new JComboBox();
		comboaktiflik.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hakedistxt.requestFocus();
				}
			}
		});
		comboaktiflik.setModel(new DefaultComboBoxModel(new String[] {"SIKAYET ACIK", "SIKAYET KAPANDI"}));
		comboaktiflik.setBounds(493, 362, 156, 22);
		contentPane.add(comboaktiflik);
		
		JLabel lblNewLabel_1_1 = new JLabel("Islem No: *");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(311, 52, 108, 14);
		contentPane.add(lblNewLabel_1_1);
		
		islemnotxt = new JTextField();
		islemnotxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					blokaditxt.requestFocus();
				}
			}
		});
		islemnotxt.setEnabled(false);
		islemnotxt.setEditable(false);
		islemnotxt.setColumns(10);
		islemnotxt.setBounds(493, 52, 156, 20);
		contentPane.add(islemnotxt);
		
		JLabel lblNewLabel_1_2 = new JLabel("Blok Adi: *");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(311, 83, 108, 14);
		contentPane.add(lblNewLabel_1_2);
		
		
		
		JDateChooser hatirlattxt = new JDateChooser();
		hatirlattxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					//hakedistxt.requestFocus();
			//	}
			}
		});
	    hatirlattxt.setBounds(493, 395, 156, 20);
	    hatirlattxt.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(hatirlattxt);
	    
	    
		JLabel lblHatirlat = new JLabel("Hatirlat:");
		lblHatirlat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHatirlat.setBounds(311, 395, 139, 14);
		contentPane.add(lblHatirlat);
		
		JLabel Hakedislbl = new JLabel("Hakedis:");
		Hakedislbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		Hakedislbl.setBounds(311, 426, 139, 14);
		contentPane.add(Hakedislbl);
		
		hakedistxt = new JTextField();
		hakedistxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (hakedistxt.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					blokaditxt.requestFocus();
				}
			}
		});
		hakedistxt.setHorizontalAlignment(SwingConstants.RIGHT);
		hakedistxt.setText("0.00");
		hakedistxt.setColumns(10);
		hakedistxt.setBounds(493, 426, 156, 20);
		contentPane.add(hakedistxt);
		
		//hatirlattxt = new JTextField();
		//hatirlattxt.setColumns(10);
		//hatirlattxt.setBounds(474, 395, 156, 20);
		//contentPane.add(hatirlattxt);

		
		JButton btnkaydet = new JButton("Kaydet");
		btnkaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1,tarih2;
				//if((blokbolumaditxt.getSelectedItem().equals("")) || (sikayetialan.getSelectedItem()==null) || (blokaditxt.getSelectedItem()==null)|| (blokbolumaditxt.getSelectedItem()==null))
				if((blokbolumaditxt.getSelectedItem().equals("")) || (blokaditxt.getSelectedItem()==null)|| (blokbolumaditxt.getSelectedItem()==null))
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					Date date =new Date();
					if (zaman.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih1=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih1=sdf.format(zaman.getDate());//TARIH FORMATLAMA
						System.out.println(tarih1);}


					if (hatirlattxt.getDate()==null){
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih2=sdf1.format(date);} 
					else {
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih2=sdf1.format(hatirlattxt.getDate());//TARIH FORMATLAMA
						System.out.println(tarih2);}
					
					String logaciklama,logkullaniciadi,logkullaniciyetkisi;
					logkullaniciadi=siteBaglanti.logkullaniciadi;
					logkullaniciyetkisi=siteBaglanti.logkullaniciyetkisi;
					logaciklama="Sikayet Islemi Ekledi...";
					
					
					if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
					
					String secim =comboaktiflik.getSelectedItem().toString(); 
					String sorgu_kaydet="insert into sitesikayetbilgihareket(logkullaniciadi,logkullaniciyetkisi,logaciklama,sikayetzamani,hatirlat,hakedis,Blokadi,Blokbolumadi,sikayetedensakinbilgi,Aciklama,sikayetilgilenen,sikayetsondurum,sikayetalinanaksiyon,sikayetirtibatbilgisi)values('"+logkullaniciadi+"','"+logkullaniciyetkisi+"','"+logaciklama+"','"+tarih1 +"','"+tarih2 +"','"+hakedistxt.getText() +"','"+blokaditxt.getSelectedItem().toString() +"','"+blokbolumaditxt.getSelectedItem().toString() +"' ,'"+ adsoyad.getSelectedItem().toString()+"','"+aciklama.getText() +"','"+ sikayetialan.getSelectedItem().toString()+"','"+secim+"','"+aksiyon.getText()+"','"+irtibatbilgi.getText()+"')";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
							 
							
							
							//siteSikayetanaekrani frame = new siteSikayetanaekrani();
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
		btnkaydet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnkaydet.setBounds(311, 473, 100, 30);
		
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//siteSikayetanaekrani frame = new siteSikayetanaekrani();
				//frame.show();
				//frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(533, 473, 100, 30);
		contentPane.add(btnvazgec);
		

		
		JButton btnNewButton = new JButton("Temizle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//blokno.setText("");
				//adsoyad.setText("");
				//sikayetialan.setText("");
				//zaman.setText("");
				aciklama.setText("");
				irtibatbilgi.setText("");
				aksiyon.setText("");
			}
		});
		btnNewButton.setBounds(426, 473, 100, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Log Kullanici Adi:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(676, 55, 132, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		logkullaniciadi = new JTextField();
		logkullaniciadi.setHorizontalAlignment(SwingConstants.RIGHT);
		logkullaniciadi.setEditable(false);
		logkullaniciadi.setColumns(10);
		logkullaniciadi.setBackground(Color.WHITE);
		logkullaniciadi.setBounds(818, 52, 168, 20);
		contentPane.add(logkullaniciadi);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Log Islem Zamani:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(676, 87, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		logzamani = new JTextField();
		logzamani.setHorizontalAlignment(SwingConstants.RIGHT);
		logzamani.setEditable(false);
		logzamani.setColumns(10);
		logzamani.setBackground(Color.WHITE);
		logzamani.setBounds(818, 84, 168, 20);
		contentPane.add(logzamani);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Log Islem Aciklamasi:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2.setBounds(676, 117, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		logaciklama = new JTextField();
		logaciklama.setHorizontalAlignment(SwingConstants.RIGHT);
		logaciklama.setEditable(false);
		logaciklama.setColumns(10);
		logaciklama.setBackground(Color.WHITE);
		logaciklama.setBounds(818, 114, 168, 20);
		contentPane.add(logaciklama);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Log Islem Yetkisi:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2_1.setBounds(676, 149, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		logkullaniciyetkisi = new JTextField();
		logkullaniciyetkisi.setHorizontalAlignment(SwingConstants.RIGHT);
		logkullaniciyetkisi.setEditable(false);
		logkullaniciyetkisi.setColumns(10);
		logkullaniciyetkisi.setBackground(Color.WHITE);
		logkullaniciyetkisi.setBounds(818, 146, 168, 20);
		contentPane.add(logkullaniciyetkisi);
		


		
		JButton btnDuzenle = new JButton("Guncelle");
		btnDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1,tarih2;
				//if((blokbolumaditxt.getSelectedItem().equals("")) || (sikayetialan.getSelectedItem()==null) || (blokaditxt.getSelectedItem()==null)|| (blokbolumaditxt.getSelectedItem()==null))
				if((blokbolumaditxt.getSelectedItem().equals("")) || (blokaditxt.getSelectedItem()==null)|| (blokbolumaditxt.getSelectedItem()==null))
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					
					Date date =new Date();
					if (zaman.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih1=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih1=sdf.format(zaman.getDate());//TARIH FORMATLAMA
						System.out.println(tarih1);}


					if (hatirlattxt.getDate()==null){
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih2=sdf1.format(date);} 
					else {
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih2=sdf1.format(hatirlattxt.getDate());//TARIH FORMATLAMA
						System.out.println(tarih2);}
					
					if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
					
					String logaciklama,logkullaniciadi,logkullaniciyetkisi;
					LocalDateTime logzamani;
					logkullaniciadi=siteBaglanti.logkullaniciadi;
					logkullaniciyetkisi=siteBaglanti.logkullaniciyetkisi;
					logaciklama="Sikayet Islemi Guncelledi...";
					LocalDateTime now1 = LocalDateTime.now();
					logzamani=now1;
					System.out.println("GUNCELLEME ZAMANI "+logzamani);
					 
					String secim =comboaktiflik.getSelectedItem().toString(); 
					String sorgu_kaydet="update sitesikayetbilgihareket set logzamani='"+logzamani+"',logkullaniciyetkisi='"+logkullaniciyetkisi+"', logaciklama='"+logaciklama+"',logkullaniciadi='"+logkullaniciadi+"',sikayetzamani='"+tarih1+"',hatirlat='"+tarih2+"',hakedis='"+hakedistxt.getText()+"',Blokadi='"+blokaditxt.getSelectedItem().toString()+"',Blokbolumadi='"+blokbolumaditxt.getSelectedItem().toString() +"',sikayetedensakinbilgi='"+ adsoyad.getSelectedItem().toString()+"',Aciklama='"+aciklama.getText() +"',sikayetilgilenen='"+ sikayetialan.getSelectedItem().toString()+"',sikayetsondurum='"+secim+"',sikayetalinanaksiyon='"+aksiyon.getText()+"',sikayetirtibatbilgisi='"+irtibatbilgi.getText()+"' where sikayetid='"+siteSikayetanaekrani.id_sakla+"'";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Islem Basarili");
							 
							
							
							//siteSikayetanaekrani frame = new siteSikayetanaekrani();
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
		btnDuzenle.setBounds(311, 473, 100, 30);
		
		if(siteSikayetanaekrani.id==0)
		{
			contentPane.add(btnkaydet);
		}
		else
		{
			contentPane.add(btnDuzenle);
			adsoyad.setEnabled(false);
			blokaditxt.setEnabled(false);
			blokbolumaditxt.setEnabled(false);

		}
		
	
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
 				siteSikayetanaekrani.id_sakla=siteSikayetanaekrani.id;
				siteSikayetanaekrani.id=0;
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();
				
				
				
				 ResultSet rsa = null;
				ResultSet rsa1 = null;
				 adsoyad.removeAllItems();//bunu yapmazsam her hata mesajýndan sonra tekrar
				sikayetialan.removeAllItems();                                 //avukatlarý üst üste ekliyor
				
				ResultSet rsa2= null;
				 
				 ResultSet rsa3 = null;
				 blokbolumaditxt.removeAllItems();
				blokaditxt.removeAllItems();
				
				
				ResultSet rs = null;
				try {
					
					myconna=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
			 	String listele_adsoyad="Select * From sitebolumsakinbilgi";
			 	mystata=myconna.createStatement();
					String listele_personel="Select * From sitepersonelbilgi";
					mystata1=myconna.createStatement();
					
					String listele_blokbilgi="Select * From siteblokbilgi";
					mystata2=myconna.createStatement();
				 	String listele_blokbolumbilgi="Select * From sitebolumbilgi";
				 	mystata3=myconna.createStatement();
					 
					 rsa=mystata.executeQuery(listele_adsoyad);
					rsa1=mystata1.executeQuery(listele_personel);
					rsa2=mystata2.executeQuery(listele_blokbilgi);
					 	rsa3=mystata3.executeQuery(listele_blokbolumbilgi);
					
					 while(rsa.next())
					 	{  //veritabanýndaki avukat ad ve soyadlar otomatik combobox'a geliyor. //Ve öyle ekletiyoruz veritabanýna
					 		adsoyad.addItem(rsa.getString("Bolumsakinadsoyad"));
						
					 }
					//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement
					 sikayetialan.addItem("Personel Secimi Henuz Yapilmadi");
					while(rsa1.next())
					{  //veritabanýndaki avukat ad ve soyadlar otomatik combobox'a geliyor. //Ve öyle ekletiyoruz veritabanýna
						
						sikayetialan.addItem(rsa1.getString("Personeladsoyad"));
						
					}
					//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement
					
					while(rsa2.next())
					{  //veritabanýndaki avukat ad ve soyadlar otomatik combobox'a geliyor. //Ve öyle ekletiyoruz veritabanýna
						blokaditxt.addItem(rsa2.getString("Blokadi"));
						
					}
					//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement
					
					 	while(rsa3.next())
					 	{  //veritabanýndaki avukat ad ve soyadlar otomatik combobox'a geliyor. //Ve öyle ekletiyoruz veritabanýna
					 		blokbolumaditxt.addItem(rsa3.getString("Blokbolumadi"));
						
					 	}
					//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement
					
					
					String listele="Select * From sitesikayetbilgihareket where sikayetid='"+siteSikayetanaekrani.id_sakla+"'";
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					if(rs.next())
					{ 
						blokaditxt.setSelectedItem(rs.getString("Blokadi"));
						blokbolumaditxt.setSelectedItem(rs.getString("Blokbolumadi"));
						adsoyad.setSelectedItem(rs.getString("sikayetedensakinbilgi"));
						sikayetialan.setSelectedItem(rs.getString("sikayetilgilenen"));
						zaman.setDate(rs.getDate("sikayetzamani"));
						aciklama.setText(rs.getString("Aciklama"));
						irtibatbilgi.setText(rs.getString("sikayetirtibatbilgisi"));
						aksiyon.setText(rs.getString("sikayetalinanaksiyon"));
						hatirlattxt.setDate(rs.getDate("hatirlat"));
						hakedistxt.setText(rs.getString("hakedis"));
						islemnotxt.setText(rs.getString("sikayetid"));
						
						logaciklama.setText(rs.getString("logaciklama"));
						logkullaniciyetkisi.setText(rs.getString("logkullaniciyetkisi"));
						logzamani.setText(rs.getString("logzamani"));
						logkullaniciadi.setText(rs.getString("logkullaniciadi"));
						
						 
					String aktif=rs.getString("sikayetsondurum");
						if(aktif.equals("SIKAYET ACIK"))
						{
							comboaktiflik.setSelectedIndex(0);
						}
						else
						{
							comboaktiflik.setSelectedIndex(1);
						}
					
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
		
	}
}
