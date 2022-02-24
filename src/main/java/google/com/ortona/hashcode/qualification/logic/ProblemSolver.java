package google.com.ortona.hashcode.qualification.logic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import google.com.ortona.hashcode.qualification.model.ProblemContainer;
import google.com.ortona.hashcode.qualification.model.SolutionContainer;

public class ProblemSolver {
    private static Logger LOG = LoggerFactory.getLogger(ProblemSolver.class);

    public SolutionContainer solve(ProblemContainer pC) {
        SolutionContainer sC = new SolutionContainer();

        // fino alla fine dei problemi

		int t = 0;
        while (!pC.PROJECT_LIST.isEmpty()) {

			t++;
        }

        return sC;
    }

    public static void main(String[] args) {
        LOG.info("Hello World!");
    }

}
