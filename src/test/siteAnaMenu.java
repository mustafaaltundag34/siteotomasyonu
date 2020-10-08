package test;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jdk.dynalink.support.SimpleRelinkableCallSite;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.List;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.awt.Dialog.ModalExclusionType;

public class siteAnaMenu extends JFrame {

	public JPanel contentPane;
	private JLabel versiyonlabel; //VERSIYON ICIN
	static Timer timer;//PROGRESS ICIN
	private Label now;//TARIH SAAT ICIN
	private JTable table;
	
	static Connection myconn1;
	static Statement mystat1;
	
	public static JButton sitesikayetbuton;
	 public static JButton siteortakcaributon;
	 public static JButton siteblokbolumbuton;
	 public static JButton kullanicibuton;
	 public static JButton sitepersonelbuton;
	 public static JButton sitetanimbuton;
	 public static JButton cikisbuton;
	 public static JButton yardimbuton;
	 public static JButton loganabuton;
	 public static JButton siteajandabuton;
	 public static JButton hakkimizdabuton;
	 
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	
	Object [] kolonlar = {"logislemzamani","logkullaniciadi","logislemid","Aciklama","logkullaniciyetkisi"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[5]; //SATIR TANIMLAMA
	private JButton btnYardimAnaEkrani_1;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteAnaMenu frame = new siteAnaMenu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void clock()//SAAT TARIH FONKSIYONU
	{
		
		Label now = new Label("Tarih ve Saat");
		now.setAlignment(Label.CENTER);
		now.setBackground(Color.WHITE);
		now.setFont(new Font("Tahoma", Font.BOLD, 16));
		now.setBounds(13, 491, 1164, 24);
		contentPane.add(now);
		
//		List list = new List(); //HATIRLATILACAKLAR ACILIRSA BU AKTIFLENECEK
//		list.setBackground(new Color(250, 250, 210));//HATIRLATILACAKLAR ACILIRSA BU AKTIFLENECEK
//		list.setMultipleSelections(false);///HATIRLATILACAKLAR ACILIRSA BU AKTIFLENECEK
//		list.setFont(new Font("Arial", Font.PLAIN, 16));//HATIRLATILACAKLAR ACILIRSA BU AKTIFLENECEK
//		list.setBounds(10, 495, 1167, 88);//HATIRLATILACAKLAR ACILIRSA BU AKTIFLENECEK
//		contentPane.add(list);//HATIRLATILACAKLAR ACILIRSA BU AKTIFLENECEK
		

	
		Thread clock=new Thread() {
			
			public void run () {
				
				try {
					for(;;) {
						
						LocalDate now1 = LocalDate.now(); // 2014-04-05
						Calendar cal=new GregorianCalendar();
						
						int day1=now1.getDayOfMonth();
						int month1=now1.getMonthValue();
						int year1=now1.getYear();
						
						//int day=cal.get(Calendar.DAY_OF_MONTH);
						//int month=cal.get(Calendar.MONTH);
						//int year=cal.get(Calendar.YEAR);
											
						int second=cal.get(Calendar.SECOND);
						int minute=cal.get(Calendar.MINUTE);
						int hour=cal.get(Calendar.HOUR_OF_DAY);
						
						now.setText(day1+"-"+month1+"-"+year1+" "+hour+":"+minute+":"+second+"    "+"Anlik Kullanici Log Kayitlari");
					sleep(1000);
				
				//HATIRLATILACAKLAR PANOSU

				//HATIRLAMA LISTESI BURAYA GELIYOR

				///HATIRLATILACAKLAR PANOSU
				}} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}//SAAT TARIH FONKSIYONU
	///////
	
	
	
	public siteAnaMenu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("SITESAKINI")) {//KULLANICI YETKI KONTROLU
					sitesikayetbuton.setVisible(true);
				    siteortakcaributon.setVisible(false);
				    siteblokbolumbuton.setVisible(false);
				    kullanicibuton.setVisible(false);
				    sitepersonelbuton.setVisible(false);
				    sitetanimbuton.setVisible(false);
				    loganabuton.setVisible(false);
				    siteajandabuton.setVisible(false);
				    
				    
					//sitesikayetbuton.setEnabled(false);
				    siteortakcaributon.setEnabled(false);
				    siteblokbolumbuton.setEnabled(false);
				    kullanicibuton.setEnabled(false);
				    sitepersonelbuton.setEnabled(false);
				    sitetanimbuton.setEnabled(false);
				    //cikisbuton.setEnabled(false);
				    //yardimbuton.setEnabled(false);
				    loganabuton.setEnabled(false);
				    siteajandabuton.setEnabled(false);
				    //hakkimizdabuton.setEnabled(false);
				}
				//LOGLAR GUNCELLENIYOR
				modelim.setRowCount(0);//TABLOYU TEMIZLIYOR
				//
		 		ResultSet rs1 = null;
				try {
					System.out.println(siteBaglanti.sunucuparametresi);
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					System.out.println("Baðlantý Saðlandý");

					String listele="Select A.islemzamani,A.kullaniciadi,A.islemid,A.Aciklama,A.kullaniciyetki From sitelogislem A UNION ALL Select B.logzamani,B.logkullaniciadi,B.Ortakcarihareketid,B.logaciklama,B.logkullaniciyetkisi From siteortakcarihareket B UNION ALL Select C.logzamani,C.logkullaniciadi,C.Bolumcarihareketid,C.logaciklama,C.logkullaniciyetkisi From sitebolumcarihareket C UNION ALL Select D.logzamani,D.logkullaniciadi,D.Personelhareketid,D.logaciklama,D.logkullaniciyetkisi From sitepersonelcarihareket D UNION ALL Select E.logzamani,E.logkullaniciadi,E.sikayetid,E.logaciklama,E.logkullaniciyetkisi From sitesikayetbilgihareket E order by islemzamani desc" ;
					//String query1="Select * From sitelogislem order by islemid DESC ";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					System.out.println("Listeleme Basarili");
				}catch(Exception hata)
				{
				System.err.println(hata);
				}
				//
				
				try {
				while(rs1.next()) {
					satirlar[0]=rs1.getString("islemzamani");
					satirlar[1]=rs1.getString("kullaniciadi");
					satirlar[2]=rs1.getString("islemid");
					satirlar[3]=rs1.getString("Aciklama");
					satirlar[4]=rs1.getString("kullaniciyetki");
					modelim.addRow(satirlar);
				}		
				}catch(SQLException hata)
				{
					System.err.println(hata);
					}
				table.setModel(modelim);
				table.updateUI();
				System.out.println("TOPLAM KAYIT: "+table.getRowCount());
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				
				//LOGLAR GUNCELLENIYOR
				
				
			}
			@Override
			public void windowClosing(WindowEvent e) {
				
				////CIKIS LOGU EKLEME
				Connection myconn2=null;
				Statement mystat2;
				//LOG TABLOSUNA EKLEME
				try {
					System.out.println(siteBaglanti.sunucuparametresi);
					myconn2=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");//LOGIN FORMDAN DIREK SUNUCU PARAMETRESI GELIYOR

					System.out.println("BAGLANTI CLASSINDAN Baðlantý Saðlandý YENI");
				}catch(Exception hata)
				{
				System.err.println(hata);
				}
				
				String sorgulogkayit,logkullaniciadi,logkullaniciyetkisi,logsunucuparametre,logaksiyon;
				logkullaniciadi=siteBaglanti.logkullaniciadi;
				logkullaniciyetkisi=siteBaglanti.logkullaniciyetkisi;
				logaksiyon="Sistemden Cikis Yapti";
				logsunucuparametre=siteBaglanti.sunucuparametresi;
				sorgulogkayit="INSERT INTO sitelog (logkullaniciadi,logkullaniciyetkisi,logsunucuparametre,logaksiyon) VALUES ('"+logkullaniciadi+"','"+logkullaniciyetkisi+"','"+logsunucuparametre+"','"+logaksiyon+"')";

				System.out.println(sorgulogkayit);
				try {
					mystat2=myconn2.createStatement();
					mystat2.executeUpdate(sorgulogkayit);

					System.out.println("Cikis Log Ekleme Basarili");

					}catch(Exception hata)
					{
					System.err.println(hata);
					}

				//LOG TABLOSUNA EKLEME
				
				///CIKIS LOGU EKLEME
				if (!siteBaglanti.logkullaniciyetkisi.equals("SITESAKINI"))
				{siteKayitsayitablosu frame = new siteKayitsayitablosu();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				}
			}
		});
		setTitle("Site Otomasyonu - ONline v. "+siteBaglanti.versionuygulama+siteBaglanti.versiondb +"- Ana Menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1204, 690);
		setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		clock();//SAATI GOSTERME
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 521, 1164, 93);
		contentPane.add(scrollPane);
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setBackground(Color.BLACK);
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(table);



		
		//HATIRLATMA EKRANINI YALNIZCA KAYIT OLUP OLMAMASI OPSIYONUNA CEVIREBILIRIZ
		siteHatirlatmapopup frame = new siteHatirlatmapopup();
		frame.show();
		frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
		//
		//HATIRLATMA EKRANINI YALNIZCA KAYIT OLUP OLMAMASI OPSIYONUNA CEVIREBILIRIZ
		
		siteblokbolumbuton = new JButton("3-) Site Blok/Bolum Islemleri");
		siteblokbolumbuton.setHorizontalAlignment(SwingConstants.LEFT);
		siteblokbolumbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sitesikayetbuton.setEnabled(false);
			    siteortakcaributon.setEnabled(false);
			    siteblokbolumbuton.setEnabled(false);
			    kullanicibuton.setEnabled(false);
			    sitepersonelbuton.setEnabled(false);
			    sitetanimbuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbuton.setEnabled(false);
			    loganabuton.setEnabled(false);
			    siteajandabuton.setEnabled(false);
			    hakkimizdabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1165, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Site Blok Bilgi Ana Ekranýna gitti...";
							String sorgu_kaydet="insert into sitelogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+siteBaglanti.logkullaniciadi+"','"+siteBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							siteBaglanti baglan = new siteBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							
							siteBlokbilgi frame = new siteBlokbilgi();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();

			}
		});


		siteblokbolumbuton.setBounds(290, 233, 289, 100);
		siteblokbolumbuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(siteblokbolumbuton);
		
		if (siteBaglanti.logkullaniciyetkisi.equals("SITESAKINI"))
		{
			sitesikayetbuton = new JButton("Site Sikayet Islemleri");
			sitesikayetbuton.setFont(new Font("Tahoma", Font.PLAIN, 48));
			sitesikayetbuton.setHorizontalAlignment(SwingConstants.CENTER);
			sitesikayetbuton.setBounds(290, 11,591, 437);
		}
		else {


			sitesikayetbuton = new JButton("4-) Site Sikayet Islemleri");
			sitesikayetbuton.setHorizontalAlignment(SwingConstants.LEFT);
			sitesikayetbuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
			sitesikayetbuton.setBounds(290, 348, 289, 100);
		}

		sitesikayetbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sitesikayetbuton.setEnabled(false);
			    siteortakcaributon.setEnabled(false);
			    siteblokbolumbuton.setEnabled(false);
			    kullanicibuton.setEnabled(false);
			    sitepersonelbuton.setEnabled(false);
			    sitetanimbuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbuton.setEnabled(false);
			    loganabuton.setEnabled(false);
			    siteajandabuton.setEnabled(false);
			    hakkimizdabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1165, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Site Sikayet Ana Ekranina gitti...";
							String sorgu_kaydet="insert into sitelogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+siteBaglanti.logkullaniciadi+"','"+siteBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							siteBaglanti baglan = new siteBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							siteSikayetanaekrani frame = new siteSikayetanaekrani();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();

				
			}
		});

		contentPane.add(sitesikayetbuton);
		
		
		sitepersonelbuton = new JButton("5-) Site Personel Islemleri");
		sitepersonelbuton.setHorizontalAlignment(SwingConstants.LEFT);
		sitepersonelbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sitesikayetbuton.setEnabled(false);
			    siteortakcaributon.setEnabled(false);
			    siteblokbolumbuton.setEnabled(false);
			    kullanicibuton.setEnabled(false);
			    sitepersonelbuton.setEnabled(false);
			    sitetanimbuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbuton.setEnabled(false);
			    loganabuton.setEnabled(false);
			    siteajandabuton.setEnabled(false);
			    hakkimizdabuton.setEnabled(false);
				
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1165, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Site Personel Ana Ekranina gitti...";
							String sorgu_kaydet="insert into sitelogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+siteBaglanti.logkullaniciadi+"','"+siteBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							siteBaglanti baglan = new siteBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							
							sitePersonelanaekrani frame = new sitePersonelanaekrani();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();

			}
		});
		sitepersonelbuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sitepersonelbuton.setBounds(589, 11, 289, 100);
		contentPane.add(sitepersonelbuton);
		
		kullanicibuton = new JButton("7-)  Kullanici Yonetimi Ekrani");
		kullanicibuton.setHorizontalAlignment(SwingConstants.LEFT);
		kullanicibuton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				sitesikayetbuton.setEnabled(false);
			    siteortakcaributon.setEnabled(false);
			    siteblokbolumbuton.setEnabled(false);
			    kullanicibuton.setEnabled(false);
			    sitepersonelbuton.setEnabled(false);
			    sitetanimbuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbuton.setEnabled(false);
			    loganabuton.setEnabled(false);
			    siteajandabuton.setEnabled(false);
			    hakkimizdabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1165, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Site Kullanici Yonetimi Ana Ekranina gitti...";
							String sorgu_kaydet="insert into sitelogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+siteBaglanti.logkullaniciadi+"','"+siteBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							siteBaglanti baglan = new siteBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							siteKullanicikayit frame = new siteKullanicikayit();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							progressBar.hide();
							
							sitesikayetbuton.setEnabled(true);
						    siteortakcaributon.setEnabled(true);
						    siteblokbolumbuton.setEnabled(true);
						    kullanicibuton.setEnabled(true);
						    sitepersonelbuton.setEnabled(true);
						    sitetanimbuton.setEnabled(true);
						    cikisbuton.setEnabled(true);
						    yardimbuton.setEnabled(true);
						    loganabuton.setEnabled(true);
						    siteajandabuton.setEnabled(true);
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();

				
			}
		});
		kullanicibuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		kullanicibuton.setBounds(589, 233, 289, 100);
		contentPane.add(kullanicibuton);
		
		siteortakcaributon = new JButton("2-) Site Ortak Cari Hareketleri");
		siteortakcaributon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				sitesikayetbuton.setEnabled(false);
			    siteortakcaributon.setEnabled(false);
			    siteblokbolumbuton.setEnabled(false);
			    kullanicibuton.setEnabled(false);
			    sitepersonelbuton.setEnabled(false);
			    sitetanimbuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbuton.setEnabled(false);
			    loganabuton.setEnabled(false);
			    siteajandabuton.setEnabled(false);
			    hakkimizdabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1165, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Site Ortak Cari Hareketler Ekranina gitti...";
							String sorgu_kaydet="insert into sitelogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+siteBaglanti.logkullaniciadi+"','"+siteBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							siteBaglanti baglan = new siteBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							siteOrtakcarihareket frame = new siteOrtakcarihareket();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR	
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
				

			}
		});
		siteortakcaributon.setHorizontalAlignment(SwingConstants.LEFT);
		siteortakcaributon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		siteortakcaributon.setBounds(290, 122, 289, 100);
		contentPane.add(siteortakcaributon);
		
		
		cikisbuton = new JButton("CIKIS");
		cikisbuton.setHorizontalAlignment(SwingConstants.LEFT);
		cikisbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object [] noSaveOption = {"Evet","Hayýr"};
				//int selectedOption = JOptionPane.showConfirmDialog(null,"Çýkýþ yapmak istiyor musunuz?","Site Otomasyonu",JOptionPane.YES_NO_OPTION);
				int noSave = JOptionPane.showOptionDialog(null,"Çýkýþ yapmak istiyor musunuz?","Site Otomasyonu",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				if (noSave == JOptionPane.YES_OPTION)
				{
//// LOG EKLEME
					////CIKIS LOGU EKLEME
					Connection myconn2=null;
					Statement mystat2;
					//LOG TABLOSUNA EKLEME
					try {
						System.out.println(siteBaglanti.sunucuparametresi);
						myconn2=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");//LOGIN FORMDAN DIREK SUNUCU PARAMETRESI GELIYOR

						System.out.println("BAGLANTI CLASSINDAN Baðlantý Saðlandý YENI");
					}catch(Exception hata)
					{
					System.err.println(hata);
					}
					
					String sorgulogkayit,logkullaniciadi,logkullaniciyetkisi,logsunucuparametre,logaksiyon;
					logkullaniciadi=siteBaglanti.logkullaniciadi;
					logkullaniciyetkisi=siteBaglanti.logkullaniciyetkisi;
					logaksiyon="Sistemden Cikis Yapti";
					logsunucuparametre=siteBaglanti.sunucuparametresi;
					sorgulogkayit="INSERT INTO sitelog (logkullaniciadi,logkullaniciyetkisi,logsunucuparametre,logaksiyon) VALUES ('"+logkullaniciadi+"','"+logkullaniciyetkisi+"','"+logsunucuparametre+"','"+logaksiyon+"')";

					System.out.println(sorgulogkayit);
					try {
						mystat2=myconn2.createStatement();
						mystat2.executeUpdate(sorgulogkayit);

						System.out.println("Cikis Log Ekleme Basarili");

						}catch(Exception hata)
						{
						System.err.println(hata);
						}

					//LOG TABLOSUNA EKLEME
					
					///CIKIS LOGU EKLEME			
					
/// LOG EKLEME
					
					
					siteKayitsayitablosu frame = new siteKayitsayitablosu();
					frame.show();
					frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
					
					System.exit(0);
				}
			}
		});
		cikisbuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Image  img1=new ImageIcon(this.getClass().getResource("/logout2.png")).getImage();
		cikisbuton.setIcon(new ImageIcon(img1));
		cikisbuton.setBounds(888, 233, 289, 215);
		contentPane.add(cikisbuton);
		
		sitetanimbuton = new JButton("1-) Site Tanim Islemleri");
		sitetanimbuton.setHorizontalAlignment(SwingConstants.LEFT);
		sitetanimbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!siteBaglanti.logkullaniciyetkisi.equals("SITESAKINI")) {//KULLANICI YETKI KONTROLU
				sitesikayetbuton.setEnabled(false);
			    siteortakcaributon.setEnabled(false);
			    siteblokbolumbuton.setEnabled(false);
			    kullanicibuton.setEnabled(false);
			    sitepersonelbuton.setEnabled(false);
			    sitetanimbuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbuton.setEnabled(false);
			    loganabuton.setEnabled(false);
			    siteajandabuton.setEnabled(false);
			    hakkimizdabuton.setEnabled(false);
				
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1165, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Site Bilgi Ana Ekranina gitti...";
							String sorgu_kaydet="insert into sitelogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+siteBaglanti.logkullaniciadi+"','"+siteBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							siteBaglanti baglan = new siteBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								table.updateUI();
								System.out.println("TOPLAM KAYIT: "+table.getRowCount());
								if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							
							siteBilgianaekran frame = new siteBilgianaekran();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR		
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
				
				}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Site Sakini bu Islemi yapamaz ..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}
			}
		});
		sitetanimbuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sitetanimbuton.setBounds(290, 11, 289, 100);
		contentPane.add(sitetanimbuton);

		
		loganabuton = new JButton("8-)  Log Yonetimi Ana Ekrani");
		loganabuton.setHorizontalAlignment(SwingConstants.LEFT);
		loganabuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				sitesikayetbuton.setEnabled(false);
			    siteortakcaributon.setEnabled(false);
			    siteblokbolumbuton.setEnabled(false);
			    kullanicibuton.setEnabled(false);
			    sitepersonelbuton.setEnabled(false);
			    sitetanimbuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbuton.setEnabled(false);
			    loganabuton.setEnabled(false);
			    siteajandabuton.setEnabled(false);
			    hakkimizdabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1165, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Site Log Yonetimi Ana Ekranina gitti...";
							String sorgu_kaydet="insert into sitelogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+siteBaglanti.logkullaniciadi+"','"+siteBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							siteBaglanti baglan = new siteBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							siteLogkayitlari frame = new siteLogkayitlari();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR	
							progressBar.hide();
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
				}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}

			}
		});
		loganabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loganabuton.setBounds(589, 348, 289, 100);
		contentPane.add(loganabuton);
		
	
		JLabel labelanafoto = new JLabel("");//ANA MENUDEKI FOTOGRAF
		labelanafoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelanafoto.setOpaque(true);
		labelanafoto.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/apartment-icon.png")).getImage();
