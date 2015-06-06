package base;

public class ToTop implements Comparable<ToTop> {
	private int count;
	private String name;

	public ToTop(int count, String name) {
		this.count = count;
		this.name = name;
	}

	public int getCount() {
		return this.count;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(ToTop o) {
		if (this.count > o.getCount())
			return 1;
		else if (this.count < o.getCount())
			return -1;
		else
			return this.name.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return this.name + "\t\t(" + this.count + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ToTop other = (ToTop) obj;
		if (count != other.count)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}