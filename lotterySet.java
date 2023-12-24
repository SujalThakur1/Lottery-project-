import java.util.*;
public class lotterySet {
    //declaring fields
    private MySet set;
    private MySet set2;
    private MySet cost;
    private int maxLottery = 0;

    /**
     * lotterySet Constructor
     *
     */
    public lotterySet(){
        cost = new MySet();
    }

    /**
     * Method UserNumber to user input to set
     *
     * @return The return boolean
     */
    public boolean UserNumber() {
        boolean check = true;
        set = new MySet();
        System.out.println("Enter your lottery number");
        System.out.println("Your number should be like this => '1 24 32 48 5 10'");
        Scanner scanner1 = new Scanner(System.in);
        String st = scanner1.nextLine();
        String[] array = st.split(" ");
        for (int i = 0; i < array.length; i++) {
            try {
                int number = Integer.parseInt(array[i]);
                if(number > maxLottery){
                    System.out.println("Your Number is higher than maximum Lottery number");
                    return false;
                }else if(number < 1){
                    System.out.println("Your Number shouldn't be less than 1");
                    return false;
                }
                set.addToSet(number);
            } catch (NumberFormatException nfe) {
                System.out.println("Only numbers are Allowed");
                return false;
            }
        }

        int size = set.getCardinality();
        if (size < 6) {
            System.out.println("You can't choose less than 6 number");
            return false;
        } else if (size > 6){
            System.out.println("You can't choose more than 6 number");
            return false;
        }

        return check;
    }

    /**
     * Method LotteryMax to get Lottery max value
     *
     */
    public void LotteryMax(){
        boolean valid = false;
        do{
            try {
                System.out.println("Enter maximum Lottery number");
                Scanner scanner = new Scanner(System.in);
                maxLottery = scanner.nextInt();
                if (maxLottery < 11) {
                    System.out.println("Number shouldn't be less than 11");
                } else {
                    valid = true;
                }
            }catch(InputMismatchException i){
                System.out.println("Only Numbers Are Allowed");
            }
        }while(!valid);
    }

    /**
     * Method runUserLottery to run userNumber method
     *
     */
    public void runUserLottery(){
        boolean valid = false;
        do {
            valid = UserNumber();
        }while (!valid);
    }

    /**
     * Method RandomNumber to generate random number
     * and add to set
     *
     */
    public void RandomNumber(){
        Random rand = new Random();
        boolean valid = false;
        set2 = new MySet();
        do {
            int number = 1 + rand.nextInt(maxLottery);
            set2.addToSet(number);
            int size = set2.getCardinality();
            if (size == 6){
                valid = true;
            }
        }while (!valid);
    }

    /**
     * Method Intersection to intersection between 2 set
     *
     * @param sett A parameter
     * @return how much prize player receive
     */
    public int Intersection(MySet sett){
        int prize = 0;
        cost = set.intersection(sett);
        int size = cost.getCardinality();
        if(size == 3){
            prize = 25;
        } else if (size == 4) {
            prize = 100;
        } else if (size == 5) {
            prize = 1000;
        } else if (size == 6) {
            prize = 1000000;
        }
        return prize;
    }

    /**
     * Method player to get total number of player
     *
     * @return player number
     */
    public int player(){
        boolean valid = false;
        int players = 0;
        do {
            try {
                System.out.println("Enter Total Number Of Players Taking Part On Lucky Draw");
                Scanner scanner = new Scanner(System.in);
                players = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException ime) {
                System.out.println("Only numbers are allowed");
            }
        }while (!valid);
        return players;
    }

    /**
     * Method week to run lottery draws for several weeks
     *
     */
    public void week(){
        boolean valid = true;
        int Week = 0;
        int players = player();
        MySet set3 = new MySet();
        MySet set4 = new MySet();
        MySet set5 = new MySet();
        MySet set6 = new MySet();
        do {
            try {
                System.out.println("Enter number of week of lottery draws you would like me to run");
                Scanner scanner2 = new Scanner(System.in);
                Week = scanner2.nextInt();
                valid = false;
            }catch (InputMismatchException ime){
                System.out.println("Only numbers are allowed");
            }
        }while (valid);
        LotteryMax();
        for (int i = 0; i <Week ; i++) {
            RandomNumber();
            set3.addSetToSet(set2);
        }
        for (int i = 0; i <players ; i++) {
            runUserLottery();
            int l = 1 ;
            int k = i + 1;
            int money = 0;
            int totalPrize = 0;
            for (MySet j : set3.getSetSet()) {
                int prize = Intersection(j);
                money = 2 + money;
                totalPrize = prize + totalPrize;
                set4.addString("Matching Lottery Number For Player no. " + k + " on Week " + l +" ==> " +cost.getSetData().toString());
                set5.addString("Player no. " + k + " win £" + prize + " on Week " + l);
                l++;
            }
            totalPrize = totalPrize - money;
            set6.addString("Total cost of ticket of player " +k+ " is £" +money+ " and total money in pocket is £"+ totalPrize );
        }
        int j = 1;
        for(MySet i : set3.getSetSet()){
            System.out.print("Lottery Number for Week "+ j +  " ==> " );
            i.printSet();
            j++;
        }
        for(String i: set4.getData()){
            System.out.println(i);
        }
        for (String i: set5.getData()) {
            System.out.println(i);
        }
        for (String i: set6.getData()) {
            System.out.println(i);
        }
    }

    /**
     * Method Player to run lucky draw and display result
     *
     */
    public void Player(){
        MySet set3 = new MySet();
        MySet set4 = new MySet();
        int players = player();
        LotteryMax();
        RandomNumber();
        for (int i = 0; i <players ; i++) {
            runUserLottery();
            int prize = Intersection(set2);
            int j = i + 1;
            set4.addString("Player no. " + j + " win £" + prize);
            set3.addString("Matching Lottery Number For Player no. " + j + " ==> " +cost.getSetData().toString());
        }
        System.out.print(" Lottery Numbers are ==> ");
        set2.printSet();
        for(String i: set3.getData()){
            System.out.println(i);
        }
        for (String i: set4.getData()) {
            System.out.println(i);
        }
    }

    /**
     * Method menu
     *
     */
    public void menu(){
        //declare variable
        boolean valid = false;
        //using do while loop which end when user input is 0
        do{
            //printing some line
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*_*_*_*_*_*_*_*-*-*-*-*-*-*-");
            System.out.println("please select one of the options below");
            System.out.println("1. Play Lottery and lose");
            System.out.println("2. Play Weekly lottery and lose your money for sure");
            System.out.println("0. Exit");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*_*_*_*_*_*_*_*-*-*-*-*-*-*-");

            //taking user input and storing in a variable
            try{
                Scanner s = new Scanner(System.in);
                int userInput = s.nextInt();

                //using switch statement
                switch(userInput){
                    case 1:
                        Player();
                        break;

                    case 2:
                        week();
                        break;

                    case 0://when user enter 0 kill system
                        valid = true;
                        System.exit(0);
                        break;

                    default:// if user print invalid input
                        System.out.println("!!!!!!!!!  Please Press Valid Input :-(  !!!!!!!!");
                }
            }catch(InputMismatchException ime){
                System.out.println("Only Integers are allowed");
            }

        }while(!valid);
    }

    /**
     * Method main
     *
     * @param args A parameter
     */
    public static void main(String[] args) {
        lotterySet lotterySet = new lotterySet();
        lotterySet.menu();
    }

}
