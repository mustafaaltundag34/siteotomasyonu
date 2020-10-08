package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class siteKullanicikayit extends JDialog {

	private JPanel contentPane;
	private JTable table1;
	public static String secilenkullanici;
	public static int id=0;
	public static int id_sakla=0;
	
//1- JFRAME AC 2- SCROOL PANE CIZ 3- JTABLE CIZ 4- DEFAULTTABLEMODEL TANIMLA 5- KOLON VE SATIRLARI TANIMLA
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	
	Object [] kolonlar = {"Kullanici Adi","Aciklama","Yetkisi","kullaniciid"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[4]; //SATIR TANIMLAMA
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteKullanicikayit frame = new siteKullanicikayit();
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
	public siteKullanicikayit() {
		setModal(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("Pencere Acildi");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("Pencere kapandi");
			}
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
				
				modelim.setRowCount(0);//TABLOYU TEMIZLIYOR
				ResultSet rs1=siteBaglanti.kullanicilistele(); //BAGLANTI CLASINDAN KULLANICILISTELE CALISIYOR
				try {
				while(rs1.next()) {
					satirlar[0]=rs1.getString("kullaniciadi");
					satirlar[1]=rs1.getString("aciklama");
					satirlar[2]=rs1.getString("yetki");
					satirlar[3]=rs1.getString("kullaniciid");
					modelim.addRow(satirlar);
				}		
				}catch(SQLException hata)
				{
					System.err.println(hata);
					}
				table1.setModel(modelim);
				table1.updateUI();
				System.out.println("TOPLAM KAYIT: "+table1.getRowCount());
				if (table1.getRowCount()>0) {table1.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				
			}
		});
		setTitle("Kullanici Kayitlari Ekrani");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1069, 469);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 52, 765, 285);
		contentPane.add(scrollPane);
		
		table1 = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table1);
		table1.setBounds(110, 112, 565, 197);
		modelim.setColumnIdentifiers(kolonlar);

		
		JButton btnNewButton = new JButton("Guncelle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			modelim.setRowCount(0);//TABLOYU TEMIZLIYOR
				ResultSet rs1=siteBaglanti.kullanicilistele(); //BAGLANTI CLASINDAN KULLANICILISTELE CALISIYOR
				try {
				while(rs1.next()) {
					satirlar[0]=rs1.getString("kullaniciadi");
					satirlar[1]=rs1.getString("aciklama");
					satirlar[2]=rs1.getString("yetki");
					satirlar[3]=rs1.getString("kullaniciid");
					modelim.addRow(satirlar);
				}		
				}catch(SQLException hata)
				{
					System.err.println(hata);
					}
				table1.setModel(modelim);
				if (table1.getRowCount()>0) {table1.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}

			}
		});
		btnNewButton.setBounds(570, 348, 140, 66);
		contentPane.add(btnNewButton);
		
		JButton btnYeniKayit = new JButton("Yeni Kayit");
		btnYeniKayit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnYeniKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				
				siteKullanicikayitdetay frame = new siteKullanicikayitdetay();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				}
				else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}
			}
		});
		btnYeniKayit.setBounds(270, 348, 140, 66);
		contentPane.add(btnYeniKayit);
		
		JButton btnKapat = new JButton("Kapat");
		btnKapat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnKapat.setBounds(870, 348, 165, 66);
		contentPane.add(btnKapat);
	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/User-Group-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(10, 52, 250, 362);
		contentPane.add(lblNewLabel);
		
		JLabel lblKullaniciListesi = new JLabel("Kullanici Kayitlari Ekrani");
		lblKullaniciListesi.setHorizontalAlignment(SwingConstants.LEFT);
		lblKullaniciListesi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblKullaniciListesi.setBounds(10, 11, 392, 26);
		contentPane.add(lblKullaniciListesi);
		
		JButton btnDegistir = new JButton("Degistir");
		btnDegistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				secilenkullanici=table1.getValueAt(table1.getSelectedRow(),0).toString();
				if (secilenkullanici.equals(siteBaglanti.logkullaniciadi)) {
				 try {
					 id = Integer.parseInt(table1.getValueAt(table1.getSelectedRow(),3).toString());
					 
						System.out.println(id);
						siteKullanicikayitdetay frame = new siteKullanicikayitdetay();
						frame.show();
						frame.setLocationRelativeTo(null);}	//FORMU MERKEZE ALIYOR
						//dispose();
						 
				 catch(Exception hata)
					{
					 JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						System.err.println(hata);
					}}		else {
						//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
						Object [] noSaveOption = {"Tamam"};
						int noSave = JOptionPane.showOptionDialog(null,"Yalnizca Kendi Kullanicinizi degistirebilirsiniz!..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}
			}
		});
		btnDegistir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDegistir.setBounds(420, 348, 140, 66);
		contentPane.add(btnDegistir);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				secilenkullanici=table1.getValueAt(table1.getSelectedRow(),0).toString();
				if ( (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) && (!secilenkullanici.equals(siteBaglanti.logkullaniciadi))) {//KULLANICI YETKI KONTROLU
										
				try {
					int id=Integer.parseInt(table1.getValueAt(table1.getSelectedRow(), 3).toString());
					System.out.println("SECILEN Kullanici= "+ id);
					String ad=table1.getValueAt(table1.getSelectedRow(),0).toString();
	
					siteBaglanti baglan = new siteBaglanti();
					baglan.yap();
					String sorgu="delete from  sitekullanicibilgi where 	kullaniciid='"+id+"'";
					int selectedOption = JOptionPane.showConfirmDialog(null,ad+" Silmek istiyor musunuz?","SIL",JOptionPane.YES_NO_OPTION); 
					if (selectedOption == JOptionPane.YES_OPTION)
					{
						
						try {
								Statement statement = baglan.myconn1.createStatement();
								statement.executeUpdate(sorgu);
							JOptionPane.showMessageDialog(null,ad+" silindi");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}
					}
				}catch(Exception hata)
					{
					 	JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						System.err.println(hata);
					}}		else {
						//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Hukuk Burosu CMF", JOptionPane.PLAIN_MESSAGE);
						Object [] noSaveOption = {"Tamam"};
						int noSave = JOptionPane.showOptionDialog(null,"Yonetici olmalisiniz ve kendi kullanicinizi silmemelisiniz!..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}
				
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSil.setBounds(720, 348, 140, 66);
		contentPane.add(btnSil);
	}
}
