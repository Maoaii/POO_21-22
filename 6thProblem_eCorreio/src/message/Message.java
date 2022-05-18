package message;

import java.time.LocalDate;
import java.util.Date;

public interface Message {

    /**
     * @return this <code>Message</code>'s subject
     */
    String getSubject();

    /**
     * @return this <code>Message</code>'s email
     */
    String getEmail();

    /**
     * @return this <code>Message</code>'s text
     */
    String getText();

    /**
     * @return this <code>Message</code>'s date
     */
    LocalDate getDate();
}
