package google.com.ortona.hashcode.qualification.logic;

import google.com.ortona.hashcode.qualification.model.Person;
import google.com.ortona.hashcode.qualification.model.Project;
import google.com.ortona.hashcode.qualification.model.Skill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectAssigner {

    /*
     * false se non può essere assegnato
     */
    public boolean assignToProject(Project project, Map<String, List<Person>> peopleList, int curTime) {
    	List<Skill> currSkills = new ArrayList<>();
    	currSkills.addAll(project.getSkillRequiredList());
    	Collections.sort(currSkills, new Comparator<Skill>() {
			@Override
			public int compare(Skill o1, Skill o2) {
				return o2.getLevel() - o1.getLevel();
			}
		});
    	
    	Map<String, Person> skill2person = new HashMap<>();
    	while(!currSkills.isEmpty()) {
    		Person p = findPerson(currSkills.remove(0), currSkills);
    		if(p == null) {
    			return false;
    		}
    	}
    	project.setContributorList(curPeople);
    	project.setStartDay(curTime);
    	for(Person p : curPeople) {
    		p.setNextAvailableTime(curTime + project.getDuration());
    	}

        return true;
    }

	private Person findPerson(Skill remove, List<Skill> currSkills) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	private void updateSkills(Project project, List<Person> people) {
		for(int i = 0; i < project.getSkillRequiredList().size(); i++) {
			Skill s = project.getSkillRequiredList().get(i);
			Person p = people.get(i);
		}
		
		
	}

}
