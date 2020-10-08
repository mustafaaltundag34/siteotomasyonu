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
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class siteOrtakcarihareket extends JDialog {

	private JPanel contentPane;
	private JTable table;

	public static int id=0;
	public static int id_sakla=0;
	
	
	DefaultTableModel modelim = new DefaultTableModel();//TABLO MODELINI TANIMLIYORUZ
	Object [] kolonlar = {"Aciklama","tarih","saat","odeme tutari","tahsilat tutari","id"}; //KOLON TANIMLAMA
	Object [] satirlar = new Object[6]; //SATIR TANIMLAMA
	private JTextField textField;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteOrtakcarihareket frame = new siteOrtakcarihareket();
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
	public siteOrtakcarihareket() {
		setModal(true);
		setTitle("Site Ortak Cari Hareketler");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1191, 440);
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
		lblNewLabel.setBounds(10, 39, 246, 350);
		Image  img=new ImageIcon(this.getClass().getResource("/Money-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Site Ortak Cari Hareketler");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 8, 364, 20);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 39, 888, 197);
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
				siteOrtakcarirapor_cagir rapor = new siteOrtakcarirapor_cagir();
				rapor.rapor(table.getValueAt(table.getSelectedRow(),5).toString());
				
				//RAPOR ALMA ISLEMI
			}
		});
		btnRapor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRapor.setBounds(675, 297, 141, 92);
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
		btnYardim.setBounds(826, 297, 162, 92);
		contentPane.add(btnYardim);
		modelim.setColumnIdentifiers(kolonlar);
		
		JButton btnduzenle = new JButton("Duzenle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (siteBaglanti.logkullaniciyetkisi.equals("SEKRETER"))) {//KULLANICI YETKI KONTROLU

				try {
						id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString());
						siteOrtakcariekleduzenle frame = new siteOrtakcariekleduzenle();
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
		btnduzenle.setBounds(409, 297, 123, 92);
		contentPane.add(btnduzenle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) {//KULLANICI YETKI KONTROLU
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();

				try {
					int id=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString());
					String tutar=table.getValueAt(table.getSelectedRow(),3).toString();
	

					
					String sorgu="delete from siteortakcarihareket where Ortakcarihareketid='"+id+"'";
					int selectedOption = JOptionPane.showConfirmDialog(null,tutar+" Silmek istiyor musunuz?","SÝL",JOptionPane.YES_NO_OPTION); 
					if (selectedOption == JOptionPane.YES_OPTION)
					{
						
						try {
							Statement statement = baglan.myconn1.createStatement();
							String sorgu_sil="Delete from burobilgi where BuroID='"+id+"'";
							statement.executeUpdate(sorgu);
							JOptionPane.showMessageDialog(null,tutar+" silindi");
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
		btnSil.setBounds(542, 297, 123, 92);
		contentPane.add(btnSil);
		
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) || (siteBaglanti.logkullaniciyetkisi.equals("SEKRETER"))) {//KULLANICI YETKI KONTROLU


				siteOrtakcariekleduzenle frame = new siteOrtakcariekleduzenle();
				frame.show();
				frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				//dispose();
				}else {
					//JOptionPane.showMessageDialog(null, "Hatali Giris...!", "Site Otomasyonu", JOptionPane.PLAIN_MESSAGE);
					Object [] noSaveOption = {"Tamam"};
					int noSave = JOptionPane.showOptionDialog(null,"Bu Islemi yalniz YONETICI yapabilir..","Site Otomasyonu",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,noSaveOption, null);
					}}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(266, 297, 123, 92);
		contentPane.add(btnekle);
		
		JButton btnvazgec = new JButton("Kapat");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(1044, 297, 110, 92);
		contentPane.add(btnvazgec);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				///HER KELIMEYLE ARAMA
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelim);
			    table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textField.getText()));
				if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
				///

			}
		});
		textField.setColumns(10);
		textField.setBounds(266, 247, 722, 30);
		contentPane.add(textField);
		
		JButton btnAra = new JButton("Ara");
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText("");
					System.out.println("TOPLAM KAYIT: "+table.getRowCount());
					if (table.getRowCount()>0) {table.setRowSelectionInterval(0, 0);System.out.println("BURADA BURADA");}//TABLODA OTOMATIK ILK SATIRI SECIYOR}
					textField.requestFocus();
				} catch (Exception e2) {
					System.out.println(e2);
					// TODO: handle exception
				}
			}
		});
		btnAra.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAra.setBounds(1044, 247, 110, 30);
		contentPane.add(btnAra);
		


		
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
			 String listele = "select * from siteortakcarihareket";
				ResultSet rs=null;
				try {
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					while(rs.next())
					{
						satirlar[0]=rs.getString("Aciklama");
						satirlar[1]=rs.getString("Ortakharekettarih");
						satirlar[2]=rs.getString("Ortakhareketsaati");
						satirlar[3]=rs.getString("Ortakodemetutari");
						satirlar[4]=rs.getString("Ortaktahsilattutari");
						satirlar[5]=rs.getString("Ortakcarihareketid");
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
