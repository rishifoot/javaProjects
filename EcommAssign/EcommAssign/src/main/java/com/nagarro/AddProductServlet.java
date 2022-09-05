package com.nagarro;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public static final String UPLOAD_DIR = "images";
    public String dbFileName = "";
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
//		int id = Integer.parseInt(request.getParameter("id"));
//        String firstName = request.getParameter("firstname");
//        String lastName = request.getParameter("lastname");
		
		String title = request.getParameter("title");
        String quantity = request.getParameter("quantity");
        String size = request.getParameter("size");          
//        String fileName = request.getParameter("image");

        Part part = request.getPart("file");
        String fileName = extractFileName(part);
//        Product prod = new Product(title, quantity, size, fileName);
//        
//        try(PrintWriter out = response.getWriter()){
//            ProductDao proDao = new ProductDao(ConnectionDao.getCon());
//            if(proDao.addProduct(prod)){
//                response.sendRedirect("index.jsp");
//            }else{
//                out.print("wrong credential");
//            }
//            
//        }catch(Exception e){
//            e.printStackTrace();
//        }

        /**
         * *** Get The Absolute Path Of The Web Application ****
         */
        String applicationPath = getServletContext().getRealPath("/WEB-INF");
        System.out.println("App Path: "+ applicationPath);
//       String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
//        System.out.println("applicationPath:" + applicationPath);
//        File fileUploadDirectory = new File(uploadPath);
//        if (!fileUploadDirectory.exists()) {
//            fileUploadDirectory.mkdirs();
//        }
//        Set<String> resourcePaths = servletContext.getResourcePaths("/");
        
        File folder = new File("src/main/webapp/WEB-INF/images/");
        System.out.println(folder);
        
        folder = (File) getServletContext().getAttribute(ServletContext.TEMPDIR);
        System.out.println(folder);
        
        String savePath = "images" + File.separator + fileName;
//        System.out.println("savePath: " + savePath);
//        String sRootPath = new File(savePath).getAbsolutePath();
        
//        System.out.println("sRootPath: " + sRootPath);
//        part.write(savePath + File.separator);
        
        File fileSaveDir1 = new File(fileName);
        /*if you may have more than one files with same name then you can calculate some random characters
         and append that characters in fileName so that it will  make your each image name identical.*/
//        part.write(savePath + File.separator);
        //out.println(id+" "+firstName+" "+lastName+" "+fileName+" "+savePath);
        /*
         You need this loop if you submitted more than one file
         for (Part part : request.getParts()) {
         String fileName = extractFileName(part);
         part.write(savePath + File.separator + fileName);
         }*/
		
		
//	1t file
//		String title = request.getParameter("title");
//        String quantity = request.getParameter("quantity");
//        String size = request.getParameter("size");          
//        String image = request.getParameter("image");
        Product prod = new Product(title, quantity, size, savePath);       
        try(PrintWriter out = response.getWriter()){
            ProductDao proDao = new ProductDao(ConnectionDao.getCon());
            if(proDao.addProduct(prod)){
                response.sendRedirect("index.jsp");
            }else{
                out.print("wrong credential");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	// file name of the upload file is included in content-disposition header like this:
    //form-data; name="dataFile"; filename="PHOTO.JPG"
//part
    private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
