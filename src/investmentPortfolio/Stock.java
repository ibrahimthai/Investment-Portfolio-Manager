/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @file Stock.java
 * @author Ibrahim Thai
 * @date November 10, 2017
 * @brief A subclass linked to Investment.java containing the function methods of a stock investment
 */

package investmentPortfolio;

/**
 *
 * @author ibro-
 */

/* THE SUB CLASS */
public class Stock extends Investment {
    
    protected String stockType = "Stock";
    
    /*************************/
    /* CONSTRUCTOR TO STOCKS */
    /*************************/

    
    /**
     * @param investmentType* The investment type.
     * @param symbol* The stock symbol.
     * @param name* The stock name.
     * @param quantity* The stock quantity.
     * @param price* The stock price.
     * @param bookValue* The stock bookValue (NOT an input).
     */
    public Stock(String investmentType, String symbol, String name, int quantity, double price, double bookValue) 
    {
        super(investmentType, symbol, name, quantity, price, bookValue);
    }
    
    /**
     *@return stockType
     **/
    public String getstockType() {
        return stockType;
    }

    public void setstockType(String stockType) {
        this.stockType = stockType;
    }
    
    
    @Override
    /**
    *@return the Stock investment object in a String format
    **/
    public String toString()
    {
        return "\n" + super.toString();
    
    }
    

    
} // End of Stock class
