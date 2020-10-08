package test;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;

public class sitePersonelekleduzenle extends JDialog{
	
	 static Connection myconn1;
	    static Statement mystat1;
	    static Connection myconn2;
	    static Statement mystat2;

	private JPanel contentPane;
	private JTextField textadsoyad;
	private JTextField texttcno;
	private JTextField texttelefon;
	private JTextField texteposta;
	private JTextField textsskno;
	private JTextField textmaas;
	private JTextField textvardiya;
	//private JTextField textgiris;
	//private JTextField textcikis;
	private JTextArea textadres;

	private JComboBox textgiris;
	private JComboBox textcikis;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sitePersonelekleduzenle frame = new sitePersonelekleduzenle();
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
	public sitePersonelekleduzenle() {
		setModal(true);
		setTitle("Site Personel Ekle Duzenle Ekrani");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 996, 395);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(10, 50, 223, 289);
		Image  img=new ImageIcon(this.getClass().getResource("/Groups-Meeting-Light-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Site Personel Ekle Duzenle Ekrani");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 413, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(261, 78, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTcNo = new JLabel("TC No:");
		lblTcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo.setBounds(261, 50, 69, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(261, 138, 69, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblEposta = new JLabel("Eposta:");
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEposta.setBounds(261, 168, 69, 14);
		contentPane.add(lblEposta);
		
		JLabel lblifre = new JLabel("Yetki:");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre.setBounds(261, 198, 69, 14);
		contentPane.add(lblifre);
		
		JLabel lblifre_1 = new JLabel("Giris Tarihi:");
		lblifre_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre_1.setBounds(261, 228, 69, 14);
		contentPane.add(lblifre_1);
		
		JLabel lblDepartman = new JLabel("Departman:");
		lblDepartman.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartman.setBounds(261, 106, 78, 14);
		contentPane.add(lblDepartman);
		
		JLabel lblSskNo = new JLabel("SSK No:");
		lblSskNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSskNo.setBounds(535, 108, 69, 14);
		contentPane.add(lblSskNo);
		
		JLabel lblMaa = new JLabel("Maas:");
		lblMaa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaa.setBounds(535, 138, 69, 14);
		contentPane.add(lblMaa);
		
		JLabel lblVardiyas = new JLabel("Vardiyasi:");
		lblVardiyas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVardiyas.setBounds(535, 168, 69, 14);
		contentPane.add(lblVardiyas);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdres.setBounds(535, 198, 69, 14);
		contentPane.add(lblAdres);
		
		JComboBox combodepartman = new JComboBox();
		combodepartman.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					texttelefon.requestFocus();
				}
			}
		});
		combodepartman.setModel(new DefaultComboBoxModel(new String[] {"IDARI ISLER", "HALKLA ILISKILER", "GUVENLIK", "PEYZAJ", "TEMIZLIK", "TEKNIK ISLER"}));
		combodepartman.setBounds(349, 106, 166, 22);
		contentPane.add(combodepartman);
		
