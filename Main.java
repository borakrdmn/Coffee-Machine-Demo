package kafimesin;

import java.util.Scanner;

class kafimesin {
    static Scanner scanner = new Scanner(System.in);
    static boolean exit = false;
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;


    static void buy() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.next();
        switch (choice) {
            case "1": {
                if (isEnoughResources(250, 0, 16, 1)) {
                    water -= 250;
                    beans -= 16;
                    cups -= 1;
                    money += 4;
                    break;
                }
            }
            case "2": {
                if (isEnoughResources(350, 75, 20, 1)) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups -= 1;
                    money += 7;
                    break;
                }
            }
            case "3": {
                if (isEnoughResources(200, 100, 12, 1)) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups -= 1;
                    money += 6;
                    break;
                }
            }
            case "back": {
                break;
            }
            default: {
                break;
            }

        }
    }

    static void fill() {
        System.out.println();
        System.out.print("Write how many ml of water do you want to add: ");
        int waterAdd = scanner.nextInt();
        System.out.println();
        System.out.print("Write how many ml of milk do you want to add: ");
        int milkAdd = scanner.nextInt();
        System.out.println();
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        int beansAdd = scanner.nextInt();
        System.out.println();
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        int cupsAdd = scanner.nextInt();
        System.out.println();
        water += waterAdd;
        milk += milkAdd;
        beans += beansAdd;
        cups += cupsAdd;
    }

    static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    static void remaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }

    static void exit() {
        exit = true;
    }

    static boolean isEnoughResources(int waterNeed, int milkNeed, int beansNeed, int cupsNeed) {
        if (water >= waterNeed) {
            if (milk >= milkNeed) {
                if (beans >= beansNeed) {
                    if (cups >= cupsNeed) {
                        System.out.println("I have enough resources, making you a coffee!");
                        return true;
                    } else {
                        System.out.println("Sorry, not enough cups!");
                        return false;
                    }
                } else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }
            } else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    public static void main(String[] args) {
        do {
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    exit();
                    break;
            }

        }
        while (exit == false);
    }
}
