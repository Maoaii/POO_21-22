package message;

import java.util.Comparator;

public class subjectMessagesComparator implements Comparator<Message> {
    /**
     * Sort by subject
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return an in >0 if o1 is sorted before o2. <0 if o1 is sorted after o2. =0 if they're equal
     */
    @Override
    public int compare(Message o1, Message o2) {
        return o1.getSubject().compareTo(o2.getSubject());
    }
}
