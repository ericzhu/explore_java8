package org.apache.commons.launcher;

public class ExitOnErrorThreadGroup extends ThreadGroup {

    //------------------------------------------------------------ Constructors

    /**
     * Constructs a new thread group. The parent of this new group is the
     * thread group of the currently running thread.
     *
     * @param name the name of the new thread group
     */
    public ExitOnErrorThreadGroup(String name) {

        super(name);

    }

    //----------------------------------------------------------------- Methods

    /**
     * Trap any uncaught {@link Error} other than {@link ThreadDeath} and exit.
     *
     * @param t the thread that is about to exit
     * @param e the uncaught exception
     */
    public void uncaughtException(Thread t, Throwable e) {
    	return;
    }

    
    public static void main(String[] args) {
		System.out.println(System.getProperty("java.endorsed.dirs"));
	}
}