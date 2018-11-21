package ro.tuc.dsrl.ds.handson.assig.three.queue.communication;

import java.io.Serializable;

import ro.tuc.dsrl.ds.handson.assig.three.queue.entities.DVD;

public class DVDMessage implements Serializable {

	private static final long serialVersionUID = -2201401938312872400L;

	private String type;
	private DVD content;

	public DVDMessage(String type, DVD content) {
		this.type = type;
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DVD getContent() {
		return content;
	}

	public void setContent(DVD content) {
		this.content = content;
	}
}
