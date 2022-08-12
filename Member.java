package src;

import java.util.Vector;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Scanner;  

/**
 * The Member class, this constructs and holds all information and functionality related to a singular member
 * 
 * @author Ryan Moddesette
 * @version 1.0
 */

public class Member {
    String name;
    int memberAccountNumber;
    String address;
    String city;
    String state;
    int zipCode;
    Vector<ServiceMember> memberServiceList;

    enum memberStatus {
        ACTIVE,
        SUSPENDED
    }
    memberStatus currentStatus;
    /**
     * member constructor
     * @param name name of member
     * @param memberAccountNumber account number of member
     * @param address address of member
     * @param city city of member
     * @param state state of member
     * @param zipCode zipcode of member
     */

    public Member (String name,int memberAccountNumber,String address,String city,String state,int zipCode) {
        this.name = name; 
        this.memberAccountNumber=memberAccountNumber; 
        this.address = address; 
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.currentStatus = memberStatus.ACTIVE;
        this.memberServiceList = new Vector<ServiceMember>();
    }
    
    /**
     * The getName function gets the name of the member
     * @return name of member
     */
    public String getName(){
        return name;
    };
    /**
     * The getMemberAccountNumber function gets the member's account number
     * @return member's account number
     */
    public int getMemberAccountNumber() {
        return memberAccountNumber;
    };
    /**
     * The getAddress function gets the address of the member
     * @return address of member
     */
    public String getAddress(){
        return address;
    };
    /**
     * The getState function gets the state of the member
     * @return state of member
     */
    public String getState(){
        return state;
    };
    /**
     * The getCity function gets city of the member
     * @return city of member
     */

    public String getCity(){
        return city;
    };
    /**
     * The getZipCode function gets the zip code of the provider
     * @return zipCode of member
     */
    public int getZipCode(){
        return zipCode;
    };
    /**
     * The enterMemberInfo function allows you to update the member's account number
     * @param newAccountNumber account number to be set for member
     */
    public void enterMemberInfo(int newAccountNumber){
        memberAccountNumber = newAccountNumber;
    };
    /**
     * The getMemberStatus function gets the current status of the member
     * @return current status of member
     */
    public memberStatus getMemberStatus(){
        return currentStatus;
    }
    /**
     * The displayMemberStatus function prints the current status of a member
     */
    public void displayMemberStatus(){
        if(currentStatus==memberStatus.ACTIVE){
            System.out.println("Member is currently active.\n");
        }else if(currentStatus==memberStatus.SUSPENDED){
            System.out.println("Member is currently suspended.\n");
        }else{
            System.out.println("Member status error.\n");
        }
    };
    /**
     * The addServiceToMember function takes in information relating to member provider and service and adds a member service object to the member service list vector
     * @param serviceCode code of service provided
     * @param serviceName name of the service that was provided 
     * @param providerNum number of provider that provided service
     * @param memberNum number of member that service was provided for
     */
    
    public static void addServiceToMember(int serviceCode, String serviceName, int providerNum, int memberNum){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        String dateAndTimeNow = formatter.format(date); 

        String dateOfService = BillingInfo.getDateOfServiceString();
        
        Member curMember = MemberFiles.searchMember(memberNum);
        Provider curProvider = ProviderFiles.searchProvider(providerNum);

        Scanner commentScanner = new Scanner(System.in);
        System.out.println("Please enter any comments about this service or enter \"N/A\".");
        String comments = commentScanner.nextLine();
        commentScanner.close();

        ServiceMember newService = new ServiceMember(dateAndTimeNow, dateOfService, providerNum, curProvider.name, memberNum, serviceCode, serviceName, comments);
        //fix: below line okay to use add() or need to figure out a way to push back?
        curMember.memberServiceList.add(newService);
    }
}
