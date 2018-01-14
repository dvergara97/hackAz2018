package com.example.aagua.hackaz2018;

/**
 * Created by roxas on 1/13/2018.
 * modified by ejara 1/13/2018
 */

public class EventLinkedList {

    EventNode head;

    public EventLinkedList() {
        head = null;
    }


    public EventNode tempdontkeep() {
        return head;
    }



    public void push(String eventName, String eventDescription, String cycle, int hour, int minute) {
        EventNode current = new EventNode(eventName, eventDescription, cycle, hour, minute);
        EventNode temp = head;
        EventNode holder;
        if (head == null) {
            head = current;
        } else {
            while(temp != null) {
                if(temp.getTotalMin() == current.getTotalMin()) {
                    holder = temp;
                    temp = current;
                    temp.setNext(holder);
                    break;
                } else if(temp.getTotalMin() < current.getTotalMin()) {
                    if(temp.getNext() == null) {
                        temp.setNext(current);
                        break;
                    } else {
                        temp = temp.getNext();
                    }
                } else if(temp.getTotalMin() > current.getTotalMin()) {
                    holder = head;
                    head = current;
                    head.setNext(holder);
                    break;
                }
            }
        }
    }

    //test later, no way to test rn
    public void pop(String eventName) {
        if (head != null) {
            if (head.getEventName().equals(eventName)) {
                head = head.getNext();
            }
            else {
                EventNode current = head;
                while (current.getNext() != null &&
                            !current.getNext().getEventName().equals(eventName)) {
                    current = current.getNext();
                }
                if (current.getNext() != null) {
                    current.setNext(current.getNext().getNext());
                }
            }
        }
    }

}
