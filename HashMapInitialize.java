package src;
/**
 * HashMapInitialize class, initializes hashmap and inserts a few members and providers to show operation of code
 * 
 * @author Summer Davis
 * @version 1.0
 */


public class HashMapInitialize {

    /**
    * main function: inserts members and providers into their respective hashmaps
    */
    public static void main() {
        MemberFiles.insertMember("Jeff",120913352,"498 1st Street","Coolville","NJ",66063);
        MemberFiles.insertMember("John",123456789,"986 2nd Street","Coolville","KS",65063);
        MemberFiles.insertMember("Jill",111111111,"Road","The City","AL",13245);
        MemberFiles.insertMember("Ally",222222222,"Rainbow Road","Big City","AL",99383);
        MemberFiles.insertMember("Madison",333333333,"Long Street","Windy City","KS",13245);
        MemberFiles.insertMember("Bill",444444444,"Longest Street","Los Angeles","CA",90210);

        ProviderFiles.insertProvider("Dr. Stevens", 999999999, "321 44th Street", "Hoover", "AL", 23542);
        ProviderFiles.insertProvider("Dr. Pauls", 948920490, "432 90th Street", "New York City", "NY", 34296);
        ProviderFiles.insertProvider("Dr. Williams", 384958483, "1 1st Street", "Pittsburgh", "PA", 73847);
        ProviderFiles.insertProvider("Dr. Johnson", 232323232, "2 2nd Street", "San Diego", "CS", 28374);
    }
}
