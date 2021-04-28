package project;

import java.util.*;

public class KfcPriceChange {
	Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		long j;
		
		System.out.println("请输入密码");
		j = input.nextLong();
		while(j!=123456) {
			System.out.println("对不起，密码错误,请重新输入");
			j = input.nextLong();
			if(j==123456)
			{
				break;
			}
		};
		if(j==123456)
		{
			KfcPriceChange o = new KfcPriceChange();
			o.changeFood();
			System.out.println("更改完毕");
			System.out.println("你是否要查询报告（查询请输入1，不查询请输入-1)");
			j = input.nextInt();
			if(j==-1)
			{
				System.out.println("结束工作");
			}
			if(j==1)
			{
				o.baogao();
			}
		}
		
		input.close();
	}
	public void changeFood() 
	{
		OrderList o = new OrderList();
		o.printFood();
		for(int i = 0,j=7;;i++,j++)
		{	
			System.out.println("请问你要增加产品？(增加请输入1，不增加请输入-1)");
			int s;
			s = input.nextInt();
			if(s==1)
			{
				System.out.println("请输入你要增加产品的名字");
				String a;
				a=input.next();
				System.out.println("请输入你要增加产品的价格");
				double b;
				b = input.nextDouble();
				o.add[i]=new Food(j,a,b);
			}
			if(s==-1) {
				break;
			}
		}
		o.printFood();
		for(;;)
		{
			System.out.println("请问你要减少产品？(减少请输入1，不减少请输入-1)");
			int s;
			s = input.nextInt();
			if(s==1)
			{
				System.out.println("请输入你要减少产品的序号");
				int a;
				a=input.nextInt();
				if(a<=6) 
				{
					while(a<6)
					{
						if(o.a[a]==null) {
							o.a[a-1]=null;
							break;
						}
						o.a[a-1]=o.a[a];
						o.a[a-1].name1-=1;
						a++;
					}
					
					if(o.add[0]!=null) {
						o.a[5]=o.add[0];
						o.a[5].name1-=1;
					}
					if(o.add[0]==null)
					{
						o.a[5]=null;
					}
					for(int j = 1;;)
					{
						if(o.add[j]!=null)
						{
							o.add[j-1]=o.add[j];
							o.add[j-1].name1-=1;
						}
						if(o.add[j]==null)
						{
							o.add[j-1]=null;
							break;
						}
						j++;
					}
				}
				else
				{
						if(a==7&&o.add[1]==null)
						{
							o.add[0]=null;
						}
						for(;;a++)
						{
							if(o.add[a-6]==null)
							{
								o.add[a-7]=null;
								break;
							}
							o.add[a-7]=o.add[a-6];
							o.add[a-7].name1-=1;
							
						}
				}
			}
			if(s==-1)
			{
				break;
			}
			o.printFood();
		}
		o.printFood();
		for(;;)
		{
			System.out.println("请问你要更改那个产品的价格(请输入序号,不更改请输入-1)");
			int i ;
			i = input.nextInt();
			if(i==-1)
			{
				break;
			}
			double price=0;
			System.out.println("请输入你要更改的价格");
			price = input.nextDouble();
			if(i<=6) {
			o.a[i-1].setPrice(price);}
			if(i>6)
			{
				o.add[i-7].setPrice(price);
			}
			o.printFood();
			if(i==-1)
			{
				break;
			}
		}
	}
	public void baogao() {
		System.out.println("|    产品    |  数量  |  价格总计  |  评价  |");
		System.out.println("  香辣鸡腿堡" +        "    "+(int)(Math.random()*100)+"         "+(int)(Math.random()*100) +"  "+ "          无               ");
		System.out.println("  奥尔良烤翅" +         "    "+(int)(Math.random()*100)+"         "+(int)(Math.random()*100)   +"  "+  "         无            ");
		System.out.println("  上校鸡块 "  +         "      "+(int)(Math.random()*100)+"        "+(int)(Math.random()*100)+"  "+ "          无"       );   
		System.out.println("  吮指原味鸡"  +           "     "+(int)(Math.random()*100)+"        "+(int)(Math.random()*100) +"            无               ");
		System.out.println("    可乐     "  +     "   "+(int)(Math.random()*100)+"         "+(int)(Math.random()*100)+ "        "+"   无               ");  
		System.out.println("    甜牛奶    "+       "   "+(int)(Math.random()*100)+"        "+(int)(Math.random()*100)+ "        "+"   无               "); 	
	}
}
