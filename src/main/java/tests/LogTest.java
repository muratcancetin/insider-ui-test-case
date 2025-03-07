package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LogTest {

    static final Logger logger = LogManager.getLogger(LogTest.class);

    @Test
    public void exampleTest() {
        logger.trace("Trace Seviyesi");
        logger.debug("Debug Seviye, hata yakalamak için kullanılır");
        logger.info("Info Seviye, biilgi için kullanılır");
        logger.warn("Warn Seviye, dikkat edilmesi istenen durumlar");
        // logger.error("Error Seviye, hata durumlarında kullanılır");
        //logger.fatal("Fatal Seviye, kritik hata durumlarında kullanılır");
    }
}
