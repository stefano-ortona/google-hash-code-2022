package google.com.ortona.hashcode.qualification.logic.sorter;

import google.com.ortona.hashcode.qualification.model.Project;

import java.util.Comparator;

public class SimpleProjectComparator implements Comparator<Project> {

    private int currentTime;


    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }


    @Override
    public int compare(Project o1, Project o2) {
        // TODO: 24/02/2022

        /*
         t+delta

         score/giorni*persone
         */

        return 0;
    }

}
