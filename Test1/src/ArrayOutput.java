public class ArrayOutput {

  {

        int myArray[][][] = {{{0, 1}, {2, 3}},  {{4}, {5}}, {{6, 7, 8}, {9}}};
        for(int i = 0; i < myArray.length; i++){
            for(int j = 0; j <myArray[i].length; j++){
                for(int val: myArray[i][j]){
                    System.out.printf("[%d][%d] %d\n", i, j, val);

                }
            }
        }
    }
}
