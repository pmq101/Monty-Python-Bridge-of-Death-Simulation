package main;
import gradingTools.comp401f17.assignment9.testcases.Assignment9Suite;
import util.trace.Tracer;

public class RunTests {
	public static void main(String[] args) {
		Tracer.showInfo(true);
		Assignment9Suite.main(args);
	}
}
