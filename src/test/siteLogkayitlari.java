package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class siteLogkayitlari extends JDialog {

	private JPanel contentPane;
	private JTable table;
	static Connection myconn1;
	static Statement mystat1;
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	
	Object [] kolonlar = {"logkullaniciadi","logkullaniciyetkisi","logdatetime","logaksiyon","logsunucuparametre"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[5]; //SATIR TANIMLAMA

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteLogkayitlari frame = new siteLogkayitlari();
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
	public siteLogkayitlari() {
		setResizable(false);
		setModal(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				siteAnaMenu.sitesikayetbuton.setEnabled(true);
				siteAnaMenu.siteortakcaributon.setEnabled(true);
				siteAnaMenu.siteblokbolumbuton.setEnabled(true);
				siteAnaMenu.kullanicibuton.setEnabled(true);
				siteAnaMenu.sitepersonelbuton.setEnabled(true);
				siteAnaMenu.sitetanimbuton.setEnabled(true);
				siteAnaMenu.cikisbuton.setEnabled(true);
				siteAnaMenu.yardimbuton.setEnabled(true);
				siteAnaMenu.loganabuton.setEnabled(true);
				siteAnaMenu.siteajandabuton.setEnabled(true);
				siteAnaMenu.hakkimizdabuton.setEnabled(true);
				
				//LOG LISTELEME
				modelim.setRowCount(0);//TABLOYU TEMIZLIYOR
				//
		 		ResultSet rs1 = null;
				try {
					System.out.println(siteBaglanti.sunucuparametresi);
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					System.out.println("Baðlantý Saðlandý");

					String query1="Select * From sitelog ORDER BY logid DESC";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(query1);
					System.out.println("Listeleme Basarili");
				}catch(Exception hata)
				{
				System.err.println(hata);
				}
				//
				
				try {
				while(rs1.next()) {
					satirlar[0]=rs1.getString("logkullaniciadi");
					satirlar[1]=rs1.getString("logkullaniciyetkisi");
					satirlar[2]=rs1.getString("logdatetime");
					satirlar[3]=rs1.getString("logaksiyon");
					satirlar[4]=rs1.getString("logsunucuparametre");
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
				//LOG LISTELEME
			}
		});
		setTitle("Log Kayitlari");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1015, 428);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 56, 825, 255);
		contentPane.add(scrollPane);
		
		//LISTELEME
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setEnabled(false);
		modelim.setColumnIdentifiers(kolonlar);
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};
		
		};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		//LISTELEME
		
		JButton btnNewButton = new JButton("Kapat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(812, 322, 172, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Yenile");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LOG LISTELEME
				
				modelim.setRowCount(0);//TABLOYU TEMIZLIYOR
				//
		 		ResultSet rs1 = null;
				try {
					System.out.println(siteBaglanti.sunucuparametresi);
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					System.out.println("Baðlantý Saðlandý");

					String query1="Select * From sitelog ORDER BY logid DESC";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(query1);
					System.out.println("Listeleme Basarili");
				}catch(Exception hata)
				{
				System.err.println(hata);
				}
				//
				
				try {
				while(rs1.next()) {
					satirlar[0]=rs1.getString("logkullaniciadi");
					satirlar[1]=rs1.getString("logkullaniciyetkisi");
					satirlar[2]=rs1.getString("logdatetime");
					satirlar[3]=rs1.getString("logaksiyon");
					satirlar[4]=rs1.getString("logsunucuparametre");
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
				//LOG LISTELEME
				
			}
		});
		btnNewButton_1.setBounds(159, 322, 186, 54);
		contentPane.add(btnNewButton_1);
		
		JLabel lblmuvekkil = new JLabel("");
		lblmuvekkil.setHorizontalAlignment(SwingConstants.CENTER);
		lblmuvekkil.setOpaque(true);
		lblmuvekkil.setBackground(Color.WHITE);
		Image  img=new ImageIcon(this.getClass().getResource("/key-icon.png")).getImage();
		lblmuvekkil.setIcon(new ImageIcon(img));
		lblmuvekkil.setBounds(10, 56, 143, 320);
		contentPane.add(lblmuvekkil);
		
		JLabel lblLogGirisCikis = new JLabel("Log Giris Cikis Kayitlari Ekrani");
		lblLogGirisCikis.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblLogGirisCikis.setBounds(10, 11, 306, 26);
		contentPane.add(lblLogGirisCikis);
		
		JButton btnKullaniciLoglari = new JButton("Kullanici Islem Loglari");
		btnKullaniciLoglari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				siteLogkullanicikayitlari frame = new siteLogkullanicikayitlari();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR	
			}
		});
		btnKullaniciLoglari.setFont(new Font("Tahoma", Font.BOLD, 18));
		Image  img7=new ImageIcon(this.getClass().getResource("/arama32pix.png")).getImage();
		btnKullaniciLoglari.setIcon(new ImageIcon(img7));
		btnKullaniciLoglari.setBounds(355, 322, 443, 54);
		contentPane.add(btnKullaniciLoglari);
		

	}
}
