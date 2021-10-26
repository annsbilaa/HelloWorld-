package com.example.helloworld.activities;

/**
 * Data model for each row of the RecyclerView
 */

class Berita {

    // Member variables representing the title and information about the sport.
    private String title;
    private String info;
    private String detail;
    private final int imageResource;

    /**
     * Constructor for the Sport data model.
     *
     * @param title The name if the sport.
     * @param info Information about the sport.
     */
    public Berita(String title, String info,String detail, int imageResource) {
        this.title = title;
        this.info = info;
        this.detail = detail;
        this.imageResource = imageResource;
    }

    /**
     * Gets the title of the sport.
     *
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }

    /**
     * Gets the info about the sport.
     *
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }

    public String getdetail() {
        return detail;
    }

    public int getImageResource() {
        return imageResource;
    }
}
