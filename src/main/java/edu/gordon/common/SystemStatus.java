package edu.gordon.common;

import java.util.HashMap;
import java.util.Observable;

/**
 * This class represents the current status of the system.
 *
 */
public class SystemStatus extends Observable
{
	private static SystemStatus instance = null;
	private HashMap<String, Boolean> status;

	private SystemStatus() {
		status = new HashMap<String, Boolean>();
		status.put("active", false);
		status.put("cardInserted", false);
	}

	/**
	 * @param name name of the status
	 * @return status
	 */
	public boolean is(String name) {
		return this.status.get(name);
	}

	public void set(String name, boolean status) {
		this.status.put(name, status);
		setChanged();
		notifyObservers();
		System.out.println("SYSTEM, " + countObservers());
	}

	public static SystemStatus getInstance() {
		if (instance == null) {
			instance = new SystemStatus();
		}

		return instance;
	}

}
