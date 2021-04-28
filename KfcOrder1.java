package project;

import java.util.Scanner;
import java.util.Date;

public class KfcOrder1 {

	public static void main(String[] args) 
	{
		KfcOrder1 o = new KfcOrder1();
		Scanner input = new Scanner(System.in);
		Date date = new Date();
		int i = 0;
		int z=0,x=0;
		double totalmoney = 0;
		OrderList o1 = new OrderList();
		o1.printTitle1();
		o1.printFood();
		for(;;)
		{
			if(i==0)
				System.out.println("������������ѡ��Ʒ�ı�ţ����������������-1");
			else
				System.out.println("�����������������������ţ����������������-1");
			i = input.nextInt();
			if(i==-1)
			{
				break;
			}
			totalmoney+=o1.a[i-1].price;
			o1.c[z] = o1.a[i-1];
			z++;
		}
		i=0;
		o1.printTitle2();
		o1.printFoodPackage();
		for(;;)
		{
			if(i==0)
				System.out.println("������������ѡ���ײ͵ı�ţ����������������-1");
			else
				System.out.println("�����������������������ţ����������������-1");
			i = input.nextInt();
			if(i==-1)
			{
				
				break;
			}
			totalmoney+=o1.b[i-1].price;
			o1.d[x] = o1.b[i-1];
			x++;
		}
		double money;
		money = totalmoney;
		o.eat();
		if(money == 0)
		 	System.out.println("��Ǹ���ǵķ���û�еõ��������⣬���ǻ����Ŭ��");
		else	
		{
			int j ;
			String[]name =new String[2];
			String email;
			System.out.println("�������Ƿ���KFC��Ա���еĻ�������1��û�еĻ�������0)");
			j = input.nextInt();
			if(j==0)
			{
				System.out.println("���Ƿ�Ը���������KFC��Ա��Ը��������1,��Ը��������0)");
				j=input.nextInt();
				if(j==1)
				{
					System.out.println("������������ֺ�����");
					name[0]=input.next();
					name[1]=input.next();
					System.out.println("��������ĵ����ʼ���绰����");
					email = input.next();
					System.out.println("��ĵ����ʼ���绰����Ϊ:"+email);
					System.out.println("��ϲ�㣡"+name[1]+name[0]+"����/Ůʿ�����Ϊ����KFC�Ļ�Ա,�����Ժ�Ὣ���Ļ�Ա���뷢�͵����ĵ���������ֻ�����");
					System.out.println("��Ļ�Ա������"+(long)(Math.random()*1000+1000000));
				}
			}
			System.out.println("��������Ʊ��Ϊ");
			for(int q=0;;q++)
			{
				if(o1.c[q]==null)
				{
					break;
				}
				System.out.println(o1.c[q].name+"   "+o1.c[q].price);
			}
			for(int q=0;;q++)
			{
				if(o1.d[q]==null)
				{
					break;
				}
				System.out.println("�ײ�"+o1.d[q].name+"   "+o1.d[q].price);
			}
			System.out.println("�ܼ�"+money+"Ԫ"+"                       "+date.toString()             );
			System.out.println("�㱾������"+money+"Ԫ������Ҫ��ô֧����1�ֽ�2��Ա");
			j = input.nextInt();
			System.out.println("֧���ɹ�����л���Ĺ��٣���ӭ�´ι���");
		}
	}
	public void eat()
	{
		Scanner input = new Scanner(System.in);
		int i = 0;
		System.out.println("������KFC���ò���(�����������1������������0)");
		i = input.nextInt(); 
		if(i == 1)
			System.out.println("����ǰ���ò�����" + (int)(Math.random()*20) + "���Ͳ�");
		else
			System.out.println("���Եȣ�����Ϊ����");
	}
}
class Food{
	int name1;
	String name;
	double price;
	public Food()
	{
		
	}
	
	public Food(int name1,String name,double price) {
		this.name1=name1;
		this.name = name;
		this.price=price;
	}
	
	public void setPrice(double newprice)
	{
		price = newprice;
	}
}

class FoodPackage{
	int name;
	String food1,food2;
	double price;
	

	public FoodPackage(int name,String food1,String food2,double price1,double price2) {
		this.name=name;
		this.food1=food1;
		this.food2=food2;
		price=price1+price2;
	}
	
}

class OrderList
{
	
	Food f1 = new Food(1,"�������ȱ�",25);;
	Food f2 = new Food(2,"�¶�������",10);
	Food f3 = new Food(3,"��У����",10);
	Food f4 = new Food(4,"˱ָԭζ��",9.9);
	Food f5 = new Food(5,"����",8);
	Food f6 = new Food(6,"��ţ��",7);
	Food[]a = {f1,f2,f3,f4,f5,f6};
	FoodPackage fp1 = new FoodPackage(1,f1.name,f2.name,f1.price,f2.price);          
	FoodPackage fp2 = new FoodPackage(2,f2.name,f4.name,f2.price,f4.price);
	FoodPackage fp3 = new FoodPackage(3,f3.name,f4.name,f3.price,f4.price);	
	FoodPackage fp4 = new FoodPackage(4,f1.name,f5.name,f1.price,f5.price);
	FoodPackage[]b = {fp1,fp2,fp3,fp4};
	Food[]c = new Food[10];
	FoodPackage[]d = new FoodPackage[10];
	Food[]add = new Food[10];
	Food[]reduce = new Food[10];
	public void printTitle1()
	{
		System.out.println("��ӭ����KFC��ϣ�����ò���죡");
		System.out.println();
		System.out.println("            �˵�            ");
		System.out.println("��Ʒ         ");
		System.out.println("���          ����               �۸�  ");
	}
	public void printTitle2()
	{
		System.out.println("            �˵�            ");
		System.out.println("�ײ�    ");
		System.out.println("���            ����             �۸�");
	}
	public void printFood()
	{
		for(int i=0;i<6;i++)
		{
			if(a[i]!=null) {
			System.out.println(a[i].name1 +"            "+a[i].name+"         "+a[i].price  );
			}
		}	
		for(int i = 0;;i++) 
		{
		if(add[i]!=null)
			System.out.println(add[i].name1 +"           "+add[i].name+"        "+add[i].price);
		if(add[i]==null)
			break;
		}
	}
	public void printFoodPackage()
	{
		for(int i = 0;i<4;i++)
		{
			System.out.println(b[i].name+"     "+b[i].food1+" "+b[i].food2+"       "+b[i].price);
		}
	}
}




