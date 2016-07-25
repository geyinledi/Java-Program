package T1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Tank1 extends JFrame implements ActionListener
{
	MyPanel mp=null;
	GkPanel gkmp=null;
	JMenuBar bar=null;
	JMenu b=null;
	JMenuItem item=null,item2=null,item3=null,item4=null;
	
	public static void main(String[] args) 
	{
		Tank1 t1=new Tank1();
	}

	public Tank1()
	{
		gkmp=new GkPanel();
		bar=new JMenuBar();
		b=new JMenu("游戏(G)");
		b.setMnemonic('G');
		item=new JMenuItem("开始新游戏(N)");
		item.setMnemonic('N');
		item2=new JMenuItem("退出游戏(E)");
		item2.setMnemonic('E');
		item3=new JMenuItem("存盘退出(C)");
		item3.setMnemonic('C');
		item4=new JMenuItem("继续游戏(S)");
		item4.setMnemonic('S');
		
		item.addActionListener(this);
		item.setActionCommand("xyx");
		item2.addActionListener(this);
		item2.setActionCommand("退出");
		item3.addActionListener(this);
		item3.setActionCommand("cunpan");
		item4.addActionListener(this);
		item4.setActionCommand("jixu");
		
		b.add(item); b.add(item2); b.add(item3); b.add(item4);
		bar.add(b);
		this.setJMenuBar(bar);
		this.add(gkmp);
		Thread t=new Thread(gkmp);
		t.start();
		
		this.setTitle("坦克大战");
		this.setSize(600,500);
		this.setLocation(300,280);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("xyx"))
		{
			mp=new MyPanel("xyx");
			this.add(mp);
			this.remove(gkmp);
			this.addKeyListener(mp);
			Thread t1=new Thread(mp);
			t1.start();
			this.setVisible(true);
		}
		else if(e.getActionCommand().equals("退出"))
		{
			Jilu.bcjl();
			System.exit(0);
		}
		else if(e.getActionCommand().equals("cunpan"))
		{
			Jilu jl=new Jilu();
			jl.Setdtk(mp.dtk);
			Jilu.cundan();
			System.exit(0);
		}
		else if(e.getActionCommand().equals("jixu"))
		{
			mp=new MyPanel("jixu");
			this.add(mp);
			this.remove(gkmp);
			this.addKeyListener(mp);
			Thread t1=new Thread(mp);
			t1.start();
			this.setVisible(true);
		}
	}
}
class GkPanel extends JPanel implements Runnable
{
	int times=0;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		if(times%2==0)
		{
			g.setColor(Color.yellow);
			g.setFont(new Font("宋体",Font.BOLD,38));
			g.drawString("第1关", 150, 132);
		}
	}
	public void run()
	{
		while(true)
		{
			try{
				Thread.sleep(600);
			}catch(Exception e){}
			this.times++;
			this.repaint();
		}
	}
}

class MyPanel extends JPanel implements KeyListener,Runnable
{
	MyTank mt;
	Vector<Weizhi> wz=new Vector<Weizhi>();
	Weizhi w=null;
	Vector<EnemyTank> dtk=new Vector<EnemyTank>();
	int dtksl=3;
	
	public MyPanel(String s)
	{
		mt=new MyTank(160,270);
		if(s.equals("xyx"))
		{
			Jilu.dqjl();
			for(int i=0;i<dtksl;i++)
			{
				EnemyTank dk=new EnemyTank((i)*185+5,0);
				dk.setFangxiang(2);
				Thread t=new Thread(dk);
				t.start();
				bullet zd=new bullet(dk.x+10,dk.y+32,2);
				dk.dzd.add(zd);
				dk.setmt(mt);
				Thread t3=new Thread(zd);
				t3.start();
				dtk.add(dk);
				mt.Setdtk(dtk);
			}
			
		}
		else if(s.equals("jixu"))
		{
			wz=Jilu.dupan();
			for(int i=0;i<wz.size();i++)
			{
				w=wz.get(i);
				System.out.println(w.x+" "+w.y+" "+w.fangxiang);
				EnemyTank dk=new EnemyTank(w.x,w.y);
				dk.setFangxiang(w.fangxiang);
				Thread t=new Thread(dk);
				t.start();
				bullet zd=new bullet(dk.x+10,dk.y+32,2);
				dk.dzd.add(zd);
				dk.setmt(mt);
				Thread t3=new Thread(zd);
				t3.start();
				dtk.add(dk);
				mt.Setdtk(dtk);
			}
		}
		music mc=new music("./游戏原声-FC《坦克大战》战前BGM.wav");
		mc.start();
	}
	
