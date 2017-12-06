*****************************
Investment Portfolio Manager
Author: Ibrahim Thai
*****************************

*********************
Program Description
*********************
This program is a portfolio containing a list of investments. With investments like Stocks and MutualFunds, you're able to add and sell, search, update their prices, and compute the total gain of the portfolio. Attributes like the symbol, name, quantity, price, and bookValue, we're able to hold an object of Stocks or Mutual Funds. 

I used to have this project only run by NetBeans IDE. But now, it's much more defensive, efficient, and is able to run on the Command Prompt. With this program, it also features opening a text file (on the command line) which contains data that you've saved after the program ends. There will be a few test cases that I've made, to show that this program can open them and will be added to the list (in the program).

NOTE: This programs opens a *.txt file. Which means each investment data (the attributes) is going to be organized in one line. 

************************************************************
Compilation Instruction (on Command Line or Command Prompt)
************************************************************
NOTE: Before you compile, you must install the JDK (Java Development Kit) to be able to run the "javac" command. The command "javac" allows you to run java files that are classes.

1. Open the Command Prompt (for Windows).
2. Go to the "Investment-Portfolio-Manager" project directory.
3. Now go to the "src" directory, which will see the package folder called "investmentPortfolio", containing all *.java files.

Running entire package
======================
To compile, input on the command line: 

Run: javac investmentPortfolio\*.java

After it compiles without error, now we run the file by inputting:

Run: java investmentPortfolio.Portfolio

				OR

Run: java investmentPortfolio.Portfolio testCase1.txt

				OR

Run: java investmentPortfolio.Portfolio testCase2.txt

				OR

Run: java investmentPortfolio.Portfolio testCase3.txt


NOTE: If you input the wrong file name, everything you do in this program will be saved to "myInvestment.txt".


After you're done, delete the *.class files by inputting:

Run: DEL investmentPortfolio\*.class			


*********************
Limitations & Errors
*********************
- When you "Search by Keyword" (the one you use for HashMaps), it's case-sensitive. So if there's an investment containing the word "Bank" and you search for "bank", it won't show.

- After you "load" the file and try to display it (Choice 6: Display Investments), it can only show you 8 investments. When you add more than 8 investments, it won't show the first investment. This sitation occurs ONLY when you use Command Prompt.

