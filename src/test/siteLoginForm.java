package test;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import java.util.Date;
import java.util.Scanner;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.*;
import com.mysql.cj.jdbc.Driver;

 

import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;


public class siteLoginForm {

	private JFrame frmLoginForm;
	private JTextField textField1;
	private JTextField textField2;
	private JPasswordField passwordField;
	private JTextField databasetext;

	public String sunucuparametresilogin; //BAGLANTI ICIN PARAMETRE BILGILERINI TUTUYOR
	static Timer timer;//PROGRESS ICIN
	public static String loginsunucu;//SIFREMI UNUTTUM ICIN SUNUCU BILGISI TUTUYOR
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteLoginForm window = new siteLoginForm();
					window.frmLoginForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public siteLoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginForm = new JFrame();
		frmLoginForm.setResizable(false);
		frmLoginForm.getContentPane().setBackground(new Color(240, 240, 240));
		frmLoginForm.setTitle("Site Otomasyonu OFFLine- Login Form");
		frmLoginForm.setBounds(100, 100, 776, 420);
		frmLoginForm.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
		
		frmLoginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Baglan...");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		Image  img2=new ImageIcon(this.getClass().getResource("/loginbuton32pix.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		btnNewButton.setBounds(314, 144, 425, 53);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//MY SQL BAGLANTI
					try
					{
						
						sunucuparametresilogin="jdbc:mysql://"+databasetext.getText()+"/site?useTimezone=true&serverTimezone=UTC";
						Connection myconn=DriverManager.getConnection (sunucuparametresilogin,"root","");
						System.out.println("Baðlantý Saðlandý");
						
						String kullaniciadi = textField1.getText();
				        String sifre = String.valueOf(passwordField.getPassword());
				        
						
				        String query1="Select kullaniciadi,AES_DECRYPT(sifresi,'abc1234') AS sifresi,aciklama,sifrehatirlatmasoru,sifrehatirlatmacevap,yetki From sitekullanicibilgi where kullaniciadi='"+kullaniciadi+"'";
						Statement stmt1=myconn.createStatement();
						ResultSet rs1=stmt1.executeQuery(query1);
						
						//VERSION BILGI EKRANI
						String query2="Select * from siteversionbilgi"; //VERSION BILGI EKRANI
						Statement stmt2=myconn.createStatement();//VERSION BILGI EKRANI
						ResultSet rs2=stmt2.executeQuery(query2);//VERSION BILGI EKRANI
						while(rs2.next())
						{
							siteBaglanti.versionadi=rs2.getString("versionadi");//VERSION BILGI EKRANI
							siteBaglanti.versiondb=rs2.getString("versiondb");//VERSION BILGI EKRANI
							siteBaglanti.versionuygulama=rs2.getString("versionuygulama");//VERSION BILGI EKRANI
						}
						//VERSION BILGI EKRANI
						
						
						int a=0;
						String b="";
						String c="";
						String d="";
						while(rs1.next())
						{
						b=rs1.getString("aciklama");
						
					    System.out.println("Sisteme Baþarý ile Login Olundu..");
						System.out.println("kullaniciadi:"+rs1.getString("kullaniciadi")+"sifresi"+rs1.getString("sifresi")+"Aciklama : " + rs1.getString("aciklama")+"Yetki : " + rs1.getString("yetki"));
						c=rs1.getString("yetki");
						siteBaglanti.logkullaniciyetkisi=rs1.getString("yetki");
						d=rs1.getString("sifresi");
						a=a+1;
						}
						if ((a>=1)&&(sifre.equals(d))&&(kullaniciadi!=null)&&(sifre!=null)) {
							
							//LOG TABLOSUNA EKLEME
							btnNewButton.setEnabled(false);//HERSEY DOGRUYSA BAGLAN BUTONU PASIF EDLIYOR
							
							String sorgulogkayit,logkullaniciadi,logkullaniciyetkisi,logsunucuparametre,logaksiyon;
							logkullaniciadi=kullaniciadi;
							logkullaniciyetkisi=c;
							logaksiyon="Sisteme Giris Yapti";
							logsunucuparametre=sunucuparametresilogin;
							siteBaglanti.logkullaniciyetkisi=c;
							siteBaglanti.logkullaniciadi=kullaniciadi;//BAGLANTI CLASSINA YAZIYOR
							siteBaglanti.logaksiyon="Sisteme Giris Yapti";// BAGLANTI CLASSINA YAZIYOR
							siteBaglanti.kullanimpdf="https://drive.google.com/open?id=1inJZcH4ha2tER2LbiXxUksB6LH8vU53c";
							siteBaglanti.sunucuparametresi=sunucuparametresilogin;
							sorgulogkayit="INSERT INTO sitelog (logkullaniciadi,logkullaniciyetkisi,logsunucuparametre,logaksiyon) VALUES ('"+logkullaniciadi+"','"+logkullaniciyetkisi+"','"+logsunucuparametre+"','"+logaksiyon+"')";
							System.out.println(sorgulogkayit);
							try {
								stmt1.executeUpdate(sorgulogkayit);
								System.out.println("Ekleme Basarili");
								}catch(Exception hata)
								{
								System.err.println(hata);
								}

							//LOG TABLOSUNA EKLEME
					
							//PROGRESS EKLEME
							JProgressBar progressBar = new JProgressBar();
							progressBar.setStringPainted(true);
							progressBar.setBounds(314,304, 425,65);
							frmLoginForm.getContentPane().add(progressBar);
							
							timer = new Timer (100, new ActionListener() {
								private int x=0;
								public void actionPerformed(ActionEvent arg0) {
									
									progressBar.setValue(x+=10);
									if (x==100) {
										timer.stop();
										//JOptionPane.showMessageDialog(null,"Tamamlandi");
										x=0;
										siteAnaMenu frame = new siteAnaMenu();
										frame.setVisible(true);
										
										System.out.println("BAGLANTIYA SUNUCU PARAMETRESI YAZILDI"+siteBaglanti.sunucuparametresi);
										
										frmLoginForm.setVisible(false);

									}
									}
							});
							
							//PROGRESS EKLEME
							timer.start();
							
						}
						else {
							Object [] noSaveOption = {"Tamam"};
							int noSave = JOptionPane.showOptionDialog(null,"Hatali Giris yaptiniz!","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
							//JOptionPane.showMessageDialog(null,noSaveOption, "Hatali Giris...!","Hukuk Otomasyonu",JOptionPane.PLAIN_MESSAGE,null);

						}

					
					}catch(Exception hata)
					{
					System.err.println(hata.getMessage());
					//throw new Exception("Deneme123");
					}
				
			}
		});
		frmLoginForm.getContentPane().setLayout(null);
		frmLoginForm.getContentPane().add(btnNewButton);
		
		textField1 = new JTextField();
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					passwordField.requestFocus();
				}
			}
		});
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField1.setBounds(491, 10, 248, 37);
		frmLoginForm.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		 
		
		JLabel lblNewLabel = new JLabel("Kullanici Adiniz :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(314, 10, 168, 37);
		frmLoginForm.getContentPane().add(lblNewLabel);
		
		JLabel lblSifrenizZ = new JLabel("Sifreniz  :");
		lblSifrenizZ.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSifrenizZ.setBounds(314, 50, 168, 37);
		frmLoginForm.getContentPane().add(lblSifrenizZ);
		
	
		
		
		JLabel Logo = new JLabel("");
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.setOpaque(true);
		Logo.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/apartment-icon.png")).getImage();//LOGO DOSYASYI CEKILIYOR
		frmLoginForm.getContentPane().add(Logo);
		Logo.setIcon(new ImageIcon(img));
		Logo.setBounds(10, 10, 287, 283);

		

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					databasetext.requestFocus();
				}
			}
		});
		passwordField.setBounds(491, 50, 248, 37);
		frmLoginForm.getContentPane().add(passwordField);
		
		JLabel lblDatabaseSeimi = new JLabel("Server Adi / IP :");
		lblDatabaseSeimi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDatabaseSeimi.setBounds(314, 90, 168, 37);
		frmLoginForm.getContentPane().add(lblDatabaseSeimi);
		
		databasetext = new JTextField();
		databasetext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField1.requestFocus();
				}
			}
		});
		databasetext.setHorizontalAlignment(SwingConstants.LEFT);
		databasetext.setText("localhost:3306");
		databasetext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		databasetext.setColumns(10);
		databasetext.setBounds(491, 90, 248, 37);
		frmLoginForm.getContentPane().add(databasetext);
		
		JButton btnNewButton_1 = new JButton("Sifremi Unuttum ?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginsunucu=databasetext.getText();
				siteSifremiunuttum frame = new siteSifremiunuttum();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR	
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image  img3=new ImageIcon(this.getClass().getResource("/sifremiunuttum22pix.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img3));
		btnNewButton_1.setBounds(314, 248, 190, 45);
		frmLoginForm.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Hakkimizda !");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image  img4=new ImageIcon(this.getClass().getResource("/hakkimizda24pix.png")).getImage();
		btnNewButton_1_1.setIcon(new ImageIcon(img4));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siteProgramhakkinda frame = new siteProgramhakkinda();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}
		});
		btnNewButton_1_1.setBounds(549, 248, 190, 45);
		frmLoginForm.getContentPane().add(btnNewButton_1_1);
		
		JLabel Logo_1 = new JLabel("");
		Logo_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image  img6=new ImageIcon(this.getClass().getResource("/javamysql.png")).getImage();
		Logo_1.setIcon(new ImageIcon(img6));
		Logo_1.setBackground(Color.WHITE);
		Logo_1.setBounds(10, 304, 287, 65);
		frmLoginForm.getContentPane().add(Logo_1);
		
		JButton btnNewButton_2 = new JButton("Online Kullanim Kilavuzu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				///// YARDIM KILAVUZU ONLINE			
				//String FILE = "D:/Hukukyardim.pdf";
				String FILE = "https://drive.google.com/open?id=1inJZcH4ha2tER2LbiXxUksB6LH8vU53c"; //Online Kullanim Kilavuzumuz
				
				try {
					if (new URL(FILE) != null) {
						Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + FILE);
						p.waitFor();
					} else {
						System.out.println("Dosya Bulunamadi");
					}
					System.out.println("Basarili");
				} catch (Exception ex) {
					ex.printStackTrace();
				}


				//YARDIM KILAVUZU ONLINE

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image  img5=new ImageIcon(this.getClass().getResource("/yardim12pix.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img5));
		btnNewButton_2.setBounds(314, 208, 425, 30);
		frmLoginForm.getContentPane().add(btnNewButton_2);
		
	}
}
