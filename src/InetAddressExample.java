//Tyler McCulla and Jackson Bacon

/**
 * This might not be the most efficient way, but we know it works. Most of the data sets
 * are small. We don't think the time complexity of a for loop is bad here.
 * We only used some parts of the original InetAddressExample.java program
 */

import java.net.*;
import java.util.Scanner;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            //Simple input for desired hostname
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter Host Website (include www.): ");
            String website = userInput.nextLine();

            InetAddress host = InetAddress.getByName(website);
            System.out.println("Quad Dotted Notation:" + " " + host.getHostAddress());

            /**
             * Local Variables used for IP conversions and notations
             *  ipString: Takes host address and creates a Quad Dotted Notation String
             *  ipDecoded: "Decodes" ipString, removes quad dotted notation for conversions
             *  ipNumbers: Array of IP integer values
             *  Binary: Array of IP binary values
             *  Hexa: Array of IP hexa values
             */

            String ipString = host.getHostAddress();
            String [] ipDecoded = ipString.split("\\.");
            Integer [] ipNumbers = new Integer[ipDecoded.length];
            String [] Binary = new String[32];
            String [] Hexa = new String[4];

            // Convert String -> Int -> Binary and Hex
            System.out.print("Binary Result: ");
            for(int i = 0; i < ipDecoded.length ; i++) {
                ipNumbers[i] = Integer.parseInt(ipDecoded[i]);
                Binary[i] = Integer.toBinaryString(ipNumbers[i]);
                Hexa[i] = Integer.toHexString(ipNumbers[i]);
                System.out.print(Binary[i]);
            }

            // Hex -> Hexa format -> print
            System.out.print("\n"+ "HexDecimal Result: ");
            for (int i=0; i < Hexa.length; i++) {
               String hexaFormat = Hexa[i];
              System.out.print(String.format("%s.", hexaFormat));
            }

        } catch (UnknownHostException e) {
            System.out.println("Unable to determine this host's address");
        }
    }
}
