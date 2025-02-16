package test.com.github.gestion_mediatheque.library;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.gestion_mediatheque.items.Book;
import com.github.gestion_mediatheque.items.CD;
import com.github.gestion_mediatheque.items.LibraryItem;
import com.github.gestion_mediatheque.items.NegativeTracksNumberException;
import com.github.gestion_mediatheque.items.NullEmptyAttributeException;
import com.github.gestion_mediatheque.library.ItemAlreadyExistedException;
import com.github.gestion_mediatheque.library.LibraryManager;
import com.github.gestion_mediatheque.library.MaxSizeLibraryException;
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
    public void testAddItem() throws ItemAlreadyExistedException, MaxSizeLibraryException {
        // Check if items added to the library doesn't share an ID
        Assert.assertNotEquals(cd.getId(), book.getId());
        libraryManager.addItem(cd);
        libraryManager.addItem(book);
    }

    @Test(expected = ItemAlreadyExistedException.class)
    public void testItemAlreadyExistedException() throws ItemAlreadyExistedException, MaxSizeLibraryException {
        // Check if items share id to trigger the exception
        Assert.assertEquals(cd.getId(), cdWithSameId.getId());
        libraryManager.addItem(cd);
        libraryManager.addItem(cdWithSameId);
    }

    @Test(expected = MaxSizeLibraryException.class)
    public void testMaxSizeLibraryException() throws ItemAlreadyExistedException, MaxSizeLibraryException,
            NullEmptyAttributeException, NegativeTracksNumberException {
        for (int i = 0; i <= libraryManager.getMaxSize(); i++) {
            libraryManager.addItem(new CD("idCD" + i, "cd", "artistName", 1));
        }
    }

    @Test
    public void testGetItem()
            throws ItemAlreadyExistedException, NullEmptyAttributeException, NegativeTracksNumberException,
            MaxSizeLibraryException {
        // Check if items added to the library doesn't share an ID
        Assert.assertNotEquals(cd.getId(), book.getId());
        libraryManager.addItem(cd);
        libraryManager.addItem(book);

        // Test for an existing book
        LibraryItem expectedBook = libraryManager.getItem(book.getId());
        Assert.assertEquals(expectedBook, book);

        // Test for an existing CD
        LibraryItem expectedCD = libraryManager.getItem(cd.getId());
        Assert.assertEquals(expectedCD, cd);

        // Test for a non existing id
        CD cdNotInLibrary = new CD(cd.getId() + "1", "cd", "artistName", 1);
        LibraryItem expectedNull = libraryManager.getItem(cdNotInLibrary.getId());
        Assert.assertNull(expectedNull);
    }

    @Test
    public void testRemoveItem() throws ItemAlreadyExistedException, MaxSizeLibraryException {
        // Check if items added to the library doesn't share an ID
        Assert.assertNotEquals(cd.getId(), book.getId());
        libraryManager.addItem(cd);
        libraryManager.addItem(book);

        // Test for removing a Book from the library
        LibraryItem expectedBook = libraryManager.removeItem(book.getId());
        Assert.assertEquals(expectedBook, book);
        Assert.assertNull(libraryManager.getItem(book.getId()));

        // Test for removing a CD from the library
        LibraryItem expectedCD = libraryManager.removeItem(cd.getId());
        Assert.assertEquals(expectedCD, cd);
        Assert.assertNull(libraryManager.getItem(cd.getId()));

        // Test for removing a object which doesn't exist in the library
        LibraryItem expectedNull = libraryManager.removeItem(cd.getId() + "1");
        Assert.assertNull(expectedNull);
    }
}
