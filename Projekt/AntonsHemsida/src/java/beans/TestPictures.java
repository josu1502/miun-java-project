/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.File;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB 
                 maxFileSize=1024*1024*50,          // 50 MB
                 maxRequestSize=1024*1024*100,      // 100 MB
                 location="/")

public class TestPictures {
    
    private Part file1;
    
    public String upload() throws IOException {
        String hej = System.getProperty("user.dir");
        System.out.println(hej);
        String filename = getFilename(file1);
        filename = new File(filename).getName();
        file1.write(filename);
        
        
        //file1.write("\\kbk.jpg");
        
        return "success";
        
    }
    private static String getFilename(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
            return s.substring(s.indexOf("=") + 2, s.length()-1);
        }
    }
    return "";
}

    /**
     * @return the file1
     */
    public Part getFile1() {
        return file1;
    }

    /**
     * @param file1 the file1 to set
     */
    public void setFile1(Part file1) {
        this.file1 = file1;
    }
}
