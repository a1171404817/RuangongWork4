package sizeyunsuan;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class init {

	public ArrayList<ArrayList<String>> initString (int n,int yunsfn,int zuojie,int youjie,boolean havaCc,boolean havaKh) throws IOException
	{
	
		
		int n1=n;
		int nc=0;
		ArrayList<ArrayList<String>> als=new ArrayList<ArrayList<String>>();
		
		

		while(nc<n1)
		{	
			
			int modelrdn=((int) (Math.random() * 100))%3;
		
		
		if(modelrdn==0||modelrdn==1){	
			 int nFuhao = yunsfn;
//			 System.out.println(nFuhao);
			 
			String fuhao[]={"+","-","×","÷"};
			
//			System.out.println(fuhao[0]+fuhao[1]+fuhao[2]+fuhao[3]);
			
			
			 String nFirstNumS = String.valueOf(((int) (Math.random() * 10000))%(youjie-zuojie)+zuojie);//产生第一个数 数值随机产生  并转化成字符串
//			 System.out.println(nFirstNum);
			
			 for(int j=0;j<nFuhao;j++)
			 {	 int fuhaoSuiji;
				 if(havaCc==true){
					 
				 fuhaoSuiji=((int) (Math.random() * 10000)%4);
				 }else {
					 fuhaoSuiji=((int) (Math.random() * 10000)%2);
				}
				 nFirstNumS=nFirstNumS+fuhao[fuhaoSuiji];
				 if(fuhaoSuiji!=3){
				 int numSuiji=((int) (Math.random() * 10000))%(youjie-zuojie)+zuojie;
				 nFirstNumS=nFirstNumS+String.valueOf(numSuiji);
				 }//处理除号部分：查重
				 else {//从生成上来限制必须是整数除是最正确的，因为要求是过程
						char[] cfn = nFirstNumS.toCharArray();
						int k=cfn.length-1;
						k--;
						String qianyigenum="";
						qianyigenum+=String.valueOf(cfn[k]);
						k--;
						while(true)
						{	
							if(k<0)break; //判断是否越界
							if(cfn[k]=='×'||cfn[k]=='÷'||cfn[k]=='+'||cfn[k]=='-'){ //判断是否是数字
								
								break;
							}
							{
								qianyigenum+=String.valueOf(cfn[k]);
								k--;
							}
							
						}
						qianyigenum=new StringBuilder(qianyigenum).reverse().toString();
						 int numSuiji=((int) (Math.random() * 10000))%(youjie-zuojie)+zuojie;
						while(true)
						{
							if(numSuiji!=0){
							 if((Integer.parseInt(qianyigenum)>=numSuiji&&Integer.parseInt(qianyigenum)%numSuiji==0)||Integer.parseInt(qianyigenum)==0)
							 {
								 break;
							 }
							}
							 numSuiji=((int) (Math.random() * 10000))%(youjie-zuojie)+zuojie;
						
						}
						 
						 nFirstNumS=nFirstNumS+String.valueOf(numSuiji);
						 
						 
						String panduans=new caculate().judges(nFirstNumS);
						if(panduans.equals("error"))
							break;
				}
				
			 
			 }
			 
			
			 String rs;
			 caculate cl=new caculate();
			 try{
			 rs=cl.judges(nFirstNumS);
			 }catch (NumberFormatException e) {
				// TODO: handle exception
				 continue;
			}
			
			 
			
			
			if(rs.equals("error")){
					continue;
			}else {
				if(modelrdn==0||havaKh==false){
				nc++;
//				System.out.println(nFirstNumS+"="+rs);
				
				ArrayList<String> tempal=new ArrayList<String>();
				tempal.add(nFirstNumS);
				tempal.add(rs);
				als.add(tempal);
//				for(int i=0;i<tempal.size();i++)
//				{
//					System.out.println(tempal.get(i));
//					
//				}
				}
				else if(modelrdn==1&&havaKh==true)
				{
					kuohao kh=new kuohao();
					String s=kh.init(nFirstNumS, 5);
					int ys=1000;//达到一定次数一定可以生成
					while(true){
						
					if(s!="error"){
						
						String rs1=kh.jieshi(s);
						if(rs1!="error")
						{		
							String rss1=new caculate().judges(rs1);
							if(rss1!="error")
							{
//								System.out.print(s);
//								System.out.println("="+rss1);
								ArrayList<String> tempal=new ArrayList<String>();
								tempal.add(s);
								tempal.add(rss1);
								als.add(tempal);
//								for(int i=0;i<tempal.size();i++)
//								{
//									System.out.println(tempal.get(i));
//									
//								}
								nc++;
								break;
							}
						}
					}
					ys--;
					if(ys<=0)break;
					 s=kh.init(nFirstNumS, 5);
				}
					
				}
			}
//			System.out.println( cl.caluJiajian(nFirstNumS));
		}
		else if(modelrdn==2){
			String isproceed=new zhenfenshu().init(yunsfn,zuojie,youjie);
			while(isproceed.equals("error"))
				isproceed=new zhenfenshu().init(yunsfn,zuojie,youjie);
			
			ArrayList<String> tempal=this.cutS(isproceed);
			als.add(tempal);
			nc++;
//			for(int i=0;i<tempal.size();i++)
//			{
//				System.out.println(tempal.get(i));
//				
//			}
			
		}
		
		}

		return als;
	}
	
	public ArrayList<String> cutS(String s)
	{
		char[] cisp = s.toCharArray();
		String rsisp="";
		String suansisp="";
		for(int i=0;i<cisp.length;i++)
		{	if(cisp[i]!='=')
				suansisp+=cisp[i];
			if(cisp[i]=='=')
			{
				for(int j=i+1;j<cisp.length;j++)
				{
					rsisp+=cisp[j];
					
				}
				break;
			}
			
		}	
		ArrayList<String> tempal=new ArrayList<String>();
		tempal.add(suansisp);
		tempal.add(rsisp);
		
		
		
		return tempal;
	}
}
