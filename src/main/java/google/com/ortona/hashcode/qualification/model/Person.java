package google.com.ortona.hashcode.qualification.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {

	private String name;

	private List<Skill> skillList;

	private int nextAvailableTime = 0;
	private Map<String, Skill> name2skill = new HashMap<>();


	public Person(String name, List<Skill> skillList) {
		this.name = name;
		this.skillList = skillList;
		this.reorder();

	}

	public void reorder() {
		for(Skill oneS:skillList) {
			name2skill.put(oneS.getName(), oneS);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public int getNextAvailableTime() {
		return nextAvailableTime;
	}

	public Skill getSkillByName(String name) {
		return this.name2skill.getOrDefault(name, new Skill(name,0));
	}

	public void setNextAvailableTime(int nextAvailableTime) {
		this.nextAvailableTime = nextAvailableTime;
	}

	@Override
	public String toString() {
		return "People{" +
				"name='" + name + '\'' +
				", skillList=" + skillList +
				", nextAvailableTime=" + nextAvailableTime +
				'}';
	}
}
