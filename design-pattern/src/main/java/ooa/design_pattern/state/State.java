package ooa.design_pattern.state;

public interface State {
	// Set the time
	public abstract void doClock(Context context, int hour);

	// Use the safeframe
	public abstract void doUser(Context context);

	// Use alarm
	public abstract void doAlarm(Context context);

	// Use phone
	public abstract void doPhone(Context context);

}
