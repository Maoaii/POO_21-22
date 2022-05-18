package eEmailSystem;

import eEmailSystem.exceptions.DuplicateMessageException;
import eEmailSystem.exceptions.NoMessagesEmailException;
import eEmailSystem.exceptions.NoMessagesSubjectException;
import message.*;

import java.time.LocalDate;
import java.util.*;

public class EmailSystemClass implements EmailSystem {
    // Constants
    private static final int MAX_EMAILS = 200;
    // Instance variables
    private Map<String, List<Message>> messagesByEmail; // String -> list of messages from an email
    private List<Message> messages; // List of all the messages by insertion order
    private Set<Message> sortedSubjectMessages; // Sorted set of messages by subject (no duplicates)
    private Set<Message> sortedSentMessages; // Sorted set of sent messages
    private Set<Message> sortedReceivedMessages; // Sorted set of received messages

    /**
     * Email system class constructor
     */
    public EmailSystemClass() {
        messagesByEmail = new HashMap<>();
        messages = new ArrayList<>(MAX_EMAILS);
        sortedSubjectMessages = new TreeSet<>(new subjectMessagesComparator());
        sortedSentMessages = new TreeSet<>(new sortedMessagesComparator());
        sortedReceivedMessages = new TreeSet<>(new sortedMessagesComparator());
    }

    @Override
    public void sendMessage(String subject, String email, String textMessage, LocalDate sendDate) throws DuplicateMessageException {
        Message message = new MessageClass(subject, email, textMessage, sendDate);

        // Try to add message and throw duplicate exception if it's a duplicate
        if (!sortedSentMessages.add(message))
            throw new DuplicateMessageException();

        // Add to sorted by subject messages
        sortedSubjectMessages.add(message);
        // Add to overall messages
        messages.add(message);

        // Add message to the map of messages by email
        List<Message> messageList = messagesByEmail.get(email);
        if (messageList == null) { // If it's the first message from an email
            messageList = new LinkedList<>();
            messagesByEmail.put(email, messageList);
        }
        messageList.add(message);
    }

    @Override
    public void receiveMessage(String subject, String email, String textMessage, LocalDate receptionDate) throws DuplicateMessageException {
        Message message = new MessageClass(subject, email, textMessage, receptionDate);

        // Try to add message and throw duplicate exception if it's a duplicate
        if (!sortedReceivedMessages.add(message))
            throw new DuplicateMessageException();

        // Add to sorted by subject messages
        sortedSubjectMessages.add(message);
        // Add to overall messages
        messages.add(message);

        // Add message to the map of messages by email
        List<Message> messageList = messagesByEmail.get(email);
        if (messageList == null) { // If it's the first message from an email
            messageList = new LinkedList<>();
            messagesByEmail.put(email, messageList);
        }
        messageList.add(message);
    }

    @Override
    public Iterator<Message> listSentMessages() {
        return sortedSentMessages.iterator();
    }

    @Override
    public Iterator<Message> listReceivedMessages() {
        return sortedReceivedMessages.iterator();
    }

    @Override
    public Iterator<Message> listMessagesSubject(String subject) throws NoMessagesSubjectException {
        List<Message> messagesSubject = new ArrayList<>();
        Iterator<Message> messageIterator = messages.iterator();

        while (messageIterator.hasNext()) {
            Message message = messageIterator.next();
            if (message.getSubject().equals(subject))
                messagesSubject.add(message);
        }

        messageIterator = messagesSubject.iterator();

        if (!messageIterator.hasNext())
            throw new NoMessagesSubjectException();

        return messageIterator;
    }

    @Override
    public Iterator<Message> listEmailMessages(String email) throws NoMessagesEmailException {
        List<Message> messages = messagesByEmail.get(email);

        if (messages == null)
            throw new NoMessagesEmailException();

        return messages.iterator();
    }

    @Override
    public Iterator<Message> listSubjects() {
        return sortedSubjectMessages.iterator();
    }
}
