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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;

public class siteBlokbolumziyaretciekleduzenle extends JDialog {
	static Connection myconn1;
	static Statement mystat1;
	static Connection myconn2;
	static Statement mystat2;

	private JPanel contentPane;
	private JTextField textadsoyad;
	private JTextField textplaka1;
	private JTextField textplaka2;

	private JTextField textbolumno;

	private JTextArea textaciklama;

	private JTextField girissaattxt;
	private JTextField cikissaattxt;
	private JComboBox texttarih;
	private JComboBox textsaat;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteBlokbolumziyaretciekleduzenle frame = new siteBlokbolumziyaretciekleduzenle();
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
	public siteBlokbolumziyaretciekleduzenle() {
		setModal(true);
		setResizable(false);
		setTitle("Ziyaretci Ekle Duzenle Ekrani");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 811, 470);
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
		label.setBounds(10, 56, 250, 362);
		Image  img=new ImageIcon(this.getClass().getResource("/11874-family-man-woman-girl-boy-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Ziyaretci Ekle Duzenle Ekrani");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 294, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ziyaretci Adi Soyadi : *");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(278, 86, 164, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTcNo = new JLabel("Cikis Tarihi :");
		lblTcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo.setBounds(278, 236, 85, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblTelefon = new JLabel("Giris Tarihi: *");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(278, 176, 85, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblEposta = new JLabel("Bolum Adi: *");
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEposta.setBounds(278, 56, 164, 14);
		contentPane.add(lblEposta);
		
		JLabel lblifre = new JLabel("Arac Plaka1:");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre.setBounds(278, 116, 75, 14);
		contentPane.add(lblifre);
		
		JLabel lblifre_1 = new JLabel("Arac Plaka2:");
		lblifre_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre_1.setBounds(278, 146, 75, 14);
		contentPane.add(lblifre_1);
		
		textadsoyad = new JTextField();
		textadsoyad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textplaka1.requestFocus();
				}
			}
		});
		textadsoyad.setBounds(477, 86, 164, 20);
		contentPane.add(textadsoyad);
		textadsoyad.setColumns(10);
		
		textplaka1 = new JTextField();
		textplaka1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textplaka2.requestFocus();
				}
			}
		});
		textplaka1.setColumns(10);
		textplaka1.setBounds(477, 116, 164, 20);
		contentPane.add(textplaka1);
		
		textplaka2 = new JTextField();
		textplaka2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					girissaattxt.requestFocus();
				}
			}
		});
		textplaka2.setColumns(10);
		textplaka2.setBounds(477, 146, 164, 20);
		contentPane.add(textplaka2);
		
//		texttarih = new JTextField();
//		texttarih.setColumns(10);
//		texttarih.setBounds(477, 176, 164, 20);
//		contentPane.add(texttarih);
		
	    JDateChooser texttarih = new JDateChooser();
	    texttarih.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {
				//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					//girissaattxt.requestFocus();
			//	}
	    	}
	    });
	    texttarih.setBounds(477, 176, 164, 20);
	    texttarih.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(texttarih);
		
		textbolumno = new JTextField();
		textbolumno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textadsoyad.requestFocus();
				}
			}
		});
		textbolumno.setEnabled(false);
		textbolumno.setEditable(false);
		//textbolumno.setEnabled(false);
		textbolumno.setColumns(10);
		textbolumno.setBounds(477, 56, 164, 20);
		contentPane.add(textbolumno);
		
	    JDateChooser textsaat = new JDateChooser();
	    textsaat.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {
				//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					//cikissaattxt.requestFocus();
			//	}
	    	}
	    });
	    textsaat.setBounds(477, 236, 164, 20);
	    textsaat.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(textsaat);
		
