- entities
    - issue(transactionId, issueType, subject, description, email, raisedBy, assignedTo, Status)
    - agent(agentId, issues)
    - User(email, number, password, accountID)
- enums
    - IssueType(Payment, Upi, Stocks, MutualFund, Gold, Insuarance)
    - Status(Raised, Resolved, Pending)


flow
User did a transaction
Transaction is pending