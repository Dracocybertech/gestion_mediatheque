package test.com.github.gestion_mediatheque.items;

import static org.junit.Assert.fail;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.github.gestion_mediatheque.items.CD;

public class CDTest {
    String originalId = "id";
    String originalTitle = "title";
    String originalArtisteName = "artistName";
    Integer originalTracksNumber = 1;

    Logger logger = Logger.getLogger(getClass().getName());

    @Before
    public void beforeTest(){
        logger.info("Begin CD test");
    }

    /**
     * Test if CD can be created if all informations are correctly given.
     */
    @Test
    public void createCDTest(){
        try {
            String id2 = originalId.concat("2");
            String title2 = originalTitle.concat("2");
            String artistName2 = originalArtisteName.concat("2");
            Integer tracksNumber2 = originalTracksNumber + 1;

            new CD(originalId, originalTitle, originalArtisteName, originalTracksNumber);
            new CD(id2, title2, artistName2, tracksNumber2);
        }
        catch(Exception e){
            fail(e.getMessage());
        }
    }
}
