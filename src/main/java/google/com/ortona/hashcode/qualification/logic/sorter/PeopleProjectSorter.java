package google.com.ortona.hashcode.qualification.logic.sorter;

import google.com.ortona.hashcode.qualification.model.People;
import google.com.ortona.hashcode.qualification.model.Project;

import java.util.List;

public class PeopleProjectSorter implements IProjectSorter {

    private final List<People> peopleList;

    public PeopleProjectSorter(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public List<Project> sortProject(List<Project> projectList) {
        return null;
    }
    
}
