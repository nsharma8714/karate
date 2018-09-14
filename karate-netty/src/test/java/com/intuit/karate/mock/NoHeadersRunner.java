package com.intuit.karate.mock;

import com.intuit.karate.FileUtils;
import com.intuit.karate.junit4.Karate;
import com.intuit.karate.netty.FeatureServer;
import cucumber.api.CucumberOptions;
import java.io.File;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 *
 * @author pthomas3
 */
@RunWith(Karate.class)
@CucumberOptions(features = "classpath:com/intuit/karate/mock/no-headers.feature")
public class NoHeadersRunner {
    
    private static FeatureServer server;
    
    @BeforeClass
    public static void beforeClass() {
        File file = FileUtils.getFileRelativeTo(MockServerTest.class, "_mock.feature");
        server = FeatureServer.start(file, 0, false, null);
        int port = server.getPort();
        System.setProperty("karate.server.port", port + "");
    }    
    
}
