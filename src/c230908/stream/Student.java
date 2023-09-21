package c230908.stream;

public class Student implements Comparable<Student> {
	private String name;
	private int score; 

	Student(String name, int score){
		this.name = name;
		this.score = score;
	}

	public String getName() { return name; }
	public int getScore() { return score; }

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return name + " : " + score;
	}

	@Override
	public boolean equals(Object s) {
		if(name != ((Student)s).getName()) return false;
		return true;
	}

	@Override
	public int compareTo(Student s) {
		return score - s.getScore();
	}
}