# Rate Limiter
- controls the rate of the traffic send by client to service **(in network systems)**
- limits the number of client requests allowed to be sent over a specified period **(in HTTP world)**
- API request count > threshold :- all the excess calls are blocked

### Examples
- A user can write no more than 2 posts per second. etc etc

## Benifits of using Rate Limiter
- Prevent resource starvation caused by Denial of Service (DoS) attack.
    - A rate limiter prevents DoS attacks, either intentional or unintentional, by blocking the excess calls
- Reduce Cost
    - fewer servers and allocating more resources to high priority APIs
    - extremely important for companies that use paid third party APIs
- Prevent servers from being overloaded


## Where to put the rate limiter?
- Client Side Rate Limiter
- Server Side Rate Limiter

## Algotithms
- **Token Bucket Algorithm**
    - commonly used, simple and well understood
    - Working
        - A token bucket is a container that has pre-defined capacity
        - Tokens are put in the bucket at preset rates periodically. Once the bucket is full, no more tokens are added. 
        - Each request consumes one token. When a request arrives, we check if there are enough tokens in the bucket.
        - If there are enough tokens, we take one token out for each request, and the request goes through. If there are not enough tokens, the request is dropped
        - takes 2 parameters
            - Bucket Size: maximum number of tokens allowed in the bucket
            - Refill Rate: number of tokens put into the bucket every second
    - Pros
        - easy to implement
        - memory efficient
        - Enables its links to handle burst traffic.
        - Token bucket allows a burst of traffic for short         periods. A request can go through as long as there are tokens left.
    - Cons 
        - Two parameters in the algorithm are bucket size and token refill rate. However, it might be challenging to tune them properly.

- **Leaky Bucket Algorithm**
    - similar to the token bucket except that requests are processed at a fixed rate
    - implemented with a first-in-first-out (FIFO) queue.
    - Working
        - When a request arrives, the system checks if the queue is full. If it is not full, the request is added to the queue.
        - Otherwise, the request is dropped.
        - Requests are pulled from the queue and processed at regular intervals.
        - 2 Parameters
            - **Bucket size**: it is equal to the queue size. The queue holds the requests to be processed at a fixed rate.
            - **Outflow rate**: it defines how many requests can be processed at a fixed rate, usually in seconds.
    - Pros
        - Memory efficient given the limited queue size.
        - processing at a fixed rate therefore it is suitable for use cases that a stable outflow rate is needed
    - Cons
        - A burst of traffic fills up the queue with old requests, and if they are not processed in time, recent requests will be rate limited
        -  two parameters in the algorithm. It might not be easy to tune them properly.
- **Fixed Bucket Algorithm**
    - Working
        - algorithm divides the timeline into fix-sized time windows and assign a counter for each window
        - Each request increments the counter by one
        - Once the counter reaches the pre-defined threshold, new requests are dropped until a new time window starts.
    - Pros
        - Memory efficient.
        - Easy to understand.
        - Resetting available quota at the end of a unit time window fits certain use cases.
    - Cons
        - Spike in traffic at the edges of a window could cause more requests than the allowed quota to go through.(let's say 10 request per minute and quota resets at every minute, so it works perfectly for 1:00 to 1:01, but requests come at 1:00:30-1:01:30 then it gets 20 requests)
- **Sliding Window Log Algorithm**
    - sliding window log algorithm fixes the issue of fixed window counter algorithm
    - Working
        - algorithm keeps track of request timestamps. Timestamp data is usually kept in cache, such as sorted sets of Redis
        - a new request comes in, remove all the outdated timestamps. Outdated timestamps are defined as those older than the start of the current time window
        - Add timestamp(linux) of the new request to the log.
        - If the log size is the same or lower than the allowed count, a request is accepted. Otherwise, it is rejected.
    - Pros
        - more accurrate
        - In any rolling window, requests will not exceed the rate limit.
    - Cons
        - consumes a lot of memory because even if a request is rejected, its timestamp might still be stored in memory.
- **Sliding Window Counter**
    - hybrid approach that combines the fixed window counter and sliding window log
    - 2 Approach
    - Pros
        - 
    - Cons
        - 


- HTTP status code **429**: user has sent too many requests
- In cloud microservices: it is implemented in API Gateway
    - API gateway is a fully managed service that supports rate limiting, SSL termination, authentication, IP whitelisting, servicing static content, etc



---

### When Do You Use Both?

### Most modern systems use **both**, for example:

A mobile app calling your backend:

* **Client-side rate limiter** → prevents spammy user interactions
* **Server-side rate limiter** → protects API from bots or DDoS

A backend service calling an external API:

* **Client-side rate limiter** → ensures you don’t hit external limits
* **Server-side rate limiter** → governs internal quota usage

This is the **industry best practice**.

---

## Visual Summary Diagram (Textual)

```
                 +------------------+
Browser/Mobile → | Client-Side SDK  | -- smooth client calls
                 +------------------+
                           |
                           |
                    (Internet)
                           |
                           v
                 +----------------------+
                 | Server-Side Limiter | -- authoritative protection
                 +----------------------+
                           |
                           v
                     Backend Service
```

---
