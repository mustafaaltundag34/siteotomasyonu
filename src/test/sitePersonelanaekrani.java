package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDialog;

public class sitePersonelanaekrani extends JDialog {

	private JPanel contentPane;
	private JTextField textisim;
	private JTable table;
	
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	
	public static int id=0;
	public static int sakla_id=0;
	
	static Connection myconn1;
	static Statement mystat1;
	
	public static String id3,id_al,isimal;
	
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolonlar= {"AdSoyad","TC","Telefon","Eposta","ID"};
	Object[] satirlar=new Object[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sitePersonelanaekrani frame = new sitePersonelanaekrani();
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
	public sitePersonelanaekrani() {
		setModal(true);
		setTitle("Site Personel Ana Ekrani");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1183, 499);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e) {
			System.out.println("pencere acildi");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("pencere kapatildi");
			}
			
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
				
				modelim.setRowCount(0);
				ResultSet rs1=null;
				
				try {
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					System.out.println("baglantý saglandi");
					String listele="Select * From sitepersonelbilgi order by Personeltcno asc";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					System.out.println("listeleme basarili");
					while(rs1.next()) {
						satirlar[0]=rs1.getString("Personeladsoyad");
						satirlar[1]=rs1.getString("Personeltcno");
						satirlar[2]=rs1.getString("Personeltelefonno");
						satirlar[3]=rs1.getString("Personelepostaadresi");
						satirlar[4]=rs1.getString("PersonelID");
						modelim.addRow(satirlar);
					
					}
					table.setModel(modelim);
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 43, 231, 399);
		Image  img=new ImageIcon(this.getClass().getResource("/Groups-Meeting-Light-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Site Personel Ana Ekrani");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 351, 27);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 43, 902, 253);
		contentPane.add(scrollPane);
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		modelim.setColumnIdentifiers(kolonlar);
		
		textisim = new JTextField();
		textisim.setBounds(251, 307, 765, 30);
		contentPane.add(textisim);
		textisim.setColumns(10);
		
		JButton btnara = new JButton("Ara");
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				ResultSet rs1=null;
				String isim=textisim.getText();
				String ara="Select * From sitepersonelbilgi where Personeladsoyad like ?";
				try {
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					preparedStatement=myconn1.prepareStatement(ara);
					preparedStatement.setString(1, "%"+isim+"%");
					rs1=preparedStatement.executeQuery();
					System.out.println("listeleme basarili");
					while(rs1.next()) {
						satirlar[0]=rs1.getString("Personeladsoyad");
						satirlar[1]=rs1.getString("Personeltcno");
						satirlar[2]=rs1.getString("Personeltelefonno");
						satirlar[3]=rs1.getString("Personelepostaadresi");
						satirlar[4]=rs1.getString("PersonelID");
						modelim.addRow(satirlar);
				}
					table.setModel(modelim);
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					//final TableColumn column=table.getColumnModel().getColumn(4);
					// column.setMinWidth(0);
	                // column.setMaxWidth(0);
	                // column.setWidth(0);
	                // column.setPreferredWidth(0);
	                // column.setResizable(false);
	                 textisim.setText("");
				
			}catch(Exception hata) {
				System.err.println(hata);
			}
			}
		});
		btnara.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnara.setBounds(1045, 307, 110, 30);
		contentPane.add(btnara);
		
		
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					id=Integer.parseInt(table.getValueAt(table.getSelectedRow(),4).toString());
					sitePersonelekleduzenle frame=new sitePersonelekleduzenle();
					frame.show();
					frame.setLocationRelativeTo(null);
					//dispose();
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Lütfen 1 satýr seciniz");
					e1.printStackTrace();
				}}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}
			}
			
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(362, 346, 101, 96);
		contentPane.add(btnduzenle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					String tut_id=table.getValueAt(table.getSelectedRow(), 4).toString();
					String tut_ad=table.getValueAt(table.getSelectedRow(), 0).toString();
					int selectedOption = JOptionPane.showConfirmDialog(null,tut_ad+" Silmek istiyor musunuz?","SÝL",JOptionPane.YES_NO_OPTION); 
					if(selectedOption==JOptionPane.YES_OPTION) {
						try {
							myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
							Statement statement=myconn1.createStatement();
							String sil="Delete from sitepersonelbilgi where PersonelID='"+tut_id+"'";
							statement.executeUpdate(sil);
							JOptionPane.showMessageDialog(null, tut_ad+"silindi");
						}catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
		            
				}catch(Exception hata) {
					JOptionPane.showMessageDialog(null, "Lütfen 1 satýr seciniz");
					System.err.println(hata);
				}}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSil.setBounds(473, 346, 101, 96);
		contentPane.add(btnSil);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				sitePersonelekleduzenle frame = new sitePersonelekleduzenle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}else {
				//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
				Object [] noSaveOption = {"Tamam"};
				int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(251, 346, 101, 96);
		contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(1045, 346, 110, 96);
		contentPane.add(btnvazgec);
		
		JButton btnCariHareketler = new JButton("Cari Hareketler");
		btnCariHareketler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (siteBaglanti.logkullaniciyetkisi.equals("SEKRETER"))) {//KULLANICI YETKI KONTROLU

				if (table.getRowCount()>0) {
				id3=table.getValueAt(table.getSelectedRow(),1).toString();//BLOKBOLUMADI ALIYOR
				isimal=table.getValueAt(table.getSelectedRow(),0).toString();//BLOKBOLUMADI ALIYOR
				System.out.println(id3 + " " + isimal);
				sitePersonelcarihareket frame = new sitePersonelcarihareket();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}}else {
				//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
				Object [] noSaveOption = {"Tamam"};
				int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}}
		});
		btnCariHareketler.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCariHareketler.setBounds(584, 346, 140, 96);
		contentPane.add(btnCariHareketler);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (siteBaglanti.logkullaniciyetkisi.equals("SEKRETER"))) {//KULLANICI YETKI KONTROLU

				//RAPOR ALMA ISLEMI
				sitePersonelanarapor_cagir rapor = new sitePersonelanarapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),4).toString());
				
				//RAPOR ALMA ISLEMI
				}else {
				//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
				Object [] noSaveOption = {"Tamam"};
				int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRapor.setBounds(734, 346, 139, 96);
		contentPane.add(btnRapor);
		
		JButton btnSil_1_1 = new JButton("Yardim");
		btnSil_1_1.addActionListener(new ActionListener() {
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
		btnSil_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Image  img5=new ImageIcon(this.getClass().getResource("/yardim12pix.png")).getImage();
		btnSil_1_1.setIcon(new ImageIcon(img5));
		
		btnSil_1_1.setBounds(883, 346, 133, 96);
		contentPane.add(btnSil_1_1);
		
		
	}
}
