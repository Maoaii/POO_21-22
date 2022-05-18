package message;

import java.util.Comparator;

public class sortedMessagesComparator implements Comparator<Message> {
    /**
     * Sort by date, subject and email
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return an in >0 if o1 is sorted before o2. <0 if o1 is sorted after o2. =0 if they're equal
     */
    @Override
    public int compare(Message o1, Message o2) {
        int cmp = o1.getDate().compareTo(o2.getDate());
        if (cmp > 0) {
            return 1;
        }
        else if (cmp < 0) {
            return -1;
        }
        else {
            cmp = o1.getSubject().compareTo(o2.getSubject()) ;
            if (cmp > 0) {
                return 1;
            }
            else if (cmp < 0) {
                return -1;
            }
            else
                return o1.getEmail().compareTo(o2.getEmail());
        }
    }
}
