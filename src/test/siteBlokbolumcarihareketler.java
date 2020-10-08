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


public class siteBlokbolumcarihareketler extends JDialog {

	private JPanel contentPane;
	private JTextField textdaireno;
	private JTable table;

	
	public static int id=0;
	public static int id_sakla=0;
	
	public static String id_al;
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"Bolum Adi","Borc Tutari ","Alinacak Tutar","Aciklama","id"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[5]; //SATIR TANIMLAMA
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteBlokbolumcarihareketler frame = new siteBlokbolumcarihareketler();
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
	public siteBlokbolumcarihareketler() {
		setModal(true);
		setResizable(false);
		setTitle("Site Blok Bolum Cari Hareketleri");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1126, 491);
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
		lblNewLabel.setBounds(10, 45, 256, 388);
		Image  img=new ImageIcon(this.getClass().getResource("/Money-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Site Blok Bolum Cari Hareketleri");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 295, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnara = new JButton("Ara");
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					textdaireno.setText("");
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					textdaireno.requestFocus();
				} catch (Exception e2) {
					System.out.println(e2);
					// TODO: handle exception
				}
			}
		});
		btnara.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnara.setBounds(979, 320, 110, 30);
		contentPane.add(btnara);
		
		textdaireno = new JTextField();
		textdaireno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				///HER KELIMEYLE ARAMA
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelim);
			    table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textdaireno.getText()));
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				///


			}
		});
		textdaireno.setBounds(277, 320, 603, 30);
		contentPane.add(textdaireno);
		textdaireno.setColumns(10);
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString());
					siteBlokbolumcarihareketekle frame = new siteBlokbolumcarihareketekle();
					frame.show();
					frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
					//dispose();
				}catch(Exception hata)
				{
				 	JOptionPane.showMessageDialog(null,"1 satýr seçiniz");
					System.err.println(hata);
				}
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(404, 358, 110, 75);
		contentPane.add(btnduzenle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					int id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString());
					String ad=table.getValueAt(table.getSelectedRow(),0).toString();
	
					siteBaglanti baglan = new siteBaglanti();
					baglan.yap();
					String sorgu="delete from sitebolumcarihareket where Bolumcarihareketid='"+id+"'";
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
						int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
						}
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSil.setBounds(530, 358, 110, 75);
		contentPane.add(btnSil);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_al=siteBlokbolumbilgi.id3;
				System.out.println("ALINAN BLOK BOLUM NO: "+id_al);
				siteBlokbolumcarihareketekle frame = new siteBlokbolumcarihareketekle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				//dispose();
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(276, 358, 110, 75);
		contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(979, 358, 110, 75);
		contentPane.add(btnvazgec);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 45, 813, 253);
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
				siteBlokbolumcarirapor_cagir rapor = new siteBlokbolumcarirapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),4).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRapor.setBounds(650, 358, 110, 75);
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
		btnSil_1_1.setBounds(770, 358, 110, 75);
		contentPane.add(btnSil_1_1);
		modelim.setColumnIdentifiers(kolonlar);

		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			 
				id_al=siteBlokbolumbilgi.id3;
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();
				modelim.setRowCount(0);
				String listele = "select * from sitebolumcarihareket where Blokbolumadi='"+id_al+"'"; //YALNIZCA ONCEKI SECILEN BLOKBOLUMDEKI SAKINLER LISTELENIYOR
				ResultSet rs=null;
				try {
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					while(rs.next())
					{
						satirlar[0]=rs.getString("Blokbolumadi");
						satirlar[1]=rs.getString("Bolumcarihareketborctutari");
						satirlar[2]=rs.getString("Bolumcarihareketalacaktutari");
						satirlar[3]=rs.getString("Aciklama");
						satirlar[4]=rs.getString("Bolumcarihareketid");
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
