package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;

public class siteOrtakcariekleduzenle extends JDialog {

	private JPanel contentPane;
	private JTextField textodemetutari;
	private JTextField texttahsilattutari;
	private JTextField textodemesaati;
	private JTextField textField;
	JTextArea textaciklama;
	private JTextField hakedistxt;
	private JTextField islemnotxt;
	private JComboBox textField_1;
	static Connection myconn,myconna;
	static Statement mystat,mystata,mystata1;
	private JTextField logkullaniciaditxt;
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
					siteOrtakcariekleduzenle frame = new siteOrtakcariekleduzenle();
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
	public siteOrtakcariekleduzenle() {
		setModal(true);
		setResizable(false);
		setTitle("Site Ortak Cari Islem Ekle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1038, 484);
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
		label.setBounds(10, 55, 266, 360);
		Image  img=new ImageIcon(this.getClass().getResource("/Money-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Site Ortak Cari Islem Ekle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 372, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Odeme Tutari:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(325, 89, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTcNo = new JLabel("Tahsilat Tutari:");
		lblTcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo.setBounds(325, 119, 96, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblTelefon = new JLabel("Saati:");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(325, 149, 89, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblEposta = new JLabel("Aciklama:");
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEposta.setBounds(325, 179, 69, 14);
		contentPane.add(lblEposta);
		
		textodemetutari = new JTextField();
		textodemetutari.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (textodemetutari.getText().length() >= 11 ) // limit to 3 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					texttahsilattutari.requestFocus();
				}
			}
		});
		textodemetutari.setHorizontalAlignment(SwingConstants.RIGHT);
		textodemetutari.setText("0.00");
		textodemetutari.setBounds(457, 89, 168, 20);
		contentPane.add(textodemetutari);
		textodemetutari.setColumns(10);
		
		texttahsilattutari = new JTextField();
		texttahsilattutari.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (texttahsilattutari.getText().length() >= 11 ) // limit to 3 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textodemesaati.requestFocus();
				}
			}
		});
		texttahsilattutari.setHorizontalAlignment(SwingConstants.RIGHT);
		texttahsilattutari.setText("0.00");
		texttahsilattutari.setBounds(457, 119, 168, 20);
		contentPane.add(texttahsilattutari);
		texttahsilattutari.setColumns(10);
		
		textodemesaati = new HintTextField("örnek= 12:12:12");
		textodemesaati.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textaciklama.requestFocus();
				}
			}
		});
		textodemesaati.setColumns(10);
		textodemesaati.setBounds(457, 149, 168, 20);
		contentPane.add(textodemesaati);
		
		//textField = new HintTextField("Örnek=2020-03-03");
		//textField.setColumns(10);
		//textField.setBounds(392, 207, 168, 20);
		//contentPane.add(textField);
		
		JLabel lblSondemeTarihi = new JLabel("Islem Tarihi:");
		lblSondemeTarihi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSondemeTarihi.setBounds(325, 241, 119, 14);
		contentPane.add(lblSondemeTarihi);
		
		
	    JDateChooser textField = new JDateChooser();
	    textField.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_1.requestFocus();
				}
	    	}
	    });
	    textField.setBounds(457, 241, 168, 20);
	    textField.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(textField);
	    
	    
		JLabel lblHatirlat = new JLabel("Hatirlat :");
		lblHatirlat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHatirlat.setBounds(325, 307, 119, 14);
		contentPane.add(lblHatirlat);
		
		JDateChooser hatirlattxt = new JDateChooser();
		hatirlattxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hakedistxt.requestFocus();
				}
			}
		});
		hatirlattxt.setBounds(457, 307, 168, 20);
		hatirlattxt.setDateFormatString("yyyy-MM-dd");
		contentPane.add(hatirlattxt);
		
		textaciklama = new JTextArea();
		textaciklama.setText("Site Ortak Cari Hareketi");
		textaciklama.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
					textField_1.requestFocus();
				}
			}
	    });
		JScrollPane scroll = new JScrollPane(textaciklama);
		scroll.setBounds(457, 179, 168, 51);                     // <-- THIS
	    getContentPane().add(scroll);
	    setLocationRelativeTo ( null );
	    textaciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    textaciklama.setLineWrap(true); //satir sonu bir alta almak icin
	    
		hakedistxt = new JTextField();
		hakedistxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (hakedistxt.getText().length() >= 11 ) // limit to 3 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				textodemetutari.requestFocus();
				}
			}
		});
		hakedistxt.setText("0.00");
		hakedistxt.setHorizontalAlignment(SwingConstants.RIGHT);
		hakedistxt.setColumns(10);
		hakedistxt.setBounds(457, 337, 168, 20);
		contentPane.add(hakedistxt);
	
		
		JLabel Hakedislbl = new JLabel("Hakedis :");
		Hakedislbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		Hakedislbl.setBounds(325, 337, 96, 14);
		contentPane.add(Hakedislbl);
		
		JLabel lblNewLabel_1_1 = new JLabel("Islem No:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(325, 57, 96, 14);
		contentPane.add(lblNewLabel_1_1);
		
		islemnotxt = new JTextField();
		islemnotxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textodemetutari.requestFocus();
				}
			}
		});
		islemnotxt.setEnabled(false);
		islemnotxt.setEditable(false);
		islemnotxt.setHorizontalAlignment(SwingConstants.RIGHT);
		islemnotxt.setColumns(10);
		islemnotxt.setBounds(457, 55, 168, 20);
		contentPane.add(islemnotxt);
		
		JLabel lblIslemiYapan = new JLabel("Personel:");
		lblIslemiYapan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIslemiYapan.setBounds(325, 276, 96, 14);
		contentPane.add(lblIslemiYapan);
		
		//textField_1 = new JTextField();
		//textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		//textField_1.setColumns(10);
		//textField_1.setBounds(457, 276, 168, 20);
		//contentPane.add(textField_1);
		
	     // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		textField_1 = new JComboBox();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hakedistxt.requestFocus();
				}
			}
		});
		textField_1.setBounds(457, 276, 168, 20);
		contentPane.add(textField_1);
		 // COMBOBOXTAN CEKTIRME GUNCELLENIN USTUNE KOYALIM
		
		JButton btnekle = new JButton("Kaydet");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tarih1,tarih2;
				if(textodemetutari.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					
					Date date =new Date();

					if (textField.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih1=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih1=sdf.format(textField.getDate());//TARIH FORMATLAMA
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
					logaciklama="Ortak Cari Islem Ekledi...";
					
					 
 					String sorgu_kaydet="insert into siteortakcarihareket(logkullaniciadi,logkullaniciyetkisi,logaciklama,personeladi,Aciklama,Ortakharekettarih,Ortakodemetutari,Ortaktahsilattutari,Ortakhareketsaati,hatirlat,hakedis)values('"+logkullaniciadi+"','"+logkullaniciyetkisi+"','"+logaciklama+"','"+textField_1.getSelectedItem().toString()+"','"+textaciklama.getText() +"','"+ tarih1+"','"+textodemetutari.getText() +"','"+ texttahsilattutari.getText()+"','"+ textodemesaati.getText()+"','"+ tarih2+"','"+hakedistxt.getText()+"')";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
							 
							
							//siteOrtakcarihareket frame = new siteOrtakcarihareket();
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
		btnekle.setBounds(300,385, 110, 30);
		
		
		JButton btnduzenle = new JButton("Guncelle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1,tarih2;
				if(textodemetutari.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					 
					Date date =new Date();

					if (textField.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih1=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih1=sdf.format(textField.getDate());//TARIH FORMATLAMA
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
					logaciklama="Ortak Cari Islemi Guncelledi...";
					LocalDateTime now1 = LocalDateTime.now();
					logzamani=now1;
					System.out.println("GUNCELLEME ZAMANI "+logzamani);
					String sorgu_kaydet="update siteortakcarihareket set logzamani='"+logzamani+"',logkullaniciyetkisi='"+logkullaniciyetkisi+"', logaciklama='"+logaciklama+"',logkullaniciadi='"+logkullaniciadi+"', personeladi='"+textField_1.getSelectedItem().toString()+"',Aciklama='"+textaciklama.getText() +"',Ortakharekettarih='"+ tarih1+"',Ortakodemetutari='"+textodemetutari.getText() +"',Ortaktahsilattutari='"+ texttahsilattutari.getText()+"', hatirlat='"+ tarih2+"', hakedis='"+ hakedistxt.getText()+"',Ortakhareketsaati='"+textodemesaati.getText()+"'  where Ortakcarihareketid='"+siteOrtakcarihareket.id_sakla+"'";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
							 
							
							//siteOrtakcarihareket frame = new siteOrtakcarihareket();
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
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(300, 385, 110, 30);
		
		if(siteOrtakcarihareket.id==0) contentPane.add(btnekle);
		
		else	contentPane.add(btnduzenle);
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//siteOrtakcarihareket form = new siteOrtakcarihareket();
				//form.show();
				//form.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(548, 385, 110, 30);
		contentPane.add(btnvazgec);
		
		 

		
		JButton btnNewButton = new JButton("Temizle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textaciklama.setText("");
				textField.setDate(null);
				textodemetutari.setText("");
				texttahsilattutari.setText("");
				textodemesaati.setText("");
				 
			}
		});
		btnNewButton.setBounds(428, 385, 110, 30);
		contentPane.add(btnNewButton);
		
		logkullaniciaditxt = new JTextField();
		logkullaniciaditxt.setBackground(Color.WHITE);
		logkullaniciaditxt.setHorizontalAlignment(SwingConstants.RIGHT);
		logkullaniciaditxt.setEditable(false);
		logkullaniciaditxt.setColumns(10);
		logkullaniciaditxt.setBounds(777, 55, 168, 20);
		contentPane.add(logkullaniciaditxt);
		
		logzamani = new JTextField();
		logzamani.setBackground(Color.WHITE);
		logzamani.setHorizontalAlignment(SwingConstants.RIGHT);
		logzamani.setEditable(false);
		logzamani.setColumns(10);
		logzamani.setBounds(777, 87, 168, 20);
		contentPane.add(logzamani);
		
		logaciklama = new JTextField();
		logaciklama.setBackground(Color.WHITE);
		logaciklama.setHorizontalAlignment(SwingConstants.RIGHT);
		logaciklama.setEditable(false);
		logaciklama.setColumns(10);
		logaciklama.setBounds(777, 117, 168, 20);
		contentPane.add(logaciklama);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Log Kullanici Adi:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(635, 58, 132, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Log Islem Zamani:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(635, 90, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Log Islem Aciklamasi:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2.setBounds(635, 120, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Log Islem Yetkisi:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2_1.setBounds(635, 152, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		logkullaniciyetkisi = new JTextField();
		logkullaniciyetkisi.setBackground(Color.WHITE);
		logkullaniciyetkisi.setHorizontalAlignment(SwingConstants.RIGHT);
		logkullaniciyetkisi.setEditable(false);
		logkullaniciyetkisi.setColumns(10);
		logkullaniciyetkisi.setBounds(777, 149, 168, 20);
		contentPane.add(logkullaniciyetkisi);
		


		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				siteOrtakcarihareket.id_sakla=siteOrtakcarihareket.id;
				siteOrtakcarihareket.id=0;
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();
				
				ResultSet rsa1 = null;
				textField_1.removeAllItems();   
				
				ResultSet rs = null;
				try {
					
					myconna=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					String listele_personel="Select * From sitepersonelbilgi";
					mystata1=myconna.createStatement();
					rsa1=mystata1.executeQuery(listele_personel);
					
					while(rsa1.next())
					{  //veritabanýndaki avukat ad ve soyadlar otomatik combobox'a geliyor. //Ve öyle ekletiyoruz veritabanýna
						textField_1.addItem(rsa1.getString("Personeladsoyad"));
						
					}
					//AVUKAT COMBOBOXA OTOMATIK CEKME BASLIGA Connection myconna,S tatement
					
					String listele="Select * From siteortakcarihareket where Ortakcarihareketid='"+siteOrtakcarihareket.id_sakla+"'";
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					if(rs.next())
					{ 
						
						textaciklama.setText(rs.getString("Aciklama"));
						textField.setDate(rs.getDate("Ortakharekettarih"));
						textodemetutari.setText(rs.getString("Ortakodemetutari"));
						texttahsilattutari.setText(rs.getString("Ortaktahsilattutari"));
						textodemesaati.setText(rs.getString("Ortakhareketsaati"));
						hatirlattxt.setDate(rs.getDate("hatirlat"));
						hakedistxt.setText(rs.getString("hakedis"));
						islemnotxt.setText(rs.getString("Ortakcarihareketid"));
						textField_1.setSelectedItem(rs.getString("personeladi"));
						
						logaciklama.setText(rs.getString("logaciklama"));
						logkullaniciyetkisi.setText(rs.getString("logkullaniciyetkisi"));
						logzamani.setText(rs.getString("logzamani"));
						logkullaniciaditxt.setText(rs.getString("logkullaniciadi"));
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
	}
}
