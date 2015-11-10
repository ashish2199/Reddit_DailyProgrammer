        package easy;
        import java.util.Scanner;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Comparator;
        /*
        [2015-09-28] Challenge #234 [Easy] Vampire Numbers
         */
        public class challenge_234 {

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int m = sc.nextInt();
                int f = n/m;
                printVampires(n, f);
                printResult(f);
            }

            // comparator to sort the multidimensional array based on column 0
            class multidimensionalSort implements Comparator<int []> {
                @Override
                public int compare(int[] o1, int[] o2){
                    int i = o1[0];
                    int j = o2[0];
                    if(i==j){return 0;}
                    if(i<j){return -1;}
                    else{return 1;}
                }
            }

            static void printResult(int factors){
                //was not able to access it from a static method thus 
                //we are creating a new object of class multidimensionalSort since it is a inner class thus 
                Arrays.sort(result,0,countNumberDiscovered,new challenge_234().new multidimensionalSort());

                if(factors==2){
                    for (int i = 0; i < countNumberDiscovered; i++){
                        System.out.println(result[i][0]+" = "+result[i][1]+" * "+result[i][2]);
                    }
                }
                if(factors==3){
                    for (int i = 0; i < countNumberDiscovered; i++) {
                        System.out.println(result[i][0]+" = "+result[i][1]+" * "+result[i][2]+" * "+result[i][3]);
                    }
                }
            }

            static ArrayList<Integer> ListOfNumbersDiscovered = new ArrayList<>();

            //stores the vamprie number with their factors , for 2 factors we have third factor as 1
            static int result[][]=new int[100][4];


            static int countNumberDiscovered=0;

            static int tempArrayForMatching[][];

            static void printVampires(int noOfDigits,int factors){
                outer:for (int i = 10; i <= 99; i++) {
                        for (int j = 10; j <= 99; j++) {
                            if(factors==2){
                                int vamp = i*j;
                                //so that it is a 4 digit number and does not have trailing zeros
                                if(vamp>999&&(vamp%100)!=0){
                                        int tmp = vamp;
                                        tempArrayForMatching=new int[noOfDigits][2];

                                        //arrays will be of the form 
                                        //a[][0]=1395
                                        //a[][1]=0 when no match found or initially
                                        //a[][1]=1 when a match has been found

                                        for (int k = 0; k < tempArrayForMatching.length; k++){
                                            tempArrayForMatching[k][0]=tmp%10;
                                            tmp=tmp/10;
                                        }


                                        fillArrayWithDigitsOfTheseNumbers(i, j);

                                        if(checkIfALLDigitMatched()){

                                            if(!ListOfNumbersDiscovered.contains(vamp)){
                                                ListOfNumbersDiscovered.add(vamp);
                                                //System.out.println(vamp+" = "+i+" * "+j);
                                                result[countNumberDiscovered][0]=vamp;
                                                result[countNumberDiscovered][1]=i;
                                                result[countNumberDiscovered][2]=j;
                                                result[countNumberDiscovered][3]=1;
                                                countNumberDiscovered++;
                                            }
                                        }
                                }
                            }

                            else if (factors==3){

                                for (int k = 10; k < 99; k++) {
                                    int vamp = i*j*k;
                                    //so that it is a 6 digit number and does not have trailing zeros
                                    if(vamp>99999&&(vamp%100)!=0){
                                        int tmp = vamp;
                                        tempArrayForMatching=new int[noOfDigits][2];
                                            for (int l = 0; l < tempArrayForMatching.length; l++){
                                                tempArrayForMatching[l][0]=tmp%10;
                                                tmp=tmp/10;
                                            }
                                            fillArrayWithDigitsOfTheseNumbers(i,j,k);
                                            if(checkIfALLDigitMatched()){
                                                if(!ListOfNumbersDiscovered.contains(vamp)){
                                                    ListOfNumbersDiscovered.add(vamp);
                                                    //System.out.println(vamp+" = "+i+" * "+j+" * "+k);
                                                    result[countNumberDiscovered][0]=vamp;
                                                    result[countNumberDiscovered][1]=i;
                                                    result[countNumberDiscovered][2]=j;
                                                    result[countNumberDiscovered][3]=k;
                                                    countNumberDiscovered++;
                                                }
                                            }
                                    }
                                }
                            }
                            else{ System.out.println("Can Calculate only upto 3 fangs only");
                                break outer;
                            }
                        }
                    }
            }

            //elipsis so that we can call function with 2 and 3 paramaters
            public static void fillArrayWithDigitsOfTheseNumbers(int...i){
                for (int j = 0; j < i.length; j++){
                    fillArray( i[j]/10 );
                    fillArray( i[j]%10 );
                }
            }



            static void fillArray( int d ){
                for (int i = 0; i < tempArrayForMatching.length; i++) {
                    if(tempArrayForMatching[i][0]==d){
                        if(tempArrayForMatching[i][1]==0){
                            tempArrayForMatching[i][1]=1;
                            break;
                        }
                    }
                }
            }

            static Boolean checkIfALLDigitMatched(){
                for (int i = 0; i < tempArrayForMatching.length; i++) {
                    if(tempArrayForMatching[i][1]==0){
                        return false;
                    }
                }
                return true;
            }
        }
