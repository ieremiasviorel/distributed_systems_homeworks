package ro.tuc.dsrl.ds.handson.assig.three.queue.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import ro.tuc.dsrl.ds.handson.assig.three.queue.entities.DVD;

public class DVDQueue {

	private BlockingQueue<DVD> queue;

	public DVDQueue() {
		queue = new LinkedBlockingDeque<DVD>();
	}

	public void put(DVD message) throws InterruptedException {
		queue.put(message);
	}

	public DVD get() throws InterruptedException {
		return queue.take();
	}
}