//		textsaat = new JTextField();
//		textsaat.setColumns(10);
//		textsaat.setBounds(477, 236, 164, 20);
//		contentPane.add(textsaat);
		
		
		JLabel lblNewLabel_2 = new JLabel("Aciklama:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(278, 296, 69, 14);
		contentPane.add(lblNewLabel_2);
		
//		textaciklama = new JTextField();
//		textaciklama.setBounds(477, 296, 164, 46);
//		contentPane.add(textaciklama);
//		textaciklama.setColumns(10);
		
		
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
					textbolumno.requestFocus();
				}
			}
	    });
		JScrollPane scroll = new JScrollPane(textaciklama);
		scroll.setBounds(477, 296, 164, 46);                     // <-- THIS
	    getContentPane().add(scroll);
	    setLocationRelativeTo ( null );
	    textaciklama.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    textaciklama.setLineWrap(true); //satir sonu bir alta almak icin
		
		JLabel lblGirisSaati = new JLabel("Giris Saati : *");
		lblGirisSaati.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGirisSaati.setBounds(278, 206, 85, 14);
		contentPane.add(lblGirisSaati);
		
		girissaattxt = new JTextField();
		girissaattxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					cikissaattxt.requestFocus();
				}
			}
		});
		girissaattxt.setColumns(10);
		girissaattxt.setBounds(477, 206, 164, 20);
		contentPane.add(girissaattxt);
		
		JLabel lblCikisSaati = new JLabel("Cikis Saati:");
		lblCikisSaati.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCikisSaati.setBounds(278, 266, 85, 14);
		contentPane.add(lblCikisSaati);
		
		cikissaattxt = new JTextField();
		cikissaattxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textaciklama.requestFocus();
				}
			}
		});
		cikissaattxt.setColumns(10);
		cikissaattxt.setBounds(477, 266, 164, 20);
		contentPane.add(cikissaattxt);
		
		
		JButton btnekle = new JButton("Kaydet");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String tarih1,tarih2;  
				if((textbolumno.getText().equals(""))|| (textadsoyad.getText().equals(""))) {
			    	  JOptionPane.showMessageDialog(null, "Lütfen gerekli alanlarý doldurunuz");
			      }
			      else {
			    	  ResultSet rs1;
			    	  try {
			    		  
							Date date =new Date();
							if (texttarih.getDate()==null) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								tarih1=sdf.format(date);}
							else {
						      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
								tarih1=sdf.format(texttarih.getDate());//TARIH FORMATLAMA
								System.out.println(tarih1);}


							if (textsaat.getDate()==null){
								SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
								tarih2=sdf1.format(date);} 
							else {
								SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
								tarih2=sdf1.format(textsaat.getDate());//TARIH FORMATLAMA
								System.out.println(tarih2);}
			    		  
			    		  String blok_kontrol="select * from sitebolumbilgi where Blokbolumadi='"+textbolumno.getText()+"'";
			    		  myconn2=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
			    		  mystat2=myconn2.createStatement();
			    		  rs1=mystat2.executeQuery(blok_kontrol);
			    		  if(rs1.next()) {
			    			  String sorgu_ekle="insert into sitebolumziyaretci(Ziyaretciadsoyad,Ziyaretcigiriszamani,Ziyaretcicikiszamani,Blokbolumadi,Ziyaretciaracplaka1,Ziyaretciaracplaka2,Ziyaretciaciklama,girissaati,cikissaati)"
										+ "values('"+ textadsoyad.getText()+"','"+ tarih1+"','"+ tarih2+"','"+ textbolumno.getText()+"','"+textplaka1.getText()+"','"+ textplaka2.getText()+"','"+ textaciklama.getText()+"','"+ girissaattxt.getText()+"','"+cikissaattxt.getText()+"')";
			    			  try {
			    				  myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
			    				  mystat1=myconn1.createStatement();
			    				  mystat1.executeUpdate(sorgu_ekle);
			    				  JOptionPane.showMessageDialog(null,"Islem basarili");
			    				  
			    				  //siteBlokbolumziyaretcigirisi frame=new siteBlokbolumziyaretcigirisi();
			    				  //frame.setVisible(true);
			    				  //frame.setLocationRelativeTo(null);
			    				  dispose();
			    			  }catch(Exception hata) {
			    				  System.err.println(hata);
			    			  }
			    		  }
			    		  else {
			    			  JOptionPane.showMessageDialog(null, "blok no yu kontrol ediniz.böyle bir blok no yoktur");
			    		  }
			    	  }catch(Exception hata) {
			    		  System.err.println(hata);
			    	  }
			      }
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(404, 385, 116, 33);
		//contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//siteBlokbolumziyaretcigirisi frame=new siteBlokbolumziyaretcigirisi();
				//frame.setVisible(true);
				//frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(656, 385, 116, 33);
		contentPane.add(btnvazgec);
		
		
		
		JButton btnDuzenle = new JButton("Guncelle");
		btnDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1,tarih2;
				if((textbolumno.getText().equals(""))|| (textadsoyad.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Lütfen gerekli alanlarý doldurunuz");
				}
				else {
					ResultSet rs1;
					try {
						
						Date date =new Date();
						if (texttarih.getDate()==null) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							tarih1=sdf.format(date);}
						else {
					      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
							tarih1=sdf.format(texttarih.getDate());//TARIH FORMATLAMA
							System.out.println(tarih1);}


						if (textsaat.getDate()==null){
							SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
							tarih2=sdf1.format(date);} 
						else {
							SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
							tarih2=sdf1.format(textsaat.getDate());//TARIH FORMATLAMA
							System.out.println(tarih2);}
						
						
						 String blok_kontrol="select * from sitebolumbilgi where Blokbolumadi='"+textbolumno.getText()+"'";
			    		  myconn2=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
			    		  mystat2=myconn2.createStatement();
			    		  rs1=mystat2.executeQuery(blok_kontrol);
			    		  if(rs1.next()) {
			    			  String guncelle="update sitebolumziyaretci set Ziyaretciadsoyad='"+ textadsoyad.getText()+"',Ziyaretcigiriszamani='"+tarih1+"',Ziyaretcicikiszamani='"+tarih2+"',Blokbolumadi='"+textbolumno.getText()+"',Ziyaretciaracplaka1='"+textplaka1.getText()+"',Ziyaretciaracplaka2='"+ textplaka2.getText()+"',girissaati='"+girissaattxt.getText()+"',cikissaati='"+cikissaattxt.getText()+"',Ziyaretciaciklama='"+textaciklama.getText()+"' where Ziyaretciid='"+siteBlokbolumziyaretcigirisi.sakla_id+"'";
			    			  try {
			    				  myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
			    				  mystat1=myconn1.createStatement();
			    				  mystat1.executeUpdate(guncelle);
			    				  JOptionPane.showMessageDialog(null, "Guncelleme basarili");
			    				  
			    				  //siteBlokbolumziyaretcigirisi frame=new siteBlokbolumziyaretcigirisi();
			    				  //frame.setVisible(true);
			    				  //frame.setLocationRelativeTo(null);
			    				  dispose();
			    			  }catch(Exception hata) {
			    				  System.err.println(hata);
			    			  }
			    		  }
			    		  else {
			    			  JOptionPane.showMessageDialog(null, "Lütfen blok  no yu kontrol ediniz.Böyle bir blok no yoktur");
			    		  }
					}catch(Exception hata) {
						System.err.println(hata);
					}
				}
			}
		});
		btnDuzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDuzenle.setBounds(404, 385, 116, 33);
		//contentPane.add(btnDuzenle);
		
		JButton btntemizle = new JButton("Temizle");
		btntemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textadsoyad.setText("");
				//texttarih.setText("");
				//textsaat.setText("");
				//textbolumno.setText("");
				textplaka1.setText("");
				textplaka2.setText("");
				girissaattxt.setText("");
				cikissaattxt.setText("");
				textaciklama.setText("");
			}
		});
		btntemizle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btntemizle.setBounds(530, 386, 116, 33);
		contentPane.add(btntemizle);
		

