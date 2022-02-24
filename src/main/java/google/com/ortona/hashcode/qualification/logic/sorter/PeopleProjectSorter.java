package google.com.ortona.hashcode.qualification.logic.sorter;

import google.com.ortona.hashcode.qualification.model.Person;
import google.com.ortona.hashcode.qualification.model.Project;

import java.util.List;

public class PeopleProjectSorter implements IProjectSorter {

    private final List<Person> personList;

    public PeopleProjectSorter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public void sortProject(List<Project> projectList) {

    }
    
}
