package google.com.ortona.hashcode.qualification.model;

import java.util.List;

public class Person {

    private String name;

    private List<Skill> skillList;

    private int nextAvailableTime = 0;


    public Person(String name, List<Skill> skillList) {
        this.name = name;
        this.skillList = skillList;
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
