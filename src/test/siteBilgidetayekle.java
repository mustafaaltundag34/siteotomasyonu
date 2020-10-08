package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;

public class siteBilgidetayekle extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	JComboBox comboyetki;
	JTextArea textadres;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteBilgidetayekle frame = new siteBilgidetayekle();
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
	public siteBilgidetayekle() {
		
		setModal(true);
		setTitle("Site Bilgi Detay Ekrani");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 819, 415);
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
		label.setBounds(10, 50, 223, 315);
		Image  img=new ImageIcon(this.getClass().getResource("/apartment-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblSiteBilgiDetayekrani = new JLabel("Site Bilgi Detay Ekrani");
		lblSiteBilgiDetayekrani.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSiteBilgiDetayekrani.setBounds(10, 11, 413, 33);
		contentPane.add(lblSiteBilgiDetayekrani);
		
		JLabel lblNewLabel_1 = new JLabel("Site Adi:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(243, 50, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTcNo = new JLabel("Baskan:");
		lblTcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo.setBounds(243, 80, 78, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblTelefon = new JLabel("Baskan Yrd:");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(243, 110, 78, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblEposta = new JLabel("Belediye Ruhsat No:");
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEposta.setBounds(243, 140, 122, 14);
		contentPane.add(lblEposta);
		
		JLabel lblifre = new JLabel("Site Blok Sayisi:");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre.setBounds(243, 170, 110, 14);
		contentPane.add(lblifre);
		
		JLabel lblifre_1 = new JLabel("Dogal Gaz Tes. No:");
		lblifre_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre_1.setBounds(243, 200, 122, 14);
		contentPane.add(lblifre_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_1.requestFocus();
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(375, 50, 120, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_2.requestFocus();
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(375, 80, 120, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_3.requestFocus();
				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(375, 110, 120, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboyetki.requestFocus();
				}
			}
			
		});
		textField_3.setColumns(10);
		textField_3.setBounds(375, 140, 120, 20);
		contentPane.add(textField_3);
		
		
		comboyetki = new JComboBox();
		comboyetki.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_7.requestFocus();
				}
			}
		});
		comboyetki.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboyetki.setBounds(375, 170, 120, 22);
		contentPane.add(comboyetki);
		
		JLabel lblDepartman = new JLabel("Site Pers.Sayisi:");
		lblDepartman.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartman.setBounds(517, 50, 100, 14);
		contentPane.add(lblDepartman);
		
		JLabel lblSskNo = new JLabel("Site Sehir:");
		lblSskNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSskNo.setBounds(517, 80, 69, 14);
		contentPane.add(lblSskNo);
		
		JLabel lblMaa = new JLabel("Vergi No:");
		lblMaa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaa.setBounds(517, 110, 69, 14);
		contentPane.add(lblMaa);
		
		JLabel lblVardiyas = new JLabel("Vergi Dairesi:");
		lblVardiyas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVardiyas.setBounds(517, 140, 110, 14);
		contentPane.add(lblVardiyas);
		
		JLabel lblAdres = new JLabel("Site Adres:");
		lblAdres.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdres.setBounds(517, 204, 69, 14);
		contentPane.add(lblAdres);
		
		JLabel lblkTarihi = new JLabel("Elektrik Tes. No:");
		lblkTarihi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblkTarihi.setBounds(243, 231, 122, 14);
		contentPane.add(lblkTarihi);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_5.requestFocus();
				}
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(665, 80, 122, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_6.requestFocus();
				}
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(665, 110, 122, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_11.requestFocus();
				}
			}
		});
		textField_6.setColumns(10);
		textField_6.setBounds(665, 140, 122, 20);
		contentPane.add(textField_6);
		
		textField_12 = new JTextField();
		textField_12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_13.requestFocus();
				}
			}
		});
		textField_12.setColumns(10);
		textField_12.setBounds(665, 256, 120, 20);
		contentPane.add(textField_12);
		
		JLabel lblSiteEposta = new JLabel("Site Eposta:");
		lblSiteEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSiteEposta.setBounds(517, 287, 100, 14);
		contentPane.add(lblSiteEposta);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(665, 287, 120, 20);
		contentPane.add(textField_13);
		
		textadres = new JTextArea();
		contentPane.add(textadres);
		textadres.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (textadres.getText().length() >= 100 ) // limit to 3 characters
	                e.consume();
	        }
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_12.requestFocus();
				}
			}
	    });
		JScrollPane scroll = new JScrollPane(textadres);
		scroll.setBounds(665, 204, 122, 41);                     // <-- THIS
	    getContentPane().add(scroll);
	    setLocationRelativeTo ( null );
	    textadres.setWrapStyleWord(true); //kelimeden satir sonu yapmasi icin
	    textadres.setLineWrap(true); //satir sonu bir alta almak icin
		
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_8.requestFocus();
				}
			}
		});
		textField_7.setColumns(10);
		textField_7.setBounds(375, 198, 120, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_9.requestFocus();
				}
			}
		});
		textField_8.setColumns(10);
		textField_8.setBounds(375, 229, 120, 20);
		contentPane.add(textField_8);
		
		JLabel lblSuTesNo = new JLabel("Su Tes. No:");
		lblSuTesNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSuTesNo.setBounds(243, 262, 69, 14);
		contentPane.add(lblSuTesNo);
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_10.requestFocus();
				}
			}
		});
		textField_9.setColumns(10);
		textField_9.setBounds(375, 262, 120, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textField_4.requestFocus();
				}
			}
		});
		textField_10.setColumns(10);
		textField_10.setBounds(665, 50, 122, 20);
		contentPane.add(textField_10);
		
		JLabel lblUyeIkametSayisi = new JLabel("Site Ikamet Nufusu:");
		lblUyeIkametSayisi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUyeIkametSayisi.setBounds(517, 172, 138, 14);
		contentPane.add(lblUyeIkametSayisi);
		
		textField_11 = new JTextField();
		textField_11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textadres.requestFocus();
				}
			}
		});
		textField_11.setColumns(10);
		textField_11.setBounds(665, 172, 122, 20);
		contentPane.add(textField_11);
		
		JButton btnekle = new JButton("Kaydet");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					 
					String blok_sayisi =comboyetki.getSelectedItem().toString(); 
					String sorgu_kaydet="insert into  sitebilgi(Siteadi,Siteadres,Sitesehir,Sitevergino,Sitevergidairesi,Sitebaskani,Sitebaskanyardimcisi,Sitebloksayisi,Siteortakelektriktesisatno,Siteortaksutesisatno,Siteortakdogalgazno,Sitebelediyeruhsatno,Siteuyeikametsayisi,Sitepersonelsayisi,Siteiletisimtelefon,siteeposta)values('"+textField.getText() +"','"+ textadres.getText()+"','"+textField_4.getText() +"','"+ textField_5.getText()+"','"+textField_6.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+blok_sayisi+"','"+textField_8.getText()+"','"+textField_9.getText()+"','"+textField_7.getText()+"','"+textField_3.getText()+"','"+textField_11.getText()+"','"+textField_10.getText()+"','"+textField_12.getText()+"','"+textField_13.getText()+"')";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
							 
							
							
							//siteBilgianaekran frame = new siteBilgianaekran();
							//frame.show();
							//frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
							dispose(); 
						 
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 
				}
			}
		});
		btnekle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnekle.setBounds(243, 335, 110, 30);
		
		JButton btnduzenle = new JButton("Guncelle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(textField.getText().equals("")) 
					{
						JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");
		
					}
					else
					{
						 
						String site_sayisi =comboyetki.getSelectedItem().toString(); 
						String sorgu_kaydet="update  sitebilgi set Siteadi='"+textField.getText()+"',Siteadres='"+textadres.getText()+"',Sitesehir='"+textField_4.getText()+"',Sitevergino='"+textField_5.getText()+"',Sitevergidairesi='"+textField_6.getText()+"',Sitebaskani='"+textField_1.getText()+"',Sitebaskanyardimcisi='"+textField_2.getText()+"',Sitebloksayisi='"+site_sayisi+"',Siteortakelektriktesisatno='"+textField_8.getText()+"',Siteortaksutesisatno='"+textField_9.getText()+"',Siteortakdogalgazno='"+textField_7.getText()+"',Sitebelediyeruhsatno='"+textField_3.getText()+"',Siteuyeikametsayisi='"+textField_11.getText()+"',Sitepersonelsayisi='"+textField_10.getText()+"',Siteiletisimtelefon='"+textField_12.getText()+"',siteeposta='"+textField_13.getText()+"' where Siteid='"+siteBilgianaekran.id_sakla+"'";
						 
								try {
								siteBaglanti baglan = new siteBaglanti();
								baglan.yap();
								baglan.mystat1=baglan.myconn1.createStatement();
								baglan.mystat1.executeUpdate(sorgu_kaydet);
								JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
								 
								
								
								//sitebilgianaekran frame = new sitebilgianaekran();
								//frame.show();
								//frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
								dispose(); 
							 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		 
					}
						
			}
		});
		btnduzenle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnduzenle.setBounds(243, 335, 110, 30);

		if(siteBilgianaekran.id==0) contentPane.add(btnekle);
		
		else contentPane.add(btnduzenle);
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//siteBilgianaekran frame = new siteBilgianaekran();
				//frame.show();
				//frame.setLocationRelativeTo(null); //FORMU MERKEZE ALIYOR
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(507, 335, 110, 30);
		contentPane.add(btnvazgec);


		
		JLabel lblSuTelefonNo = new JLabel("Site Telefon No:");		JButton btnNewButton = new JButton("Temizle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textadres.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_1.setText("");
				textField_2.setText("");
				
				textField_8.setText("");
				textField_9.setText("");
				textField_7.setText("");
				textField_3.setText("");
				textField_11.setText("");
				textField_10.setText("");
				textField_12.setText("");
				textField_13.setText("");
			}
		});
		btnNewButton.setBounds(375, 335, 110, 30);
		contentPane.add(btnNewButton);
		
		
		lblSuTelefonNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSuTelefonNo.setBounds(517, 256, 100, 14);
		contentPane.add(lblSuTelefonNo);
		

		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			 
				siteBilgianaekran.id_sakla=siteBilgianaekran.id;
				siteBilgianaekran.id=0;
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();
				
				ResultSet rs = null;
				try {
					
					String listele="Select * From sitebilgi where Siteid='"+siteBilgianaekran.id_sakla+"'";
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					if(rs.next())
					{ 
						
						textField.setText(rs.getString("Siteadi"));
						textadres.setText(rs.getString("Siteadres"));
						textField_4.setText(rs.getString("Sitesehir"));
						textField_5.setText(rs.getString("Sitevergino"));
						textField_6.setText(rs.getString("Sitevergidairesi"));
						textField_1.setText(rs.getString("Sitebaskani"));
						textField_2.setText(rs.getString("Sitebaskanyardimcisi"));
						
						textField_8.setText(rs.getString("Siteortakelektriktesisatno"));
						textField_9.setText(rs.getString("Siteortaksutesisatno"));
						textField_7.setText(rs.getString("Siteortakdogalgazno"));
						textField_3.setText(rs.getString("Sitebelediyeruhsatno"));
						textField_11.setText(rs.getString("Siteuyeikametsayisi"));
						textField_10.setText(rs.getString("Sitepersonelsayisi"));
						textField_12.setText(rs.getString("Siteiletisimtelefon"));
						textField_13.setText(rs.getString("siteeposta"));
						
						int  bloksayisi=Integer.parseInt(rs.getString("Sitebloksayisi"));
						
						for(int i=1;i<=10;i++)
						{
							if(bloksayisi==i)
							{
								comboyetki.setSelectedIndex(i-1);
							}
						}
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
	}
}
