package google.com.ortona.hashcode.qualification.model;

import java.util.ArrayList;
import java.util.List;

public class SolutionContainer {

    public List<Project> SOLUTION_PROJECT_LIST = new ArrayList<>();

    public SolutionContainer() {
    }

    public int getScore() {
        return 0;
    }

    @Override
    public String toString() {
        return "__";
    }
}
