package kr.kwangan2.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kwangan2.domain.Author;
import kr.kwangan2.domain.Blog;
import kr.kwangan2.domain.Comm;
import kr.kwangan2.domain.CommSearcher;

public class BlogTest {

	public static void main(String[] args) {
		String resource = "kr/kwangan2/conf/sqlMapConfig.xml";
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMapper.openSession();

			List<Blog> blogs = session.selectList("kr.kwangan2.conf.Blog.selectBlog");

			for (Blog blog : blogs) {
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("blog id: " + blog.getBlogId());
				
			
				Author author = blog.getAuthor();
				System.out.println("\t" + author);
				List<Comm> comms = blog.getComms();
				for (Comm comm : comms) {
					System.out.println("\t" + comm);
				}
				System.out.println("--------------------------------------------------------------------------");
			}

		
			CommSearcher commSearcher = new CommSearcher();
			commSearcher.setFkblogId(1);
			commSearcher.setSearchKey("content");
			List<Comm> comms = session.selectList("selectCommsByBlogId", commSearcher);
			for (Comm comm : comms) {
				System.out.println(comm);
			}
			
/*
			Comm comm = new Comm();
			comm.setCommId(1);
			comm.setCommTitle("update title");
			comm.setCommContent("update content");
			comm.setFkblogId(1);
			int result = session.update("udpateComm" + comm);
			if (result > 0) {
				System.out.println("업데이트 성공");
			}

			ArrayList<Integer> commIdlist = new ArrayList<Integer>();
			commIdlist.add(2); // blog_id
			commIdlist.add(2);
			commIdlist.add(3);
			commIdlist.add(21);
			List<Comm> commList = session.selectList("selectCommsByCommIds", commIdlist);
			for (Comm comm2 : commList) {
				System.out.println(comm2);
			}
			
			//insert
			
			//delete
			
*/			
			session.commit();

		} catch (IOException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

	} // class

}
