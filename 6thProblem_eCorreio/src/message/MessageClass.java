package message;

import java.time.LocalDate;
import java.util.Date;

public class MessageClass implements Message {
    // Instance variables
    private String subject;
    private String email;
    private String text;
    private LocalDate date;

    /**
     * Message Constructor
     *
     * @param subject - <code>Message</code>'s subject
     * @param email - <code>Message</code>'s email
     * @param text - <code>Message</code>'s text
     * @param date - <code>Message</code>'s date
     */
    public MessageClass(String subject, String email, String text, LocalDate date) {
        this.subject = subject;
        this.email = email;
        this.text = text;
        this.date = date;
    }

    @Override
    public String getSubject() {
        return subject;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public String getText() {
        return text;
    }
    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object other) {
        boolean subjectCmp = this.getSubject().compareTo(((Message) other).getSubject()) == 0;
        boolean emailCmp = this.getEmail().compareTo(((Message) other).getEmail()) == 0;
        boolean dateCmp = this.getDate().compareTo(((Message) other).getDate()) == 0;

        return subjectCmp && emailCmp && dateCmp;
    }
}
