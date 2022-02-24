package google.com.ortona.hashcode.qualification.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemContainer {

    public List<Project> PROJECT_LIST = new ArrayList<>();
    public List<Person> Person_LIST = new ArrayList<>();

    public Map<String, Person> SKILL_2_PEOPLE_MAP = new HashMap<>();


    public ProblemContainer() {
    }

    @Override
    public String toString() {
        return "";
    }

}