		JLabel lblkTarihi = new JLabel("Cikis Tarihi:");
		lblkTarihi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblkTarihi.setBounds(261, 259, 69, 14);
		contentPane.add(lblkTarihi);
		textadsoyad = new JTextField();
		textadsoyad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					combodepartman.requestFocus();
				}
			}
			
		});
		textadsoyad.setBounds(349, 78, 164, 20);
		contentPane.add(textadsoyad);
		textadsoyad.setColumns(10);
		
		texttcno = new JTextField();
		texttcno.setBounds(349, 50, 164, 20);
		contentPane.add(texttcno);
		texttcno.setColumns(10);
		texttcno.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (texttcno.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textadsoyad.requestFocus();
				}
			}
			
		});
		
		texttelefon = new JTextField();
		texttelefon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (texttelefon.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					texteposta.requestFocus();
				}
			}
		});
		texttelefon.setColumns(10);
		texttelefon.setBounds(349, 138, 164, 20);
		contentPane.add(texttelefon);
		
		
		JComboBox comboyetki = new JComboBox();
		comboyetki.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textsskno.requestFocus();
				}
			}
		});
		comboyetki.setModel(new DefaultComboBoxModel(new String[] {"YONETICI", "GUVENLIK", "SEKRETER", "SITESAKINI","MUHASEBE"}));
		comboyetki.setBounds(349, 198, 164, 22);
		contentPane.add(comboyetki);
		
		texteposta = new JTextField();
		texteposta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboyetki.requestFocus();
				}
			}
		});
		texteposta.setColumns(10);
		texteposta.setBounds(349, 168, 164, 20);
		contentPane.add(texteposta);

		

		
		textsskno = new JTextField();
		textsskno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textmaas.requestFocus();
				}
			}
		});
		textsskno.setBounds(645, 108, 166, 20);
		contentPane.add(textsskno);
		textsskno.setColumns(10);
		
		textmaas = new JTextField();
		textmaas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){   					      
					e.consume();}
				 if (textmaas.getText().length() >= 11 ) // limit to 11 characters
		                e.consume();
			
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textvardiya.requestFocus();
				}
			}
		});
		textmaas.setHorizontalAlignment(SwingConstants.RIGHT);
		textmaas.setText("0.00");
		textmaas.setBounds(645, 138, 166, 20);
		contentPane.add(textmaas);
		textmaas.setColumns(10);
		
		textvardiya = new JTextField();
		textvardiya.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textadres.requestFocus();
				}
			}
		});
		textvardiya.setBounds(645, 168, 166, 20);
		contentPane.add(textvardiya);
		textvardiya.setColumns(10);
		
		JTextArea textadres = new JTextArea();
		textadres.setBounds(627, 170, 166, 41);
		contentPane.add(textadres);
		textadres.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (textadres.getText().length() >= 100 ) 
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					//textadsoyad.requestFocus();
			//	}
			}
		});
		JScrollPane scroll1 = new JScrollPane(textadres);
	   scroll1.setBounds(645,198,166,47);                    
	    getContentPane().add(scroll1);
	    setLocationRelativeTo ( null );
	    textadres.setWrapStyleWord(true);
	    textadres.setLineWrap(true);
		
	    //textgiris = new JTextField();
		//textgiris.setColumns(10);
		//textgiris.setBounds(331, 226, 164, 20);
		//contentPane.add(textgiris);
		
	    JDateChooser textgiris = new JDateChooser();
	    textgiris.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {
				//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					//textcikis.requestFocus();
			//	}
	    	}
	    });
	    textgiris.setBounds(349, 226, 164, 20);
	    textgiris.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(textgiris);
		
		
	    JDateChooser textcikis = new JDateChooser();
	    textcikis.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textsskno.requestFocus();
				}
	    	}
	    });
	    textcikis.setBounds(349, 257, 164, 20);
	    textcikis.setDateFormatString("yyyy-MM-dd");
	    contentPane.add(textcikis);
	    
		//textcikis = new JTextField();
		//textcikis.setColumns(10);
		//textcikis.setBounds(331, 257, 164, 20);
		//contentPane.add(textcikis);
		
		addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e) {
				System.out.println("pencere acildi");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("pencere kapandi");
			}
			public void windowActivated(WindowEvent e) {
				int id_al=sitePersonelanaekrani.id;
				ResultSet rs=null;
				try {
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					String listele="Select * From sitepersonelbilgi where PersonelID='"+id_al+"'";
					mystat1=myconn1.createStatement();
					rs=mystat1.executeQuery(listele);
					if(rs.next()) {
						textadsoyad.setText(rs.getString("Personeladsoyad"));
						texttcno.setText(rs.getString("Personeltcno"));
						texttelefon.setText(rs.getString("Personeltelefonno"));
						texteposta.setText(rs.getString("Personelepostaadresi"));
						comboyetki.setSelectedItem(rs.getString("Personelyetki"));
						textgiris.setDate(rs.getDate("Personelisegiristarihi"));
						textcikis.setDate(rs.getDate("Personelistencikistarihi"));
						//String departman=rs.getString("Personeldepartman");
						combodepartman.setSelectedItem(rs.getString("Personeldepartman"));
						textadres.setText(rs.getString("Personeladres"));
						textsskno.setText(rs.getString("Personelsskno"));
						textmaas.setText(rs.getString("Personelmaasi"));
						textvardiya.setText(rs.getString("Personelvardiyasi"));
						sitePersonelanaekrani.sakla_id=sitePersonelanaekrani.id;
						sitePersonelanaekrani.id=0;
					}
				}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				
			}
		});
		
		JButton btnekle = new JButton("Kaydet");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String tarih1,tarih2;
				if(texttcno.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "gerekli alanlarý doldurun");
			}
			else {
					
				Date date =new Date();
				if (textgiris.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih1=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih1=sdf.format(textgiris.getDate());//TARIH FORMATLAMA
					System.out.println(tarih1);}


				if (textcikis.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					//tarih2=sdf1.format(date);
					tarih2="2099-01-01";} 
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(textcikis.getDate());//TARIH FORMATLAMA
					System.out.println(tarih2);}
				
				if ((textmaas.getText()).equals("")){textmaas.setText("0");}
				
							String sorgu_ekle="insert into sitepersonelbilgi(Personeladsoyad,Personeltcno,Personeltelefonno,Personelepostaadresi,Personelyetki,Personelisegiristarihi,Personelistencikistarihi,Personeldepartman,Personeladres,Personelsskno,Personelmaasi,Personelvardiyasi)"
									+ "values('"+ textadsoyad.getText()+"','"+ texttcno.getText()+"','"+ texttelefon.getText()+"','"+ texteposta.getText()+"','"+comboyetki.getSelectedItem().toString()+"','"+tarih1+"','"+ tarih2+"','"+combodepartman.getSelectedItem().toString()+"','"+ textadres.getText()+"','"+textsskno.getText()+"','"+textmaas.getText()+"','"+ textvardiya.getText()+"')";
							try {
								myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
								mystat1=myconn1.createStatement();
								mystat1.executeUpdate(sorgu_ekle);
								JOptionPane.showMessageDialog(null, "Ýslem basarili");
								//sitePersonelanaekrani frame=new sitePersonelanaekrani();
								//frame.setVisible(true);
								//frame.setLocationRelativeTo(null);
								dispose();
							}catch(Exception hata)
							{
								JOptionPane.showMessageDialog(null,"TC No tekrarli veya Hatali/Eksik Alanlari Doldurunuz.!");
								System.err.println(hata);
							} 
							
			}
			}
			
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(383, 309, 110, 30);
		//contentPane.add(btnekle);
		
		JButton btnduzenle = new JButton("Guncelle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tarih1,tarih2;
				
				Date date =new Date();
				if (textgiris.getDate()==null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tarih1=sdf.format(date);}
				else {
			      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih1=sdf.format(textgiris.getDate());//TARIH FORMATLAMA
					System.out.println(tarih1);}


				if (textcikis.getDate()==null){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					//tarih2=sdf1.format(date);
					tarih2="2099-01-01";}  
				else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//TARIH FORMATLAMA
					tarih2=sdf1.format(textcikis.getDate());//TARIH FORMATLAMA
					System.out.println(tarih2);}
				
				String guncelle="update sitepersonelbilgi set Personeladsoyad='"+ textadsoyad.getText()+"',Personeltcno='"+ texttcno.getText()+"',Personeltelefonno='"+texttelefon.getText()+"',Personelepostaadresi='"+texteposta.getText()+"',Personelyetki='"+comboyetki.getSelectedItem().toString()+"',Personelisegiristarihi='"+ tarih1+"',Personelistencikistarihi='"+ tarih2+"',Personeldepartman='"+combodepartman.getSelectedItem().toString()+"',Personeladres='"+textadres.getText()+"',Personelsskno='"+textsskno.getText()+"',Personelmaasi='"+textmaas.getText()+"',Personelvardiyasi='"+textvardiya.getText()+"' where PersonelID='"+sitePersonelanaekrani.sakla_id+"'";
				try {
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					mystat1=myconn1.createStatement();
					mystat1.executeUpdate(guncelle);
					JOptionPane.showMessageDialog(null, "guncelleme basarili");
					//sitePersonelanaekrani frame=new sitePersonelanaekrani();
					//frame.setVisible(true);
					//frame.setLocationRelativeTo(null);
					dispose();
					
				}catch(Exception hata)
				{
					JOptionPane.showMessageDialog(null,"TC No tekrarli veya Hatali/Eksik Alanlari Doldurunuz.!");
					System.err.println(hata);
				} 
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(383, 309, 110, 30);
		//contentPane.add(btnduzenle);
		
		if(sitePersonelanaekrani.id==0)
		{
			contentPane.add(btnekle);
		}
		else
		{
			texttcno.enable(false);
			contentPane.add(btnduzenle);

		}
		
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sitePersonelanaekrani frame=new sitePersonelanaekrani();
				//frame.show();
				//frame.setLocationRelativeTo(null);;
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(639, 309, 110, 30);
		contentPane.add(btnvazgec);
		
		JButton btntemizle = new JButton("Temizle");
		btntemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textadsoyad.setText("");
				//texttcno.setText("");
				texttelefon.setText("");
				texteposta.setText("");
				//textgiris.setText("");
				//textcikis.setText("");
				textadres.setText("");
				textsskno.setText("");
				textmaas.setText("");
				textvardiya.setText("");
			}
		});
		btntemizle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntemizle.setBounds(514, 309, 110, 30);
		contentPane.add(btntemizle);
		
		
		
		
		
		
	}
}
