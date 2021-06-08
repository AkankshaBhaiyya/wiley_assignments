

public class CDTwo implements Comparable<CDTwo>{
	private String name,title;
	public CDTwo(String name, String title) {
		super();
		this.name = name;
		this.title = title;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getTitle() {
		return title;
	}
	protected void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CDTwo other = (CDTwo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CDTwo [name=" + name + ", title=" + title + "]";
	}

	public int compareTo(CDTwo cdtwo) {
		String name1= this.getName();
		String name2=cdtwo.getName();
		return name1.compareTo(name2);
	}
	
}
