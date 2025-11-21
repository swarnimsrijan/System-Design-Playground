# Observer Design Pattern
- also known as **Event-Subscriber, Listener**
- provides a way to react to events happening in other objects without coupling to their classes.
- define a subscription mechanism
    - notifies multiple objects about events that happen to the object they're observing

## Problem
- Customer-Store relationship
    - Customer interested in particular product (visits daily)
    - Store share notification (to even to those customer who are not interested in that product)
    - Conflict created
## Solution
- 


## Usage
- Core Java Libraries
    ```
    java.util.Observer/java.util.Observable (rarely used in real world)
    All implementations of java.util.EventListener (practically all over Swing components)
    javax.servlet.http.HttpSessionBindingListener
    javax.servlet.http.HttpSessionAttributeListener
    javax.faces.event.PhaseListener
    ```
## Identification
- if you see a subscription method that stores incoming objects in a list 

# Problems asked 
1. Youtube channel-subscriber system
2. Notification System