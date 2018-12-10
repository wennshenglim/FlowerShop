/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

/**
 *
 * @author kky
 */
public class CorporateCustomer {
      private String csID;
     private int creditlimit;

    public CorporateCustomer(String csID, int creditlimit) {
        this.csID = csID;
        this.creditlimit = creditlimit;
    }

    public String getCsID() {
        return csID;
    }

    public int getCreditlimit() {
        return creditlimit;
    }

    public void setCsID(String csID) {
        this.csID = csID;
    }

    public void setCreditlimit(int creditlimit) {
        this.creditlimit = creditlimit;
    }

    @Override
    public String toString() {
        return String.format("RM"+creditlimit);
    }
     
     
}
