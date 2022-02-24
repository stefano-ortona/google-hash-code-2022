package google.com.ortona.hashcode.qualification.logic;

import google.com.ortona.hashcode.qualification.model.Person;
import google.com.ortona.hashcode.qualification.model.Project;
import google.com.ortona.hashcode.qualification.model.Skill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		Set<String> assignedPeople = new HashSet<>();
		while(!currSkills.isEmpty()) {
			Skill curSkill = currSkills.remove(0);
			Person p = findPerson(curSkill, currSkills, peopleList,assignedPeople);
			if(p == null) {
				return false;
			}
			skill2person.put(curSkill.getName(), p);
			assignedPeople.add(p.getName());

		}
		project.setContributorList(skill2person);
		project.setStartDay(curTime);
		for(Person p : skill2person.values()) {
			p.setNextAvailableTime(curTime + project.getDuration());
		}
		updateSkills(project, skill2person);

		return true;
	}

	private Person findPerson(Skill remove, List<Skill> currSkills, Map<String, List<Person>> peopleList, Set<String> assignedPeople) {
		// TODO Auto-generated method stub
		return null;
	}



	private void updateSkills(Project project, Map<String, Person> skill2person) {
		for(Skill oneSkill : project.getSkillRequiredList()) {
			Skill personSkill = skill2person.get(oneSkill.getName()).getSkillByName(oneSkill.getName());
			if(personSkill.getLevel() <= oneSkill.getLevel()) {
				personSkill.setLevel(personSkill.getLevel() + 1);
			}
		}
	}

}
