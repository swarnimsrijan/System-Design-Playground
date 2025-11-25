package service;

import entity.Agent;
import entity.Issue;
import enums.IssueStatus;
import repository.AgentRepository;
import repository.IssueRepository;
import strategy_assignment.AssignmentStrategy;

import java.util.ArrayList;
import java.util.List;

public class AssignmentService {
    private final AgentRepository agentRepository;
    private final IssueRepository issueRepository;
    private final AssignmentStrategy assignmentStrategy;

    public AssignmentService(AgentRepository agentRepository, IssueRepository issueRepository, AssignmentStrategy assignmentStrategy) {
        this.agentRepository = agentRepository;
        this.issueRepository = issueRepository;
        this.assignmentStrategy = assignmentStrategy;
    }

    public void assignIssue(String issueId){
        Issue issue = issueRepository.getById(issueId);
        if(issue == null) throw new IllegalArgumentException("Issue not found");

        List<Agent> agentList = new ArrayList<>(agentRepository.getAll());
        Agent assigned = assignmentStrategy.assign(agentList, issue);

        if (assigned != null) {
            assigned.setAssignedIssueId(issue.getId());
            issue.setAssignedAgentId(assigned.getId());
            System.out.println(">>> Issue " + issueId + " assigned to agent " + assigned.getId());
        } else {
            for(Agent agent : agentList) {
                 if(agent.getExpertise().contains(issue.getIssueType())){
                     agent.getWaitlist().add(issue.getId());
                     issue.setStatus(IssueStatus.WAITING);
                     System.out.println(">>> Issue " + issueId + " added to waitlist of Agent " + agent.getId());
                     return;
                 }
            }
            System.out.println(">>> No agent found with expertise for issue " + issueId);
        }
    }




}
