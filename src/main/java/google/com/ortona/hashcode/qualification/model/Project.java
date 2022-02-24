package google.com.ortona.hashcode.qualification.model;

import java.util.List;

public class Project {

    private String name;

    private List<Skill> skillRequiredList;

    private int bestBeforeDay;

    private List<People> contributorList;


    public Project(String name, List<Skill> skillRequiredList, int bestBeforeDay) {
        this.name = name;
        this.skillRequiredList = skillRequiredList;
        this.bestBeforeDay = bestBeforeDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkillRequiredList() {
        return skillRequiredList;
    }

    public void setSkillRequiredList(List<Skill> skillRequiredList) {
        this.skillRequiredList = skillRequiredList;
    }

    public int getBestBeforeDay() {
        return bestBeforeDay;
    }

    public void setBestBeforeDay(int bestBeforeDay) {
        this.bestBeforeDay = bestBeforeDay;
    }

    public List<People> getContributorList() {
        return contributorList;
    }

    public void setContributorList(List<People> contributorList) {
        this.contributorList = contributorList;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", skillRequiredList=" + skillRequiredList +
                ", bestBeforeDay=" + bestBeforeDay +
                ", contributorList=" + contributorList +
                '}';
    }

}
