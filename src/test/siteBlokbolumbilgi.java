package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;

public class siteBlokbolumbilgi extends JDialog {

	private JPanel contentPane;
	private JTextField aramak;
	private JTable table;

	public static int id=0;
	public static int id_sakla=0;
	
	public static String id3,id_al;
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"Bolum Sahibi","Blok Adi","Bolum Adi","Aktiflik","Telefon","id"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[6]; //SATIR TANIMLAMA
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteBlokbolumbilgi frame = new siteBlokbolumbilgi();
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
	public siteBlokbolumbilgi() {
		setModal(true);
		setResizable(false);
		setTitle("Site Blok Bolum Bilgi Ekrani");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1116, 530);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 42, 204, 436);
		Image  img=new ImageIcon(this.getClass().getResource("/apartment-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Site Blok Bolum (Daire veya Dukkan) Bilgi Ekrani");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 452, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnara = new JButton("Ara");
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					aramak.setText("");
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					aramak.requestFocus();
				} catch (Exception e2) {
					System.out.println(e2);
					// TODO: handle exception
				}
			}
		});
		btnara.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnara.setBounds(947, 316, 130, 30);
		contentPane.add(btnara);
		
		aramak = new JTextField();
		aramak.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				///HER KELIMEYLE ARAMA
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelim);
			    table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(aramak.getText()));
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				///
			}
		});
		aramak.setBounds(224, 316, 713, 30);
		contentPane.add(aramak);
		aramak.setColumns(10);
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (siteBaglanti.logkullaniciyetkisi.equals("SEKRETER"))) {//KULLANICI YETKI KONTROLU

				try {
					id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString());
					siteBlokbolumbilgiekleduzenle frame = new siteBlokbolumbilgiekleduzenle();
					frame.show();
					frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
					//dispose();
				}catch(Exception hata)
				{
				 	JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
					System.err.println(hata);
				}}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(374, 357, 140, 30);
		contentPane.add(btnduzenle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					int id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString());
					String ad=table.getValueAt(table.getSelectedRow(),0).toString();
	
					siteBaglanti baglan = new siteBaglanti();
					baglan.yap();
					String sorgu="delete from sitebolumbilgi where BolumId='"+id+"'";
					int selectedOption = JOptionPane.showConfirmDialog(null,ad+" Silmek istiyor musunuz?","SÝL",JOptionPane.YES_NO_OPTION); 
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
				}
				 catch(Exception hata)
					{
					 	JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
						System.err.println(hata);
					}}else {
						//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
						Object [] noSaveOption = {"Tamam"};
						int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
						}
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSil.setBounds(524, 357, 140, 30);
		contentPane.add(btnSil);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (siteBaglanti.logkullaniciyetkisi.equals("SEKRETER"))) {//KULLANICI YETKI KONTROLU

				id_al=siteBlokbilgi.id2;
				siteBlokbolumbilgiekleduzenle frame = new siteBlokbolumbilgiekleduzenle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				//dispose();
				}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(224, 357, 140, 30);
		contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(947, 398, 130, 80);
		contentPane.add(btnvazgec);
		
		JButton btnZiyaretciGirisi = new JButton("Ziyaretci Girisi");
		btnZiyaretciGirisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (siteBaglanti.logkullaniciyetkisi.equals("GUVENLIK"))) {//KULLANICI YETKI KONTROLU


				if (table.getRowCount()>0) {
				id3=table.getValueAt(table.getSelectedRow(),2).toString();//BLOKBOLUMADI ALIYOR
				if (id3.equals(null)){System.out.println("Secim yapmadiniz");} else {
				siteBlokbolumziyaretcigirisi frame = new siteBlokbolumziyaretcigirisi();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}}
				}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}}
		});
		btnZiyaretciGirisi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnZiyaretciGirisi.setBounds(224, 398, 140, 80);
		contentPane.add(btnZiyaretciGirisi);
		
		JButton btnCariHareketler = new JButton("Cari Hareketler");
		btnCariHareketler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (siteBaglanti.logkullaniciyetkisi.equals("SEKRETER"))) {//KULLANICI YETKI KONTROLU

				if (table.getRowCount()>0) {
				id3=table.getValueAt(table.getSelectedRow(),2).toString();//BLOKBOLUMADI ALIYOR
				if (id3.equals(null)){System.out.println("Secim yapmadiniz");} else {
				siteBlokbolumcarihareketler frame = new siteBlokbolumcarihareketler();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}}}else {
				//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
				Object [] noSaveOption = {"Tamam"};
				int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Hukuk Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}}

		});
		btnCariHareketler.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCariHareketler.setBounds(374, 398, 140, 80);
		contentPane.add(btnCariHareketler);
		
		JButton btnBolumSakinBilgisi = new JButton("Sakin Bilgisi");
		btnBolumSakinBilgisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount()>0) {
				id3=table.getValueAt(table.getSelectedRow(),2).toString();//BLOKBOLUMADI ALIYOR
				if (id3.equals(null)){System.out.println("Secim yapmadiniz");} else {
				siteBlokbolumsakinbilgisi frame = new siteBlokbolumsakinbilgisi();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}}}
		});
		btnBolumSakinBilgisi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBolumSakinBilgisi.setBounds(524, 398, 140, 80);
		contentPane.add(btnBolumSakinBilgisi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(224, 41, 853, 264);
		contentPane.add(scrollPane);
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//RAPOR ALMA ISLEMI
				siteBlokbolumbilgianarapor_cagir rapor = new siteBlokbolumbilgianarapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),5).toString());
				
				//RAPOR ALMA ISLEMI
	
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRapor.setBounds(674, 357, 130, 30);
		contentPane.add(btnRapor);
		
		JButton btnvazgec_1_1 = new JButton("Yardim");
		btnvazgec_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				
			}
		});
		btnvazgec_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Image  img5=new ImageIcon(this.getClass().getResource("/yardim12pix.png")).getImage();
		btnvazgec_1_1.setIcon(new ImageIcon(img5));
		btnvazgec_1_1.setBounds(674, 398, 130, 80);
		contentPane.add(btnvazgec_1_1);
		modelim.setColumnIdentifiers(kolonlar);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				id_al=siteBlokbilgi.id2;
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();
				modelim.setRowCount(0);
				String listele = "select * from sitebolumbilgi where Blokadi='"+id_al+"'"; //YALNIZCA ONCEKI SECILEN BLOKTAKI BOLUMLER LISTELENIYOR
				ResultSet rs=null;
				try {
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					while(rs.next())
					{
						satirlar[0]=rs.getString("Bolumsahibi");
						satirlar[1]=rs.getString("Blokadi");
						satirlar[2]=rs.getString("Blokbolumadi");
						satirlar[3]=rs.getString("Bolumaktiflik");
						satirlar[4]=rs.getString("Bolumsahibitelefon");
						satirlar[5]=rs.getString("BolumId");
						modelim.addRow(satirlar);
					}
					table.setModel(modelim);
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					//final TableColumn column = table.getColumnModel().getColumn(5);
					// column.setMinWidth(0);
	                // column.setMaxWidth(0);
	                // column.setWidth(0);
	                // column.setPreferredWidth(0);
	                // column.setResizable(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
