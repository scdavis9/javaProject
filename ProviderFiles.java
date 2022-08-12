package src;

import java.util.HashMap;

/**
 * The ProviderFiles class. This creates and stores a hash map to store all members and their data.
 * 
 * @author Eleri Floyd
 * @version 1.0
 */
public class ProviderFiles {

    //public static int consultations; //counts number of consultations
    public static HashMap<Integer, Provider> providerMap = new HashMap<> (); //stores all providers and their information

    /**
     * Inserts provider and their corresponding information into has map to be stored
     * @param name the provider's name
     * @param accNumber the provider's account numer
     * @param address the provider's address
     * @param city the provider's city
     * @param state the provider's state
     * @param zip the provider's zip code
     */
    public static void insertProvider(String name, int accNumber, String address, String city, String state, int zip) {
        //fee currently initalized to 0
        Provider newProvider = new Provider(name, accNumber, address, city, state, zip, 0);
        providerMap.put(newProvider.accNumber, newProvider);
    }

    /**
     * Searches for a provider by their given account number
     * @param accNumber the provider's account number
     * @return the provider found at the given member number
     */
    public static Provider searchProvider(int accNumber) {
        if (providerMap.containsKey(accNumber)) {
            return providerMap.get(accNumber);
        }
        else {
            return null;
        }
    }

    /**
     * Removes provider with the given account number
     * @param accNumber the provider's account number
     */
    public static void removeProvider(int accNumber) {
        providerMap.remove(accNumber);
    }

}
