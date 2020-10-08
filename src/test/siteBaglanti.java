package test;
import java.net.ConnectException;
import com.mysql.cj.jdbc.Driver;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class siteBaglanti {
	public static String logkullaniciyetkisi="";
	public static String logkullaniciadi;
	public static String logaksiyon;
	public static String sunucuparametresi;  //LOGIN FORMDAN DIREK GELIYOR PARAMETRE
	public static String versionadi;
	public static String versiondb;
	public static String versionuygulama;
	public static String kullanimpdf; //KULLANIM KILAVUZU YOLU LOGIN FORMDAN BELIRLENIYOR 
	
	
	public static Connection myconn1;
	public static Statement mystat1;
	
	static void yap() {
		try {
			System.out.println(sunucuparametresi);
			myconn1=DriverManager.getConnection (sunucuparametresi,"root","");
			System.out.println("BAGLANTI CLASSINDAN Baðlantý Saðlandý YENI");
		}catch(Exception hata)
		{
		System.err.println(hata);
		}
	}
	
	//KULLANILMIYOR**************
	static ResultSet kullanicilistele() 
	{
 		ResultSet rs1 = null;
		try {
			myconn1=DriverManager.getConnection (sunucuparametresi,"root","");
			System.out.println("BAGLANTI CLASSINDAN Baðlantý Saðlandý YENI");

			String query1="Select * From sitekullanicibilgi";
			mystat1=myconn1.createStatement();
			rs1=mystat1.executeQuery(query1);
			System.out.println("BAGLANTI CLASSINDAN Listeleme Basarili YENI");
		}catch(Exception hata)
		{
		System.err.println(hata);
		}
		return rs1;
	}
	

 	
	static void kullaniciekle(String sorgukullanicikayit) 
	{
 		
		try {
		mystat1.executeUpdate(sorgukullanicikayit);
		System.out.println("BAGLANTI CLASSINDAN Ekleme Basarili YENI");
		}catch(Exception hata)
		{
		System.err.println(hata);
		}

	}
	
	//KULLANILMIYOR******************
}

