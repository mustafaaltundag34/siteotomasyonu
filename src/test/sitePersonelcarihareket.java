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

public class sitePersonelcarihareket extends JDialog {

	private JPanel contentPane;
	private JTextField textisim;
	private JTable table;
	
	private PreparedStatement preparedStatement=null;
	private Statement statement=null;
	
	static Connection myconn1;
	static Statement mystat1;
	
	
	public static int id=0;
	public static int id_sakla=0;
	public static String id_al,isimal;
	
	
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolonlar= {"TC","AdSoyad","Aciklama","ID"};
	Object[] satirlar=new Object[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sitePersonelcarihareket frame = new sitePersonelcarihareket();
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
	public sitePersonelcarihareket() {
		setModal(true);
		setTitle("Personel Cari Hareket Ekrani");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1093, 476);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("pencere acildi");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("pencere kapatildi");
			}
			
			public void windowActivated(WindowEvent e) {
				id_al=sitePersonelanaekrani.id3;
				modelim.setRowCount(0);
				ResultSet rs1=null;
				try {
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					System.out.println("baglantý saglandý");
					String listele="Select * From sitepersonelcarihareket where Personeltcno='"+id_al+"'";
					mystat1=myconn1.createStatement();
					rs1=mystat1.executeQuery(listele);
					System.out.println("listeleme basarili");
					while(rs1.next()) {
						satirlar[0]=rs1.getString("Personeltcno");
						satirlar[1]=rs1.getString("Personeladsoyad");
						satirlar[2]=rs1.getString("Aciklama");
						satirlar[3]=rs1.getString("Personelhareketid");
						modelim.addRow(satirlar);
					}
			table.setModel(modelim);
			System.out.println("TOPLAM KAYIT: "+table.getRowCount());
			if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
			
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 39, 241, 382);
		Image  img=new ImageIcon(this.getClass().getResource("/Money-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Personel Cari Hareket Ekrani");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 8, 364, 20);
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
		textisim.setBounds(261, 297, 669, 30);
		contentPane.add(textisim);
		textisim.setColumns(10);
		
		
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
		btnara.setBounds(951, 297, 110, 30);
		contentPane.add(btnara);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 39, 800, 246);
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
					sitePersonelcariekleduzenle frame=new sitePersonelcariekleduzenle();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					//dispose();
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Lütfen 1 satýrý seciniz");
					e1.printStackTrace();
				}
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(501, 334, 110, 87);
		contentPane.add(btnduzenle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				try {
					String tut_id=table.getValueAt(table.getSelectedRow(), 3).toString();
					String tut_ad=table.getValueAt(table.getSelectedRow(), 1).toString();
					int selectedOption=JOptionPane.showConfirmDialog(null,tut_ad+"Silmek istiyor musunuz?","SÝL",JOptionPane.YES_NO_OPTION);
					if(selectedOption==JOptionPane.YES_OPTION) {
						try {
							myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
							Statement statement=myconn1.createStatement();
							String sil="Delete from sitepersonelcarihareket where Personelhareketid='"+tut_id+"'";
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
		btnSil.setBounds(381, 334, 110, 87);
		contentPane.add(btnSil);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				sitePersonelcariekleduzenle frame = new sitePersonelcariekleduzenle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(261, 334, 110, 87);
		contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(951, 334, 110, 87);
		contentPane.add(btnvazgec);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//RAPOR ALMA ISLEMI
				sitePersonelhareketrapor_cagir rapor = new sitePersonelhareketrapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),3).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRapor.setBounds(621, 334, 149, 87);
		contentPane.add(btnRapor);
		
		JButton btnduzenle_1_1 = new JButton("Yardim");
		btnduzenle_1_1.addActionListener(new ActionListener() {
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
		btnduzenle_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Image  img5=new ImageIcon(this.getClass().getResource("/yardim12pix.png")).getImage();
		btnduzenle_1_1.setIcon(new ImageIcon(img5));
		btnduzenle_1_1.setBounds(780, 334, 150, 87);
		contentPane.add(btnduzenle_1_1);
		
		
	}
}
