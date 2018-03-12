package ipv4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 12-03-2018
 **/

public class HostNetworkDataTest {
    private HostNetworkData hostNetworkData = new HostNetworkData();
    private Logger logger = LogManager.getLogger(HostNetworkDataTest.class);

    @Before
    public void setUp() {
        Configurator.initialize(new DefaultConfiguration());
    }

    @Test
    public void sutShouldGetIpv4addressCompatibileWithRegex() throws IOException {
        String ip = hostNetworkData.giveIPv4address();
        logger.info("IPv4: " + ip);

        Pattern pattern = Pattern.compile(HostNetworkData.IPV4_REGEX);
        Matcher matcher = pattern.matcher(ip);

        assertTrue(matcher.matches());
    }

    @Test
    public void sutShouldGetLocalHost() throws UnknownHostException {
        String hostName = hostNetworkData.giveLocalHostAddress();
        logger.info("Local Host: " + hostName);
    }

    @Test
    public void sutShouldGiveSubnetMaskCompatibileWithRegex() throws IOException {
        int mask = hostNetworkData.giveSubnetMask();
        logger.info("Subnet mask: " + mask);
    }

    @Test
    public void sutShouldConvertSubnetMask() throws IOException {
        String mask = hostNetworkData.convertedSubnetMusk();
        logger.info("Converted subnet mask: " + mask);
    }

    @Test
    public void sutShouldGivePublicIPAddress() throws IOException {
        String publicIP = hostNetworkData.givePublicNetworkAddress();
        logger.info("Public network address: " + publicIP);
    }

    @Test
    public void sutShouldGiveBroadcastAddress() throws IOException {
        String broadcast = hostNetworkData.giveBroadcastAddress();
        logger.info(broadcast);
    }

}