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

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;


public class siteBlokbilgi extends JDialog {

	private JPanel contentPane;
	private JTextField textblokno;
	private JTable table;

	public static int id=0;
	public static int id_sakla=0;
	
	public static String id1;
	public static String id2;
	
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"Blok Adý","Dis Kapý No","Sorumlu","Blok Aciklama","id"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[5]; //SATIR TANIMLAMA
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteBlokbilgi frame = new siteBlokbilgi();
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
	public siteBlokbilgi() {
		setModal(true);
		setResizable(false);
		setTitle("Site Blok Bilgi Ana Ekrani");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1192, 465);
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
		lblNewLabel.setBounds(10, 42, 222, 369);
		Image  img=new ImageIcon(this.getClass().getResource("/apartment-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Site Blok Bilgi Ana Ekrani");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 313, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnara = new JButton("Ara");
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					textblokno.setText("");
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					textblokno.requestFocus();
				} catch (Exception e2) {
					System.out.println(e2);
					// TODO: handle exception
				}

			}
		});
		btnara.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnara.setBounds(1053, 308, 100, 30);
		contentPane.add(btnara);
		//Textbox'a yazdýgýnda otomatik arama yapma (DÝNAMÝK OLARAK) bütün alanlarda arama yapar
		textblokno = new JTextField();
		textblokno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				///HER KELIMEYLE ARAMA
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelim);
			    table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textblokno.getText()));
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				///

			}
		});
		textblokno.setBounds(242, 308, 801, 30);
		contentPane.add(textblokno);
		textblokno.setColumns(10);
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (siteBaglanti.logkullaniciyetkisi.equals("SEKRETER"))) {//KULLANICI YETKI KONTROLU

				try {
					id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString());
					siteBlokbilgiekleduzenle frame = new siteBlokbilgiekleduzenle();
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
				int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI,SEKRETER yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
				}
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(361, 349, 110, 62);
		contentPane.add(btnduzenle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					int id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString());
					System.out.println("SECILEN BLOK ID= "+ id);
					String ad=table.getValueAt(table.getSelectedRow(),0).toString();
	
					siteBaglanti baglan = new siteBaglanti();
					baglan.yap();
					String sorgu="delete from  siteblokbilgi where 	BlokID='"+id+"'";
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
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSil.setBounds(481, 349, 119, 62);
		contentPane.add(btnSil);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (siteBaglanti.logkullaniciyetkisi.equals("SEKRETER"))) {//KULLANICI YETKI KONTROLU
				siteBlokbilgiekleduzenle frame = new siteBlokbilgiekleduzenle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				//dispose();
				}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI,SEKRETER yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(242, 349, 109, 62);
		contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(1053, 349, 100, 62);
		contentPane.add(btnvazgec);
		
		JButton btnSiteBolumBilgi = new JButton("Bolum Bilgi");
		btnSiteBolumBilgi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				id2=table.getValueAt(table.getSelectedRow(),0).toString();
				if (id2.equals(null)){System.out.println("Secim yapmadiniz");} else {
				siteBlokbolumbilgi frame = new siteBlokbolumbilgi();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				}}
		});
		btnSiteBolumBilgi.setFont(new Font("Tahoma", Font.BOLD, 14));
		Image  img9=new ImageIcon(this.getClass().getResource("/house24pix.png")).getImage();
		btnSiteBolumBilgi.setIcon(new ImageIcon(img9));
		btnSiteBolumBilgi.setBounds(751, 349, 145, 62);
		contentPane.add(btnSiteBolumBilgi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 42, 911, 255);
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
				siteBlokbilgianarapor_cagir rapor = new siteBlokbilgianarapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),4).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRapor.setBounds(610, 349, 131, 62);
		contentPane.add(btnRapor);
		
		JButton btnYardim = new JButton("Yardim");
		btnYardim.addActionListener(new ActionListener() {
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
		btnYardim.setFont(new Font("Tahoma", Font.BOLD, 14));
		Image  img5=new ImageIcon(this.getClass().getResource("/yardim12pix.png")).getImage();
		btnYardim.setIcon(new ImageIcon(img5));
		btnYardim.setBounds(906, 349, 137, 62);
		contentPane.add(btnYardim);
		modelim.setColumnIdentifiers(kolonlar);

		
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
				
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();
				modelim.setRowCount(0);
				String listele = "select * from siteblokbilgi";
				ResultSet rs=null;
				try {
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					while(rs.next())
					{
						satirlar[0]=rs.getString("Blokadi");
						satirlar[1]=rs.getString("Blokdiskapino");
						satirlar[2]=rs.getString("Bloksorumlusu");
						satirlar[3]=rs.getString("Blokaciklama");
						satirlar[4]=rs.getString("BlokID");
						modelim.addRow(satirlar);
					}
					table.setModel(modelim);
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					//final TableColumn column = table.getColumnModel().getColumn(4);
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
