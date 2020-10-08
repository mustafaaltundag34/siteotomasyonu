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
import javax.swing.RowFilter;

import com.mysql.cj.protocol.Resultset;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class siteBlokbolumziyaretcigirisi extends JDialog {

	private JPanel contentPane;
	private JTextField textisim;
	private JTable table;
	
	private PreparedStatement preparedStatement=null;
	private Statement statement=null;
	
	public static int id=0;
	public static int sakla_id=0;
	
	static Connection myconn1;
	static Statement mystat1;
	public static String id_al;
	
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolonlar= {"AdSoyad","Giris Zamaný","BlokAdi","Ziyaretciid"};
	Object[] satirlar=new Object[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteBlokbolumziyaretcigirisi frame = new siteBlokbolumziyaretcigirisi();
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
	public siteBlokbolumziyaretcigirisi() {
		setModal(true);
		setResizable(false);
		setTitle("Site Blok Bolum Ziyaretci Ekrani");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1114, 498);
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
		lblNewLabel.setBounds(10, 52, 228, 392);
		Image  img=new ImageIcon(this.getClass().getResource("/11874-family-man-woman-girl-boy-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Site Blok Bolum Ziyaretci Ekrani");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 302, 31);
		contentPane.add(lblNewLabel_1);
		
		textisim = new JTextField();
		textisim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				///HER KELIMEYLE ARAMA
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelim);
			    table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textisim.getText()));
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				///

			}
		});
		textisim.setBounds(248, 314, 593, 30);
		contentPane.add(textisim);
		textisim.setColumns(10);

		
		
		addWindowListener(new WindowAdapter(){
			public void windowActivated(WindowEvent e) {
				
				id_al=siteBlokbolumbilgi.id3;
				modelim.setRowCount(0);
				
				ResultSet rs1=null;
				try {
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
				    mystat1=myconn1.createStatement();
				    String listele="select * from sitebolumziyaretci where Blokbolumadi='"+id_al+"'"; //YALNIZCA ONCEKI SECILEN BLOKBOLUMDEKI SAKINLER LISTELENIYOR
					rs1=mystat1.executeQuery(listele);
					System.out.println("listeleme basarili");
					while(rs1.next()) {
						satirlar[0]=rs1.getString("Ziyaretciadsoyad");
						satirlar[1]=rs1.getString("Ziyaretcigiriszamani");
						satirlar[2]=rs1.getString("Blokbolumadi");
						satirlar[3]=rs1.getString("Ziyaretciid");
						modelim.addRow(satirlar);
				}table.setModel(modelim);
				System.out.println("TOPLAM KAYIT: "+table.getRowCount());
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		

		
		JButton btnara = new JButton("Ara");
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					textisim.setText("");
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					textisim.requestFocus();
				} catch (Exception e2) {
					System.out.println(e2);
					// TODO: handle exception
				}
				
			}
		});
		btnara.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnara.setBounds(969, 314, 110, 30);
		contentPane.add(btnara);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 52, 831, 253);
		contentPane.add(scrollPane);
		
		table = new JTable() {// TABLODA OYNAMA YAPTIRMIYORUZ
		public boolean isCellEditable(int row, int column) {// TABLODA OYNAMA YAPTIRMIYORUZ
			return false;// TABLODA OYNAMA YAPTIRMIYORUZ
		};};// TABLODA OYNAMA YAPTIRMIYORUZ
		scrollPane.setViewportView(table);
		modelim.setColumnIdentifiers(kolonlar);
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 3).toString());
					System.out.println(id);

					siteBlokbolumziyaretciekleduzenle frame=new siteBlokbolumziyaretciekleduzenle();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					//dispose();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Lütfen gecerli bir satýr giriniz");
					e1.printStackTrace();
				}
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(364, 350, 110, 94);
		contentPane.add(btnduzenle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					String tut_id=table.getValueAt(table.getSelectedRow(), 3).toString();
					String tut_ad=table.getValueAt(table.getSelectedRow(), 0).toString();
					int selectedOption=JOptionPane.showConfirmDialog(null, tut_ad+"Silmek istiyor musunuz?","Sil",JOptionPane.YES_NO_OPTION);
					try {
						if (selectedOption == JOptionPane.YES_OPTION)
						{
							myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
							Statement statement=myconn1.createStatement();
							String sil="delete from sitebolumziyaretci where Ziyaretciid='"+tut_id+"'";
							statement.executeUpdate(sil);
							JOptionPane.showMessageDialog(null, tut_ad+"silindi");
						}
						
					}catch(SQLException e1) {
						
						e1.printStackTrace();
					}
				}catch(Exception hata) {
					JOptionPane.showMessageDialog(null, "Lütfen bir satýr seciniz");
					System.err.println(hata);
				}}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}

			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSil.setBounds(490, 350, 110, 94);
		contentPane.add(btnSil);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_al=siteBlokbolumbilgi.id3;
				siteBlokbolumziyaretciekleduzenle frame = new siteBlokbolumziyaretciekleduzenle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				//dispose();
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(248, 350, 110, 94);
		contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(969, 350, 110, 94);
		contentPane.add(btnvazgec);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//RAPOR ALMA ISLEMI
				siteBlokbolumziyaretcirapor_cagir rapor = new siteBlokbolumziyaretcirapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),3).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRapor.setBounds(611, 350, 110, 94);
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
		btnSil_1_1.setBounds(731, 350, 110, 94);
		contentPane.add(btnSil_1_1);
		
		
	}
}
