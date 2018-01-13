package com.example.aagua.hackaz2018;

/**
 * Created by roxas on 1/13/2018.
 */

public class EventLinkedList {

    EventNode head;

    public EventLinkedList() {
        head = null;
    }

    public void push(String eventName, String eventDescription,
                     String cycle, int hour, int minute) {
        if (head == null) {
            head = new EventNode(eventName, eventDescription, cycle, hour, minute);
        }
        else {
            //Have to sort


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
