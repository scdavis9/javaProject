package src;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * The EFTReport class, this class writes an EFT report to the disk pertaining to the costs and services within the provider files
 * 
 * @author Rediat Shamsu
 * @version 1.0
 */

public class EFTReport {
    /**
    * printEFTReport, reads EFT file and then prints each line
    */
    public static void printEFTReport(){
        try{
            File EFTfile = new File("EFT.txt");
            Scanner EFTscanner = new Scanner(EFTfile);
            while(EFTscanner.hasNextLine()){
                String EFTline =EFTscanner.nextLine();
                System.out.println(EFTline+"\n"); 
            }
            EFTscanner.close();
        }catch(IOException e){
            System.out.println("Error opening EFT file.\n");
            e.printStackTrace();
        }
        //need to write EFT report to Disk
        //Provider files contains cost and service
    }
    
}


