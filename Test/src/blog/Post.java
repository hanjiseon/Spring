package blog;

import java.util.ArrayList;

public class Post {
	
	private int id;
	private String subject;
	private Author author;
	private ArrayList<Comment> comments;
	private ArrayList<Tag> tags;
	private int draft;
}
