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
				System.out.println("请你输入你想选择单品的编号，如果不想点餐请输入-1");
			else
				System.out.println("如果你想继续点餐请继续输入编号，如果不想点餐请输入-1");
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
				System.out.println("请你输入你想选择套餐的编号，如果不想点餐请输入-1");
			else
				System.out.println("如果你想继续点餐请继续输入编号，如果不想点餐请输入-1");
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
		 	System.out.println("抱歉我们的服务没有得到您的满意，我们会继续努力");
		else	
		{
			int j ;
			String[]name =new String[2];
			String email;
			System.out.println("请问你是否有KFC会员（有的话请输入1，没有的话请输入0)");
			j = input.nextInt();
			if(j==0)
			{
				System.out.println("你是否愿意加入我们KFC会员（愿意请输入1,不愿意请输入0)");
				j=input.nextInt();
				if(j==1)
				{
					System.out.println("请输入你的名字和姓氏");
					name[0]=input.next();
					name[1]=input.next();
					System.out.println("请输入你的电子邮件或电话号码");
					email = input.next();
					System.out.println("你的电子邮件或电话号码为:"+email);
					System.out.println("恭喜你！"+name[1]+name[0]+"先生/女士，你成为我们KFC的会员,我们稍后会将您的会员号码发送到您的电子邮箱或手机号码");
					System.out.println("你的会员号码是"+(long)(Math.random()*1000+1000000));
				}
			}
			System.out.println("您的消费票据为");
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
				System.out.println("套餐"+o1.d[q].name+"   "+o1.d[q].price);
			}
			System.out.println("总计"+money+"元"+"                       "+date.toString()             );
			System.out.println("你本次消费"+money+"元，你想要怎么支付，1现金，2会员");
			j = input.nextInt();
			System.out.println("支付成功，感谢您的光临，欢迎下次光临");
		}
	}
	public void eat()
	{
		Scanner input = new Scanner(System.in);
		int i = 0;
		System.out.println("你想在KFC中用餐吗(如果想请输入1，不想则输入0)");
		i = input.nextInt(); 
		if(i == 1)
			System.out.println("请你前往用餐区域" + (int)(Math.random()*20) + "座就餐");
		else
			System.out.println("请稍等，马上为你打包");
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
	
	Food f1 = new Food(1,"香辣鸡腿堡",25);;
	Food f2 = new Food(2,"奥尔良烤翅",10);
	Food f3 = new Food(3,"上校鸡块",10);
	Food f4 = new Food(4,"吮指原味鸡",9.9);
	Food f5 = new Food(5,"可乐",8);
	Food f6 = new Food(6,"甜牛奶",7);
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
		System.out.println("欢迎光临KFC，希望您用餐愉快！");
		System.out.println();
		System.out.println("            菜单            ");
		System.out.println("单品         ");
		System.out.println("序号          名称               价格  ");
	}
	public void printTitle2()
	{
		System.out.println("            菜单            ");
		System.out.println("套餐    ");
		System.out.println("序号            内容             价格");
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




