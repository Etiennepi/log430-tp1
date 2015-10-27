package edu.gordon.common;

import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import edu.gordon.common.events.CardInsertedEvent;
import edu.gordon.common.events.TurnOffEvent;
import edu.gordon.common.events.TurnOnEvent;

/**
 * This class represents the current status of the system.
 *
 */
public class StatusEventBus
{
	private static StatusEventBus instance = null;
	private AsyncEventBus eventBus = null;

	private StatusEventBus() {
		eventBus = new AsyncEventBus(Executors.newCachedThreadPool(new ThreadFactoryBuilder().setDaemon(true).setNameFormat("event-bus-%d").build()));
	}

	public static StatusEventBus getInstance() {
		if (instance == null) {
			instance = new StatusEventBus();
		}
		return instance;
	}

	public void registerToEventBus(Object object) {
		eventBus.register(object);
	}

	public void postTurnOnEvent(TurnOnEvent e){
		eventBus.post(e);
	}

	public void postTurnOffEvent(TurnOffEvent e){
		eventBus.post(e);
	}

	public void postCardInsertedEvent(CardInsertedEvent e){
		eventBus.post(e);
	}

}
