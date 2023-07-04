package pro18;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	private DataSource dataFactory;
	Connection con;
	PreparedStatement pstmt;

	public BoardDAO() {
		
		// JNDI(Java Naming and Directory Interface)를 사용하여
		// DataSource를 검색하는 부분입니다.
		try {
			Context ctx = new InitialContext();

			// InitialContext 객체를 생성하여 JNDI에 대한 초기 컨텍스트를 가져옵니다.
			Context envContext = (Context) ctx.lookup("java://comp/env");

			// 메서드를 사용하여 "java://comp/env" 경로에 대한 컨텍스트를 찾습니다.
			// 이 경로는 일반적으로 JNDI 네임스페이스에 접근하기 위한 표준 경로입니다.
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");

			// 메서드를 사용하여 "jdbc/oracle" 이름을 가진 DataSource를 찾습니다.
			// 이를 통해 데이터베이스 연결에 사용될 DataSource를 가져옵니다.

		} catch (Exception e) {

		}

	}

	public List selectAllArticles(Map pagingMap) {

		// 데이터베이스에서 게시글을 검색하는 메서드

		List articlesList = new ArrayList<>();
		// 페이징 처리를 위한 pagingMap 매개변수를 받고, 지정된 범위에 해당하는 게시글을 검색하여
		// ArticleVO 객체로 변환하고 이를 리스트에 추가합니다.

		int section = (Integer) pagingMap.get("section");
		// pagingMap에서 "section" 키로 저장된 값을 가져옵니다. 섹션은 페이지 섹션을 나타냅니다.

		int pageNum = (Integer) pagingMap.get("pageNum");
		// pagingMap에서 "pageNum" 키로 저장된 값을 가져옵니다. 페이지 번호를 나타냅니다.

		try {
			con = dataFactory.getConnection();
			// dataFactory에서 커넥션을 가져옵니다. 데이터베이스 연결을 위한 커넥션 객체를 생성합니다.

			String query = "select * from (" + "select ROWNUM as recNum," + "LVL," + "articleNO," + "title," + "id,"
					+ "writeDate" + " from (select LEVEL as LVL," + "articleNO," + "title," + "id," + "writeDate"
					+ " from t_board" + " start with parentNO = 0" + " connect by prior articleNO = parentNO"
					+ " order siblings by articleNO DESC" + ") "
					+ " where recNum between(?-1)*100+(?-1)*10+1 and (?-1)*100+?*10";

			pstmt = con.prepareStatement(query);
			// SQL 쿼리를 실행하기 위한 PreparedStatement 객체를 생성합니다.

			pstmt.setInt(1, section);
			pstmt.setInt(2, pageNum);
			pstmt.setInt(3, section);
			pstmt.setInt(4, pageNum);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// ResultSet에서 결과를 하나씩 반복하여 처리합니다

				int level = rs.getInt("lvl");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNO(articleNO);
				article.setParentNO(parentNO);
				article.setTitle(title);
				article.setId(id);
				article.setWriteDate(writeDate);
				articlesList.add(article);
			} // end while

			rs.close();
			pstmt.close();
			con.close();
			// 리소스 누수를 방지하기 위해 사용한 리소스를 명시적으로 닫아야 합니다.

		} catch (Exception e) {
			// TODO: handle exception
		}

		return articlesList;

	}

	public List selectAllArticles() {

		List articlesList = new ArrayList();

		try {
			con = dataFactory.getConnection();

			String query = "SELECT LEVEL,articleNO,parentNO,title,content,id,writeDate" + " from t_board"
					+ " START WITH  parentNO=0" + " CONNECT BY PRIOR articleNO=parentNO"
					+ " ORDER SIBLINGS BY articleNO DESC";
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNO(articleNO);
				article.setParentNO(parentNO);
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);
				articlesList.add(article);
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return articlesList;

	}

	private int getNewArticleNO() {

		try {
			con = dataFactory.getConnection();
			String query = "select max(articleNO) from t_board ";
			pstmt = con.prepareStatement(query);
			// SQL 쿼리를 실행하기 위한 PreparedStatement 객체를 생성합니다.

			ResultSet rs = pstmt.executeQuery(query);
			// Java JDBC(Java Database Connectivity)를 통해
			// 데이터베이스에서 결과 집합을 가져오기 위해 사용되는 인터페이스입니다.

			if (rs.next())
				return (rs.getInt(1) + 1);

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {

		}
		return 0;
	}

	public int insertNewArticle(ArticleVO article) {

		int articleNO = getNewArticleNO();

		try {

			con = dataFactory.getConnection();

			int parentNO = article.getParentNO();

			String title = article.getTitle();
			String content = article.getContent();
			String id = article.getId();

			String imageFileName = article.getImageFileName();
			// getImageFileName() 메서드는 article 객체에서 이미지 파일 이름을 가져오는 메서드

			String query = "INSERT INTO t_board (articleNO, parentNO, title, content, imageFileName, id)"
					+ " VALUES (?, ? ,?, ?, ?, ?)";
			// 테이블에 데이터를 삽입하는 SQL 쿼리를 생성하는 부분입니다.

			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return articleNO;
	}

	public ArticleVO selectArticle(int articleNO) {
		
		ArticleVO article = new ArticleVO();
		
		try {
			con = dataFactory.getConnection();
			String query = "select articleNO,parentNO,title,content, imageFileName,id,writeDate" + " from t_board"
					+ " where articleNO=?";
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			int _articleNO = rs.getInt("articleNO");
			int parentNO = rs.getInt("parentNO");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = rs.getString("imageFileName");
			String id = rs.getString("id");
			Date writeDate = rs.getDate("writeDate");

			article.setArticleNO(_articleNO);
			article.setParentNO(parentNO);
			article.setTitle(title);
			article.setContent(content);
			article.setImageFileName(imageFileName);
			article.setId(id);
			article.setWriteDate(writeDate);
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	public void updateArticle(ArticleVO article) {
		
		int articleNO = article.getArticleNO();
		
		String title = article.getTitle();
		String content = article.getContent();
		String imageFileName = article.getImageFileName();
		
		// ArticleVO의 메서드를 이용하여 저장된 값을 get을 이용해 가져옴
		// why? 업데이트를 위해 가져오는 것
		
		try {
			con = dataFactory.getConnection();
			String query = "update t_board  set title=?,content=?";
			if (imageFileName != null && imageFileName.length() != 0) {
				query += ",imageFileName=?";
			}
			query += " where articleNO=?";

			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			
			// 이 과정에서 위쪽에서 미리 가져온 데이터를 set 해줌
			
			if (imageFileName != null && imageFileName.length() != 0) {
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, articleNO);
			} else {
				pstmt.setInt(3, articleNO);
			}
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteArticle(int articleNO) {
		
		try {
			con = dataFactory.getConnection();
			
			String query = "DELETE FROM t_board ";
			query += " WHERE articleNO in (";
			query += "  SELECT articleNO FROM  t_board ";
			query += " START WITH articleNO = ?";
			query += " CONNECT BY PRIOR  articleNO = parentNO )";
			
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Integer> selectRemovedArticles(int articleNO) {
		
		List<Integer> articleNOList = new ArrayList<Integer>();
		
		try {
			con = dataFactory.getConnection();
			
			String query = "SELECT articleNO FROM  t_board  ";
			
			query += " START WITH articleNO = ?";
			query += " CONNECT BY PRIOR  articleNO = parentNO";
			
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				articleNO = rs.getInt("articleNO");
				articleNOList.add(articleNO);
			}
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleNOList;
	}

	public int selectTotArticles() {
		
		try {
			
			con = dataFactory.getConnection();
			
			String query = "select count(articleNO) from t_board ";
			
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
				return (rs.getInt(1));
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
