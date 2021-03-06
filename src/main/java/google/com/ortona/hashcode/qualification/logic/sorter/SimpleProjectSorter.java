package google.com.ortona.hashcode.qualification.logic.sorter;

import google.com.ortona.hashcode.qualification.model.Project;

import java.util.List;

public class SimpleProjectSorter implements IProjectSorter {

    @Override
    public void sortProject(List<Project> projectList) {
        projectList.sort(new SimpleProjectComparator());
    }

}
