package View;

import java.util.Date;

public class Article {
    String title;
    Date published;
    String content;

    public Article(String title, String content, Date published) {
        this.title = title;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublished() {
        return published;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", published=" + published +
                ", content='" + content + '\'' +
                '}';
    }

}
