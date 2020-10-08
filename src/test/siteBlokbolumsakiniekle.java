package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class siteBlokbolumsakiniekle extends JDialog {

	private JPanel contentPane;
	private JTextField textadsoyad;
	private JTextField texttcno;
	private JTextField texttelefon;
	private JTextField texteposta;
	private JTextField textbolumno;
	private JTextField tarihtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteBlokbolumsakiniekle frame = new siteBlokbolumsakiniekle();
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
	public siteBlokbolumsakiniekle() {
		setModal(true);
		setTitle("Site Blok Bolum Sakini Ekle Duzenle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 658, 386);
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
		label.setBounds(10, 55, 250, 281);
		Image  img=new ImageIcon(this.getClass().getResource("/11874-family-man-woman-girl-boy-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Site Blok Bolum Sakini Ekle Duzenle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 409, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(276, 85, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTcNo = new JLabel("TC No:");
		lblTcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTcNo.setBounds(276, 115, 69, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefon.setBounds(276, 145, 69, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblEposta = new JLabel("Eposta:");
		lblEposta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEposta.setBounds(276, 175, 69, 14);
		contentPane.add(lblEposta);
		
		JLabel lblifre = new JLabel("Bolum Adi:");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblifre.setBounds(276, 55, 69, 14);
		contentPane.add(lblifre);
		
		textadsoyad = new JTextField();
		textadsoyad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					texttcno.requestFocus();
				}
			}
		});
		textadsoyad.setBounds(393, 85, 164, 20);
		contentPane.add(textadsoyad);
		textadsoyad.setColumns(10);
		
		texttcno = new JTextField();
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
					texttelefon.requestFocus();
				}
			}
		});
		texttcno.setBounds(393, 115, 164, 20);
		contentPane.add(texttcno);
		texttcno.setColumns(10);
		
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
		texttelefon.setBounds(393, 145, 164, 20);
		contentPane.add(texttelefon);
		
		texteposta = new JTextField();
		texteposta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				textadsoyad.requestFocus();
				}
			}
		});
		texteposta.setColumns(10);
		texteposta.setBounds(393, 175, 164, 20);
		contentPane.add(texteposta);
		
		textbolumno = new JTextField();
		textbolumno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textadsoyad.requestFocus();
				}
			}
		});
		textbolumno.setEnabled(false);
		textbolumno.setEditable(false);
		textbolumno.setColumns(10);
		textbolumno.setBounds(393, 55, 164, 20);
		contentPane.add(textbolumno);
		
		JLabel lblKayitTarihi = new JLabel("Kayit Tarihi:");
		lblKayitTarihi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKayitTarihi.setBounds(276, 206, 95, 14);
		contentPane.add(lblKayitTarihi);
		
		tarihtxt = new JTextField();
		tarihtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textbolumno.requestFocus();
				}
			}
		});
		tarihtxt.setEnabled(false);
		tarihtxt.setEditable(false);
		tarihtxt.setColumns(10);
		tarihtxt.setBounds(393, 206, 164, 20);
		contentPane.add(tarihtxt);
		
		JButton btnekle = new JButton("Kaydet");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textbolumno.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					String sorgu_kaydet="insert into sitebolumsakinbilgi(Bolumsakinadsoyad,Bolumsakintcno,Bolumsakintelefon,Bolumsakinepostaadresi,Blokbolumadi)values('"+textadsoyad.getText() +"','"+ texttcno.getText()+"','"+texttelefon.getText() +"','"+ texteposta.getText()+"','"+textbolumno.getText()+"')";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_kaydet);
							JOptionPane.showMessageDialog(null,"Islem Basarili");
							 
							
							
							//siteBlokbolumsakinbilgisi frame = new siteBlokbolumsakinbilgisi();
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
		btnekle.setBounds(276, 306, 110, 30);
		
		
		JButton btnduzenle = new JButton("Guncelle");
		btnduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textbolumno.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null,"Gerekli Alanlarý Doldurunuz.!");

				}
				else
				{
					 
					 
					String sorgu_guncelle="update  sitebolumsakinbilgi set Bolumsakinadsoyad='"+textadsoyad.getText() +"',Bolumsakintcno='"+ texttcno.getText()+"',Bolumsakintelefon='"+texttelefon.getText() +"',Bolumsakinepostaadresi='"+ texteposta.getText()+"',Blokbolumadi='"+textbolumno.getText()+"' where Bolumsakinid='"+siteBlokbolumsakinbilgisi.id_sakla+"'";
					 
 						try {
 							siteBaglanti baglan = new siteBaglanti();
 							baglan.yap();
							baglan.mystat1=baglan.myconn1.createStatement();
							baglan.mystat1.executeUpdate(sorgu_guncelle);
							JOptionPane.showMessageDialog(null,"Ýþlem Baþarýlý");
							 
							
							
							//siteBlokbolumsakinbilgisi frame = new siteBlokbolumsakinbilgisi();
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
		btnduzenle.setBounds(276, 306, 110, 30);
		if(siteBlokbolumsakinbilgisi.id==0) {
			textbolumno.setText(siteBlokbolumbilgi.id3);
			contentPane.add(btnekle);
		}
		else {
			textbolumno.enable(false);
			contentPane.add(btnduzenle);
		}
		
		JButton btnvazgec = new JButton("Vazgec");
		btnvazgec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//siteBlokbolumsakinbilgisi form = new siteBlokbolumsakinbilgisi();
				//form.show();
				//form.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnvazgec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvazgec.setBounds(516, 306, 110, 30);
		contentPane.add(btnvazgec);
		
		
		
		JButton btnNewButton = new JButton("Temizle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textbolumno.setText("");
				textadsoyad.setText("");
				texttcno.setText("");
				texttelefon.setText("");
				texteposta.setText("");
				
			}
		});
		btnNewButton.setBounds(393, 306, 110, 30);
		contentPane.add(btnNewButton);
		

		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			 
				siteBlokbolumsakinbilgisi.id_sakla=siteBlokbolumsakinbilgisi.id;
				siteBlokbolumsakinbilgisi.id=0;
				siteBaglanti baglan = new siteBaglanti();
				baglan.yap();
				
				ResultSet rs = null;
				try {
					
					String listele="Select * From sitebolumsakinbilgi where Bolumsakinid='"+siteBlokbolumsakinbilgisi.id_sakla+"'";
					baglan.mystat1=baglan.myconn1.createStatement();
					rs=baglan.mystat1.executeQuery(listele);
					if(rs.next())
					{ 
						
						textbolumno.setText(rs.getString("Blokbolumadi"));
						textadsoyad.setText(rs.getString("Bolumsakinadsoyad"));
						texttcno.setText(rs.getString("Bolumsakintcno"));
						texttelefon.setText(rs.getString("Bolumsakintelefon"));
						texteposta.setText(rs.getString("Bolumsakinepostaadresi"));
						tarihtxt.setText(rs.getString("Bolumsakinkayittarihi"));
						 
				 
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
	}
}
