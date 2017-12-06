/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investmentPortfolio;

/**
 *
 * @author ibro-
 */

/**
 * File: Investment.java   
 * Author: Ibrahim Thai   
 * Date: November 10, 2017   
 * Brief Description: A superclass to hold the investment subclasses
 */

/* THE SUPER CLASS */
public class Investment {
    
    /* Stock attributes */
    private String investmentType;
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue;
    
    // NOT an input!
    private double gain;
    
    /******************************/
    /* CONSTRUCTOR TO INVESTMENTS */
    /******************************/

    /**
     * @param investmentType* The investment type (Stock or MutualFund).
     * @param symbol* The investment symbol.
     * @param name* The investment name.
     * @param quantity* The investment quantity.
     * @param price* The investment price.
     * @param bookValue* The investment bookValue (NOT an input).
     */
    public Investment(String investmentType, String symbol, String name, int quantity, double price, double bookValue) 
    {
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.bookValue = bookValue;
    }
    
    /**************************************/
    /* GETTERS AND SETTERS TO INVESTMENTS */
    /**************************************/
    
    
    /**
     * 
     * @return investmentType
     */
    public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}
	
	/**
     * 
     * @return symbol
     */
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * 
     * @return bookValue
     */
    public double getBookValue() {
        return bookValue;
    }

    public void setBookValue(double bookValue) {
        this.bookValue = bookValue;
    }
    
    /**
     * 
     * @return getGain
     */
    public double getGain() {
		return gain;
	}

	public void setGain(double gain) {
		this.gain = gain;
	}
    
    
    @Override
    /**
    *@return The investment object in a String format
    **/
    public String toString()
    {
        return String.format("Type : %s\nSymbol : %s\nName : %s\nQuantity : %d\nPrice : $%.2f\nbookValue : $%.2f\n\n", this.investmentType, this.symbol, this.name, this.quantity, this.price, this.bookValue);
    }
    
    
    
    
}
