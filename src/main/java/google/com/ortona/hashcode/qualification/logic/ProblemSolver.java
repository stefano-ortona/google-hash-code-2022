package google.com.ortona.hashcode.qualification.logic;


import google.com.ortona.hashcode.qualification.logic.sorter.IProjectSorter;
import google.com.ortona.hashcode.qualification.logic.sorter.SimpleProjectSorter;
import google.com.ortona.hashcode.qualification.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import google.com.ortona.hashcode.qualification.model.ProblemContainer;
import google.com.ortona.hashcode.qualification.model.SolutionContainer;

import java.util.Iterator;
import java.util.List;

public class ProblemSolver {
    private static Logger LOG = LoggerFactory.getLogger(ProblemSolver.class);

    public static int PROJECT_TIME_BUFFER = 30;

    private IProjectSorter PROJECT_SORTER = new SimpleProjectSorter();
	private ProjectAssigner PROJECT_ASSIGNER = new ProjectAssigner();


    public SolutionContainer solve(ProblemContainer pC) {
        SolutionContainer sC = new SolutionContainer();

        // fino alla fine dei problemi

		int t = 0;
        while (!pC.PROJECT_LIST.isEmpty()) {
        	removeImpossibleProjects(t, pC.PROJECT_LIST);

			PROJECT_SORTER.sortProject(pC.PROJECT_LIST);

			for (Project project : pC.PROJECT_LIST) {
				PROJECT_ASSIGNER.assignToProject(project, pC.SKILL_2_PEOPLE_MAP);
			}

			t++;
        }

        return sC;
    }


    /*
     * Internal methods
     */

    private void removeImpossibleProjects(int currentTime, List<Project> projectList) {
		// rimuove anche i progetti già assegnati
        Iterator<Project> it = projectList.iterator();
        while (it.hasNext()) {
            Project project = it.next();

            // if already assigned
            if (project.getStartDay() != null) {
                projectList.remove(project);
            }

            // if no value
            if (project.getScoreByCurrentTime(currentTime) <= 0) {
                projectList.remove(project);
            }
        }
	}






    public static void main(String[] args) {
        LOG.info("Hello World!");
    }

}
