package blog;

import java.io.Serializable;
import java.util.ArrayList;

public class Blog implements Serializable{

	private int blogId;
	private String title;
	private Author author;
	private ArrayList<Post> post;
	
	public Blog(int blogId ) {
		this.blogId = blogId;
	}


}
