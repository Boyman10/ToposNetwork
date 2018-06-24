package org.rhm.climb.webapp.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.servlet.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action class to display image from a specific folder !
 * 
 * @author Boyman
 * @version 0.1.0
 */
public class ShowImage extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 7242580538989306432L;

	private static final Logger LOGGER = LogManager.getLogger(ShowImage.class);
	
	// To be used to receive the image from the request url
	private HttpServletRequest servletRequest;

	// image details :
	byte[] imageInByte = null;
	String imageId;

	public String execute() throws Exception {

		return SUCCESS;
	}
	
	
	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	
	public byte[] getCustomImageInBytes() {

		System.out.println("imageId" + imageId);

		BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(getImageFile(this.imageId));
			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "png", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imageInByte;
	}

	private File getImageFile(String imageId) {
		
		// retrieve path from struts.properties file :
		String filePath = getText("uploads.saveDir");

		File file = new File(filePath + File.separator + "climb-webapp" + File.separator + "uploads", imageId);
		
		System.out.println(file.toString());
		
		return file;
	}

	public String getCustomContentType() {
		return "image/png";
	}

	public String getCustomContentDisposition() {
		return "anyname.png";
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;
		
	}

}
