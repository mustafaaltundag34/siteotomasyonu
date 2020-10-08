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
import java.time.LocalDateTime;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;

public class sitePersonelcariekleduzenle extends JDialog {
	 static Connection myconn1;
	    static Statement mystat1;
	    static Connection myconn2;
	    static Statement mystat2;

	private JPanel contentPane;
	private JTextField texttcno;
	private JTextField textadsoyad;
	private JTextField textalacaktutari;
	private JTextField textborctutari;
	private JTextArea textaciklama;
	private JComboBox texttarih;
	private JTextField hakedistxt;
	private JTextField islemno;
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
					sitePersonelcariekleduzenle frame = new sitePersonelcariekleduzenle();
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
	public sitePersonelcariekleduzenle() {
		setModal(true);
		setTitle("Personel Cari Hareket Ekle Duzenle");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1045, 461);
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
		label.setBounds(10, 55, 250, 352);
		Image  img=new ImageIcon(this.getClass().getResource("/Money-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Personel Cari Hareket Ekle Duzenle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 372, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TC No:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(272, 84, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTcNo = new JLabel("Ad Soyad:");
		lblTcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo.setBounds(272, 114, 69, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblTelefon = new JLabel("Alacak Tutari:");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(272, 174, 89, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblEposta = new JLabel("Aciklama:");
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEposta.setBounds(272, 204, 69, 14);
		contentPane.add(lblEposta);
		
		JTextArea textaciklama = new JTextArea();
		textaciklama.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textaciklama.setText("Personel Cari Hareketi");
		textaciklama.setBounds(402, 175, 168, 65);
		contentPane.add(textaciklama);
		textaciklama.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(textaciklama.getText().length()>=100) {
					e.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hakedistxt.requestFocus();
				}
			}
		});
		
		JScrollPane scroll1 = new JScrollPane(textaciklama);
		   scroll1.setBounds(404,204,168,47);                    
		    getContentPane().add(scroll1);
		    setLocationRelativeTo ( null );
		    textaciklama.setWrapStyleWord(true);
		    textaciklama.setLineWrap(true);
		
		JLabel lblSondemeTarihi = new JLabel("Islem Tarihi:");
		lblSondemeTarihi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSondemeTarihi.setBounds(272, 262, 119, 14);
		contentPane.add(lblSondemeTarihi);
		
		JLabel lblBorTutari = new JLabel("Borc Tutari:");
		lblBorTutari.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBorTutari.setBounds(272, 144, 89, 14);
		contentPane.add(lblBorTutari);
		
		textborctutari = new JTextField();
		textborctutari.setHorizontalAlignment(SwingConstants.RIGHT);
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
		textborctutari.setText("0.00");
		textborctutari.setBounds(404, 144, 168, 20);
		contentPane.add(textborctutari);
		textborctutari.setColumns(10);
		
//		texttarih = new JTextField();
//		texttarih.setColumns(10);
//		texttarih.setBounds(402, 251, 168, 20);
//		contentPane.add(texttarih);
		

	    
	    
		JLabel lblHakedis = new JLabel("Hatirlat :");
		lblHakedis.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHakedis.setBounds(272, 287, 119, 14);
		contentPane.add(lblHakedis);
		
		JDateChooser hatirlat = new JDateChooser();
		hatirlat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					//hakedistxt.requestFocus();
				//}
			}
		});
		hatirlat.setBounds(404, 287, 168, 20);
		hatirlat.setDateFormatString("yyyy-MM-dd");
		contentPane.add(hatirlat);
		
		
		JDateChooser texttarih = new JDateChooser();
		texttarih.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					//hatirlat.requestFocus();
			//	}
			}
		});
		texttarih.setBounds(404, 262, 168, 20);
		texttarih.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(texttarih);
	    
		JLabel lblHakedis_1 = new JLabel("Hakedis :");
		lblHakedis_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHakedis_1.setBounds(272, 312, 89, 14);
		contentPane.add(lblHakedis_1);
		
		hakedistxt = new JTextField();
		hakedistxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textborctutari.requestFocus();
				}
			}
		});
		hakedistxt.setText("0.00");
		hakedistxt.setHorizontalAlignment(SwingConstants.RIGHT);
		hakedistxt.setColumns(10);
		hakedistxt.setBounds(404, 312, 168, 20);
		contentPane.add(hakedistxt);
		
		
		texttcno = new JTextField();
		texttcno.setEditable(false);
		texttcno.setEnabled(false);
		//texttcno.setEnabled(false);
		texttcno.setBounds(404, 84, 168, 20);
		contentPane.add(texttcno);
		texttcno.setColumns(10);
		texttcno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(texttcno.getText().length()>=11) {
					e.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textadsoyad.requestFocus();
				}
			}
		});
		
		textadsoyad = new JTextField();
		textadsoyad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textborctutari.requestFocus();
				}
			}
		});
		textadsoyad.setEnabled(false);
		textadsoyad.setEditable(false);
		textadsoyad.setBounds(404, 114, 168, 20);
		contentPane.add(textadsoyad);
		textadsoyad.setColumns(10);
		
		textalacaktutari = new JTextField();
		textalacaktutari.setHorizontalAlignment(SwingConstants.RIGHT);
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
					textaciklama.requestFocus();
				}
			}
		});
		textalacaktutari.setText("0.00");
		textalacaktutari.setColumns(10);
		textalacaktutari.setBounds(404, 174, 168, 20);
		contentPane.add(textalacaktutari);
		
		JButton btnekle = new JButton("Kaydet");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1,tarih2;
				if(texttcno.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Lütfen gerekli alanlarý doldurun");
					
				}
				else {
					
					Date date =new Date();
					if (texttarih.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih1=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih1=sdf.format(texttarih.getDate());//TARIH FORMATLAMA
						System.out.println(tarih1);}
					
					if (hatirlat.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih2=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih2=sdf.format(hatirlat.getDate());//TARIH FORMATLAMA
						System.out.println(tarih2);}
					
					if ((textborctutari.getText()).equals("")){textborctutari.setText("0");}
					if ((textalacaktutari.getText()).equals("")){textalacaktutari.setText("0");}
					if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
					
					String logaciklama,logkullaniciadi,logkullaniciyetkisi;
					logkullaniciadi=siteBaglanti.logkullaniciadi;
					logkullaniciyetkisi=siteBaglanti.logkullaniciyetkisi;
					logaciklama="Personel Islemi Ekledi...";
					

							String sorgu_ekle="insert into sitepersonelcarihareket(logkullaniciadi,logkullaniciyetkisi,logaciklama,hatirlat,hakedis,Personeltcno,Personeladsoyad,Personelborctutari,Personelalacaktutari,Aciklama,Personelharekettarihi)"
									+ "values('"+logkullaniciadi+"','"+logkullaniciyetkisi+"','"+logaciklama+"','"+ tarih2+"','"+ hakedistxt.getText()+"','"+ texttcno.getText()+"','"+ textadsoyad.getText()+"','"+ textborctutari.getText()+"','"+ textalacaktutari.getText()+"','"+textaciklama.getText()+"','"+ tarih1+"')";
							try {
								myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
								mystat1=myconn1.createStatement();
								mystat1.executeUpdate(sorgu_ekle);
								JOptionPane.showMessageDialog(null, "Islem basarili");
								//sitePersonelcarihareket frame=new sitePersonelcarihareket();
								//frame.setVisible(true);
								//frame.setLocationRelativeTo(null);
								dispose();
							}catch(Exception hata)
							{
								JOptionPane.showMessageDialog(null,"TC No tekrarli veya Hatali/Eksik Alanlari Doldurunuz.!");
								System.err.println(hata);
							} 
				}
				}

		
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(380, 380, 110, 30);
//		contentPane.add(btnekle);
		
		JButton btnduzenle = new JButton("Guncelle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1,tarih2;
				if(texttcno.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "lütfen gerekli alanlarý doldurunuz");
				}
				else {
					
					Date date =new Date();
					if (texttarih.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih1=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih1=sdf.format(texttarih.getDate());//TARIH FORMATLAMA
						System.out.println(tarih1);}
					
					if (hatirlat.getDate()==null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						tarih2=sdf.format(date);}
					else {
				      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
						tarih2=sdf.format(hatirlat.getDate());//TARIH FORMATLAMA
						System.out.println(tarih2);}
					
					
					if ((textborctutari.getText()).equals("")){textborctutari.setText("0");}
					if ((textalacaktutari.getText()).equals("")){textalacaktutari.setText("0");}
					if ((hakedistxt.getText()).equals("")){hakedistxt.setText("0");}
					
					String logaciklama,logkullaniciadi,logkullaniciyetkisi;
					LocalDateTime logzamani;
					logkullaniciadi=siteBaglanti.logkullaniciadi;
					logkullaniciyetkisi=siteBaglanti.logkullaniciyetkisi;
					logaciklama="Personel Cari Islemi Guncelledi...";
					LocalDateTime now1 = LocalDateTime.now();
					logzamani=now1;
					System.out.println("GUNCELLEME ZAMANI "+logzamani);
					
					ResultSet rs1=null;
					try {
						String personel_kontrol="select * from sitepersonelbilgi where Personeltcno='"+texttcno.getText()+"'";
						myconn2=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
						mystat2=myconn2.createStatement();
						rs1=mystat2.executeQuery(personel_kontrol);
						if(rs1.next()) {
							String guncelle="update sitepersonelcarihareket set logzamani='"+logzamani+"',logkullaniciyetkisi='"+logkullaniciyetkisi+"', logaciklama='"+logaciklama+"',logkullaniciadi='"+logkullaniciadi+"',hakedis='"+ hakedistxt.getText()+"',hatirlat='"+ tarih2+"',Personeltcno='"+ texttcno.getText()+"',Personeladsoyad='"+ textadsoyad.getText()+"',Personelborctutari='"+textborctutari.getText()+"',Personelalacaktutari='"+textalacaktutari.getText()+"',Aciklama='"+textaciklama.getText()+"',Personelharekettarihi='"+ tarih1+"' where Personelhareketid='"+sitePersonelcarihareket.id_sakla+"'";
							try {
								myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
								mystat1=myconn1.createStatement();
								mystat1.executeUpdate(guncelle);
								JOptionPane.showMessageDialog(null,"guncelleme basarili");
								sitePersonelcarihareket frame=new sitePersonelcarihareket();
								frame.setVisible(true);
								frame.setLocationRelativeTo(null);
								dispose();
							}catch(Exception hata) {
								System.err.println(hata);
							}
						}else {
							JOptionPane.showMessageDialog(null,"personel tcyi kontrol ediniz.boyle bir tc yoktur");
						}
					}catch(Exception hata) {
						System.err.println(hata);
					}
				}
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(380, 380, 110, 30);
//		contentPane.add(btnduzenle);
		
		if(sitePersonelcarihareket.id==0)
		{
			textadsoyad.setText(sitePersonelanaekrani.isimal);
			texttcno.setText(sitePersonelcarihareket.id_al);
			System.out.println(sitePersonelanaekrani.isimal + " " + sitePersonelcarihareket.id_al );
			contentPane.add(btnekle);
		}
		else
		{
			texttcno.enable(false);
			textadsoyad.enable(false);
			contentPane.add(btnduzenle);

		}
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sitePersonelcarihareket frame=new sitePersonelcarihareket();
				//frame.setVisible(true);
				//frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(624, 380, 110, 30);
		contentPane.add(btnvazgec);
		
		JButton btntemizle = new JButton("Temizle");
		btntemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//texttcno.setText("");
				//textadsoyad.setText("");
				textborctutari.setText("");
				textalacaktutari.setText("");
				textaciklama.setText("");
				//texttarih.setText("");
			}
		});
		btntemizle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntemizle.setBounds(501, 380, 110, 30);
		contentPane.add(btntemizle);
		
		JLabel lblNewLabel_1_1 = new JLabel("Islem No:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(272, 55, 82, 14);
		contentPane.add(lblNewLabel_1_1);
		
		islemno = new JTextField();
		islemno.setEnabled(false);
		islemno.setEditable(false);
		islemno.setColumns(10);
		islemno.setBounds(404, 55, 168, 20);
		contentPane.add(islemno);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Log Kullanici Adi:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(603, 58, 132, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		logkullaniciadi = new JTextField();
		logkullaniciadi.setHorizontalAlignment(SwingConstants.RIGHT);
		logkullaniciadi.setEditable(false);
		logkullaniciadi.setColumns(10);
		logkullaniciadi.setBackground(Color.WHITE);
		logkullaniciadi.setBounds(745, 55, 168, 20);
		contentPane.add(logkullaniciadi);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Log Islem Zamani:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(603, 90, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		logzamani = new JTextField();
		logzamani.setHorizontalAlignment(SwingConstants.RIGHT);
		logzamani.setEditable(false);
		logzamani.setColumns(10);
		logzamani.setBackground(Color.WHITE);
		logzamani.setBounds(745, 87, 168, 20);
		contentPane.add(logzamani);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Log Islem Aciklamasi:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2.setBounds(603, 120, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		logaciklama = new JTextField();
		logaciklama.setHorizontalAlignment(SwingConstants.RIGHT);
		logaciklama.setEditable(false);
		logaciklama.setColumns(10);
		logaciklama.setBackground(Color.WHITE);
		logaciklama.setBounds(745, 117, 168, 20);
		contentPane.add(logaciklama);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Log Islem Yetkisi:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2_1.setBounds(603, 152, 132, 14);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		logkullaniciyetkisi = new JTextField();
		logkullaniciyetkisi.setHorizontalAlignment(SwingConstants.RIGHT);
		logkullaniciyetkisi.setEditable(false);
		logkullaniciyetkisi.setColumns(10);
		logkullaniciyetkisi.setBackground(Color.WHITE);
		logkullaniciyetkisi.setBounds(745, 149, 168, 20);
		contentPane.add(logkullaniciyetkisi);
		

		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("Pencere Acildi");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("Pencere kapandi");
			}
			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println(sitePersonelcarihareket.id);
				 sitePersonelcarihareket.id_sakla=sitePersonelcarihareket.id;
				 sitePersonelcarihareket.id=0;
				 
				 ResultSet rs=null;
				  try 
					{
						myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
						String listele="select * from sitepersonelcarihareket where Personelhareketid='"+sitePersonelcarihareket.id_sakla+"'";
						mystat1=myconn1.createStatement();
						rs=mystat1.executeQuery(listele);
						if(rs.next()) {
							texttcno.setText(rs.getString("Personeltcno"));
							textadsoyad.setText(rs.getString("Personeladsoyad"));
							textborctutari.setText(rs.getString("Personelborctutari"));
							textalacaktutari.setText(rs.getString("Personelalacaktutari"));
							textaciklama.setText(rs.getString("Aciklama"));
							texttarih.setDate(rs.getDate("Personelharekettarihi"));
							hatirlat.setDate(rs.getDate("hatirlat"));
							hakedistxt.setText(rs.getString("hakedis"));
							islemno.setText(rs.getString("Personelhareketid"));
						
							
							logaciklama.setText(rs.getString("logaciklama"));
							logkullaniciyetkisi.setText(rs.getString("logkullaniciyetkisi"));
							logzamani.setText(rs.getString("logzamani"));
							logkullaniciadi.setText(rs.getString("logkullaniciadi"));
							
						}
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
	}
}
