package test.com.github.gestion_mediatheque.items;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.github.gestion_mediatheque.items.Book;
import com.github.gestion_mediatheque.items.NullEmptyAttributeException;
import com.github.gestion_mediatheque.people.Author;

public class BookTest {

    Author author1;
    ArrayList<Author> listAuthors;
    String id = "id";
    String title = "title";

    Logger logger = Logger.getLogger(getClass().getName());

    @Before
    public void beforeTest() {
        logger.info("Begin Book test");
        try {
            String authorName = "author1";
            author1 = new Author(authorName);
            listAuthors = new ArrayList<>();
            listAuthors.add(author1);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    /**
     * Test if a Book is created if valid parameters are given.
     */
    @Test
    public void createBookTest() {
        String id2 = "id2";
        String title2 = "title2";

        try {
            new Book(id, title, listAuthors);
            new Book(id2, title2, listAuthors);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test if a Book is not created if the id is null.
     * 
     * @throws NullEmptyAttributeException
     */
    @Test(expected = NullEmptyAttributeException.class)
    public void nullAttributeException() throws NullEmptyAttributeException {
        new Book(id, null, listAuthors);
    }

    /**
     * Test if a Book is not created if the id is empty.
     * 
     * @throws NullEmptyAttributeException
     */
    @Test(expected = NullEmptyAttributeException.class)
    public void emptyTitleException() throws NullEmptyAttributeException {
        new Book(id, "", listAuthors);
    }

    /**
     * Test if a Book is not created if the list of authors is null.
     * 
     * @throws NullEmptyAttributeException
     */
    @Test(expected = NullEmptyAttributeException.class)
    public void nullAuthorsException() throws NullEmptyAttributeException {
        new Book(id, title, null);
    }

    /**
     * Test if a Book is not created if the list of authors is empty.
     * 
     * @throws NullEmptyAttributeException
     */
    @Test(expected = NullEmptyAttributeException.class)
    public void emptyAuthorsException() throws NullEmptyAttributeException {
        listAuthors = new ArrayList<>();
        new Book(id, title, listAuthors);
    }

}
