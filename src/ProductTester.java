import java.util.Arrays;
import java.util.Scanner;

public class ProductTester {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int maxSize = getNumProducts(in);

    if (maxSize == 0) {
      System.out.println("\nThere are no products!");
      getMenuOption(in);
    } else {
      Product productArr[] = new Product[maxSize];

      addToInventory(productArr, in);

      int menuChoice;

      do {
        menuChoice = getMenuOption(in);
        executeMenuChoice(menuChoice, productArr, in);
      } while (menuChoice != 0);

      in.close();
    }
  }

  public static void addToInventory(Product productArr[], Scanner in) {
    int stockChoice = -1;

    // TODO: Choose first which type of product, and only then how many of them

    do {
      try {
        System.out.println("\n1: CD");
        System.out.println("2: DVD");
        System.out.print("Type in the type of the product: ");

        in.nextLine();
        stockChoice = in.nextInt();

        if (stockChoice < 1 || stockChoice > 2) {
          System.out.println("\nInvalid option");
        }
      } catch (Exception e) {
        System.out.println("\nInvalid type of data entered");
      }
    } while (stockChoice < 1 || stockChoice > 2);

    if (stockChoice == 1) {
      addCDToInventory(productArr, in);
    } else if (stockChoice == 2) {
      addDVDToInventory(productArr, in);
    }
  }

  public static void addCDToInventory(Product productArr[], Scanner in) {
    for (int i = 0; i < productArr.length; i++) {
      in.nextLine();

      // TODO: add treatment to Number fields
      
      System.out.print("\nType in the CD name: ");
      String tempCDName = in.nextLine();

      System.out.print("Type in the artist name: ");
      String tempArtistName = in.nextLine();

      System.out.print("Type in the recording seal name: ");
      String tempRecSeal = in.nextLine();

      System.out.print("Type in the track count: ");
      int tempTrackCount = in.nextInt();

      System.out.print("Type in the stock quantity: ");
      int tempQty = in.nextInt();

      System.out.print("Type in the product price: ");
      double tempPrice = in.nextDouble();

      Product tempProduct = new CD(i, tempCDName, tempQty, tempPrice, tempArtistName, tempTrackCount, tempRecSeal);
      productArr[i] = tempProduct;
    }
  }

  public static void addDVDToInventory(Product productArr[], Scanner in) {
    for (int i = 0; i < productArr.length; i++) {
      in.nextLine();

      // TODO: add treatment to Number fields

      System.out.print("\nType in the DVD name: ");
      String tempDVDName = in.next();

      System.out.print("Type in the studio name: ");
      String tempStudioName = in.next();

      System.out.print("Type in the age rating: ");
      String tempAgeRating = in.next();

      System.out.print("Type in the movie duration: ");
      int tempDuration = in.nextInt();

      System.out.print("Type in the stock quantity: ");
      int tempQty = in.nextInt();

      System.out.print("Type in the product price: ");
      double tempPrice = in.nextDouble();

      Product tempProduct = new CD(i, tempDVDName, tempQty, tempPrice, tempStudioName, tempDuration, tempAgeRating);
      productArr[i] = tempProduct;
    }
  }

  public static String displayInventory(Product productArr[]) {
    Product tempArr[] = new Product[productArr.length];

    for (int i = 0; i < productArr.length; i++) {
      tempArr[i] = productArr[i];
    }

    return Arrays.toString(tempArr);
  }

  public static int getNumProducts(Scanner in) {
    int maxSize = -1;

    do {
      try {
        System.out.println("Type in how many products you want to add");
        System.out.println("Type 0 if you don't want to add products");

        maxSize = in.nextInt();

        if (maxSize < 0) {
          System.out.println("\nOnly positive numbers or zero are allowed!");
        }
      } catch (Exception e) {
        System.out.println("\nIncorrect type of data entered");
        in.nextLine();
      }
    } while (maxSize < 0);

    return maxSize;
  }

  public static int getMenuOption(Scanner in) {
    int menuChoice = -1;

    do {
      try {
        System.out.println("\n1. Show inventory");
        System.out.println("2. Add stock");
        System.out.println("3. Deduct stock");
        System.out.println("4. Discontinue product");
        System.out.println("0. Exit");
        System.out.print("Insert a menu option: ");

        menuChoice = in.nextInt();
        System.out.println();

        if (menuChoice < 0 || menuChoice > 4) {
          System.out.println("\nIncorrect option.");
        }
      } catch (Exception e) {
        System.out.println("\nIncorrect type of data entered");
        in.nextLine();
      }
    } while (menuChoice > 4 || menuChoice < 0);

    return menuChoice;
  }

  public static void executeMenuChoice(int menuChoice, Product productArr[], Scanner in) {
    switch (menuChoice) {
      case 1:
        // TODO: format this output
        System.out.println(displayInventory(productArr));
        break;
      case 2:
        addInventory(productArr, in);
        break;
      case 3:
        deductInventory(productArr, in);
        break;
      case 4:
        discontinueInventory(productArr, in);
        break;
    }
  }

  public static int getProductNumber(Product productArr[], Scanner in) {
    int productChoice = -1;

    do {
      try {
        for (int i = 0; i < productArr.length; i++) {
          System.out.print(productArr[i].getId() + " - ");
          System.out.println(productArr[i].getName());
        }
        
        System.out.print("Select a product by it's ID: ");

        productChoice = in.nextInt();

        if (productChoice < 0 || productChoice >= productArr.length) {
          System.out.println("\nIncorrect option");
        }
      } catch (Exception e) {
        System.out.println("\nIncorrect type of data entered");
        in.nextLine();
      }
    } while (productChoice < 0 || productChoice >= productArr.length);

    return productChoice;
  }

  public static void addInventory(Product productArr[], Scanner in) {
    int productChoice;
    int updateValue = -1;

    productChoice = getProductNumber(productArr, in);

    if (!productArr[productChoice].isActive()) {
      System.out.println("\nCan't add stock to discontinued products");
      System.out.println("Returning to menu...");
    } else {
      do {
        try {
          System.out.print("Type how many products you want to add: ");
          updateValue = in.nextInt();

          if (updateValue < 0) {
            System.out.println("\nNegative numbers not allowed");
          }
        } catch (Exception e) {
          System.out.println("\nInvalid type of data entered");
          in.nextLine();
        }
      } while (updateValue < 0);

      productArr[productChoice].addToInventory(updateValue);
    }
  }

  public static void deductInventory(Product productArr[], Scanner in) {
    int productChoice;
    int updateValue = -1;

    productChoice = getProductNumber(productArr, in);
    int currentQty = productArr[productChoice].getQty();

    do {
      try {
        System.out.print("Type how many products you want to deduct: ");
        updateValue = in.nextInt();

        if (updateValue < 0) {
          System.out.println("\nNegative numbers not allowed");
        } else if (updateValue > currentQty) {
          System.out.println("\nCan't deduct more items than the current stock has");
        }
      } catch (Exception e) {
        System.out.println("\nInvalid type of data entered");
        in.nextLine();
      }
    } while (updateValue < 0 || updateValue > currentQty);

    productArr[productChoice].deductFromInventory(updateValue);
  }

  // TODO: add recontinue inventory method

  public static void discontinueInventory(Product productArr[], Scanner in) {
    int productChoice = getProductNumber(productArr, in);

    productArr[productChoice].setActive(false);
  }
}
