package ipv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.InvalidPropertiesFormatException;

/**
 * @Author Karol Meksuła
 * 12-03-2018
 **/

public class HostNetworkData {
    public static final String IPV4_REGEX = "\\A(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z";

    public String giveIPv4address() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("gogle.com", 80));
        String ip = socket.getLocalAddress().toString();

        if (ip.substring(1).matches(IPV4_REGEX))
            return ip.substring(1);

        else throw new InvalidPropertiesFormatException("IPv4 dessignation is imposible. There is not that address!");
    }

    public String giveLocalHostAddress() throws UnknownHostException {
        return String.valueOf(Inet4Address.getLocalHost());
    }

    private int subnetMask;

    public int giveSubnetMask() throws IOException {
        String ip = giveIPv4address();
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getByName(ip));
        networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();
        subnetMask = networkInterface.getInterfaceAddresses().get(1).getNetworkPrefixLength();
        return subnetMask;
    }

    public String convertedSubnetMusk() throws IOException {
        giveSubnetMask();

        int [] decimals = subnetMaskToDecimal(subnetMaskToBinary());
        StringBuilder stringBuilder = new StringBuilder();
        String result = null;

        for (int i = 0; i < 4; i++) {
            if (i == 3)
                stringBuilder.append(decimals[i]);
            else stringBuilder.append(decimals[i] + ".");

            result = stringBuilder.toString();
        }

        return result;
    }

    public String givePublicNetworkAddress() throws IOException {
        URL ipUrl = new URL("http://checkip.amazonaws.com");
        InputStreamReader inputStreamReader = new InputStreamReader(ipUrl.openStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }

    public String giveBroadcastAddress() throws IOException {
        convertedSubnetMusk();

        String decimals = subnetMaskToBinary();
        char [] chars = decimals.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < decimals.length(); i++) {
            if (chars[i] == '1') {
                stringBuilder.append("0");
            }
            if (chars[i] == '0')
                stringBuilder.append("1");
        }

        String afterNot = stringBuilder.toString(); //binarna postać reszty z maski

        int [] appends = subnetMaskToDecimal(afterNot);


        //TODO 1. Wyznacz adres sieci: ip i maska na postać binarną i później AND()
        //TODO 2. Adres sieci + appends == broadcast address

        return "";
    }

    public String giveNetworkAddress() throws IOException {
        String iPv4addressBinary = expressionToBinary(giveIPv4address());

        String subnetMaskBinary = subnetMaskToBinary();

        //TODO AND()


        String networkAddress = null;

        return networkAddress;
    }

    protected String expressionToBinary(String expression) {
        StringBuilder stringBuilder = new StringBuilder();

        String [] splited = expression.split("\\.");

        for (int i = 0; i < splited.length; i++) {
            int decimal = Integer.parseInt(splited[i]);
            stringBuilder.append(Integer.toBinaryString(decimal));
        }

        return stringBuilder.toString();
    }

    protected String and(String binary1, String binary2) {
        System.out.println(binary1);
        System.out.println(binary2);
        return null;
    }

    protected String subnetMaskToBinary() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < subnetMask; i++) {
            builder.append("1");
        }

        String binarySubnetMask = builder.toString();
        int one = binarySubnetMask.length();
        int zeros = 32 - one;

        for (int i = 0; i < zeros; i++) {
            builder.append("0");
        }

        return builder.toString();
    }

    private int [] subnetMaskToDecimal(String binarySubnetMask) {
        String [] octals = new String[4];

        int start = 0;
        int end = 8;

        for (int i = 0; i < 4; i++) {
            octals[i] = binarySubnetMask.substring(start, end);
            start = start + 8;
            end = end + 8;
        }

        int [] decimals = new int[4];

        for (int i = 0; i < 4; i++){
            decimals[i] = Integer.parseInt(octals[i], 2);
        }

        return decimals;
    }



}
