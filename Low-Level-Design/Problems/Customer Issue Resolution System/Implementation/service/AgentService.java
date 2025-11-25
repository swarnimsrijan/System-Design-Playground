package service;

import entity.Agent;
import enums.IssueType;
import repository.AgentRepository;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class AgentService {
    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public void addAgent(String email, String name, List<IssueType> issueTypesList){
        String id = "A" + UUID.randomUUID().toString().substring(0, 6);
        Agent agent = new Agent(id, email, name, new HashSet<>(issueTypesList));
        agentRepository.save(agent);
        System.out.println(">>> Agent " + id + " created");
    }

    public void viewAgentsWorkHistory(){
        for(Agent agent: agentRepository.getAll()){
            System.out.println(agent.getId() + " -> " + agent.getHistory());
        }
    }

}
