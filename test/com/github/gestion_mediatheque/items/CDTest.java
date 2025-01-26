package test.com.github.gestion_mediatheque.items;

import static org.junit.Assert.fail;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.github.gestion_mediatheque.items.CD;

public class CDTest {
    String id = "id";
    String title = "title";
    String artistName = "artistName";
    Integer tracksNumber = 1;

    Logger logger = Logger.getLogger(getClass().getName());

    @Before
    public void beforeTest() {
        logger.info("Begin CD test");
    }

    /**
     * Test if CD can be created if all informations are correctly given.
     */
    @Test
    public void createCDTest() {
        try {
            String id2 = id.concat("2");
            String title2 = title.concat("2");
            String artistName2 = artistName.concat("2");
            Integer tracksNumber2 = tracksNumber + 1;

            new CD(id, title, artistName, tracksNumber);
            new CD(id2, title2, artistName2, tracksNumber2);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
