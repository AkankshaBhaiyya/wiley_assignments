package org.metro.bean;

import java.sql.Timestamp;

public class SystemInfo {
	private int cardid,amount;
	private String source,destination;
	private Timestamp srcTimestamp,destTimestamp;
	public SystemInfo()
	{
		
	}
	public SystemInfo(int cardid, int amount, String source, String destination, Timestamp srcTimestamp,
			Timestamp destTimestamp) {
		super();
		this.cardid = cardid;
		this.amount = amount;
		this.source = source;
		this.destination = destination;
		this.srcTimestamp = srcTimestamp;
		this.destTimestamp = destTimestamp;
	}
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Timestamp getSrcTimestamp() {
		return srcTimestamp;
	}
	public void setSrcTimestamp(Timestamp srcTimestamp) {
		this.srcTimestamp = srcTimestamp;
	}
	public Timestamp getDestTimestamp() {
		return destTimestamp;
	}
	public void setDestTimestamp(Timestamp destTimestamp) {
		this.destTimestamp = destTimestamp;
	}
	@Override
	public String toString() {
		return "SystemInfo [cardid=" + cardid + ", amount=" + amount + ", source=" + source + ", destination="
				+ destination + ", srcTimestamp=" + srcTimestamp + ", destTimestamp=" + destTimestamp + "]";
	}

}
