package ca.etsmtl.log430.lab3;

import java.util.Observable;

/**
 * Assigns teachers to courses.
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
public class AssignTeacherToCourse extends Communication
{
	public AssignTeacherToCourse(Integer registrationNumber, String componentName) {
		super(registrationNumber, componentName);
	}

	/**
	 * The update() method is an abstract method that is called whenever the
	 * notifyObservers() method is called by the Observable class. First we
	 * check to see if the NotificationNumber is equal to this thread's
	 * RegistrationNumber. If it is, then we execute.
	 * 
	 * @see ca.etsmtl.log430.lab3.Communication#update(java.util.Observable,
	 *      java.lang.Object)
	 */
	public void update(Observable thing, Object notificationNumber) {
		Menus menu = new Menus();
		Teacher myTeacher = new Teacher();
		Course myCourse = new Course();

		if (registrationNumber.compareTo((Integer)notificationNumber) == 0) {
			addToReceiverList("ListTeachersComponent");
			addToReceiverList("ListCoursesComponent");

			// Display the teachers and prompt the user to pick a teacher

			signalReceivers("ListTeachersComponent");

			myTeacher = menu.pickTeacher(CommonData.theListOfTeachers.getListOfTeachers());

			if (myTeacher != null) {
				/*
				 * Display the courses that are available and ask the user to
				 * pick a course to register for
				 */
				signalReceivers("ListCoursesComponent");

				myCourse = menu.pickCourse(CommonData.theListOfCourses.getListOfCourses());

				if (myCourse != null)	{	
					/*
					 * If the selected course and teacher exist, then complete
					 * the registration process.
					 */
					myCourse.assignTeacher(myTeacher);
					myTeacher.assignCourse(myCourse);
				} else {
					System.out.println("\n\n *** Course not found ***");
				} 
			} else {
				System.out.println("\n\n *** Teacher not found ***");
			}
		}
	}
}