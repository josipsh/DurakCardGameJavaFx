package hr.algebra.chatComponent.model;

import hr.algebra.sharedModel.User;

public class Message {
    private final User user;
    private final String content;
    private final boolean isUserAuthor;

    public Message(User user, String content, boolean isUserAuthor) {
        this.user = user;
        this.content = content;
        this.isUserAuthor = isUserAuthor;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public boolean isUserAuthor() {
        return isUserAuthor;
    }
}
