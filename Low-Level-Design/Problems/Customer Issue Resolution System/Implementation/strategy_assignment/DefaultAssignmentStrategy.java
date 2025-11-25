package strategy_assignment;

import entity.Agent;
import entity.Issue;

import java.util.List;

public class DefaultAssignmentStrategy implements AssignmentStrategy{

    @Override
    public Agent assign(List<Agent> agents, Issue issue){
        for(Agent agent: agents){
            if(agent.isAvailable() && agent.getExpertise().contains(issue.getIssueType())){
                return agent;
            }
        }
        return null;
    }
}
