package test;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.SystemColor;

public class siteBlokbolumcarihareketekle extends JDialog {

	private JPanel contentPane;
	private JTextField textborctutari;
	private JTextField textdaireno;
	private JTextField textalacaktutari;
	private JTextArea textaciklama;
//	private JTextField textField_2;
	private JTextField islemnotxt;
	private JComboBox textField;
	private JComboBox textField_1;
	JTextField hakedistxt;
	private JTextField logkullaniciyetkisi;
	private JTextField logaciklama;
	private JTextField logzamani;
	private JTextField logkullaniciadi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteBlokbolumcarihareketekle frame = new siteBlokbolumcarihareketekle();
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
	public siteBlokbolumcarihareketekle() {
		setModal(true);
		setResizable(false);
		setTitle("Site Blok Bolum Cari Hareket Ekle  Duzenle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1080, 408);
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
		label.setBounds(10, 52, 263, 311);
		Image  img=new ImageIcon(this.getClass().getResource("/Money-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Site Blok Bolum Cari Hareket Ekle  Duzenle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 8, 467, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Borc Tutari:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(297, 109, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTcNo = new JLabel("Bolum Adi:");
		lblTcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo.setBounds(297, 80, 82, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblTelefon = new JLabel("Alacak Tutari:");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(297, 140, 89, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblEposta = new JLabel("Aciklama:");
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEposta.setBounds(297, 170, 69, 14);
		contentPane.add(lblEposta);
		
		textborctutari = new JTextField();
		textborctutari.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (textborctutari.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textalacaktutari.requestFocus();
				}
			}
		});
		textborctutari.setHorizontalAlignment(SwingConstants.RIGHT);
		textborctutari.setText("0.00");
		textborctutari.setBounds(423, 109, 168, 20);
		contentPane.add(textborctutari);
		textborctutari.setColumns(10);
		
		textdaireno = new JTextField();
		textdaireno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textborctutari.requestFocus();
				}
			}
		});
		textdaireno.setEditable(false);
		textdaireno.setEnabled(false);
		textdaireno.setFont(new Font("Tahoma", Font.BOLD, 11));
		textdaireno.setBackground(Color.WHITE);
		//textdaireno.setEnabled(false);
		textdaireno.setBounds(423, 80, 168, 20);
		contentPane.add(textdaireno);
		textdaireno.setColumns(10);
		
		textalacaktutari = new JTextField();
		textalacaktutari.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (textalacaktutari.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textalacaktutari.requestFocus();
				}
			}
		});
		textalacaktutari.setHorizontalAlignment(SwingConstants.RIGHT);
		textalacaktutari.setText("0.00");
		textalacaktutari.setColumns(10);
		textalacaktutari.setBounds(423, 140, 168, 20);
		contentPane.add(textalacaktutari);
		
		
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
					islemnotxt.requestFocus();
				}
			}
		});
		hakedistxt.setHorizontalAlignment(SwingConstants.RIGHT);
		hakedistxt.setText("0.00");
		hakedistxt.setColumns(10);
		hakedistxt.setBounds(423, 288, 168, 20);
		contentPane.add(hakedistxt);
		
		JLabel lblTcNo_1 = new JLabel("Islem No:");
		lblTcNo_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo_1.setBounds(297, 52, 82, 14);
		contentPane.add(lblTcNo_1);
		
		islemnotxt = new JTextField();
		islemnotxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textdaireno.requestFocus();
				}
			}
		});
		islemnotxt.setEditable(false);
		islemnotxt.setEnabled(false);
		islemnotxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		islemnotxt.setBackground(Color.WHITE);
		islemnotxt.setColumns(10);
		islemnotxt.setBounds(423, 52, 168, 20);
		contentPane.add(islemnotxt);
		 
		textaciklama = new JTextArea();
		textaciklama.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textaciklama.setText("Blok Bolum Cari Hareketi");
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
					hakedistxt.requestFocus();
				}
			}
	    });
		JScrollPane scroll = new JScrollPane(textaciklama);
		scroll.setBounds(423, 170, 168, 51);                     // <-- THIS
	    getContentPane().add(scroll);
	    setLocationRelativeTo ( null );
	    textaciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    textaciklama.setLineWrap(true); //satir sonu bir alta almak icin
		
		JLabel lblSondemeTarihi = new JLabel("Islem Tarihi:");
		lblSondemeTarihi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSondemeTarihi.setBounds(297, 228, 119, 14);
		contentPane.add(lblSondemeTarihi);
		
		//textField = new JTextField();
		//textField.setColumns(10);
		//textField.setBounds(423, 228, 168, 20);
		//contentPane.add(textField);
		
	    JDateChooser textField = new JDateChooser();
	    textField.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {

				//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				//	textField_1.requestFocus();
				//}
	    	}
	    });
	    textField.setBounds(423, 228, 168, 20);
	    textField.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(textField);
		
		
		JLabel lblHatirlat = new JLabel("Hatirlat:");
		lblHatirlat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHatirlat.setBounds(297, 258, 119, 14);
		contentPane.add(lblHatirlat);
		
		//textField_1 = new JTextField();
		//textField_1.setColumns(10);
		//textField_1.setBounds(423, 258, 168, 20);
		//contentPane.add(textField_1);
		
	    JDateChooser textField_1 = new JDateChooser();
	    textField_1.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {

				//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					//hakedistxt.requestFocus();
				//}
	    	}
	    });
	    textField_1.setBounds(423, 258, 168, 20);
	    textField_1.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(textField_1);
		
		
		JLabel lblHakedis = new JLabel("Hakedis:");
		lblHakedis.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHakedis.setBounds(297, 288, 89, 14);
		contentPane.add(lblHakedis);
		
		
		JButton btnekle = new JButton("Kaydet");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1,tarih2;
				if(textdaireno.getText().equals("")) 
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


					if (textField_1.getDate()==null){
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih2=sdf1.format(date);} 
					else {
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih2=sdf1.format(textField_1.getDate());//TARIH FORMATLAMA
						System.out.println(tarih2);}
					
					if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
					
					String logaciklama,logkullaniciadi,logkullaniciyetkisi;
					logkullaniciadi=siteBaglanti.logkullaniciadi;
					logkullaniciyetkisi=siteBaglanti.logkullaniciyetkisi;
					logaciklama="Bolum Cari islemi Ekledi...";
					
					String sorgu_kaydet="insert into sitebolumcarihareket(logkullaniciadi,logkullaniciyetkisi,logaciklama,Bolumcarihareketborctutari,Blokbolumadi,Aciklama,Bolumcarihareketalacaktutari,harekettarihi,hatirlat,hakedis)values('"+logkullaniciadi+"','"+logkullaniciyetkisi+"','"+logaciklama+"','"+textborctutari.getText()+"','"+textdaireno.getText()+"','"+textaciklama.getText()+"','"+textalacaktutari.getText()+"','"+ tarih1+"','"+ tarih2+"','"+hakedistxt.getText()+"')";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Islem Basarili");
							 
								
							//siteBlokbolumcarihareketler frame = new siteBlokbolumcarihareketler();
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
		btnekle.setBounds(296, 333, 110, 30);
		if(siteBlokbolumcarihareketler.id==0) contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//siteBlokbolumcarihareketler frame = new siteBlokbolumcarihareketler();
				//frame.show();
				//frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(546, 333, 110, 30);
		contentPane.add(btnvazgec);
		

		
		
		JButton btnNewButton = new JButton("Temizle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textdaireno.setText("");
				textborctutari.setText("");
				textalacaktutari.setText("");
				textaciklama.setText("");
				//textField_1.setText("");
			}
		});
		btnNewButton.setBounds(423, 333, 110, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Log Islem Yetkisi:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2_1.setBounds(616, 149, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		logkullaniciyetkisi = new JTextField();
		logkullaniciyetkisi.setHorizontalAlignment(SwingConstants.RIGHT);
		logkullaniciyetkisi.setEditable(false);
		logkullaniciyetkisi.setColumns(10);
		logkullaniciyetkisi.setBackground(Color.WHITE);
		logkullaniciyetkisi.setBounds(758, 146, 168, 20);
		contentPane.add(logkullaniciyetkisi);
		
		logaciklama = new JTextField();
		logaciklama.setHorizontalAlignment(SwingConstants.RIGHT);
		logaciklama.setEditable(false);
		logaciklama.setColumns(10);
		logaciklama.setBackground(Color.WHITE);
		logaciklama.setBounds(758, 114, 168, 20);
		contentPane.add(logaciklama);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Log Islem Aciklamasi:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2.setBounds(616, 117, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Log Islem Zamani:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(616, 87, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		logzamani = new JTextField();
		logzamani.setHorizontalAlignment(SwingConstants.RIGHT);
		logzamani.setEditable(false);
		logzamani.setColumns(10);
		logzamani.setBackground(Color.WHITE);
		logzamani.setBounds(758, 84, 168, 20);
		contentPane.add(logzamani);
		
		logkullaniciadi = new JTextField();
		logkullaniciadi.setHorizontalAlignment(SwingConstants.RIGHT);
		logkullaniciadi.setEditable(false);
		logkullaniciadi.setColumns(10);
		logkullaniciadi.setBackground(Color.WHITE);
		logkullaniciadi.setBounds(758, 52, 168, 20);
		contentPane.add(logkullaniciadi);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Log Kullanici Adi:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(616, 55, 132, 14);
		contentPane.add(lblNewLabel_1_1_1);


		
		JButton btnDuzenle = new JButton("Guncelle");
		btnDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1,tarih2;
				if(textdaireno.getText().equals("")) 
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


					if (textField_1.getDate()==null){
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih2=sdf1.format(date);} 
					else {
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih2=sdf1.format(textField_1.getDate());//TARIH FORMATLAMA
						System.out.println(tarih2);}
					
					if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
					 
					String logaciklama,logkullaniciadi,logkullaniciyetkisi;
					LocalDateTime logzamani;
					logkullaniciadi=siteBaglanti.logkullaniciadi;
					logkullaniciyetkisi=siteBaglanti.logkullaniciyetkisi;
					logaciklama="Bolum Cari Islemi Guncelledi...";
					LocalDateTime now1 = LocalDateTime.now();
					logzamani=now1;
					System.out.println("GUNCELLEME ZAMANI "+logzamani);
					
					String sorgu_guncelle="update  sitebolumcarihareket set logzamani='"+logzamani+"',logkullaniciyetkisi='"+logkullaniciyetkisi+"', logaciklama='"+logaciklama+"',logkullaniciadi='"+logkullaniciadi+"',Bolumcarihareketborctutari='"+textborctutari.getText() +"',Blokbolumadi='"+ textdaireno.getText()+"',Aciklama='"+textaciklama.getText() +"',Bolumcarihareketalacaktutari='"+ textalacaktutari.getText()+"',harekettarihi='"+tarih1+"',hatirlat='"+tarih2+"',hakedis='"+hakedistxt.getText()+"' where Bolumcarihareketid='"+siteBlokbolumcarihareketler.id_sakla+"'";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_guncelle);
							JOptionPane.showMessageDialog(null,"Islem Basarili");
							 
							///////////
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Blok Bolum Cari hareketi isledi...";
							String logekle="insert into sitelogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+siteBaglanti.logkullaniciadi+"','"+siteBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							siteBaglanti baglan1 = new siteBaglanti();
	 							baglan1.yap();
								baglan1.mystat1=baglan1.myconn1.createStatement();
								baglan1.mystat1.executeUpdate(logekle);
								//table.updateUI();
								//System.out.println("TOPLAM KAYIT: "+table.getRowCount());
								//if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							
							//siteBlokbolumcarihareketler frame = new siteBlokbolumcarihareketler();
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
		btnDuzenle.setBounds(296, 333, 110, 30);
	 
		if(siteBlokbolumcarihareketler.id==0) {
			textdaireno.setText(siteBlokbolumbilgi.id3);
			System.out.println("GELEN NO: "+siteBlokbolumbilgi.id3);
			contentPane.add(btnekle);
		}
		else contentPane.add(btnDuzenle);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			 
				siteBlokbolumcarihareketler.id_sakla=siteBlokbolumcarihareketler.id;
				siteBlokbolumcarihareketler.id=0;
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();
				
				ResultSet rs = null;
				try {
					
					String listele="Select * From sitebolumcarihareket where Bolumcarihareketid='"+siteBlokbolumcarihareketler.id_sakla+"'";
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					if(rs.next())
					{ 
						
						textdaireno.setText(rs.getString("Blokbolumadi"));
						textborctutari.setText(rs.getString("Bolumcarihareketborctutari"));
						textalacaktutari.setText(rs.getString("Bolumcarihareketalacaktutari"));
						textaciklama.setText(rs.getString("Aciklama"));
						islemnotxt.setText(rs.getString("Bolumcarihareketid"));
						hakedistxt.setText(rs.getString("hakedis"));
						textField.setDate(rs.getDate("harekettarihi"));
						textField_1.setDate(rs.getDate("hatirlat"));
						
						logaciklama.setText(rs.getString("logaciklama"));
						logkullaniciyetkisi.setText(rs.getString("logkullaniciyetkisi"));
						logzamani.setText(rs.getString("logzamani"));
						logkullaniciadi.setText(rs.getString("logkullaniciadi"));
						
				 
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
		
	}
}
