class dynamicArray
{
	int arr[];
	int current; //current location of present elemnt
	dynamicArray(int n)
	{
		arr=new int[n];
		current=0;
	}
	
	void print()
	{
		System.out.println();
		for(int i=0;i<current;i++)
			System.out.print("|"+arr[i]);
	}
	
	int  getSize()
	{
		return arr.length;
	}
	
	void add(int k)
	{
		if(current<getSize())
		{
				arr[current]=k;
				current++;
		}
		else
		{
			
			int tArr[]=new int[getSize()*2];
			//current+=1;
			for(int i=0;i<getSize();i++)
			{
				tArr[i]=arr[i];
			}
			tArr[current]=k;
			++current;
			arr=new int[getSize()*2];
			arr=tArr;
			
		}
	}
	void delete(int loc)	//delete elemnt at 'loc' index
	{
		if(current>=0)
		{
			int tArr[]=new int[getSize()-1];
			for(int i=0;i<current;i++)
			{
				if(i>=loc)
				{
					tArr[i]=arr[i+1];
				}
				else
					tArr[i]=arr[i];
			}
			--current;
			arr=tArr;
		}
		else
		{
			System.out.println("Array Already empty");
		}
	}
}
public class dArray
{
	public static void main(String[] arg)
	{
		dynamicArray A=new dynamicArray(2);
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		A.print();
		A.delete(2);
		A.print();
	}
}
