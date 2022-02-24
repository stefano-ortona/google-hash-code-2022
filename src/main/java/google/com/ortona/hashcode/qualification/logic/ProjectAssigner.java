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
	public boolean assignToProject(Project project, Map<String, List<Person>> peopleList, int curTime, List<Person> all) {
		List<Skill> currSkills = new ArrayList<>();
		currSkills.addAll(project.getSkillRequiredList());
		Collections.sort(currSkills, new Comparator<Skill>() {
			@Override
			public int compare(Skill o1, Skill o2) {
				return o2.getLevel() - o1.getLevel();
			}
		});

		Map<Integer, Person> skill2person = new HashMap<>();
		Set<String> assignedPeople = new HashSet<>();
		while(!currSkills.isEmpty()) {
			Skill curSkill = currSkills.remove(0);
			Person p = findPerson(curSkill, currSkills, peopleList,assignedPeople,skill2person,curTime, all);
			if(p == null) {
				return false;
			}
			skill2person.put(curSkill.getIndex(), p);
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

	private Person findPerson(Skill remove, List<Skill> currSkills, Map<String, List<Person>> peopleList, Set<String> assignedPeople, Map<Integer, Person> skill2person, int curTime, List<Person> all) {

		Person best = null;
		for(Person p:getPossiblePeople(peopleList, all,remove)) {
			if(p.getNextAvailableTime() > curTime || assignedPeople.contains(p.getName())) {
				continue;
			}
			if(!isEligible(p,remove,skill2person)) {
				continue;
			}
			if(best == null || p.getSkillByName(remove.getName()).getLevel() < best.getSkillByName(remove.getName()).getLevel()) {
				best = p;
			}
			// if same level, get the person with less skills
			if(p.getSkillList().size() < best.getSkillList().size()) {
				best = p;
			}

		}
		return best;
	}

	private List<Person> getPossiblePeople(Map<String, List<Person>> peopleMap, List<Person> all, Skill remove) {
		return remove.getLevel() > 1 ? peopleMap.get(remove.getName()) : all;
	}


	private boolean isEligible(Person person, Skill remove, Map<Integer, Person> skill2person) {
		int personLevel = person.getSkillByName(remove.getName()).getLevel();
		if(personLevel >= remove.getLevel()) {
			return true;
		}
		if(personLevel < remove.getLevel() - 1) {
			return false;
		}
		for(Person p: skill2person.values()) {
			if(p.getSkillByName(remove.getName()) != null && p.getSkillByName(remove.getName()).getLevel() >= remove.getLevel()) {
				//mentorship
				return true;
			}
		}
		return false;

	}



	private void updateSkills(Project project, Map<Integer, Person> skill2person) {
		for(Skill oneSkill : project.getSkillRequiredList()) {
			Skill personSkill = skill2person.get(oneSkill.getIndex()).getSkillByName(oneSkill.getName());
			if(personSkill.getLevel() <= oneSkill.getLevel()) {
				personSkill.setLevel(personSkill.getLevel() + 1);
			}
		}
	}

}
