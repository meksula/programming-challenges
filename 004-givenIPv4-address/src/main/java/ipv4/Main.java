package ipv4;

import java.io.IOException;

/**
 * @Author Karol Meksuła
 * 12-03-2018
 **/

public class Main {
    public static void main(String[]args) throws IOException {
        HostNetworkData hostNetworkData = new HostNetworkData();
        System.out.println("IPv4 address: " + hostNetworkData.giveIPv4address());

    }
}
