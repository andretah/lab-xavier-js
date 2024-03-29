package ca.etsmtl.log430.lab3;

/**
 * Initializes the system. First each component is instantiated. This is where
 * the component name and an ID is assigned. Then, the executive component is
 * started.
 * 
 * @author A.J. Lattanze, CMU
 * @version 1.3, 2012-Feb-14
 */

/*
 * Modification Log **********************************************************
 * v1.3, R. Champagne, 2012-Feb-14 - Various refactorings for new lab.
 * 
 * v1.2, R. Champagne, 2011-Feb-24 - Various refactorings, conversion of
 * comments to javadoc format.
 * 
 * v1.1, R. Champagne, 2002-Jun-19 - Adapted for use at ETS.
 * 
 * v1.0, A.J. Lattanze, 12/29/99 - Original version.
 * ***************************************************************************
 */

public class SystemInitialize {

	public static void main(String argv[]) {
		/*
		 * We instantiate each system component. After these components are
		 * instantiated, they simply wait until the Executive broadcasts
		 * changes. The broadcast message includes a registration number. These
		 * IDs are used in broadcasts to components. The component name is also
		 * included and is used whenever a caller wants to reference a
		 * component. Rather than have to remember a number, they can reference
		 * a component by name. I used the declared name of the object, but you
		 * could use anything you want.
		 */
		new AssignTeacherToCourse(new Integer(100), "AssignTeacherToCourse");
		new ListTeachers(new Integer(101), "ListTeachersComponent");
		new ListCourses(new Integer(102), "ListCoursesComponent");
		new ListCoursesAssignedToTeacher(new Integer(103),
				"ListCoursesAssignedToTeacherComponent");
		new ListTeachersAssignedToCourse(new Integer(104),
				"ListTeachersAssignedToCourseComponent");
		
		// LOG430 MODIFICATION 1
		new ListCoursesPreviouslyAssignedToTeacherComponent(new Integer(105),"ListCoursesPreviouslyAssignedToTeacherComponent");

		// LOG430 MODIFICATION 2
		new ListUnassignedCoursesComponent(new Integer(106),"ListUnassignedCoursesComponent");
		
		Executive executiveComponent = new Executive(new Integer(107),
				"ExecutiveComponent");

		// Start the executive
		executiveComponent.execute();
	}
}