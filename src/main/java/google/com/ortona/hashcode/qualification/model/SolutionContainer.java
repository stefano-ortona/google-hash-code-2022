package google.com.ortona.hashcode.qualification.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionContainer {

    public List<Project> SOLUTION_PROJECT_LIST = new ArrayList<>();

    public SolutionContainer() {
    }

    public int getScore() {
        for (Project project : SOLUTION_PROJECT_LIST) {

        }
        return 0;
    }

    @Override
    public String toString() {
    	StringBuilder output = new StringBuilder("" + SOLUTION_PROJECT_LIST.size()).append("\n");
    	for(final Project project: SOLUTION_PROJECT_LIST) {
    		output.append(project.getName()).append("\n");
    		final List<Skill> skills = project.getSkillRequiredList();
    		final Map<String,Person> contributors = project.getContributorList();
    		final String names = skills.stream().
    				map(skill -> contributors.get(skill.getName()).getName()).
    				collect(Collectors.joining(" "));
    		output.append(names).append("\n");
    	}
    	
        return output.toString();
    }
}
