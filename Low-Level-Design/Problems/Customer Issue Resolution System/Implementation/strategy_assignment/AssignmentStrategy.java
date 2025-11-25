package strategy_assignment;

import entity.Agent;
import entity.Issue;

import java.util.List;

public interface AssignmentStrategy {
    Agent assign(List<Agent> agents, Issue issue);
}
