package com.jfixby.cmns.api.desktop;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.jfixby.cmns.api.file.File;
import com.jfixby.cmns.api.image.ArrayColorMap;
import com.jfixby.cmns.api.image.ColorMap;
import com.jfixby.cmns.api.image.GrayMap;
import com.jfixby.cmns.api.io.InputStream;
import com.jfixby.cmns.api.io.OutputStream;

public interface ImageAWTComponent {

    BufferedImage readFromFile(File image_file) throws IOException;

    void writeToFile(java.awt.Image java_img_icon, File file, String file_type) throws IOException;

    ArrayColorMap newAWTColorMap(BufferedImage image);

    BufferedImage toAWTImage(ColorMap image_function);

    ArrayColorMap readAWTColorMap(java.io.InputStream java_is) throws IOException;

    ArrayColorMap readAWTColorMap(File image_file) throws IOException;

    void writeToFile(ColorMap image, File image_file, String file_type) throws IOException;

    BufferedImage toAWTImage(GrayMap grayImage);

    void writeToFile(Image java_image, File file, String file_type, int image_mode) throws IOException;

    void writeToStream(Image javaImage, OutputStream outputStream, String file_type, int awtImageMode)
	    throws IOException;

    BufferedImage readFromStream(InputStream is) throws IOException;

}
