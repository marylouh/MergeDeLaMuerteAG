package fr.isika.cda.amap_generation.utils;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
@ManagedBean
@ViewScoped
public class UploadFileBean implements Serializable{


	
	private static final long serialVersionUID = 1L;

	private String folder = "/ressources/"; 
	private Part file; 
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	
		
	public void saveFile() {
		
		System.out.println("saveFile method invoked");
		
		System.out.println("Content-type :{0}"+ file.getContentType());
		System.out.println("filename : {0}" + file.getName());
		System.out.println("Submitted filename :{0} "+ file.getSubmittedFileName());
		System.out.println("size:{0}"+ file.getSize());
		
		String fileName=""; 
		 fileName = getFilename(file);
		 
		 System.out.println("filename " + fileName);
		 try {
			file.write(folder+fileName);
		} catch (IOException e) {
		System.out.println("Error");
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File"+ fileName + "Uploaded"));
		
		
		
	}

	private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
	
		
	



}
