public class Main extends Helper {


    public static void main(String[] args) {

        Helper objectForCallingMethods = new Main();
        User user = new User("user", "user123");
        User admin = new Admin("admin", "admin123");


        objectForCallingMethods.creatingTables();
        objectForCallingMethods.creatingMenu();
        objectForCallingMethods.creatingStuff();

        boolean condition1 = false;
        boolean condition2 = false;
        boolean condition3 = false;
        boolean condition4 = false;
        boolean condition5 = false;
        boolean condition6 = false;
        boolean condition7 = false;

        objectForCallingMethods.Login(user);
        while (!condition1) {

            System.out.println("congratulations you did it well!");
            condition2 = false;
            while (!condition2) {
                int choose1 = objectForCallingMethods.mainMenu();
                switch (choose1) {
                    case (1):
                        condition3 = false;
                        while (!condition3) {
                            objectForCallingMethods.showTables();
                            System.out.println("You have chosen order Management");
                            System.out.print("1. Choosing Table\t\t 2. Go back\n" +
                                    "Please choose: ");
                            int choose2 = objectForCallingMethods.takeAnIntegerInput();
                            switch (choose2) {
                                case 1:
                                    condition4 = false;
                                    while (!condition4) {
                                        System.out.print("Please choose table");
                                        int numberOfTable = objectForCallingMethods.choosingTables() - 1;
                                        int status = objectForCallingMethods.checkingTable(numberOfTable);
                                        switch (status) {
                                            case 1:
                                                System.out.println("This table is Full");
                                                System.out.println("1. Delete Order\t\t 2. Go back \n Please choose one: ");
                                                int choose3 = objectForCallingMethods.takeAnIntegerInput();
                                                switch (choose3) {
                                                    case 1:
                                                        System.out.println("You opted to delete order");
                                                        objectForCallingMethods.deleteOrder(numberOfTable);
                                                        objectForCallingMethods.totalProfit =
                                                                tables[numberOfTable].getBill() +
                                                                        objectForCallingMethods.totalProfit;
                                                        tables[numberOfTable].setStatus("Empty");
                                                        tables[numberOfTable].setBill(0);
                                                        System.out.println("Bill is added to Total Profit");
                                                        condition4 = true;
                                                        break;
                                                    case 2:
                                                        System.out.println("You opted go Back");
                                                        condition4 = true;
                                                        break;
                                                }
                                                break;
                                            case 0:
                                                System.out.println("1. Add Order\t\t 2. Go back \n Please choose one: ");
                                                int choose4 = objectForCallingMethods.takeAnIntegerInput();
                                                switch (choose4) {
                                                    case 1:
                                                        System.out.println("You have chosen to add Order");
                                                        objectForCallingMethods.addOrder(numberOfTable);
                                                        condition4 = true;
                                                        break;
                                                    case 2:
                                                        System.out.println("You opted go Back");
                                                        condition4 = true;
                                                        break;

                                                }
                                                break;
                                        }


                                    }
                                    break;

                                case 2:
                                    System.out.println("You opted go back!");
                                    condition3 = true;
                                    break;

                            }

                        }
                        break;

                    case 2:

                        objectForCallingMethods.Login(admin);
                        condition5 = false;
                        while (!condition5) {
                            System.out.println("Welcome, Mr." + admin.getName());
                            objectForCallingMethods.stuffLister();
                            System.out.print("\n1. Choose personnel\t\t2.add personnel\t\t3.go back\nChoose the peration:");
                            int choose5 = objectForCallingMethods.takeAnIntegerInput();
                            switch (choose5) {
                                case 1:
                                    objectForCallingMethods.stuffLister();
                                    System.out.print("Please choose the number of personnel that you want to edit: ");
                                    int numberOfPersonnel = objectForCallingMethods.takeAnIntegerInput();
                                    condition6 = false;
                                    while (!condition6) {
                                        if (numberOfPersonnel <= 0 || numberOfPersonnel > personnels.size()) {
                                            System.out.println("Please choose Personnel in range");
                                            numberOfPersonnel = objectForCallingMethods.takeAnIntegerInput();
                                        } else {
                                            System.out.println("Congratulatonis");
                                            condition6 = true;
                                        }
                                    }

                                    Personnel personnel = personnels.get(numberOfPersonnel - 1);

                                    condition7 = false;
                                    while (!condition7) {
                                        objectForCallingMethods.spaceMaker();
                                        objectForCallingMethods.showPersonnel(personnel);
                                        System.out.println("Please choose what to do with this personnel!\n" +
                                                "1. Edit salary \t\t 2. Edit Workhours \t\t 3.Fire personnel \t\t4. Go Back");
                                        System.out.print("Your choice: ");
                                        int choose6 = objectForCallingMethods.takeAnIntegerInput();
                                        switch (choose6) {
                                            case 1:
                                                objectForCallingMethods.editSalary(personnel);
                                                break;
                                            case 2:
                                                objectForCallingMethods.editWorkhours(personnel);
                                                break;
                                            case 3:
                                                objectForCallingMethods.firePersonnel(personnel);
                                                condition7 = true;
                                                break;
                                            case 4:
                                                condition7 = true;
                                                System.out.println("you opted to go back!");
                                                break;
                                        }


                                    }
                                    break;

                                case 2:
                                    objectForCallingMethods.addPersonnel();
                                    break;
                                case 3:
                                    condition5 = true;
                                    System.out.println("you opted go back!");
                                    break;


                            }

                        }
                        break;
                    case 3:
                        boolean condition8 = false;
                        while (!condition8) {
                            System.out.println("You have chosen menu management!");
                            objectForCallingMethods.showMenu();
                            System.out.println("pleaase choose one of them\n " +
                                    "1. Change price\t\t 2. Add new food \t\t 3. Delete Food\t\t 4. Go back");
                            System.out.print("Your choice: ");
                            int choose7 = objectForCallingMethods.takeAnIntegerInput();
                            switch (choose7) {
                                case 1:
                                    objectForCallingMethods.changePrice();
                                    break;
                                case 2:
                                    objectForCallingMethods.addFood();
                                    break;
                                case 3:
                                    objectForCallingMethods.deleteFood();
                                    break;
                                case 4:
                                    System.out.println("You opted go back!");
                                    condition8 = true;
                                    break;


                            }
                        }
                        break;
                    case 4:
                        System.out.println("Your totali Profit is: " + objectForCallingMethods.totalProfit + "$");
                        break;
                    case 5:
                        System.out.println("exitinig..................");
                        System.out.println("Good bye");
                        condition2 = true;


                }

            }
            condition1 = true;


        }
    }


}
