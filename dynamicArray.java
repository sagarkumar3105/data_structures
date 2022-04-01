class dynamic
{
	int arr[];
	int current; //current location of present element
	dynamic(int n)
	{
		arr=new int[n];
		current=-1;
	}
	
	void print()
	{
		for(int i=0;i<current;i++)
			System.out.print("|"+arr[i]);
		System.out.println();
	}
	
	int  getSize()
	{
		return arr.length;
	}
	
	void add(int k)
	{
		if(current<getSize())
		{
			if(current<0)	//Initial Condition
				current+=1;
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
	void isEmpty()
	{
		if(current<0)
			System.out.println("Array is empty");
		else
			System.out.println("Array is not Empty");
			
	}
	
	int indexOf(int k)
	{
		int flag=0;
		for(int i=0;i<current;i++)
		{	if(arr[i]==k)
			{
				flag=1;
				return i;
			}
		}
		//-1 -> element not present
		return -1 ;
		
	}
	
	
	void search(int k)
	{
		int flag=0,i=0;
		for(;i<current;i++)
		{
			if(arr[i]==k)
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
				System.out.println("Element present in the Array at index"+i);
		else
			System.out.println("Element not present in the Array");
			
	}
}
public class dArray
{
	public static void main(String[] arg)
	{
		dynamic A=new dynamic(2);
		A.isEmpty();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		A.print();
		A.delete(2);
		A.print();
		A.isEmpty();
		System.out.println("Index of 45 is "+A.indexOf(45));
		A.search(4);
	}
}
