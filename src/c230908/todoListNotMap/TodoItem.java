package c230908.todoListNotMap;

public class TodoItem implements Comparable<TodoItem> {
	private String title;
	private String text;
	private int rank;

	public TodoItem() {
	}

	public TodoItem(String title, String text, int rank) {
		this.title = title;
		this.text = text;
		this.rank = rank;
	}

	public String title() {
		return this.title;
	}

	public String text() {
		return this.text;
	}

	public int rank() {
		return this.rank;
	}

	@Override
	public int hashCode() {
		return title.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TodoItem))
			return false;
		if (!title.equals(((TodoItem) obj).title()))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "제목 : " + title + "\n" + "우선순위 : " + rank + "\n" + "내용 : " + text + "\n";
	}

	@Override
	public int compareTo(TodoItem todoItem) {
		return todoItem.rank - this.rank;
	}

	public String toList() {
		return "제목 : " + title + " / " + "우선순위 : " + rank;
	}

	public boolean isThis(String title) {
		if (title.equals(this.title))
			return true;
		return false;
	}
}