///
		if(siteBlokbolumziyaretcigirisi.id==0) {
			textbolumno.setText(siteBlokbolumbilgi.id3);
			System.out.println("GELEN NO: "+siteBlokbolumbilgi.id3);
			contentPane.add(btnekle);
		}
		else contentPane.add(btnDuzenle);		
		
///
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
 
				siteBlokbolumziyaretcigirisi.sakla_id=siteBlokbolumziyaretcigirisi.id;
				siteBlokbolumziyaretcigirisi.id=0;
				ResultSet rs=null;
				try {
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					String listele="select * from sitebolumziyaretci where Ziyaretciid='"+siteBlokbolumziyaretcigirisi.sakla_id+"'";
					mystat1=myconn1.createStatement();
					rs=mystat1.executeQuery(listele);
					if(rs.next()) {
						textadsoyad.setText(rs.getString("Ziyaretciadsoyad"));
						texttarih.setDate(rs.getDate("Ziyaretcigiriszamani"));
						textsaat.setDate(rs.getDate("Ziyaretcicikiszamani"));
						textbolumno.setText(rs.getString("Blokbolumadi"));
						textplaka1.setText(rs.getString("Ziyaretciaracplaka1"));
						textplaka2.setText(rs.getString("Ziyaretciaracplaka2"));
						textaciklama.setText(rs.getString("Ziyaretciaciklama"));
						girissaattxt.setText(rs.getString("girissaati"));
						cikissaattxt.setText(rs.getString("cikissaati"));
					}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}