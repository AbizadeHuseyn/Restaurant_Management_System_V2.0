import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Helper implements Functions {

    public static Table[] tables = new Table[9];

    public Scanner scanner = new Scanner(System.in);

    public static List<Food> meals = new ArrayList<>();
    public static List<Food> drinks = new ArrayList<>();
    public static List<Food> salads = new ArrayList<>();

    public static List<Personnel> personnels = new ArrayList<>();
    public static List<List<Food>> categories = new ArrayList<>();

    public float totalProfit = 0;

    public void spaceMaker() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------" +
                "--------------------------------------------------------------------");
        System.out.println();
    }


    public void Login(User user) {
        boolean condition2 = false;
        while (!condition2) {

            if (user instanceof Admin) {
                System.out.print("|-----------------------------------------------------|\n" +
                        "|                ADMIN LOGIN SCREEN                   |\n" +
                        "|                                                     |\n" +
                        "|             Please enter the name: ");
            } else {
                System.out.print("|-----------------------------------------------------|\n" +
                        "|                      LOGIN SCREEN                   |\n" +
                        "|                                                     |\n" +
                        "|             Please enter the name: ");

            }
            String enteredName = takeAnStringInput();
            System.out.println("|");
            System.out.print("|             Please enter the password: ");
            String enteredPassword = takeAnStringInput();
            System.out.println("|-----------------------------------------------------|");

            if (enteredName.equals(user.getName()) && enteredPassword.equals(user.getPassword())) {

                System.out.println("Welcome, " + user.getName() + ", to restaurant management system!");
                condition2 = true;

            } else {
                System.out.println("\n" +
                        "|-------------------------|\n" +
                        "| Wrong name or password! |\n" +
                        "|-------------------------|\n");
            }
        }

    }

    public void showTables() {
        System.out.print(
                "    ---------                 ---------                  ----------        \n" +
                        "  /           \\             /           \\               /           \\      \n" +
                        " |      1      |           |      2      |             |      3     |      \n" +
                        "  \\           /             \\           /               \\          /       \n" +
                        "    ----------                ----------                 ----------\n" +
                        " \n " +
                        "    ---------                 ---------                  ----------        \n" +
                        "  /           \\             /           \\               /           \\      \n" +
                        " |      4      |           |      5      |             |      6     |      \n" +
                        "  \\           /             \\           /               \\          /       \n" +
                        "    ----------                ----------                 ----------\n" +
                        "\n" +
                        "    ---------                 ---------                  ----------        \n" +
                        "  /           \\             /           \\               /           \\      \n" +
                        " |      7      |           |      8      |             |      9     |      \n" +
                        "  \\           /             \\           /               \\          /       \n" +
                        "    ----------                ----------                 ----------\n"

        );
    }

    public void addOrder(int num) {

        spaceMaker();
        float totalBill = 0;
        boolean condition = false;
        while (!condition) {
            showMenu();
            System.out.println("Please choose category\n" +
                    "1. Meals \t2. Drinks \t3. Salads");
            int categoryNumber = takeAnIntegerInput();
            boolean condition3 = false;
            while (!condition3) {
                if (categoryNumber <= 0 || categoryNumber > categories.size()) {
                    System.out.println("Please choose category in range");
                    categoryNumber = takeAnIntegerInput();
                } else condition3 = true;
            }
            List<Food> category = categories.get(categoryNumber - 1);
            for (int i = 0; i < category.size(); i++) {
                Food food = category.get(i);
                System.out.println(i + 1 + ". " + food.getName() + "....." + food.getPrice() + "$");
            }
            System.out.print("Choose food please: ");
            int food = takeAnIntegerInput();
            boolean condition1 = false;
            while (!condition1) {
                if (food <= 0 || food > category.size()) {
                    System.out.println("Please choose food in range");
                    food = takeAnIntegerInput();
                } else {
                    condition1 = true;
                }
            }
            System.out.println("Please enter the number of portions you want: ");
            int portions = takeAnIntegerInput();
            totalBill = totalBill + category.get(food - 1).getPrice() * portions;
            System.out.println("Your total Bill is " + totalBill);
            System.out.print("Do you want to add new foo to your order? ");
            String choice = takeAnStringInput();
            if (choice.equals("Yes")) continue;
            else {
                System.out.println("Your total bill is " + totalBill + "$");
                tables[num].setBill(totalBill);
                tables[num].setStatus("Full");
                condition = true;
            }
        }
        spaceMaker();
    }

    public void deleteOrder(int number) {
        totalProfit = (totalProfit + tables[number].getBill()) / 2;
        tables[number].setStatus("Empty");

    }

    public void editSalary(Personnel personnel) {
        spaceMaker();
        System.out.println("Just to remind, this personnel's salary is " + personnel.getSalary() + "$");
        System.out.print("Please enter the new salary: ");
        float newSalary = takeAnFloatInput();
        personnel.setSalary(newSalary);
        System.out.println("Now, this personnel's salary is " + personnel.getSalary() + "$");
        spaceMaker();
    }

    public void editWorkhours(Personnel personnel) {
        List<Integer> nums = new ArrayList<>();
        spaceMaker();
        System.out.println("Just to remind, this personnel's workhours is " + personnel.getWorkHours());
        String newWorkhours = "";
        boolean condition = false;
        while (!condition) {
            System.out.print("Please enter the new workhours and be Sure that it matches with the time type" +
                    "(00:00): ");
            newWorkhours = takeAnStringInput();
            if (newWorkhours.length() == 11) {
                char c1 = newWorkhours.charAt(2);
                char c2 = newWorkhours.charAt(8);
                char c3 = newWorkhours.charAt(5);
                if (":".equals(Character.toString(c1)) && ":".equals(Character.toString(c2)) && "-".equals(Character.toString(c3))) {
                    condition = true;
                    break;
                } else {
                    System.out.println("Try valid Type");

                }
            } else {
                System.out.println("Try valid type!");
            }

        }

        personnel.setWorkHours(newWorkhours);
        System.out.println("Now, this personnel's workhours is " + personnel.getWorkHours());
    }

    public void firePersonnel(Personnel personnel) {
        spaceMaker();
        boolean condition = false;
        while (!condition) {
            System.out.print("Are you sure to fire this personnel: ");
            String decision = takeAnStringInput();
            if ("Yes".equals(decision)) {
                personnels.remove(personnel);
                condition = true;
                System.out.println("You fired " + personnel.getName());
            } else {
                System.out.println("process is denied!");
                condition = true;
            }
        }
    }


    public void addPersonnel() {
        spaceMaker();
        System.out.println("Please enter following data precisely");
        System.out.print("Name: ");
        String name = takeAnStringInput();

        System.out.print("Surname: ");
        String surname = takeAnStringInput();

        System.out.print("Age: ");
        int age = takeAnIntegerInput();

        System.out.print("Email: ");
        String email = takeAnStringInput();

        String newWorkhours = "";
        boolean condition = false;
        while (!condition) {
            System.out.print("Please enter the new workhours and be Sure that it matches with the time type" +
                    "(00:00): ");
            newWorkhours = takeAnStringInput();
            if (newWorkhours.length() == 11) {
                char c1 = newWorkhours.charAt(2);
                char c2 = newWorkhours.charAt(8);
                char c3 = newWorkhours.charAt(5);
                if (":".equals(Character.toString(c1)) && ":".equals(Character.toString(c2)) && "-".equals(Character.toString(c3))) {
                    condition = true;
                    break;
                } else {
                    System.out.println("Try valid Type");

                }
            } else {
                System.out.println("Try valid type!");
            }

        }

        System.out.print("Salary: ");
        float salary = takeAnFloatInput();

        Personnel newPersonnel = new Personnel(name, surname, age, email, newWorkhours, salary);
        personnels.add(newPersonnel);
        System.out.println("Congratulation you have added new personnel to your stuff!");
        spaceMaker();

    }

    public void changePrice() {
        spaceMaker();
        System.out.println("Please choose category\n" +
                "1. Meals \t2. Drinks \t3. Salads");
        int categoryNumber = takeAnIntegerInput();
        boolean condition3 = false;
        while (!condition3) {
            if (categoryNumber <= 0 || categoryNumber > categories.size()) {
                System.out.println("Please choose category in range");
                categoryNumber = takeAnIntegerInput();
            } else {
                condition3 = true;
            }
        }
        List<Food> category = categories.get(categoryNumber - 1);
        for (int i = 0; i < category.size(); i++) {
            Food food = category.get(i);
            System.out.println(i + 1 + ". " + food.getName() + "....." + food.getPrice() + "$");
        }
        System.out.print("Choose food please: ");
        int food = takeAnIntegerInput() - 1;
        boolean condition1 = false;
        while (!condition1) {
            if (food < 0 || food >= category.size()) {
                System.out.println("Please choose food in range");
                food = takeAnIntegerInput() - 1;
            } else {
                condition1 = true;
            }
        }
        Food chosenFood = category.get(food);
        System.out.println("You have chosen: \n" +
                chosenFood.getName() + "....." + chosenFood.getPrice() + "$");
        System.out.print("Please enter new price for chosen food: ");
        float newPrice = takeAnFloatInput();
        chosenFood.setPrice(newPrice);
        System.out.println("This food's cost is: " + chosenFood.getPrice() + "$");
        spaceMaker();

    }

    public void addFood() {
        spaceMaker();
        System.out.println("Please enter following data precisely");
        System.out.println("Please choose category\n" +
                "1. Meals \t2. Drinks \t3. Salads");
        int categoryNumber = takeAnIntegerInput();
        boolean condition3 = false;
        while (!condition3) {
            if (categoryNumber <= 0 || categoryNumber > categories.size()) {
                System.out.println("Please choose category in range");
                categoryNumber = takeAnIntegerInput();
            } else {
                condition3 = true;
            }
        }
        List<Food> category = categories.get(categoryNumber - 1);
        System.out.print("Name: ");
        String name = takeAnStringInput();
        System.out.print("Price: ");
        float price = takeAnFloatInput();

        Food newFood = new Food(name, price);
        category.add(newFood);
        System.out.println("Process finished succesfully");
        spaceMaker();

    }

    public void deleteFood() {
        spaceMaker();
        System.out.println("Please choose category\n" +
                "1. Meals \t2. Drinks \t3. Salads");
        int categoryNumber = takeAnIntegerInput();
        boolean condition3 = false;
        while (!condition3) {
            if (categoryNumber <= 0 || categoryNumber > categories.size()) {
                System.out.println("Please choose category in range");
                categoryNumber = takeAnIntegerInput();
            } else {
                condition3 = true;
            }
        }
        List<Food> category = categories.get(categoryNumber - 1);
        if (category.size() == 0) {
            System.out.println("There is no food in this category, Please try other ones");
        } else {
            for (int i = 0; i < category.size(); i++) {
                Food food = category.get(i);
                System.out.println(i + 1 + ". " + food.getName() + "....." + food.getPrice() + "$");
            }
            System.out.print("Choose food please: ");
            int food = takeAnIntegerInput() - 1;
            boolean condition1 = false;
            while (!condition1) {
                if (food < 0 || food >= category.size()) {
                    System.out.println("Please choose food in range");
                    food = takeAnIntegerInput() - 1;
                } else {
                    condition1 = true;
                }
            }
            Food chosenFood = category.get(food);
            System.out.println("You have chosen: \n" +
                    chosenFood.getName() + "....." + chosenFood.getPrice() + "$");
            System.out.println("Are you sure to delete this food?");
            String decision = takeAnStringInput();
            if ("Yes".equals(decision)) {
                category.remove(chosenFood);
            } else {
                System.out.println("You denied!");
            }
        }
        spaceMaker();

    }


    public void creatingMenu() {

        Meal meal1 = new Meal("fries", 10);
        Meal meal2 = new Meal("kabab", 20);
        Meal meal3 = new Meal("chicken", 15);
        Meal meal4 = new Meal("dolma", 12);
        Meal meal5 = new Meal("dovga", 7);

        meals.add(meal1);
        meals.add(meal2);
        meals.add(meal3);
        meals.add(meal4);
        meals.add(meal5);


        Drink drink1 = new Drink("tea", 5);
        Drink drink2 = new Drink("cola", 2);
        Drink drink3 = new Drink("fanta", 2);
        Drink drink4 = new Drink("ayran", 1.50f);
        Drink drink5 = new Drink("ice tea", 3);

        drinks.add(drink1);
        drinks.add(drink2);
        drinks.add(drink3);
        drinks.add(drink4);
        drinks.add(drink5);


        Salad salad1 = new Salad("mimoza", 16);
        Salad salad2 = new Salad("capital", 14);
        Salad salad3 = new Salad("sezar", 16);
        Salad salad4 = new Salad("choban", 4);
        Salad salad5 = new Salad("fruit", 18);

        salads.add(salad1);
        salads.add(salad2);
        salads.add(salad3);
        salads.add(salad4);
        salads.add(salad5);

        categories.add(meals);
        categories.add(drinks);
        categories.add(salads);

    }


    public void creatingTables() {
        for (int i = 0; i < tables.length; i++) {
            tables[i] = new Table(i);
        }
    }

    public void creatingStuff() {
        Personnel personnel1 = new Personnel("Jack", "Daniel", 17, "jackdaniel@gmail.com", "09:00-17:00", 500);
        Personnel personnel2 = new Personnel("Taylor", "Frankinson", 17, "TaylorFrankson@gmail.com", "09:00-17:00", 500);
        Personnel personnel3 = new Personnel("Trevor", "Anderson", 23, "andersonn@gmail.com", "17:00-00:00", 700);
        Personnel personnel4 = new Personnel("Gil", "Stone", 30, "gilstone@gmail.com", "15:00-17:00", 200);
        Personnel personnel5 = new Personnel("Will", "Hunting", 22, "goodwillhunting@gmail.com", "00:00-09:00", 650);

        personnels.add(personnel1);
        personnels.add(personnel2);
        personnels.add(personnel3);
        personnels.add(personnel4);
        personnels.add(personnel5);
    }


    public void stuffLister() {

        List<List<String>> rows = new ArrayList<>();
        List<String> headers = Arrays.asList("|Number", "|Name", "|Surname", "|age", "|email", "|workhours", "|salary");
        rows.add(Arrays.asList("------------------------", "------------------------", "------------------------", "------------------------", "------------------------", "------------------------", "------------------------"));
        rows.add(headers);
        rows.add(Arrays.asList("------------------------", "------------------------", "------------------------", "------------------------", "------------------------", "------------------------", "------------------------"));
        int num = 1;
        for (Personnel personnel : personnels) {
            String number = Integer.toString(num) + ".";
            String Name = "|" + personnel.getName();
            String Surname = "|" + personnel.getSurname();
            String Age = "|" + Integer.toString(personnel.getAge());
            String email = "|" + personnel.getEmail();
            String workhours = "|" + personnel.getWorkHours();
            String salary = "|" + Float.toString(personnel.getSalary()) + "$";
            rows.add(Arrays.asList(number, Name, Surname, Age, email, workhours, salary));
            num++;
        }
        rows.add(Arrays.asList("------------------------", "------------------------", "------------------------", "------------------------", "------------------------", "------------------------", "------------------------"));
        System.out.println(formatAsTable(rows));
    }


    public void mealsLister() {
        System.out.println("M E A L S");
        for (Food meal : meals) {
            System.out.println(meal.getName() + "......" + meal.getPrice() + "$");
        }
    }

    public void drinksLister() {
        System.out.println("D R I N K S");
        for (Food meal : drinks) {
            System.out.println(meal.getName() + "......" + meal.getPrice() + "$");
        }
    }

    public void saladsLister() {
        System.out.println("S A L A D S");
        for (Food meal : salads) {
            System.out.println(meal.getName() + "......" + meal.getPrice() + "$");
        }
    }

    public void showMenu() {
        spaceMaker();
        mealsLister();
        spaceMaker();
        drinksLister();
        spaceMaker();
        saladsLister();
        spaceMaker();
    }

    public void showPersonnel(Personnel personnel) {
        List<List<String>> rows = new ArrayList<>();
        List<String> headers = Arrays.asList("|Name", "|Surname", "|age", "|email", "|workhours", "|salary");
        rows.add(Arrays.asList("------------------------", "------------------------", "------------------------", "------------------------", "------------------------", "------------------------"));
        rows.add(headers);
        rows.add(Arrays.asList("------------------------", "------------------------", "------------------------", "------------------------", "------------------------", "------------------------"));
        String Name = "|" + personnel.getName();
        String Surname = "|" + personnel.getSurname();
        String Age = "|" + Integer.toString(personnel.getAge());
        String email = "|" + personnel.getEmail();
        String workhours = "|" + personnel.getWorkHours();
        String salary = "|" + Float.toString(personnel.getSalary()) + "$";
        rows.add(Arrays.asList(Name, Surname, Age, email, workhours, salary));
        rows.add(Arrays.asList("------------------------", "------------------------", "------------------------", "------------------------", "------------------------", "------------------------"));
        System.out.println(formatAsTable(rows));


    }

    //-------------------------------------------------------
    public String takeAnStringInput() {
        String input = scanner.nextLine();
        return input;
    }

    public float takeAnFloatInput() {
        float f = 0;
        boolean condition = false;
        while (!condition) {
            try {
                f = Float.parseFloat(takeAnStringInput());
                condition = true;
            } catch (Exception e) {
                System.out.println("Try valid type!");
            }
        }
        return f;
    }

    public int takeAnIntegerInput() {
        int n = 0;
        boolean condition = false;
        while (condition != true) {
            try {
                n = Integer.parseInt(takeAnStringInput());
                condition = true;
            } catch (Exception e) {
                System.out.println("Try valid type!");
            }
        }
        return n;
    }

    public int mainMenu() {
        System.out.print(
                "|--------------------------------------------------|\n" +
                        "|                   MAIN MENU                      |\n" +
                        "|                                                  |\n" +
                        "|               1. Order Management                |\n" +
                        "|               2. Staff Management                |\n" +
                        "|               3. Menu Management                 |\n" +
                        "|               4. Show Today's profit             |\n" +
                        "|               5. Exit system                     |\n" +
                        "|                                                  |\n" +
                        "|             Please choose to continue:");
        int choose = takeAnIntegerInput();
        System.out.println("|--------------------------------------------------|");
        return choose;

    }

    public int choosingTables() {
        spaceMaker();
        System.out.print("\n please choose table!");
        int number = takeAnIntegerInput();
        boolean condition = false;
        while (condition != true) {
            if (number > 0 && number <= 9) {
                return number;
            } else {
                System.out.print("Please choose table in range");
                number = takeAnIntegerInput();
            }
        }
        spaceMaker();
        return number;
    }

    public int checkingTable(int number) {
        int status = 0;
        if (!"Empty".equals(tables[number].getStatus())) {
            status = 1;
        }
        return status;


    }

    public String formatAsTable(List<List<String>> rows) {
        int[] maxLengths = new int[rows.get(0).size()];
        for (List<String> row : rows) {
            for (int i = 0; i < row.size(); i++) {
                maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
            }
        }

        StringBuilder formatBuilder = new StringBuilder();
        for (int maxLength : maxLengths) {
            formatBuilder.append("%-").append(maxLength + 2).append("s");
        }
        String format = formatBuilder.toString();

        StringBuilder result = new StringBuilder();
        for (List<String> row : rows) {
            result.append(String.format(format, row.toArray(new String[0]))).append("\n");
        }
        return result.toString();
    }


}

interface Functions {
    void showMenu();

    void spaceMaker();

    void Login(User user);

    void deleteOrder(int number);

    void editSalary(Personnel personnel);

    void editWorkhours(Personnel personnel);

    void firePersonnel(Personnel personnel);

    void addPersonnel();

    void changePrice();

    void deleteFood();

    void creatingMenu();

    void creatingTables();

    void creatingStuff();

    void stuffLister();

    // --------------------------------------------------------------------------------------------------------------

    String takeAnStringInput();

    float takeAnFloatInput();

    int takeAnIntegerInput();

    int mainMenu();

    int choosingTables();

    int checkingTable(int number);

    String formatAsTable(List<List<String>> rows);


}


