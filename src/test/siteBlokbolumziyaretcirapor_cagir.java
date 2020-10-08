package test;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.lowagie.text.Document;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class siteBlokbolumziyaretcirapor_cagir {
	
	static Connection myconn1;
	static Statement mystat1;
	
	public void rapor(String sayi) {
		
		ResultSet rs1 = null;
		
		try 
		{
	 
			myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
			String listele="Select * From sitebolumziyaretci where Ziyaretciid='"+sayi+"'";
			mystat1=myconn1.createStatement();
			rs1=mystat1.executeQuery(listele);
				if(rs1.next())
				{	
					String path;
					path=System.getProperty("user.home") + "/Desktop"; //DESKTOP YOLUNU BULMA
					Document document = new Document();
					PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path+"\\siteblokbolumziyaretci.pdf"));
					document.open();
					//ekrana yazýlar basýlýyor
					document.add(new Paragraph("SECILEN BOLUM ZIYARETCI SATIRI BILGILERI :"));
					
		         //Liste yöntemiyle veri ekleme
			         List list = new List(List.UNORDERED);
			            list.add(new ListItem("Ziyaretci id="+rs1.getString("BolumId")));
			            list.add(new ListItem("Ziyaretci Adi Soyadi ="+rs1.getString("Ziyaretciadsoyad")));
			            list.add(new ListItem("Ziyaretci Giris Tarihi="+rs1.getString("Ziyaretcigiriszamani")));
			            list.add(new ListItem("Ziyaretci Giris Saati="+rs1.getString("girissaati")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Ziyaretci Cikis Tarihi="+rs1.getString("Ziyaretcicikiszamani")));
			            list.add(new ListItem("Ziyaretci Cikis Saati="+rs1.getString("cikissaati")));
			            list.add(new ListItem("Bolum Adi / No="+rs1.getString("Blokbolumadi")));			            
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Plaka 1="+rs1.getString("Ziyaretciaracplaka1")));
			            list.add(new ListItem("Plaka 2="+rs1.getString("Ziyaretciaracplaka2")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Bu Rapor :"+ siteBaglanti.versionadi+" Uygulamasi ile talebiniz uzere olusturulmustur..."));
			           document.add(list);
			         
					//Dökümaný kapatýyoruz
					document.close();
			        pdfWriter.close();
				
			        
			        
			        //Eklenen pdf'i direk olarak açma
			       // String FILE = "C:\\Users\\yýlmaz\\eclipse-workspace\\Deneme\\avukatbilgi.pdf";
			        String FILE = path+"\\siteblokbolumziyaretci.pdf";
					try 
					{
						if ((new File(FILE)).exists()) {
							Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + FILE);
							p.waitFor();
						} else {
							System.out.println("Dosya Bulunamadi");
						}
						System.out.println("Islem Basarili");
					}catch (Exception ex) {
						ex.printStackTrace();
					}
			        
		        
				}	
		}
		catch(Exception e1)
		{
			 JOptionPane.showMessageDialog(null,"1 satýr seçiniz veya");
				e1.printStackTrace();
		}
		
 
	}
	
	
}
