/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package investmentPortfolio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ibro-
 */
/**
 * File: Portfolio.java Author: Ibrahim Thai Date: November 10, 2017 Brief
 * Description: File containing the menu and process of the project
 */
public class Portfolio {

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        FileWriter file;
        String investmentFile = "myInvestment.txt";

        /* Set every Investment attribute to nothing */
        Stock myStock = new Stock("", "", "", 0, 0.00, 0.00);
        MutualFund myMutualFund = new MutualFund("", "", "", 0, 0.00, 0.00);

        /* Hash map search by keyword (String) and investment index locations (Integer) */
        Map< String, ArrayList<Integer>> investmentHashMap = new HashMap< String, ArrayList<Integer>>();

        /* Holds ALL investment types: Stock and Mutual Fund */
        List<Investment> investmentArray = new ArrayList<>();

        /* Create scanner inputs for investment type */
        Scanner inputInvestmentType = new Scanner(System.in);

        /*Create scanner inputs for each Stock attribute*/
        Scanner inputStockSymbol = new Scanner(System.in);
        Scanner inputStockName = new Scanner(System.in);
        Scanner inputStockQuantity = new Scanner(System.in);
        Scanner inputStockPrice = new Scanner(System.in);

        /*Create scanner inputs for each Mutual Fund attribute*/
        Scanner inputMutualFundSymbol = new Scanner(System.in);
        Scanner inputMutualFundName = new Scanner(System.in);
        Scanner inputMutualFundQuantity = new Scanner(System.in);
        Scanner inputMutualFundPrice = new Scanner(System.in);

        /* Create scanner for choices */
        Scanner inputChoice = new Scanner(System.in);

        Scanner inputSymbolToSell = new Scanner(System.in);
        Scanner inputEditQuantity = new Scanner(System.in);

        Scanner inputNewPrice = new Scanner(System.in);
        Scanner inputSearchType = new Scanner(System.in);
        Scanner inputSearchName = new Scanner(System.in);
        Scanner inputSearchSymbol = new Scanner(System.in);

        // Search by price range
        Scanner inputPriceMin = new Scanner(System.in);
        Scanner inputPriceMax = new Scanner(System.in);

        /* Stock Book Value equation variables */
        double stockBookValueEquation = 0.00;
        double commissionFee = 9.99;

        double mutualFundBookValueEquation = 0.00;
        double redemptionFee = 45.00;

        // Investment gain equations and variables
        double totalGain = 0.00;
        double stockGainEquation = 0.00;
        double mutualFundGainEquation = 0.00;

        int quantityEdits = 0;

        // When user inputs the price range to SEARCH
        double priceMin = 0.00;
        double priceMax = 0.00;

        // Choice menu
        String choice;

        // Miscellaneous
        String symbol;
        String search;
        String searchType;
        String searchSymbol;
        double newPrice = 0.00;

        // Hold variables (temp)
        double currentBookValue = 0.00;
        int currentQuantity = 0;

        // Stock or Mutualfund
        String investmentType;

        // Loop Counters
        int i = 0;

        /* LOAD FILE HERE */
        // Variable to load investment files
        for (String fileName : args) {
            System.out.println(fileName);

            BufferedReader reader;

            try {
                // Read file name
                reader = new BufferedReader(new FileReader(fileName));

                // Read line in the file
                String readLine;

                System.out.println("\nList of Investments Uploaded");
                System.out.println("==============================");

                // Keep reading the line until the end of file
                while ((readLine = reader.readLine()) != null) {
                    // Prints out the list of investments
                    System.out.println(readLine);

                    Investment myInvestment = new Investment("", "", "", 0, 0.00, 0.00);

                    // Split the attributes (in the file) seperated by a comma
                    String[] investmentAttributes = readLine.split(",");

                    // Add investment attributes
                    // Investment Type (Stock or Mutual Fund)
                    myInvestment.setInvestmentType(investmentAttributes[0]);
                    myInvestment.getInvestmentType();

                    // Investment Symbol
                    myInvestment.setSymbol(investmentAttributes[1]);
                    myInvestment.getSymbol();

                    // Investment Name
                    myInvestment.setName(investmentAttributes[2]);
                    myInvestment.getName();

                    // Investment Quantity
                    myInvestment.setQuantity(Integer.valueOf(investmentAttributes[3]));
                    myInvestment.getQuantity();

                    // Investment Price
                    myInvestment.setPrice(Double.valueOf(investmentAttributes[4]));
                    myInvestment.getPrice();

                    // Investment Book Value
                    myInvestment.setBookValue(Double.valueOf(investmentAttributes[5]));
                    myInvestment.getBookValue();

                    investmentArray.add(myInvestment);

                }

            } catch (IOException e) {
                System.out.println("Unable to read file!");
            }

        } // End of searching for file name in command line argument

