package google.com.ortona.hashcode.qualification.logic.sorter;

import google.com.ortona.hashcode.qualification.model.Project;

import java.util.Comparator;

public class SimpleProjectComparator implements Comparator<Project> {

    private int currentTime;


    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }


    @Override
    public int compare(Project p1, Project p2) {
        // TODO: 24/02/2022

        if (p1.isCritical(currentTime) != p2.isCritical(currentTime)) {
            if (p1.isCritical(currentTime)) return -1;
            else return 1;
        }

        /*
         t+delta

         score/giorni*persone
         */

        return 0;
    }



    /*
     * Internal utils
     */

    private int getProjectScoreEvaluation(Project project) {
        return project.getScore()/project.getSkillRequiredList().size()*project.getDuration();
    }

}
