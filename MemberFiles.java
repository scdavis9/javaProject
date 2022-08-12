package src; //deals with adding, searching, and removing members from list

import java.util.HashMap;

import src.Member.memberStatus;

/**
 * The MemberFiles class. This creates and stores a hash map to store all members and their data.
 * 
 * @author Eleri Floyd
 * @version 1.0
 */
public class MemberFiles {
    public static HashMap<Integer, Member> memberMap = new HashMap<> ();

    /**
     * Inserts member and their corresponding information into hash map to be stored
     * @param name the member's name
     * @param accNumber the member's account numer
     * @param address the member's address
     * @param city the member's city
     * @param state the member's state
     * @param zip the member's zip code
     */
    public static void insertMember(String name, int accNumber, String address, String city, String state, int zip) {
        Member newMem = new Member(name, accNumber, address, city, state, zip);
        newMem.currentStatus = memberStatus.ACTIVE;
        memberMap.put(accNumber, newMem);
    }

    /**
     * Searches for a member by their given account number
     * @param accNumber the member's account number
     * @return the member found at the given member number
     */
    public static Member searchMember(int accNumber) {
        if (memberMap.containsKey(accNumber)) {
            return memberMap.get(accNumber);
        }
        else {
            return null;
        }
    }
    
    /**
     * Removes member with the given account number
     * @param accNumber the member's account number
     */
    public static void removeMember(int accNumber) {
        memberMap.remove(accNumber);
    }
    
}