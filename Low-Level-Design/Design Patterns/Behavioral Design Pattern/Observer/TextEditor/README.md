# Observer Design Pattern Demonstration

## Key Components
- **Publisher(Subject)**
    - **EventManager**: Manages the list of listeners and notifies them when an event occurs.
        - subscribe: Adds a listener to a specific event type.
        - unsubscribe: Removes a listener from a specific event type.
        - notify: Notifies all listeners subscribed to a specific event type.
    - Editor: A concrete publisher that uses EventManager to notify listeners about file operations (open, save).
  
- **Observers(Listeners)**
  - EventListener:
    - interface
      - defines the update method, which all concrete listeners must implement.
  - EmailNotificationListener:
    - Sends an email notification when an event occurs.
    - LogOpenListener: Logs the event to a file when an event occurs.


## How It Works
- **Initialization**
  - The Editor creates an EventManager with two event types: "open" and "save". 
  - Listeners are subscribed to these events:
    - LogOpenListener is subscribed to the "open" event. 
    - EmailNotificationListener is subscribed to the "save" event.
- **Event Triggering**
  - When editor.openFile("test.txt") is called:
    - The Editor notifies all listeners subscribed to the "open" event. 
    - The LogOpenListener logs the event. 
  - When editor.saveFile() is called:
    - The Editor notifies all listeners subscribed to the "save" event.
    - The EmailNotificationListener sends an email notification.
- **Output**
  - When you run the Demo class, the output is:
  ```
  CopySave to log \path\to\log\file.txt: Someone has performed open operation with the following file: test.txt
  Email to admin@example.com: Someone has performed save operation with the following file: test.txt
  ```

[//]: # (Why Use the Observer Pattern?)

[//]: # (Loose Coupling: The publisher &#40;Editor&#41; doesn’t need to know the details of its listeners.)

[//]: # (Dynamic Relationships: Listeners can be added or removed at runtime.)

[//]: # (Reusability: The same listener can be reused for multiple publishers.)

