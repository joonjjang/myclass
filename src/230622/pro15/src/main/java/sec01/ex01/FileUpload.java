package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";

		File cur = new File("C:\\file_repo");

		// 파일을 올리는 공간에다가 파일을 올리고자하는 용량과 경로 설정
		// 파일 공간에 대한 설정을 위한 클래스 DiskFileItemFactory
		
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//파일 설정과 관련된 여러가지 일을 하는 클래스,파일과 관련된 내용을 항목
		//파일 아이템이란 예를 들어 파일 이름, 파일 크기
		
		
		factory.setRepository(cur);
		factory.setSizeThreshold(1024 * 1024);
		//DiskFileItemFactory() 에 setSizeThreshold()는 저장될 파일 크기의 제한을 말한다.
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		System.out.println("파일 업로드 객체" + upload);
		
		try {
			List items = upload.parseRequest(request);
			System.out.println(items);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
				} else {
					System.out.println("파라미터명:" + fileItem.getFieldName());
					System.out.println("파일명:" + fileItem.getName());
					System.out.println("파일크기:" + fileItem.getSize() + "bytes");

					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
							System.out.println(idx);
						if (idx == -1) {
							System.out.println(fileItem.getName()+12);
							idx = fileItem.getName().lastIndexOf("/");
							System.out.println(idx);
						}
						System.out.println(fileItem.getName()+123);
						String fileName = fileItem.getName().substring(idx + 1);
//						System.out.println(fileName);
						File uploadFile = new File(cur + "\\" + fileName);
//						System.out.println(uploadFile);
						
						fileItem.write(uploadFile);
					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
