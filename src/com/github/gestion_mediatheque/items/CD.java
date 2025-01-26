package com.github.gestion_mediatheque.items;

public class CD implements LibraryItem{
    private String id;
    private String title;
    private String artistName;
    private Integer tracksNumber;

    /**
     * Create a CD.
     * 
     * @param id
     * @param title
     * @param artistName
     * @param tracksNumber
     * @throws NullEmptyAttributeException
     * @throws NegativeTracksNumberException
     */
    public CD(String id, String title, String artistName, Integer tracksNumber)
            throws NullEmptyAttributeException, NegativeTracksNumberException {
        if (id == null || id.isEmpty()) {
            throw new NullEmptyAttributeException("id");
        }
        if (title == null || title.isEmpty()) {
            throw new NullEmptyAttributeException("title");
        }
        if (artistName == null || artistName.isEmpty()) {
            throw new NullEmptyAttributeException("artistName");
        }
        if (tracksNumber == null) {
            throw new NegativeTracksNumberException();
        }

        this.id = id;
        this.title = title;
        this.artistName = artistName;
        this.tracksNumber = tracksNumber;
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArtistName(){
        return this.artistName;
    }

    public Integer getTracksNumber(){
        return this.tracksNumber;
    }
}
