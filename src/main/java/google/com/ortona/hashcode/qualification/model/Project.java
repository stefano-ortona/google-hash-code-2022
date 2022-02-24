package google.com.ortona.hashcode.qualification.model;

import google.com.ortona.hashcode.qualification.logic.ProblemSolver;

import java.util.List;

public class Project {

    private String name;

    private List<Skill> skillRequiredList;

    private int bestBeforeDay;

    private int duration;

    private int score;

    private List<Person> contributorList;

    private Integer startDay = null;

    public Project(String name, List<Skill> skillRequiredList, int bestBeforeDay, int duration, int score) {
        this.name = name;
        this.skillRequiredList = skillRequiredList;
        this.bestBeforeDay = bestBeforeDay;
        this.duration = duration;
        this.score = score;
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

    public boolean isCritical(int currentTime) {
        return currentTime + ProblemSolver.PROJECT_TIME_BUFFER >= bestBeforeDay;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", skillRequiredList=" + skillRequiredList +
                ", bestBeforeDay=" + bestBeforeDay +
                ", duration=" + duration +
                ", score=" + score +
                ", contributorList=" + contributorList +
                ", startDay=" + startDay +
                '}';
    }

}
