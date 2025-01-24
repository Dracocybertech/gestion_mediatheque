package test.com.github.gestion_mediatheque.people;

import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.github.gestion_mediatheque.people.Author;
import com.github.gestion_mediatheque.people.NullNameException;

public class AuthorTest {
    
    Logger logger = Logger.getLogger(getClass().getName());
    
    @Before
    public void beforeTest(){
        logger.info("Begin Author test");
    }

    @Test
    public void createAuthorTest(){
        String name = "Name";
        String id = "id";
        LocalDate birthdate = LocalDate.of(2024,1,1);
        String nationality = "French";

        try{
            new Author(name);
            new Author(name, id);
            new Author(name, id, birthdate, nationality);
        }
        catch(Exception e){
            fail(e.getMessage());
        }
    }

    @Test(expected = NullNameException.class)
    public void nullNameAuthorTest() throws NullNameException{
        String name = null;
        new Author(name);
    }

    @Test(expected = NullNameException.class)
    public void emptyNameAuthorTest() throws NullNameException{
        String name = "";
        new Author(name);
    }
}
