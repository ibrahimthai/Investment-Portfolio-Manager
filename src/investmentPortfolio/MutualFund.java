/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @file MutualFund.java
 * @author Ibrahim Thai
 * @date November 10, 2017
 * @brief A subclass linked to Investment.java containing the function methods of a mutual fund investment
 */
package investmentPortfolio;

/**
 *
 * @author ibro-
 */

/* THE SUB CLASS */
public class MutualFund extends Investment {
    
	protected String mutualFundType = "Mutual Fund";
	
    /******************************/
    /* CONSTRUCTOR TO MUTUALFUNDS */
    /******************************/

	/**
     * @param investmentType* The investment type.
     * @param symbol* The stock symbol.
     * @param name* The stock name.
     * @param quantity* The stock quantity.
     * @param price* The stock price.
     * @param bookValue* The stock bookValue (NOT an input).
     */
    public MutualFund(String investmentType, String symbol, String name, int quantity, double price, double bookValue) 
    {
        super(investmentType, symbol, name, quantity, price, bookValue);
    }
    
    /**
     *@return mutualFundType
     **/
    public String getMutualFundType() {
		return mutualFundType;
	}


	public void setMutualFundType(String mutualFundType) {
		this.mutualFundType = mutualFundType;
	}
    
    
    @Override
    /**
    *@return the MutualFund investment object in a String format
    **/
    public String toString()
    {
        return "\n" + super.toString();
    
    }
    
    
    
} // End of class
