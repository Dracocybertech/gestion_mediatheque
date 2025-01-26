package test.com.github.gestion_mediatheque.items;

import java.util.logging.Logger;

import org.junit.Before;

public class CDTest {
    String originalId = "id";
    String originalTitle = "title";

    Logger logger = Logger.getLogger(getClass().getName());

    @Before
    public void beforeTest(){
        logger.info("Begin CD test");
    }
}
