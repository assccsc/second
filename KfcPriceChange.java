package project;

import java.util.*;

public class KfcPriceChange {
	Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		long j;
		
		System.out.println("����������");
		j = input.nextLong();
		while(j!=123456) {
			System.out.println("�Բ����������,����������");
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
			System.out.println("�������");
			System.out.println("���Ƿ�Ҫ��ѯ���棨��ѯ������1������ѯ������-1)");
			j = input.nextInt();
			if(j==-1)
			{
				System.out.println("��������");
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
			System.out.println("������Ҫ���Ӳ�Ʒ��(����������1��������������-1)");
			int s;
			s = input.nextInt();
			if(s==1)
			{
				System.out.println("��������Ҫ���Ӳ�Ʒ������");
				String a;
				a=input.next();
				System.out.println("��������Ҫ���Ӳ�Ʒ�ļ۸�");
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
			System.out.println("������Ҫ���ٲ�Ʒ��(����������1��������������-1)");
			int s;
			s = input.nextInt();
			if(s==1)
			{
				System.out.println("��������Ҫ���ٲ�Ʒ�����");
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
			System.out.println("������Ҫ�����Ǹ���Ʒ�ļ۸�(���������,������������-1)");
			int i ;
			i = input.nextInt();
			if(i==-1)
			{
				break;
			}
			double price=0;
			System.out.println("��������Ҫ���ĵļ۸�");
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
		System.out.println("|    ��Ʒ    |  ����  |  �۸��ܼ�  |  ����  |");
		System.out.println("  �������ȱ�" +        "    "+(int)(Math.random()*100)+"         "+(int)(Math.random()*100) +"  "+ "          ��               ");
		System.out.println("  �¶�������" +         "    "+(int)(Math.random()*100)+"         "+(int)(Math.random()*100)   +"  "+  "         ��            ");
		System.out.println("  ��У���� "  +         "      "+(int)(Math.random()*100)+"        "+(int)(Math.random()*100)+"  "+ "          ��"       );   
		System.out.println("  ˱ָԭζ��"  +           "     "+(int)(Math.random()*100)+"        "+(int)(Math.random()*100) +"            ��               ");
		System.out.println("    ����     "  +     "   "+(int)(Math.random()*100)+"         "+(int)(Math.random()*100)+ "        "+"   ��               ");  
		System.out.println("    ��ţ��    "+       "   "+(int)(Math.random()*100)+"        "+(int)(Math.random()*100)+ "        "+"   ��               "); 	
	}
}
