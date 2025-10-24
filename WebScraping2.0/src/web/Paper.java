package web;

import java.util.Objects;

public class Paper {
    private int id;
    private String title;
    private String url;
    private String abstractText;
    private String publisher;
    private String source;
    private String pubdate;

    // Constructor
    public Paper(int id, String title, String url, String abstractText, String publisher, String source, String pubdate) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.abstractText = abstractText;
        this.publisher = publisher;
        this.source = source;
        this.pubdate = pubdate;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getAbstractText() { return abstractText; }
    public void setAbstractText(String abstractText) { this.abstractText = abstractText; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getPubdate() { return pubdate; }
    public void setPubdate(String pubdate) { this.pubdate = pubdate; }

    // Equality based only on title
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paper)) return false;
        Paper paper = (Paper) o;
        return Objects.equals(title, paper.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", abstractText='" + abstractText + '\'' +
                ", publisher='" + publisher + '\'' +
                ", source='" + source + '\'' +
                ", pubdate='" + pubdate + '\'' +
                '}';
    }
}