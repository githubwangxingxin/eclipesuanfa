package com.wxx.bigdecimaltest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.trs.client.*;

public class TestDecimal {
	public static void main(String[] args) {

		String sHost = "210.76.97.231";
		String sPort = "8888";
		String sUserName = "system";
		String sPassWord = "ciskwtrs123";
		TRSConnection trscon = null;

		try
		{
			// ��������
			trscon = new TRSConnection();
			trscon.connect(sHost, "8888", sUserName, sPassWord, "T2");          

			trscon.setMaintOptions('\n', "", "", 0, 0); //����ά����¼��ѡ��.
			/*for(int i=1;i<=65353;i++) {
				Random random=new Random();
				int num=random.nextInt(1000);
				 /
				  * String strValue = "SID=$CODE\nVISITTYPE=110201\nLOGTIME=2019.3."+3+" 00:00:00\nLOGY=2019\nLOGYM=2019.3\nLOGYMD=2019.3."+3+"\nkeyword=������";
				int iInsertNum = trscon.executeInsert("KW2_LOG", "system", strValue);
				System.out.println("�����¼�������¼��Ϊ:" + iInsertNum);
			}*/
			Date date=new Date(System.currentTimeMillis());
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
			String logtime=simpleDateFormat.format(date);
			System.out.println(logtime);
			simpleDateFormat.applyPattern("yyyy");
			String logy=simpleDateFormat.format(date);
			System.out.println(logy);
			simpleDateFormat.applyPattern("yyyy.MM");
			String logym=simpleDateFormat.format(date);
			System.out.println(logym);
			simpleDateFormat.applyPattern("yyyy.MM.dd");
			String logymd=simpleDateFormat.format(date);
			System.out.println(logymd);
			String strValue = "SID=$CODE\nVISITTYPE=19\nLOGTIME="+logtime+"\nLOGY="+logy+"\nLOGYM="+logym+"\nLOGYMD="+logymd+"\nAMOUNT=1";
			//int iInsertNum = trscon.executeInsert("KW2_LOG", "system", strValue);
			int iInsertNum = trscon.executeInsert("KW2_LOG", "system", strValue);

           //   int iUpdate=trscon.executeUpdate("KW2_LOG","system","IP=210.76.103.26","logymd=2019.1.30");

			
		}
		catch (TRSException ex)
		{
			// ���������Ϣ
			System.out.println(ex.getErrorCode() + ":" + ex.getErrorString());
			ex.printStackTrace();
		}
		finally
		{
			// �ر�����
			if (trscon != null) trscon.close();
			trscon = null;
		}
	}
	public static void main2(String[] args) {
		
	}
	
	
	
}
