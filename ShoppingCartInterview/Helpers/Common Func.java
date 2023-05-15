public class CommonFunc
{
	public static int FindSmallestElement (int [] arr1)
	{//start method
		int index = arr1[0];
		for (int i=1; i<arr1.length; i++){
			if (arr1[i] > index )
			{
				index = arr1[i];
				return index ;
			}
			return 0;
	}//end method
}