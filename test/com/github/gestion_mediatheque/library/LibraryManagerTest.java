package test.com.github.gestion_mediatheque.library;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.gestion_mediatheque.items.Book;
import com.github.gestion_mediatheque.items.CD;
import com.github.gestion_mediatheque.library.ItemAlreadyExistedException;
import com.github.gestion_mediatheque.library.LibraryManager;
import com.github.gestion_mediatheque.people.Author;

public class LibraryManagerTest {

    LibraryManager libraryManager;
    CD cd;
    CD cdWithSameId;
    Book book;
    Book bookWithSameId;
    Author author;

    Logger logger = Logger.getLogger(getClass().getName());

    @Before
    public void beforeTest() {
        logger.info("Begin Library manager test");
        libraryManager = new LibraryManager();
        try {
            cd = new CD("idCD", "cd", "artistName", 1);
            cdWithSameId = new CD("idCD", "cdWithSameId", "artistName", 1);
            author = new Author("name");
            ArrayList<Author> listAuthors = new ArrayList<>();
            listAuthors.add(author);
            book = new Book("idBook", "book", listAuthors);
            bookWithSameId = new Book("idBook", "bookWithSameId", listAuthors);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    @Test
    public void testAddItem() throws ItemAlreadyExistedException {
        // Check if items added to the library doesn't share an ID
        Assert.assertNotEquals(cd.getId(), book.getId());
        libraryManager.addItem(cd);
        libraryManager.addItem(book);
    }

    @Test(expected = ItemAlreadyExistedException.class)
    public void testItemAlreadyExistedException() throws ItemAlreadyExistedException {
        // Check if items share id to trigger the exception
        Assert.assertEquals(cd.getId(), cdWithSameId.getId());
        libraryManager.addItem(cd);
        libraryManager.addItem(cdWithSameId);
    }
}
