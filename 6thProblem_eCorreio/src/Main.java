import eEmailSystem.EmailSystem;
import eEmailSystem.EmailSystemClass;
import eEmailSystem.exceptions.DuplicateMessageException;
import eEmailSystem.exceptions.NoMessagesEmailException;
import eEmailSystem.exceptions.NoMessagesSubjectException;
import message.Message;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    // Commands
    private enum Command {
        ENVIAR, RECEBER, ENVIADAS, RECEBIDAS, ASSUNTO, EMAIL, ASSUNTOS, SAIR, UNKNOWN
    }

    // Output messages
    private static final String EXIT_MESSAGE = "A terminar.";
    private static final String MESSAGE_REGISTERED = "Mensagem registada.";
    private static final String MESSAGES_HEADER = "data | assunto | email";
    private static final String MESSAGES_LISTING = "%s | %s | %s\n";
    private static final String MESSAGES_SUBJECT_EMAIL_HEADER = "data | assunto | email | texto";
    private static final String MESSAGES_SUBJECT_EMAIL_LISTING = "%s | %s | %s | %s\n";




    public static void main(String[] args) {
        interpretCommands();
    }

    /**
     * Interpret user commands
     */
    private static void interpretCommands() {
        Scanner in = new Scanner(System.in);
        EmailSystem eSystem = new EmailSystemClass();

        Command command = readCommand(in);

        while (!command.equals(Command.SAIR)) {
            switch (command) {
                case ENVIAR: interpretSend(in, eSystem); break;
                case RECEBER: interpretReceive(in, eSystem); break;
                case ENVIADAS: interpretSentMessages(eSystem); break;
                case RECEBIDAS: interpretReceivedMessages(eSystem); break;
                case ASSUNTO: interpretSubject(in, eSystem); break;
                case EMAIL: interpretEmail(in, eSystem); break;
                case ASSUNTOS: interpretSubjectsEmails(eSystem); break;
                default: break;
            }
            System.out.println();
            command = readCommand(in);
        }
        System.out.println(EXIT_MESSAGE);
        System.out.println();
        in.close();
    }

    /**
     * Interprets the send command - sends a message
     *
     * @param in - input reader
     * @param eSystem - eMail system
     */
    private static void interpretSend(Scanner in, EmailSystem eSystem) {
        String subject = in.nextLine().trim();
        String email = in.nextLine().trim();
        String text = in.nextLine().trim();
        String dateString = in.nextLine().trim();

        try {
            LocalDate date = LocalDate.parse(dateString);
            eSystem.sendMessage(subject, email, text, date);
            System.out.println(MESSAGE_REGISTERED);
        } catch (DuplicateMessageException e) {
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Interprets the receive command - receives a message
     *
     * @param in - input reader
     * @param eSystem - eMail system
     */
    private static void interpretReceive(Scanner in, EmailSystem eSystem) {
        String subject = in.nextLine().trim();
        String email = in.nextLine().trim();
        String text = in.nextLine().trim();
        String dateString = in.nextLine().trim();

        try {
            LocalDate date = LocalDate.parse(dateString);
            eSystem.receiveMessage(subject, email, text, date);
            System.out.println(MESSAGE_REGISTERED);
        } catch (DuplicateMessageException e) {
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Interprets sent messages command - list out all sent messages
     *
     * @param eSystem - eMail system
     */
    private static void interpretSentMessages(EmailSystem eSystem) {
        Iterator<Message> messageIterator = eSystem.listSentMessages();
        System.out.println(MESSAGES_HEADER);
        while (messageIterator.hasNext()) {
            Message message = messageIterator.next();
            System.out.printf(MESSAGES_LISTING,
                    message.getDate().toString(), message.getSubject(), message.getEmail());
        }
    }

    /**
     * Interprets received messages command - list out all received messages
     *
     * @param eSystem - eMail system
     */
    private static void interpretReceivedMessages(EmailSystem eSystem) {
        Iterator<Message> messageIterator = eSystem.listReceivedMessages();
        System.out.println(MESSAGES_HEADER);
        while (messageIterator.hasNext()) {
            Message message = messageIterator.next();
            System.out.printf(MESSAGES_LISTING,
                    message.getDate().toString(), message.getSubject(), message.getEmail());
        }
    }

    /**
     * Interprets subject command - list out all messages with subject specified
     *
     * @param in - input reader
     * @param eSystem - eMail system
     */
    private static void interpretSubject(Scanner in, EmailSystem eSystem) {
        String subject = in.nextLine();
        try {
            Iterator<Message> messageIterator = eSystem.listMessagesSubject(subject);
            System.out.println(MESSAGES_SUBJECT_EMAIL_HEADER);
            while (messageIterator.hasNext()) {
                Message message = messageIterator.next();
                System.out.printf(MESSAGES_SUBJECT_EMAIL_LISTING,
                        message.getDate().toString(), message.getSubject(), message.getEmail(), message.getText());
            }
        } catch (NoMessagesSubjectException e) {
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Interprets email command - list out all messages with email specified
     *
     * @param in - input reader
     * @param eSystem - eMail system
     */
    private static void interpretEmail(Scanner in, EmailSystem eSystem) {
        String email = in.nextLine();

        try {
            Iterator<Message> messageIterator = eSystem.listEmailMessages(email);
            System.out.println(MESSAGES_SUBJECT_EMAIL_HEADER);
            while (messageIterator.hasNext()) {
                Message message = messageIterator.next();
                System.out.printf(MESSAGES_SUBJECT_EMAIL_LISTING,
                        message.getDate().toString(), message.getSubject(), message.getEmail(), message.getText());
            }
        } catch (NoMessagesEmailException e) {
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Interprets subjects command - list out all subjects
     *
     * @param eSystem - eMail system
     */
    private static void interpretSubjectsEmails(EmailSystem eSystem) {
        Iterator<Message> messageIterator = eSystem.listSubjects();

        while (messageIterator.hasNext()) {
            Message message = messageIterator.next();
            System.out.println(message.getSubject());
        }
    }

    /**
     * Reads input and converts to a <code>Command</code>
     *
     * @param in - input reader
     */
    private static Command readCommand(Scanner in) {
        String cmd = in.nextLine().toUpperCase().trim();
        try {
            return Command.valueOf(cmd);
        } catch (IllegalArgumentException e) {
            return Command.UNKNOWN;
        }
    }
}
