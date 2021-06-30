package org.metro.bean;
import java.sql.Timestamp;
public class Journey {
	private int cardid;
	private String sourcestation,destinationstation;
	private Timestamp src,des;
	public Journey()
	{
		
	}
	public Journey(int cardid, String sourcestation, String destinationstation,Timestamp src,Timestamp des) {
		super();
		this.cardid = cardid;
		this.sourcestation = sourcestation;
		this.destinationstation = destinationstation;
		this.src=src;
		this.des=des;
	}
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public String getSourcestation() {
		return sourcestation;
	}
	public void setSourcestation(String sourcestation) {
		this.sourcestation = sourcestation;
	}
	public String getDestinationstation() {
		return destinationstation;
	}
	public void setDestinationstation(String destinationstation) {
		this.destinationstation = destinationstation;
	}
	public Timestamp getSrc()
	{
		return src;
	}
	public void setSrc(Timestamp src)
	{
		this.src=src;
	}
	public Timestamp getDes()
	{
		return des;
	}
	public void setDes(Timestamp des)
	{
		this.des=des;
	}
	@Override
	public String toString() {
		return "journey [cardid=" + cardid + ", sourcestation=" + sourcestation + ", destinationstation="
				+ destinationstation + "]";
	}
	
}

