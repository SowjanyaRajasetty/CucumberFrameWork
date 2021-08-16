package Practice;

public class Conditions {

	 

    public int func(int[] intArray) {

           if (intArray.length == 100000) {

                  return -1;

           } else {

                  return 0;

           }



    }



    public static void main(String[] args) {



           Conditions cond = new Conditions();

           int[] intArray = new int[100000];

           for (int i = 0; i < intArray.length; i++) {

                  intArray[i]=i;

           }

           int value = cond.func(intArray);

           System.out.println(value);



    }



}