package StepDefinition;

public class ReUsabeFunc
{
	public static int FindSmallestElement(int[] arr1) {
		int index = arr1[0];
		for (int i=1; i<arr1.length; i++)
		{
			if (arr1[i] > index )
			{
				index = arr1[i];
				return index ;
			}
		}
		return 0;
	}
}