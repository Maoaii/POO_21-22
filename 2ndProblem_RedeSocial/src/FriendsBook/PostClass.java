package FriendsBook;

public class PostClass implements Post {
	private String postMessage;
	private String author;
	
	public PostClass(String author, String postMessage) {
		this.author = author;
		this.postMessage = postMessage;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public String getMessage() {
		return postMessage;
	}
	
	
}
