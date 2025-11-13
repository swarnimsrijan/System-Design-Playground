# API Gateway Pattern
- stands for **Backend for frontend**
- the entry gate for taking entry in any application by an external source
- medium between the client applications and microservices

# Use of this pattern
- Single Entry Point
- routes the request
    - provide a roadmap for how
        - request goes
        - approve
        - cancelled
        - Api composition
        - app authentication
- rate limiting
- authentication
- load balancing

# How API Gateway Handles the Client requests:
- Client(external) -> API gateway
- routes the req to their place
- other additive requests i.e. using multiple services and the aggregating result are handled by API gateway.

# Architecture
- 2 Layers
    - Common layer
        - helps in the working of edge function which helps in the authentication
    - API layer
        - each API module helps in making an API for specific clients. 
        - one or more independent API modules.
- Image
![Architecture](https://github.com/swarnimsrijan/System-Design-Playground/blob/main/Resources/apigatewayarchitecture.jpg)


# Advantages
- encloses the whole internal structure of web applications.
- never calls a particular service
- helps in simplification of code of client-side
- prevention from malicious cyber attacks

# Disadvantage
- application services will be shown only if the API is up-to-date means updated.
- important for each process for being lightweight because otherwise their time complexity will get increased because their developer has to wait in the process of updating API.
