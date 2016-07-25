package T1;
import java.util.*;

import javax.sound.sampled.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
class Tank
{
	int x=0,y=0;
	int fangxiang=0;
	int sudu=5;
	boolean shengming=true;
	
    public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getFangxiang() {
		return fangxiang;
	}
	public void setFangxiang(int fangxiang) {
		this.fangxiang = fangxiang;
	}
	public int getSudu() {
		return sudu;
	}
	public void setSudu(int sudu) {
		this.sudu = sudu;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
class EnemyTank extends Tank implements Runnable
{
	static int sudu=2;
	int time=0;
	Vector<bullet> dzd=new Vector<bullet>();
	MyTank mt=null;
	Vector<EnemyTank> dtk1=new Vector<EnemyTank>();
	
	public void setmt(MyTank mt)
	{
		this.mt=mt;
	}
	public EnemyTank(int x,int y)
	{
		super(x,y);
	}
	public void dtkxl(Vector<EnemyTank> dtk)
	{
		this.dtk1=dtk;
	}
	public boolean pengzhuang2()
	{
		boolean b=false;
		
		switch(this.fangxiang)
		{
		case 0:
			if(mt.fangxiang==0||mt.fangxiang==2)
			{
				if(this.y<=mt.y+30&&this.y>=mt.y&&this.x>=mt.x&&this.x<=mt.x+20)
				    return true;
				if(this.x+20>=mt.x&&this.x+20<=mt.x+20&&this.y>=mt.y&&this.y<=mt.y+30)
					return true;
			}
			else if(mt.fangxiang==1||mt.fangxiang==3)
			{
				if(this.x<=mt.x+30&&this.x>=mt.x&&this.y>=mt.y&&this.y<=mt.y+20)
					return true;
				if(this.x+20<=mt.x+30&&this.x+20>=mt.x&&this.y>=mt.y&&this.y<=mt.y+20)
					return true;
			}
			break;
		case 1:
			if(mt.fangxiang==0||mt.fangxiang==2)
			{
				if(this.y<=mt.y+30&&this.y>=mt.y&&this.x>=mt.x&&this.x<=mt.x+20)
					return true;
				if(this.y+20<=mt.y+30&&this.y+20>=mt.y&&this.x>=mt.x&&this.x<=mt.x+20)
					return true;
			}
			else if(mt.fangxiang==1||mt.fangxiang==3)
			{
				if(this.y<=mt.y+20&&this.y>=mt.y&&this.x>=mt.x&&this.x<=mt.x+30)
					return true;
				if(this.y+20<=mt.y+20&&this.y+20>=mt.y&&this.x>=mt.x&&this.x<=mt.x+30)
					return true;
			}
			break;
		case 2:
			if(mt.fangxiang==0||mt.fangxiang==2)
			{
				if(this.y+30>=mt.y&&this.y+30<=mt.y+30&&this.x>=mt.x&&this.x<=mt.x+20)
					return true;
				if(this.y+30>=mt.y&&this.y+30<=mt.y+30&&this.x+20>=mt.x&&this.x+20<=mt.x+20)
					return true;
			}
			else if(mt.fangxiang==1||mt.fangxiang==3)
			{
				if(this.y+30>=mt.y&&this.y+30<=mt.y+20&&this.x>=mt.x&&this.x<=mt.x+30)
					return true;
				if(this.y+30>=mt.y&&this.y+30<=mt.y+20&&this.x+20>=mt.x&&this.x+20<=mt.x+20)
					return true;
			}
			break;
		case 3:
			if(mt.fangxiang==0||mt.fangxiang==2)
			{
				if(this.y>=mt.y&&this.y<=mt.y+30&&this.x+30>=mt.x&&this.x+30<=mt.x+20)
					return true;
				if(this.y+20>=mt.y&&this.y+20<=mt.y+30&&this.x+30>=mt.x&&this.x+30<=mt.x+20)
				    return true;
			}
			else if(mt.fangxiang==1||mt.fangxiang==3)
			{
				if(this.y>=mt.y&&this.y<=mt.y+20&&this.x+30>=mt.x&&this.x+30<=mt.x+30)
					return true;
				if(this.y+20>=mt.y&&this.y+20<=mt.y+20&&this.x+30>=mt.x&&this.x+30<=mt.x+30)
					return true;
			}
			break;
		}
		return b;
	}
	public boolean pengzhuang()
	{
		boolean b=false;
		
		switch(this.fangxiang)
		{
		case 0:
			for(int i=0;i<dtk1.size();i++)
			{
				EnemyTank dt=dtk1.get(i);
				//System.out.println(dt.getX()+" "+dt.getY());
				if(dt!=this)
				{
					if(dt.fangxiang==0||dt.fangxiang==2)
					{
						if(this.y<=dt.y+30&&this.y>=dt.y&&this.x>=dt.x&&this.x<=dt.x+20)
							return true;
						if(this.x+20>=dt.x&&this.x+20<=dt.x+20&&this.y>=dt.y&&this.y<=dt.y+30)
							return true;
					}
					else if(dt.fangxiang==1||dt.fangxiang==3)
					{
						if(this.x>=dt.x&&this.x<=dt.x+30&&this.y>=dt.y&&this.y<=dt.y+20)
							return true;
						if(this.x+20>=dt.x&&this.x+20<=dt.x+30&&this.y>=dt.y&&this.y<=dt.y+20)
							return true;
					}
				}
			}
			break;
		case 1:
			for(int i=0;i<dtk1.size();i++)
			{
				EnemyTank dt=dtk1.get(i);
				if(dt!=this)
				{
					if(dt.fangxiang==0||dt.fangxiang==2)
					{
						if(this.x>=dt.x&&this.x<=dt.x+20&&this.y>=dt.y&&this.y<=dt.y+30)
							return true;
						if(this.x>=dt.x&&this.x<=dt.x+20&&this.y+20>=dt.y&&this.y+20<=dt.y+30)
							return true;
					}
					else if(dt.fangxiang==1||dt.fangxiang==3)
					{
						if(this.x>=dt.x&&this.x<=dt.x+30&&this.y>=dt.y&&this.y<=dt.y+20)
							return true;
						if(this.x>=dt.x&&this.x<=dt.x+30&&this.y+20>=dt.y&&this.y+20<=dt.y+20)
							return true;
					}
				}
			}
			break;
		case 2:
			for(int i=0;i<dtk1.size();i++)
			{
				EnemyTank dt=dtk1.get(i);
				if(dt!=this)
				{
					if(dt.fangxiang==0||dt.fangxiang==2)
					{
						if(this.x>=dt.x&&this.x<=dt.x+20&&this.y+30>=dt.y&&this.y<=dt.y+30)
							return true;
						if(this.x+20>=dt.x&&this.x+20<=dt.x+20&&this.y+30>=dt.y&&this.y+30<=dt.y+30)
							return true;
					}
					if(dt.fangxiang==1||dt.fangxiang==3)
					{
						if(this.x>=dt.x&&this.x<=dt.x+30&&this.y+30>=dt.y&&this.y+30<=dt.y+20)
							return true;
						if(this.x+20>=dt.x&&this.x+20<=dt.x+30&&this.y+30>=dt.y&&this.y+30<=dt.y+20)
							return true;
					}
				}
			}
			break;
		case 3:
			for(int i=0;i<dtk1.size();i++)
			{
				EnemyTank dt=dtk1.get(i);
				if(dt!=this)
				{
					if(dt.fangxiang==0||dt.fangxiang==2)
					{
						if(this.x+30>=dt.x&&this.x+30<=dt.x+20&&this.y>=dt.y&&this.y<=dt.y+30)
							return true;
						if(this.x+30>=dt.x&&this.x+30<=dt.x+20&&this.y+20>=dt.y&&this.y+20<=dt.y+30)
							return true;
					}
					if(dt.fangxiang==1||dt.fangxiang==3)
					{
						if(this.x+30>=dt.x&&this.x+30<=dt.x+30&&this.y>=dt.y&&this.y<=dt.y+20)
							return true;
						if(this.x+30>=dt.x&&this.x+30<=dt.x+30&&this.y+20>=dt.y&&this.y+20<=dt.y+20)
							return true;
					}
				}
			}
			break;
		}
		return b;
	}
	public void run()
	{
		while(true)
		{
			switch(this.fangxiang)
			{
			case 0:
				for(int i=0;i<30;i++)
				{
					if(y>0&&!pengzhuang()&&!pengzhuang2())
					{
						y-=sudu;
						try{
							Thread.sleep(50);
						}catch(Exception e){}
					}
				}
				break;
			case 1:
				for(int i=0;i<30;i++)
				{
					if(x>0&&!pengzhuang()&&!pengzhuang2())
					{
						x-=sudu;
						try{
							Thread.sleep(50);
						}catch(Exception e){}
					}
				}
				break;
			case 2:
				for(int i=0;i<30;i++)
				{
					if(y<270&&!pengzhuang()&&!pengzhuang2())
					{
						y+=sudu;
						try{
							Thread.sleep(50);
						}catch(Exception e){}
					}
				}
				break;
			case 3:
				for(int i=0;i<30;i++)
				{
					if(x<370&&!pengzhuang()&&!pengzhuang2())
					{
						x+=sudu;
						try{
							Thread.sleep(50);
						}catch(Exception e){}
					}
				}
				break;
			}
			this.fangxiang=(int)(Math.random()*4);
			
			if(this.shengming==false)
			{
				break;
			}
			this.time++;
			
			if(time%2==0)
			{
				if(this.shengming)
				{
					if(dzd.size()<5)
					{
						bullet ezd=null;
						
						switch(fangxiang)
						{
						case 0:
							ezd=new bullet(x,y,0);
							dzd.add(ezd);
							break;
						case 1:
							ezd=new bullet(x-2,y+10,1);
							dzd.add(ezd);
							break;
						case 2:
							ezd=new bullet(x+10,y+32,2);
						    dzd.add(ezd);
						    break;
						case 3:
							ezd=new bullet(x+32,y+10,3);
							dzd.add(ezd);
							break;
						}
						Thread t5=new Thread(ezd);
						t5.start();
					}
				}
			}
		}
	}
}
class MyTank extends Tank
{
	int zidannum=2;
	boolean flagA=false,flagD=false,flagS=false,flagW=false;
	boolean fire=false;
	Vector<bullet> aa=new Vector<bullet>(zidannum);
	Vector<EnemyTank> dtk=new Vector<EnemyTank>();
	bullet zd=null;
	
	public MyTank(int x,int y)
	{
		super(x,y);
	}
	public void Setdtk(Vector<EnemyTank> dtk)
	{
		this.dtk=dtk;
	}
	public boolean pengzhuang1()
	{
        boolean b=false;
		
		switch(this.fangxiang)
		{
		case 0:
			for(int i=0;i<dtk.size();i++)
			{
				EnemyTank dt=dtk.get(i);
				if(this.shengming&&dt.shengming)
				{
					if(dt.fangxiang==0||dt.fangxiang==2)
					{
						if(this.y<=dt.y+30&&this.y>=dt.y&&this.x>=dt.x&&this.x<=dt.x+20)
							return true;
						if(this.x+20>=dt.x&&this.x+20<=dt.x+20&&this.y>=dt.y&&this.y<=dt.y+30)
							return true;
					}
					else if(dt.fangxiang==1||dt.fangxiang==3)
					{
						if(this.x>=dt.x&&this.x<=dt.x+30&&this.y>=dt.y&&this.y<=dt.y+20)
							return true;
						if(this.x+20>=dt.x&&this.x+20<=dt.x+30&&this.y>=dt.y&&this.y<=dt.y+20)
							return true;
					}
				}
			}
			break;
		case 1:
			for(int i=0;i<dtk.size();i++)
			{
				EnemyTank dt=dtk.get(i);
				if(this.shengming&&dt.shengming)
				{
					if(dt.fangxiang==0||dt.fangxiang==2)
					{
						if(this.x>=dt.x&&this.x<=dt.x+20&&this.y>=dt.y&&this.y<=dt.y+30)
							return true;
						if(this.x>=dt.x&&this.x<=dt.x+20&&this.y+20>=dt.y&&this.y+20<=dt.y+30)
							return true;
					}
					else if(dt.fangxiang==1||dt.fangxiang==3)
					{
						if(this.x>=dt.x&&this.x<=dt.x+30&&this.y>=dt.y&&this.y<=dt.y+20)
							return true;
						if(this.x>=dt.x&&this.x<=dt.x+30&&this.y+20>=dt.y&&this.y+20<=dt.y+20)
							return true;
					}
				}
			}
			break;
		case 2:
			for(int i=0;i<dtk.size();i++)
			{
				EnemyTank dt=dtk.get(i);
				if(this.shengming&&dt.shengming)
				{
					if(dt.fangxiang==0||dt.fangxiang==2)
					{
						if(this.x>=dt.x&&this.x<=dt.x+20&&this.y+30>=dt.y&&this.y<=dt.y+30)
							return true;
						if(this.x+20>=dt.x&&this.x+20<=dt.x+20&&this.y+30>=dt.y&&this.y+30<=dt.y+30)
							return true;
					}
					if(dt.fangxiang==1||dt.fangxiang==3)
					{
						if(this.x>=dt.x&&this.x<=dt.x+30&&this.y+30>=dt.y&&this.y+30<=dt.y+20)
							return true;
						if(this.x+20>=dt.x&&this.x+20<=dt.x+30&&this.y+30>=dt.y&&this.y+30<=dt.y+20)
							return true;
					}
				}
			}
			break;
		case 3:
			for(int i=0;i<dtk.size();i++)
			{
				EnemyTank dt=dtk.get(i);
				if(this.shengming&&dt.shengming)
				{
					if(dt.fangxiang==0||dt.fangxiang==2)
					{
						if(this.x+30>=dt.x&&this.x+30<=dt.x+20&&this.y>=dt.y&&this.y<=dt.y+30)
							return true;
						if(this.x+30>=dt.x&&this.x+30<=dt.x+20&&this.y+20>=dt.y&&this.y+20<=dt.y+30)
							return true;
					}
					if(dt.fangxiang==1||dt.fangxiang==3)
					{
						if(this.x+30>=dt.x&&this.x+30<=dt.x+30&&this.y>=dt.y&&this.y<=dt.y+20)
							return true;
						if(this.x+30>=dt.x&&this.x+30<=dt.x+30&&this.y+20>=dt.y&&this.y+20<=dt.y+20)
							return true;
					}
				}
			}
			break;
		}
		return b;
	}
	public void xiangshang()
	{
		 y-=sudu;
	}
	public void xiangxia()
	{
		 y+=sudu;
	}
	public void xiangzuo()
	{
		 x-=sudu;
	}
	public void xiangyou()
	{
		 x+=sudu;
	}
	public void fsbullet()
	{
		if(fire==true)
		{
			switch(fangxiang)
			{
			case 0:
				
				zd=new bullet(x+10,y-2,0);
				if(aa.size()<zidannum)
				    aa.add(zd);
				break;
			case 1:
				zd=new bullet(x-2,y+10,1);
				if(aa.size()<zidannum)
				    aa.add(zd);
				break;
			case 2:
				zd=new bullet(x+10,y+32,2);
				if(aa.size()<zidannum)
				    aa.add(zd);
				break;
			case 3:
				zd=new bullet(x+32,y+10,3);
				if(aa.size()<zidannum)
				    aa.add(zd);
				break;
			}
			Thread t=new Thread(zd);
			t.start();
		}
		fire=false;
	}
}
class bullet implements Runnable
{
	int x;
	int y;
	int fangxiang;
	int sudu=1;
	boolean shengming=true;
	
	public bullet(int x,int y,int fangxiang)
	{
		this.x=x;
		this.y=y;
		this.fangxiang=fangxiang;
	}
	public void run()
	{
		while(true)
		{
			try{
				Thread.sleep(5);
			}catch(Exception e){}
			
			switch(fangxiang)
			{
			case 0:
				y-=sudu;
				break;
			case 1:
				x-=sudu;
				break;
			case 2:
				y+=sudu;
				break;
			case 3:
				x+=sudu;
				break;
			}
			if(x<0||x>400||y>300||y<0)
			{
				shengming=false;
				break;
			}
		}
	}
}
class Jilu
{
	private static int dtsl=10;
	private static int mtsl=2;
	private static int sdtj=0;
	static int time=0;
	private static FileWriter writer;
	private static BufferedWriter buffer1;
	private static FileReader reader;
	private static BufferedReader buffer2;
	private static Vector<EnemyTank> dtk1=new Vector<EnemyTank>();
	static EnemyTank dt=null;
	static Vector<Weizhi> wzjh=new Vector<Weizhi>();
	
	public Vector<EnemyTank> getdtk()
	{
		return dtk1;
	}
	public static void Setdtk(Vector<EnemyTank> dtk)
	{
		dtk1=dtk;
	}
	public static void cundan()
	{
		try{
		    writer=new FileWriter("e:/test.txt");
		    buffer1=new BufferedWriter(writer);
		    String a;
		    a=sdtj+" "+dtsl+" "+mtsl+" "+dt.sudu+" ";
		    buffer1.write(a);
		    for(int i=0;i<dtk1.size();i++)
		    {
		    	EnemyTank dt=dtk1.get(i);
		    	if(dt.shengming)
		    	{
		    		String ss=null;
		    		ss=dt.x+" "+dt.y+" "+dt.fangxiang;
		    		ss=ss+" ";
		    		buffer1.write(ss);
		    	}
		    	buffer1.flush();
		    }
		    buffer1.flush();
		}catch(Exception e){
			System.out.println("³öÏÖ´íÎó");
		}
		finally
		{
			try{
				buffer1.close();
				writer.close();
			}catch(Exception e)
			{
				
			}
		}
	}
	public static Vector<Weizhi> dupan()
	{
		Weizhi wz;
		try{
			reader=new FileReader("e:/test.txt");
			buffer2=new BufferedReader(reader);
			String s=buffer2.readLine();
			String sz[]=s.split(" ");
			sdtj=Integer.parseInt(sz[0]);
			dtsl=Integer.parseInt(sz[1]);
			mtsl=Integer.parseInt(sz[2]);
			dt.sudu=Integer.parseInt(sz[3]);
			for(int i=4;i<sz.length;i=i+3)
			{
				wz=new Weizhi(Integer.parseInt(sz[i]),Integer.parseInt(sz[i+1]),Integer.parseInt(sz[i+2]));
				wzjh.add(wz);
			}
		}catch(Exception e)
		{
			
		}
		return wzjh;
	}
	public static void bcjl()
	{
		try{
		    writer=new FileWriter("e:/test.txt");
		    buffer1=new BufferedWriter(writer);
		    String a;
		    a=sdtj+" ";
		    buffer1.write(a);
		    buffer1.flush();
		}catch(Exception e){}
		finally
		{
			try{
				writer.close();
				buffer1.close();
			}catch(Exception e)
			{
				
			}
		}
	}
	public static void dqjl()
	{
		try{
			reader=new FileReader("e:/test.txt");
			buffer2=new BufferedReader(reader);
			String a=buffer2.readLine();
			String sz[]=a.split(" ");
			sdtj=Integer.parseInt(sz[0]);
		}catch(Exception e)
		{
			
		}
	}
	public static int getSdtj()
	{
		return sdtj;
	}
	public static void setSdtj(int sdtj)
	{
		Jilu.sdtj=sdtj;
	}
	public static int getDtsl() {
		return dtsl;
	}
	public static void setDtsl(int dtsl) {
		Jilu.dtsl = dtsl;
	}
	public static int getMtsl() {
		return mtsl;
	}
	public static void setMtsl(int mtsl) {
		Jilu.mtsl = mtsl;
	}
	public static void dtjs()
	{
		dtsl--;
		time++;
		if(time%2==0)
		{
			dt.sudu++;
		}
	}
	public static void sdsl()
	{
		sdtj++;
	}
	public static void mtjs()
	{
		mtsl--;
	}
}
class Weizhi
{
	int x;
	int y;
	int fangxiang;
	public Weizhi(int x,int y,int fangxiang)
	{
		this.x=x;
		this.y=y;
		this.fangxiang=fangxiang;
	}
}
class music extends Thread
{
	private String wjm;
	public music(String ypwj)
	{
		wjm=ypwj;
	}
	public void run()
	{
		File wjl=new File(wjm);
		AudioInputStream ypsrl=null;
		try{
			ypsrl=AudioSystem.getAudioInputStream(wjl);
		}catch(Exception e){}
		AudioFormat format=ypsrl.getFormat();
		SourceDataLine aqsj=null;
		DataLine.Info info=new DataLine.Info(SourceDataLine.class,format);
		try{
			aqsj=(SourceDataLine)AudioSystem.getLine(info);
			aqsj.open(format,aqsj.getBufferSize());
		}catch(Exception e){}
		aqsj.start();
		int zjtj=0;
		byte[] hczj=new byte[1024];
		try{
			while(zjtj!=-1)
			{
				zjtj=ypsrl.read(hczj,0,hczj.length);
				if(zjtj>=0)
				   aqsj.write(hczj,0,zjtj);
			}
		}catch(Exception e){}
		finally
		{
			aqsj.drain();
			aqsj.close();
		}
	}
}