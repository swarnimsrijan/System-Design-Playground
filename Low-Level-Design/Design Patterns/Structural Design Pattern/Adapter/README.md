# Adapter Design Pattern

- also know as wrapper
- allows objects with incompatible interfaces to collaborate.



# How to Implement
- **Identify Incompatible Classes**
    - **Service class**: Unchangeable, useful (3rd-party/legacy).
    - **Client class**: Needs to use the service, but interfaces don’t match.

- **Define Client Interface**
    - Declare how clients want to communicate with the service.

- **Create Adapter Class**
    - Implement the client interface(adapter class should follow client interface).
    - Leave methods empty initially.

- **Store Service Reference**
    - Add a field for the service object.
    - Initialize via constructor or method calls.

- **Implement Adapter Methods**
    - For each client interface method:
        - Delegate work to the service object.
        - Convert data/interface as needed.

- **Use Adapter in Client**
    - Clients interact only with the client interface.
    - Adapters can evolve without changing client code.


# Pros and Cons
## Pros
- **Single Responsibility Principle**: as data conversion code is seperated from primary business logic
- **Open/Closed Principle**: new types of adapters can be introduced
## Cons
- **Increased Complexity**


# Examples
- Stream classes in Java