//		Image  img=new ImageIcon(this.getClass().getResource("/denemegif.gif")).getImage();
		labelanafoto.setIcon(new ImageIcon(img));
		labelanafoto.setBounds(13, 11, 267, 437);
		contentPane.add(labelanafoto);

		
		Label durumcubugu = new Label("");
		durumcubugu.setFont(new Font("Tahoma", Font.BOLD, 12));
		durumcubugu.setBackground(Color.WHITE);
		durumcubugu.setBounds(10, 620, 843, 27);
		durumcubugu.setText("KULLANICI : "+siteBaglanti.logkullaniciadi+" "+"YETKI :"+siteBaglanti.logkullaniciyetkisi+" "+"DURUM :"+siteBaglanti.sunucuparametresi+" "+" ONLINE");
		contentPane.add(durumcubugu);
		
		Label versiyonlabel = new Label("Version");
		versiyonlabel.setAlignment(Label.RIGHT);
		versiyonlabel.setBackground(Color.WHITE);
		versiyonlabel.setForeground(Color.BLACK);
		versiyonlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		versiyonlabel.setBounds(857, 620, 320, 27);
		versiyonlabel.setText(siteBaglanti.versionadi+siteBaglanti.versionuygulama+siteBaglanti.versiondb);
		contentPane.add(versiyonlabel);
		
		yardimbuton = new JButton("YARDIM");
		yardimbuton.setHorizontalAlignment(SwingConstants.LEFT);
		yardimbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sitesikayetbuton.setEnabled(false);
			    siteortakcaributon.setEnabled(false);
			    siteblokbolumbuton.setEnabled(false);
			    kullanicibuton.setEnabled(false);
			    sitepersonelbuton.setEnabled(false);
			    sitetanimbuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbuton.setEnabled(false);
			    loganabuton.setEnabled(false);
			    siteajandabuton.setEnabled(false);
			    hakkimizdabuton.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1165, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Site Kullanim Kilavuzuna gitti...";
							String sorgu_kaydet="insert into sitelogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+siteBaglanti.logkullaniciadi+"','"+siteBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							siteBaglanti baglan = new siteBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
	 						///// YARDIM KILAVUZU ONLINE			
	 						//String FILE = "D:/Hukukyardim.pdf";
	 						String FILE = siteBaglanti.kullanimpdf; //Online Kullanim Kilavuzumuz
	 						
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
							progressBar.hide();
							
							sitesikayetbuton.setEnabled(true);
						    siteortakcaributon.setEnabled(true);
						    siteblokbolumbuton.setEnabled(true);
						    kullanicibuton.setEnabled(true);
						    sitepersonelbuton.setEnabled(true);
						    sitetanimbuton.setEnabled(true);
						    cikisbuton.setEnabled(true);
						    yardimbuton.setEnabled(true);
						    loganabuton.setEnabled(true);
						    siteajandabuton.setEnabled(true);
						    hakkimizdabuton.setEnabled(true);
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
				
			}
		});
		yardimbuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Image  img2=new ImageIcon(this.getClass().getResource("/yardimyeni64pix.png")).getImage();
		yardimbuton.setIcon(new ImageIcon(img2));
		yardimbuton.setBounds(888, 11, 289, 100);
		contentPane.add(yardimbuton);
		
		siteajandabuton = new JButton("6-)  Site Ajanda ve Hatirlatma");
		siteajandabuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sitesikayetbuton.setEnabled(false);
			    siteortakcaributon.setEnabled(false);
			    siteblokbolumbuton.setEnabled(false);
			    kullanicibuton.setEnabled(false);
			    sitepersonelbuton.setEnabled(false);
			    sitetanimbuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbuton.setEnabled(false);
			    loganabuton.setEnabled(false);
			    siteajandabuton.setEnabled(false);
			    hakkimizdabuton.setEnabled(false);
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1165, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							
							//KULLANICI LOGU EKLEME
							String islemaciklama;
							islemaciklama="Site Ajanda ve Hatirlatma Ana Ekranina gitti...";
							String sorgu_kaydet="insert into sitelogislem (kullaniciadi,kullaniciyetki,Aciklama)values('"+siteBaglanti.logkullaniciadi+"','"+siteBaglanti.logkullaniciyetkisi+"','"+islemaciklama +"')";
							 
	 						try {
	 							siteBaglanti baglan = new siteBaglanti();
	 							baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								//JOptionPane.showMessageDialog(null,"Islem Baþarýlý");
								 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	 						
							//KULLANICI LOGU EKLEME
							
							siteAjandaanaekrani frame = new siteAjandaanaekrani();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR	
							progressBar.hide();
							

						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
				
			
			}
		});
		siteajandabuton.setHorizontalAlignment(SwingConstants.LEFT);
		siteajandabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		siteajandabuton.setBounds(589, 122, 289, 100);
		contentPane.add(siteajandabuton);
		
		hakkimizdabuton = new JButton("HAKKIMIZDA");
		hakkimizdabuton.setHorizontalAlignment(SwingConstants.LEFT);
		hakkimizdabuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//
				sitesikayetbuton.setEnabled(false);
			    siteblokbolumbuton.setEnabled(false);
			    kullanicibuton.setEnabled(false);
			    sitepersonelbuton.setEnabled(false);
			    sitetanimbuton.setEnabled(false);
			    cikisbuton.setEnabled(false);
			    yardimbuton.setEnabled(false);
			    loganabuton.setEnabled(false);
			    siteajandabuton.setEnabled(false);
			    hakkimizdabuton.setEnabled(false);
			    siteortakcaributon.setEnabled(false);
			    
				//PROGRESS EKLEME
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setBounds(13, 459,1165, 24);
				getContentPane().add(progressBar);
				
				timer = new Timer (100, new ActionListener() {
					private int x=0;
					public void actionPerformed(ActionEvent arg0) {
						
						progressBar.setValue(x+=10);
						if (x==100) {
							timer.stop();
							x=0;
							siteProgramhakkinda frame = new siteProgramhakkinda();
							frame.show();
							frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR	
							progressBar.hide();
							
							sitesikayetbuton.setEnabled(true);
						    siteortakcaributon.setEnabled(true);
						    siteblokbolumbuton.setEnabled(true);
						    kullanicibuton.setEnabled(true);
						    sitepersonelbuton.setEnabled(true);
						    sitetanimbuton.setEnabled(true);
						    cikisbuton.setEnabled(true);
						    yardimbuton.setEnabled(true);
						    loganabuton.setEnabled(true);
						    siteajandabuton.setEnabled(true);
						    hakkimizdabuton.setEnabled(true);
						}
						}
				});

				//PROGRESS EKLEME
				timer.start();
				
				//
				
			}
		});
		hakkimizdabuton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Image  img8=new ImageIcon(this.getClass().getResource("/hakkimizda64pix.png")).getImage();
		hakkimizdabuton.setIcon(new ImageIcon(img8));
		hakkimizdabuton.setBounds(888, 122, 289, 100);
		contentPane.add(hakkimizdabuton);
		



	}
}
