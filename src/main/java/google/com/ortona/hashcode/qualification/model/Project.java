package google.com.ortona.hashcode.qualification.model;

import java.util.List;

public class Project {

    private String name;

    private List<Skill> skillRequiredList;

    private int bestBeforeDay;

    private int score;

    private List<Person> contributorList;

    private Integer startDay = null;


    public Project(String name, List<Skill> skillRequiredList, int bestBeforeDay, int score, List<Person> contributorList, int startDay) {
        this.name = name;
        this.skillRequiredList = skillRequiredList;
        this.bestBeforeDay = bestBeforeDay;
        this.score = score;
        this.contributorList = contributorList;
        this.startDay = startDay;
    }


    /*
     * Utility
     */

    public int getFinalScore() {
        if (startDay == null) {
            return 0;
        }
        return 0;
    }

    // ------


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

    public List<Person> getContributorList() {
        return contributorList;
    }

    public void setContributorList(List<Person> contributorList) {
        this.contributorList = contributorList;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", skillRequiredList=" + skillRequiredList +
                ", bestBeforeDay=" + bestBeforeDay +
                ", score=" + score +
                ", contributorList=" + contributorList +
                ", startDay=" + startDay +
                '}';
    }

}
