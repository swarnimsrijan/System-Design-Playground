package service;

import entity.Agent;
import entity.Issue;
import enums.IssueStatus;
import enums.IssueType;
import repository.AgentRepository;
import repository.IssueRepository;

import java.util.List;
import java.util.Map;

public class IssueService {
    private final IssueRepository issueRepository;
    private final AgentRepository agentRepository;

    public IssueService(IssueRepository issueRepository, AgentRepository agentRepository) {
        this.issueRepository = issueRepository;
        this.agentRepository = agentRepository;
    }

    public Issue createIssue(String transactionId, IssueType issueType, String subject, String description, String email){
        Issue issue = new Issue(transactionId, issueType, subject, description, email);
        issueRepository.save(issue);
        System.out.println(">>> Issue " + issue.getId() + " created against transaction \"" + transactionId + "\"");
        return issue;
    }
    public List<Issue> getIssues(Map<String, String> filter){
        return issueRepository.getAll().stream().filter(issue -> {
            if(filter.containsKey("email") && !issue.getEmail().equalsIgnoreCase(filter.get("email"))){
                return false;
            }
            if(filter.containsKey("type") && !issue.getEmail().equalsIgnoreCase(filter.get("type"))){
                return false;
            }
            if(filter.containsKey("status") && !issue.getEmail().equalsIgnoreCase(filter.get("status"))){
                return false;
            }
            return true;
        }).toList();
    }

    public void updateIssue(String issueId, IssueStatus status, String resolution){
        Issue issue = issueRepository.getById(issueId);
        if(issue == null) throw new IllegalArgumentException("Issue Not Found");
        issue.setStatus(status);
        issue.setResolution(resolution);
        System.out.println(">>> " + issueId + " status updated to " + issue.getStatus());
    }

    public void resolveIssue(String issueId, String resolution){
        Issue issue = issueRepository.getById(issueId);
        if(issue == null) throw new IllegalArgumentException("Issue not found");

        issue.setStatus(IssueStatus.RESOLVED);
        issue.setResolution(resolution);

        if(issue.getAssignedAgentId() != null){
            Agent agent = agentRepository.getById(issue.getAssignedAgentId());
            if(agent != null){
                agent.getHistory().add(issue.getId());
                agent.setAssignedIssueId(null);
            }

        }

        System.out.println(">>> " + issueId + " issue marked resolved");
    }


}