        /**
         * ***********************
         */
        /* SIMULATION STARTS HERE */
        /**
         * ***********************
         */
        while (true) {
            System.out.println("\n1. Buy: Own a new investment or add more quantity to an existing investment.");
            System.out.println("2. Sell: Reduce some quantity of an existing investment.");
            System.out.println("3. Update: Refresh the prices of all existing investments.");
            System.out.println("4. GetGain: Compute the total gain of the portfolio by accumulating the gains of all its investments.");
            System.out.println("5. Search: Find a specific investment in the portfolio");
            System.out.println("6. Display list of investments");
            System.out.println("7. Save and Quit");

            System.out.println("\nInput choice");
            choice = inputChoice.nextLine();

            /**
             * ****************************************************************************
             */
            /* 1. Buy: Own a new investment or add more quantity to an existing investment */
            /**
             * ****************************************************************************
             */
            if (choice.equals("1") || choice.equalsIgnoreCase("Buy") || choice.equalsIgnoreCase("B")) {

                System.out.println("\n1. Stock");
                System.out.println("2. MutualFund");

                investmentType = inputInvestmentType.nextLine();

                // ADD STOCK 
                if (investmentType.equals("1") || investmentType.equalsIgnoreCase("Stock")) {
                    myStock = new Stock("", "", "", 0, 0.00, 0.00);

                    // INVESTMENT TYPE (String)
                    myStock.setInvestmentType("Stock");
                    myStock.getInvestmentType();

                    // SYMBOL (String)
                    System.out.println("\nInput symbol: ");
                    myStock.setSymbol(inputStockSymbol.nextLine());
                    myStock.getSymbol();

                    // Loop through each investment in the array
                    for (i = 0; i < investmentArray.size(); i++) {
                        // If there's a duplicate symbol in the array
                        while (investmentArray.get(i).getSymbol().equals(myStock.getSymbol())) {
                            System.out.println("Symbol already existed!");
                            System.out.println("\nInput symbol again: ");
                            myStock.setSymbol(inputStockSymbol.nextLine());
                            myStock.getSymbol();
                        }
                    }

                    // TITLE (String)
                    System.out.println("\nInput name: ");
                    myStock.setName(inputStockName.nextLine());
                    myStock.getName();

                    // SECURITY FOR INVESTMENT QUANTITY
                    boolean quantityCheck = false;
                    do {
                        try {
                            quantityCheck = true;

                            System.out.println("\nInput quantity: ");
                            myStock.setQuantity(Integer.parseInt(inputStockQuantity.nextLine()));

                            if (myStock.getQuantity() < 0) {
                                quantityCheck = false;
                                System.out.println("\nError inputting the quantity!");
                            }

                        } catch (NumberFormatException error) {
                            quantityCheck = false;
                            System.out.println("\nError inputting the quantity!");
                        }

                    } while (quantityCheck != true);

                    myStock.getQuantity();

                    // PRICE (Double)
                    boolean priceCheck = false;

                    // SECURITY FOR STOCK PRICE
                    do {
                        try {
                            priceCheck = true;

                            System.out.println("\nInput price of stock: ");
                            myStock.setPrice(Double.parseDouble(inputStockPrice.nextLine()));

                            if (myStock.getPrice() < 0) {
                                priceCheck = false;
                                System.out.println("\nError inputting a price!");
                            }

                        } catch (NumberFormatException error) {
                            priceCheck = false;
                            System.out.println("\nError inputting a price!");
                        }

                    } while (priceCheck != true);

                    myStock.getPrice();

                    // Calculate Stock bookValue
                    stockBookValueEquation = myStock.getQuantity() * myStock.getPrice() + commissionFee;

                    myStock.setBookValue(stockBookValueEquation);

                    // Stock Book Value
                    myStock.getBookValue();

                    // Add to investment array
                    investmentArray.add((Investment) myStock);

                } // END OF ADDING INVESTMENT STOCK
                // ADD MUTUALFUND
                else if (investmentType.equals("2") || investmentType.equalsIgnoreCase("MutualFund")) {
                    myMutualFund = new MutualFund("", "", "", 0, 0.00, 0.00);

                    myMutualFund.setInvestmentType("Mutual Fund");
                    myMutualFund.getInvestmentType();

                    // SYMBOL (String)
                    System.out.println("\nInput symbol: ");
                    myMutualFund.setSymbol(inputMutualFundSymbol.nextLine());
                    myMutualFund.getSymbol();

                    // Loop through each investment in the array
                    for (i = 0; i < investmentArray.size(); i++) {
                        // If there's a duplicate symbol in the array
                        while (investmentArray.get(i).getSymbol().equals(myMutualFund.getSymbol())) {
                            System.out.println("Symbol already existed!");
                            System.out.println("\nInput symbol again: ");
                            myMutualFund.setSymbol(inputMutualFundSymbol.nextLine());
                            myMutualFund.getSymbol();
                        }

                    } // END OF LOOP THROUGH EACH INVESTMENT ARRAY   

                    // TITLE (String)
                    System.out.println("\nInput name: ");
                    myMutualFund.setName(inputMutualFundName.nextLine());
                    myMutualFund.getName();

                    // SECURITY FOR INVESTMENT QUANTITY
                    boolean quantityCheck = false;
                    do {
                        try {
                            quantityCheck = true;

                            System.out.println("\nInput quantity: ");
                            myMutualFund.setQuantity(Integer.parseInt(inputMutualFundQuantity.nextLine()));

                            if (myMutualFund.getQuantity() < 0) {
                                quantityCheck = false;
                                System.out.println("\nError inputting the quantity!");
                            }

                        } catch (NumberFormatException error) {
                            quantityCheck = false;
                            System.out.println("\nError inputting the quantity!");
                        }

                    } while (quantityCheck != true);

                    myMutualFund.getQuantity();

                    // PRICE
                    boolean priceCheck = false;

                    // SECURITY FOR STOCK PRICE
                    do {
                        try {
                            priceCheck = true;

                            System.out.println("\nInput price of Mutual Fund: ");
                            myMutualFund.setPrice(Double.parseDouble(inputMutualFundPrice.nextLine()));

                            if (myMutualFund.getPrice() < 0) {
                                priceCheck = false;
                                System.out.println("\nError inputting a price!");
                            }

                        } catch (NumberFormatException error) {
                            priceCheck = false;
                            System.out.println("\nError inputting a price!");
                        }

                    } while (priceCheck != true);

                    myMutualFund.getPrice();

                    // Calculate Mutual Fund bookValue
                    mutualFundBookValueEquation = myMutualFund.getQuantity() * myMutualFund.getPrice();
                    myMutualFund.setBookValue(mutualFundBookValueEquation);

                    // Mutual Fund Book Value
                    myMutualFund.getBookValue();

                    // Add to investment array
                    investmentArray.add((Investment) myMutualFund);

                } // END OF ADDING INVESTMENT MUTUAL FUND
                else {
                    System.out.println("\nInvalid choice. Going back to menu!");
                }

            } // END OF CHOICE 1: BUY
            /**
             * ********************************************************
             */
            /* 2. Sell: reduce some quantity of an existing investment */ /**
             * ********************************************************
             */
            else if (choice.equals("2")) {
                // Check if investment array is empty
                if (investmentArray.isEmpty()) {
                    System.out.println("\nInvestment list is empty. Nothing to sell! ");
                } // If there's something in the investment array
                else {
                    // Removes the square brackets and commas that the toString included
                    System.out.println("List of Investments to Sell");
                    System.out.println("===========================");
                    System.out.println(investmentArray.toString().replace("[", "").replace("]", "").replace(", ", ""));

                    System.out.println("\nInput symbol of what you want to sell: ");
                    symbol = inputSymbolToSell.nextLine();

                    boolean quantityCheck = false;

                    // SECURITY FOR STOCK QUANTITY
                    do {
                        try {
                            quantityCheck = true;

                            System.out.println("\nInput quantity of investment: ");
                            quantityEdits = Integer.parseInt(inputEditQuantity.nextLine());

                            if (quantityEdits < 0) {
                                quantityCheck = false;
                                System.out.println("\nError inputting the quantity!");
                            }

                        } catch (NumberFormatException error) {
                            quantityCheck = false;
                            System.out.println("\nError inputting the quantity!");
                        }

                    } while (quantityCheck != true); // SECURITY ENDS HERE

                    // Loop through each investment in the array
                    for (i = 0; i < investmentArray.size(); i++) {
                        // If we can't find the symbol (that the user wants to sell)
                        if (investmentArray.get(i).getSymbol().equals(symbol)) {
                            /* Remove the investment if we don't have enough quantity */
                            if (investmentArray.get(i).getQuantity() <= quantityEdits) {
                                // Remove it from HashMap first, before removing the entire object
                                investmentHashMap.remove(investmentArray.get(i).getName());
                                investmentArray.remove(i);

                                System.out.println("\nInvestment removed due to lack of quantity!");
                                break;
                            } else {

                                // Value changing for Stock : Quantity and Book Value
                                if (investmentArray.get(i).getInvestmentType().equals("Stock")) {
                                    // Set your current quantity in a variable
                                    currentQuantity = investmentArray.get(i).getQuantity();

                                    // Subtract quantities
                                    investmentArray.get(i).setQuantity(investmentArray.get(i).getQuantity() - quantityEdits);

                                    // Book Value * (current quantity - quantity selling) / current quantity
                                    investmentArray.get(i).setBookValue(investmentArray.get(i).getBookValue() * (currentQuantity - quantityEdits) / currentQuantity);

                                } // Value changing for Mutual Fund : Quantity and Book Value
                                else if (investmentArray.get(i).getInvestmentType().equals("Mutual Fund")) {
                                    // Set your current quantity in a variable
                                    currentQuantity = investmentArray.get(i).getQuantity();

                                    // Set your current Book Value in a variable
                                    currentBookValue = investmentArray.get(i).getBookValue();

                                    investmentArray.get(i).setBookValue(currentBookValue * (currentQuantity - quantityEdits) / currentQuantity);

                                }

                                System.out.println("Investment successfully changed!");
                                System.out.println(investmentArray.get(i).toString().replace("[", "").replace("]", "").replace(", ", ""));
                                break;
                            }
                        }

                    } // END OF LOOP THROUGH EACH INVESTMENT ARRAY  

                }

            } // END OF CHOICE 2: SELL
            /**
             * ***********************************************************
             */
            /* 3. Update: Refresh the prices for all existing investments */ /**
             * ***********************************************************
             */
            else if (choice.equals("3")) {
                // Check if investment array is empty
                if (investmentArray.isEmpty()) {
                    System.out.println("\nList is empty. Nothing to update!");
                } // If there's something in the investment array
                else {
                    // Loop through each investment in the array
                    for (i = 0; i < investmentArray.size(); i++) {
                        System.out.println(investmentArray.get(i).toString().replace("[", "").replace("]", "").replace(", ", ""));

                        boolean priceCheck = false;

                        // SECURITY FOR NEW PRICE
                        do {
                            try {
                                priceCheck = true;

                                System.out.println("Input new price for the investment above: ");
                                newPrice = Double.parseDouble(inputNewPrice.nextLine());

                                if (newPrice < 0) {
                                    priceCheck = false;
                                    System.out.println("\nError inputting the new price!");
                                }

                            } catch (NumberFormatException error) {
                                priceCheck = false;
                                System.out.println("\nError inputting the new price!");
                            }

                        } while (priceCheck != true); // SECURITY ENDS HERE

                        // Update every new price per investment
                        investmentArray.get(i).setPrice(newPrice);

                        // Check if it's a Stock or a Mutual Fund
                        if (investmentArray.get(i).getInvestmentType().equals("Stock")) {
                            // Calculate Stock gain
                            stockGainEquation = (investmentArray.get(i).getQuantity() * investmentArray.get(i).getPrice() - commissionFee) - investmentArray.get(i).getBookValue();

                            // Get the gain for Stock
                            investmentArray.get(i).setGain(stockGainEquation);

                        } else if (investmentArray.get(i).getInvestmentType().equals("Mutual Fund")) {
                            // Calculate Mutual Fund gain
                            mutualFundGainEquation = (investmentArray.get(i).getQuantity() * investmentArray.get(i).getPrice() - redemptionFee) - investmentArray.get(i).getBookValue();

                            // Get the gain for Mutual Fund
                            investmentArray.get(i).setGain(mutualFundGainEquation);
                        }

                    } // End of loop for updating every price per investment 

                }

            } // END OF CHOICE 3: UPDATE
            /**
             * ****************************************************************************************************
             */
            /* 4. getGain: Compute the total gain of the portfolio by accumulating the gain of all its investments */ /**
             * ****************************************************************************************************
             */
            else if (choice.equals("4")) {
                totalGain = 0.00;

                // Loop through each investment in the array
                for (i = 0; i < investmentArray.size(); i++) {
                    totalGain += investmentArray.get(i).getGain();
                }

                System.out.println("\n");
                System.out.println(String.format("Total gain: $%.2f", totalGain));

            } // END OF CHOICE 4: GET GAIN
            /**
             * **********
             */
            /* 5. Search */ /**
             * **********
             */
            else if (choice.equals("5") || choice.equalsIgnoreCase("Search")) {
                // SEARCH TYPE MENU
                System.out.println("\n1. Search by symbol");
                System.out.println("2. Search by keyword");
                System.out.println("3. Search by price");

                System.out.println("\nInput search type: ");
                searchType = inputSearchType.nextLine();

                // SEARCH BY SYMBOL
                if (searchType.equals("1") || searchType.equalsIgnoreCase("Symbol")) {
                    // Input symbol to search for
                    System.out.println("\nInput symbol of stock: ");
                    searchSymbol = inputSearchSymbol.nextLine();

                    // Loop through each stock in ArrayList
                    for (i = 0; i < investmentArray.size(); i++) {
                        while (investmentArray.get(i).getSymbol().equals(searchSymbol)) {
                            System.out.println(investmentArray.get(i).toString().replace("[", "").replace("]", "").replace(", ", ""));
                            break;
                        }

                    }

                } // END OF "SEARCH BY SYMBOL"
                // SEARCH BY KEYWORD (USING HASHMAPS)
                else if (searchType.equals("2") || searchType.equalsIgnoreCase("Keyword")) {
                    String words[];

                    // Insert all investment names to Hash Maps (in split words)
                    for (i = 0; i < investmentArray.size(); i++) {
                        // Split the words (making a word array)
                        words = investmentArray.get(i).getName().trim().split("\\s+");

                        // Add each word in that one line (making them the keyword)
                        for (String splitWords : words) {
                            investmentHashMap.put(splitWords, new ArrayList<Integer>());
                        }

                    }

                    Collection<String> nameSplitted = investmentHashMap.keySet();
                    Iterator<String> iterateSplittedNames = nameSplitted.iterator();

                    int index = 0;

                    // Algorithm to upload all the indices in the right place for each keyword
                    while (iterateSplittedNames.hasNext()) {
                        String currentWord = iterateSplittedNames.next();

                        for (i = 0; i < investmentArray.size(); i++) {
                            if (investmentArray.get(i).getName().toLowerCase().contains(currentWord.toLowerCase())) {
                                index = i;
                                investmentHashMap.get(currentWord).add(index);
                            }

                        }

                    }

                    // Search for keyword
                    System.out.println("Input name for search: ");
                    search = inputSearchName.nextLine();

                    // If it's just one word
                    if (!search.contains(" ")) {
                        if (investmentHashMap.get(search) == null) {
                            System.out.println("keyword not found!\n");
                        } else {
                            // Print splitted names (Hash Maps)
                            System.out.println("Key: " + search);
                            System.out.println("Value: A list of " + Arrays.asList(investmentHashMap.get(search)));
                        }

                    } // If there's multiple words in the name
                    else {
                        String breakKeywords[];

                        breakKeywords = search.trim().split("\\s+");

                        for (String printKeywordInfo : breakKeywords) {
                            if (investmentHashMap.get(printKeywordInfo) == null) {
                                System.out.println("keyword not found!\n");
                            } else {
                                System.out.println("Key: " + printKeywordInfo);
                                System.out.println("Value: A list of " + Arrays.asList(investmentHashMap.get(printKeywordInfo)));
                            }

                        }

                    }

                } // END OF "SEARCH BY KEYWORD"
                /* 3. SEARCH BY PRICE */ else if (searchType.equals("3") || searchType.equalsIgnoreCase("price")) {
                    /* Input price range */
                    System.out.println("\nInput minimum price range: ");
                    priceMin = inputPriceMin.nextDouble();

                    System.out.println("\nInput maximum price range: ");
                    priceMax = inputPriceMax.nextDouble();

                    /**
                     * *************************************
                     */
                    /* Loop through each stock in ArrayList */
                    /**
                     * *************************************
                     */
                    System.out.println("\nInvestments Based on Price Range");
                    System.out.println("==================================");

                    for (i = 0; i < investmentArray.size(); i++) {
                        while (investmentArray.get(i).getPrice() > priceMin && investmentArray.get(i).getPrice() < priceMax) {
                            System.out.println(investmentArray.get(i).toString().replace("[", "").replace("]", "").replace(", ", ""));
                            break;
                        }

                    }

                } // END OF SEARCH BY PRICE RANGE

            } // END OF CHOICE 5: SEARCH
            /**
             * *******************************
             */
            /* 6. Display List of Investments */ /**
             * *******************************
             */
            else if (choice.equals("6") || choice.equalsIgnoreCase("Display")) {
                System.out.println("List of Investments");
                System.out.println("===================");
                System.out.println(investmentArray.toString().replace("[", "").replace("]", "").replace(", ", ""));

            } // END OF CHOICE 6: DISPLAY
            /**
             * *****************
             */
            /* 7. Quit and Save */ /**
             * *****************
             */
            else if (choice.equals("7") || choice.equalsIgnoreCase("Quit")) {
                for (String fileName : args) {
                    System.out.println(fileName);

                    BufferedReader reader;

                    try {
                        // Read file name
                        reader = new BufferedReader(new FileReader(fileName));

                        // Read line in the file
                        String readLine;

                        System.out.println("\nList of Investments Uploaded");
                        System.out.println("==============================");

                        // Keep reading the line until the end of file
                        while ((readLine = reader.readLine()) != null) {
                            file = new FileWriter(fileName);

                            BufferedWriter writeToInvestment = new BufferedWriter(file);

                            for (Investment uploadInvestments : investmentArray) {
                                writeToInvestment.write(uploadInvestments.getInvestmentType() + ",");
                                writeToInvestment.write(uploadInvestments.getSymbol() + ",");
                                writeToInvestment.write(uploadInvestments.getName() + ",");
                                writeToInvestment.write(uploadInvestments.getQuantity() + ",");
                                writeToInvestment.write(String.valueOf(uploadInvestments.getPrice()) + ",");
                                writeToInvestment.write(String.valueOf(uploadInvestments.getBookValue()) + "\n");
                            }

                            writeToInvestment.close();
                        }

                        System.out.println("Data successfully saved to " + fileName);

                    } catch (IOException e) {
                        System.out.println("Unable to read file!");

                        file = new FileWriter(investmentFile);

                        BufferedWriter writeToInvestment = new BufferedWriter(file);

                        for (Investment uploadInvestments : investmentArray) {
                            writeToInvestment.write(uploadInvestments.getInvestmentType() + ",");
                            writeToInvestment.write(uploadInvestments.getSymbol() + ",");
                            writeToInvestment.write(uploadInvestments.getName() + ",");
                            writeToInvestment.write(uploadInvestments.getQuantity() + ",");
                            writeToInvestment.write(String.valueOf(uploadInvestments.getPrice()) + ",");
                            writeToInvestment.write(String.valueOf(uploadInvestments.getBookValue()) + "\n");
                        }

                        writeToInvestment.close();

                        System.out.println("Data successfully saved to " + investmentFile);
                    }

                } // End of searching for file name in command line argument

                return;

            } // END OF CHOICE 7: QUIT
            /* If choices are beyond the given choices */ else {
                System.out.println("Invalid choice!");
            }

        }
        /* END OF SIMULATION */


    } // END OF MAIN

} // END OF CLASS PORTFOLIO