	public void jzwf(bullet zd,MyTank mt)
	{
		switch(mt.fangxiang)
		{
		case 0:
		case 2:
			 if(zd.x<mt.getX()+20&&zd.x>mt.getX()&&zd.y>mt.getY()&&zd.y<mt.getY()+30)
			 {
				 zd.shengming=false;
				 mt.shengming=false;
				 Jilu.mtjs();
				 mt.setX(160);
				 mt.setY(270);
				 mt.setFangxiang(0);
				 mt.shengming=false;
				 mt.aa=new Vector<bullet>(mt.zidannum);
			 }
		case 1:
		case 3:
			if(zd.x>mt.getX()&&zd.x<mt.getX()+30&&zd.y>mt.getY()&&zd.y<mt.getY()+20)
			{
				zd.shengming=false;
				mt.shengming=false;
				Jilu.mtjs();
				mt.setX(160);
			    mt.setY(270);
			    mt.setFangxiang(0);
			    mt.shengming=false;
			    mt.aa=new Vector<bullet>(mt.zidannum);
			}
		}
	}
	public void jzdf(bullet zd,Tank dt)
	{
		switch(dt.fangxiang)
		{
		case 0:
		case 2:
			if(zd.x<dt.getX()+20&&zd.x>dt.getX()&&zd.y>dt.getY()&&zd.y<dt.getY()+30)
			{
				zd.shengming=false;
				dt.shengming=false;
				Jilu.dtjs();
				Jilu.sdsl();
				dtk.remove(dt);
			}
			break;
		case 1:
		case 3:
			if(zd.x>dt.getX()&&zd.x<dt.getX()+30&&zd.y>dt.getY()&&zd.y<dt.getY()+20)
			{
				zd.shengming=false;
				dt.shengming=false;
				Jilu.dtjs();
				Jilu.sdsl();
				dtk.remove(dt);
			}
			break;
		}
	}
	public void tjsj(Graphics g)
	{
		this.drawTank(95,330,g,0,0);
		g.setColor(Color.black);
		g.drawString(Jilu.getMtsl()+"",126,345);
		this.drawTank(205, 330, g, 0, 1);
		g.setColor(Color.black);
		g.drawString(Jilu.getDtsl()+"",236,345);
		this.drawTank(450,150,g,0,1);
		g.setColor(Color.black);
		g.setFont(new Font("宋体",Font.BOLD,28));
		g.drawString("消灭敌坦总数", 410, 120);
		g.drawString(Jilu.getSdtj()+"", 485, 175);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		if(mt.shengming)
		    this.drawTank(mt.getX(), mt.getY(), g, mt.fangxiang, 0);
		this.tjsj(g);
		for(int i=0;i<mt.aa.size();i++)
		{
			bullet zd=mt.aa.get(i);
			if(zd.shengming)
			{
				for(int j=0;j<dtk.size();j++)
				{
					EnemyTank dt=dtk.get(j);
					if(dt.shengming)
					{
						this.jzdf(zd,dt);
					}
				}
			}
			this.repaint();
		}
		for(int i=0;i<dtk.size();i++)
		{
			EnemyTank d=dtk.get(i);
			for(int j=0;j<d.dzd.size();j++)
			{
				bullet zd=d.dzd.get(j);
				if(zd.shengming&&mt.shengming)
				{
					this.jzwf(zd,mt);
				}
			}
			this.repaint();
		}
		for(int i=0;i<dtk.size();i++)
		{
			EnemyTank dt=dtk.get(i);
			for(int j=0;j<dt.dzd.size();j++)
			{
				if(dt.dzd.get(j).shengming&&dt.dzd.get(j)!=null)
				{
					g.setColor(Color.white);
				    g.fill3DRect(dt.dzd.get(j).x, dt.dzd.get(j).y, 3, 3, false);
				}
				if(dt.dzd.get(j).shengming==false)
					dt.dzd.remove(j);
			}
		}
		for(int i=0;i<dtk.size();i++)
		{
			EnemyTank dt1=dtk.get(i);
			dt1.dtkxl(dtk);
			if(dt1.shengming)
			     this.drawTank(dt1.getX(), dt1.getY(), g, dt1.fangxiang, 1);
		}
		if(mt.shengming==false)
		{
			if(Jilu.getMtsl()==1)
				mt.shengming=true;
		}
		while(dtk.size()<3&&3<=Jilu.getDtsl())
		{
			dtksl++;
			EnemyTank dt=new EnemyTank((dtksl%3)*185+5,0);
			dt.setFangxiang(2);
			Thread t=new Thread(dt);
			t.start();
			bullet zd=new bullet(dt.x+10,dt.y+32,2);
			dt.dzd.add(zd);
			dt.setmt(mt);
			Thread t3=new Thread(zd);
			t3.start();
			dtk.add(dt);
		}
		for(int i=0;i<mt.aa.size();i++)
		{
			if(mt.aa.get(i)!=null&&mt.aa.get(i).shengming)
			{
				g.setColor(Color.white);
			    g.fill3DRect(mt.aa.get(i).x, mt.aa.get(i).y, 3, 3, false);
			} 
			if(mt.aa.get(i).shengming==false)
			{
				mt.aa.remove(i);
			}
		}
	}
	public void drawTank(int x,int y,Graphics g,int fangxiang,int leixing)
	{
		switch(leixing)
		{
		case 0:
			g.setColor(Color.yellow);
			break;
		case 1:
			g.setColor(Color.green);
			break;
		}
		switch(fangxiang)
		{
		case 0:
			g.fill3DRect(x,y,5,30,false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fillOval(x+7, y+12, 6, 6);
			g.drawLine(x+10, y+15, x+10, y-2);
			break;
		case 1:
			g.fill3DRect(x, y, 30, 5,false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fill3DRect(x,y+15, 30, 5, false);
			g.fillOval(x+12, y+7, 6, 6);
			g.drawLine(x+15, y+10, x-2, y+10);
			break;
		case 2:
			g.fill3DRect(x,y,5,30,false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fillOval(x+7, y+12, 6, 6);
			g.drawLine(x+10,y+15,x+10,y+32);
			break;
		case 3:
			g.fill3DRect(x, y, 30, 5,false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fill3DRect(x,y+15, 30, 5, false);
			g.fillOval(x+12, y+7, 6, 6);
			g.drawLine(x+15, y+10, x+32, y+10);
			break;
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			mt.flagW=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_S)
		{
			mt.flagS=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_A)
		{
			mt.flagA=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_D)
		{
			mt.flagD=false;
		}
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			if(mt.y>0&&mt.shengming&&!mt.pengzhuang1())
			{
				this.mt.setFangxiang(0);
				this.mt.xiangshang();
			}
			mt.flagW=true;
		}
		else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			if(mt.y<270&&mt.shengming&&!mt.pengzhuang1())
			{
				this.mt.setFangxiang(2);
				this.mt.xiangxia();
			}
			mt.flagS=true;
		}
		else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			if(mt.x>0&&mt.shengming&&!mt.pengzhuang1())
			{
				this.mt.setFangxiang(1);
				this.mt.xiangzuo();
			}
			mt.flagA=true;
		}
		else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			if(mt.x<370&&mt.shengming&&!mt.pengzhuang1())
			{
				this.mt.setFangxiang(3);
				this.mt.xiangyou();
			}
			mt.flagD=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_K)
		{
			if(mt.shengming)
			    mt.fsbullet();
			mt.fire=true;
		}
		this.repaint();
	}
	public void run()
	{
		int time=0;
		while(true)
		{
			try{
				Thread.sleep(100);
			}catch(Exception e)
			{
				
			}
			this.repaint();
		}
	}
}