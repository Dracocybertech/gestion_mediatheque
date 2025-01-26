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
    String originalId = "id";
    String originalTitle = "title";

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

    @Test
    public void createBookTest() {
        String id = originalId.concat("1");
        String title = originalTitle.concat("1");
        String id2 = originalId.concat("2");
        String title2 = originalTitle.concat("2");

        try {
            new Book(id, title, listAuthors);
            new Book(id2, title2, listAuthors);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test(expected = NullEmptyAttributeException.class)
    public void nullAttributeException() throws NullEmptyAttributeException {
        String id = originalId.concat("1");
        String nullTitle = null;
        new Book(id, nullTitle, listAuthors);
    }

    @Test(expected = NullEmptyAttributeException.class)
    public void emptyTitleException() throws NullEmptyAttributeException {
        String id = originalId.concat("1");
        String nullTitle = "";
        new Book(id, nullTitle, listAuthors);
    }

    @Test(expected = NullEmptyAttributeException.class)
    public void nullAuthorsException() throws NullEmptyAttributeException {
        String id = originalId.concat("1");
        String title = originalTitle.concat("1");
        listAuthors = null;
        new Book(id, title, listAuthors);
    }

    @Test(expected = NullEmptyAttributeException.class)
    public void emptyAuthorsException() throws NullEmptyAttributeException {
        String id = originalId.concat("1");
        String title = originalTitle.concat("1");
        listAuthors.clear();
        new Book(id, title, listAuthors);
    }

}
