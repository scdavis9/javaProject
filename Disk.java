package src;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;
import java.lang.String;
import java.text.DateFormat;

/**
 * The Disk Class for saving Data, getting records by serviceCode, and displaying the weekly summary.
 * 
 * @author Rediat Shamsu
 * @version 1.0
 */
public class Disk {
    static FileWriter diskWriter;
    static HashMap<Integer, Vector<String> > diskMap;
    static HashMap<String, Vector<Vector<String>>> dateMap;
    static DateFormat dateFormatting = DateFormat.getDateInstance();
    /*
    The Disk Constructor below takes the Disk file and puts it into two
    hashmaps which can be browsed by serviceCode and serviceDate. The purpose is to
    make retrieval faster and more efficient as these maybe operations used frequently.
    */ 
    public Disk(){
        try {
            diskMap = new HashMap<Integer, Vector<String>>();
            dateMap = new HashMap<String, Vector<Vector<String>>>(); 
            File diskFile = new File("Disk.txt");   
            Scanner diskScanner = new Scanner(diskFile);
            while(diskScanner.hasNextLine()){
                String line = diskScanner.nextLine();   
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("/");
                Vector<String> lineVector = new Vector<String>();
                int serviceCode;
                while(lineScanner.hasNext()){
                    lineVector.addElement(lineScanner.next());
                }
                lineScanner.close();
                if(lineVector.size() > 1){
                    serviceCode = Integer.parseInt(lineVector.get(1));
                    String serviceDate = lineVector.get(0);
                    diskMap.put(serviceCode, lineVector);
                    Vector<String> curDateVector = lineVector;
                    if(!dateMap.containsKey(serviceDate)){
                        Vector<Vector<String>> dateVector= new Vector<Vector<String>>();
                        dateVector.addElement(curDateVector);
                        dateMap.put(serviceDate, dateVector);
                    }else{
                        dateMap.get(serviceDate).addElement(curDateVector);
                    }
                }
            }
            diskScanner.close();
        } catch (IOException  e) {
            System.out.println("Error opening disk. \n");
            e.printStackTrace();
        }
    };
    /*
    The saveData() function below adds a new service to the Disk. 
     */
    public void saveData(Date dateofService, int serviceCode, String comment, Integer memberNumber, Integer providerNumber){
        try{
            FileWriter dataWriter = new FileWriter("Disk.txt",true);
            String dateStr = dateFormatting.format(dateofService);
            dataWriter.write(dateStr);
            dataWriter.write("/");
            dataWriter.write(Integer.toString(serviceCode));
            dataWriter.write("/");
            dataWriter.write(comment);
            dataWriter.write("/"+Integer.toString(memberNumber)+"/"+Integer.toString(providerNumber));
            dataWriter.write("\n");
            Vector<String> dataVector = new Vector<String>();
            dataVector.add(dateofService.toString());
            dataVector.add(Integer.toString(serviceCode));
            dataVector.add(comment);
            dataVector.add(Integer.toString(memberNumber));
            dataVector.add(Integer.toString(providerNumber));
            diskMap.put(serviceCode, dataVector);
            Vector<String> newDateVector = new Vector<String>();
            newDateVector.addElement(dateStr);
            newDateVector.addElement(Integer.toString(serviceCode));
            newDateVector.addElement(comment);
            newDateVector.addElement(Integer.toString(memberNumber));
            newDateVector.addElement(Integer.toString(providerNumber));
            if(!dateMap.containsKey(dateStr)){
                Vector<Vector<String>> dateVector= new Vector<Vector<String>>();
                dateVector.addElement(newDateVector);
                dateMap.put(dateStr, dateVector);
            }else{
                dateMap.get(dateStr).addElement(newDateVector);
            }           
            dataWriter.close();
            }catch(IOException e){
                System.out.println("Error saving data to disk.\n");
                e.printStackTrace();
            }
    };
    public void getByServiceCode(int serviceCode){
        if(diskMap.containsKey(serviceCode)){
           Vector<String> outputVector = diskMap.get(serviceCode);
           if(outputVector.size()>4){
            System.out.printf("Date: %s\tService Code:%s\t\tMember Number:%s\tProvider Number:%s\tComments:%s\n",outputVector.get(0),
            outputVector.get(1),outputVector.get(3),outputVector.get(4),outputVector.get(2)); 
           }else{
               System.out.printf("Vector size is unexpected %s\n", outputVector.size());
           }
        }else{
            System.out.printf("Service Code:%s not found.\n",serviceCode);
        }
    };
    /*
    getByServiceDate() is at least for now, just a helper function for getWeeklySummary() that displays all 
    the services for a given day. But it is going to be much more useful if future versions require more than
    just a weekly summary, such as a monthly summary or a summary by date range.
     */
    public void getByServiceDate(Date dateOfService){
        String dateString = dateFormatting.format(dateOfService);
        if(dateMap.containsKey(dateString)){
            Vector<Vector<String>> dateOutputVector = dateMap.get(dateString);
            for(Integer i = 0; i < dateOutputVector.size(); i++){
                Vector<String> outputVector = dateOutputVector.get(i);
                System.out.printf("Date: %s\tService Code:%s\t\tMember Number:%s\tProvider Number:%s\tComments:%s\n",outputVector.get(0),
                outputVector.get(1),outputVector.get(3),outputVector.get(4),outputVector.get(2)); 
            }
         }else{
             System.out.printf("No Activity on Date: %s.\n",dateOfService);
         }
    };
    /*
    Displays all the services provided that week.
    */
    public void getWeeklySummary(){
        Instant now = Instant.now(); 
        System.out.printf("Weekly Summary from %s to %s:\n", dateFormatting.format(Date.from(now)),dateFormatting.format(Date.from(now.minus(7, ChronoUnit.DAYS))));
        for(int i = 0; i <= 7; i ++){
            getByServiceDate(Date.from(now.minus(i, ChronoUnit.DAYS)));
        }
    };
    public void writeEFTData(Provider serviceProvider,Integer Amount){
        try{
            FileWriter EFTwriter = new FileWriter("EFT.txt",true);
            EFTwriter.write("Provider: "+serviceProvider.name+" No: "+serviceProvider.accNumber+" "+"Charge: $"+Amount+"\n");
            EFTwriter.close();
            }catch(IOException e){
                System.out.println("Error writing to EFT file.\n");
                e.printStackTrace();
            }
    }



}
