package eEmailSystem;

import eEmailSystem.exceptions.*;
import message.Message;

import java.time.LocalDate;
import java.util.Iterator;

public interface EmailSystem {

    /**
     * Sends a message to <code>receiverEmail</code>
     *
     * @param subject - email subject
     * @param receiverEmail - receiver email
     * @param textMessage - email text message
     * @param sendDate - sending date
     * @throws DuplicateMessageException - if there's already a message with the same
     *                                     subject, receiver email and text message in the system
     */
    void sendMessage(String subject, String receiverEmail, String textMessage, LocalDate sendDate)
            throws DuplicateMessageException;

    /**
     * Receives a message from <code>senderEmail</code>
     *
     * @param subject - email subject
     * @param senderEmail - sender email
     * @param textMessage - email text message
     * @param receptionDate - reception date
     * @throws DuplicateMessageException - if there's already a message with the same
     *                                     subject, receiver email and text message in the system
     */
    void receiveMessage(String subject, String senderEmail, String textMessage, LocalDate receptionDate)
            throws DuplicateMessageException;

    /**
     * @return a <code>Message Iterator</code> that iterates through all the sent messages in the system,
     *         ordered by: date, subject and receiver email;
     */
    Iterator<Message> listSentMessages();

    /**
     * @return a <code>Message Iterator</code> that iterates through all the received messages in the system,
     *         ordered by: date, subject and sender email;
     */
    Iterator<Message> listReceivedMessages();

    /**
     * @param subject - subject to filter messages to
     * @return a <code>Message Iterator</code> that iterates through all the messages with <code>subject</code>,
     *         ordered by insertion order
     * @throws NoMessagesSubjectException - if there are no messages with <code>subject</code> registered in the system
     */
    Iterator<Message> listMessagesSubject(String subject) throws NoMessagesSubjectException;

    /**
     * @param email - email to list messages from
     * @return a <code>Message Iterator</code> that iterates through all the messages from email <code>email</code>,
     *         by insertion order
     * @throws NoMessagesEmailException - if this <code>email</code> doesn't have any messages
     */
    Iterator<Message> listEmailMessages(String email) throws NoMessagesEmailException;

    /**
     * @return a <code>Message Iterator</code> that iterates through all messages in the system,
     *         insertion order
     */
    Iterator<Message> listSubjects();
}
