package com.jfixby.cmns.api.image;

import com.jfixby.cmns.api.ComponentInstaller;

public class ImageProcessing {

    public static final String IMAGE_CHANNEL_FILE_EXTENTION = ".r3-img-gray";

    static private ComponentInstaller<ImageProcessingComponent> componentInstaller = new ComponentInstaller<ImageProcessingComponent>(
	    "ImageProcessing");

    public static final void installComponent(ImageProcessingComponent component_to_install) {
	componentInstaller.installComponent(component_to_install);
    }

    public static final ImageProcessingComponent invoke() {
	return componentInstaller.invokeComponent();
    }

    public static final ImageProcessingComponent component() {
	return componentInstaller.getComponent();
    }

    public static ArrayColorMap newArrayColorMap(ArrayColorMapSpecs color_function_specs) {
	return invoke().newArrayColorMap(color_function_specs);
    }

    public static ArrayColorMapSpecs newArrayColorMapSpecs() {
	return invoke().newArrayColorMapSpecs();
    }

    public static ColorMapSpecs newColorMapSpecs() {
	return invoke().newColorMapSpecs();
    }

    public static ColorMap newColorMap(ColorMapSpecs lambda_specs) {
	return invoke().newColorMap(lambda_specs);
    }

    public static ColorMap newColorMap(ColoredλImage lambda, int width, int height) {
	return invoke().newColorMap(lambda, width, height);
    }

    public static ColoredλImageCache newImageCache(int width, int height) {
	return invoke().newImageCache(width, height);
    }

    public static GrayλImage scale(GrayλImage base, float scaleX, float scaleY) {
	return invoke().scale(base, scaleX, scaleY);
    }

    public static ColoredλImage scale(ColoredλImage base, float scaleX, float scaleY) {
	return invoke().scale(base, scaleX, scaleY);
    }

    public static GrayλImage minus(GrayλImage base, GrayλImage diff) {
	return invoke().minus(base, diff);
    }

    public static GrayλImage multiply(GrayλImage image, float mult) {
	return invoke().multiply(image, mult);
    }

    public static GrayMap newGrayMap(GrayλImage lambda, int width, int height) {
	return invoke().newGrayMap(lambda, width, height);
    }

    public static GrayMapSpecs newGrayMapSpecs() {
	return invoke().newGrayMapSpecs();
    }

    public static GrayλImage roundArguments(GrayλImage image) {
	return invoke().roundArguments(image);
    }

    public static ArrayGrayMapSpecs newArrayGrayMapSpecs() {
	return invoke().newArrayGrayMapSpecs();
    }

    public static ArrayGrayMap newArrayGrayMap(ArrayGrayMapSpecs specs) {
	return invoke().newArrayGrayMap(specs);
    }

    public static GrayλImage plus(GrayλImage base, GrayλImage add) {
	return invoke().plus(base, add);
    }

    public static int roundArgument(float x) {
	return invoke().roundArgument(x);
    }

    public static GrayλImage ONE() {
	return invoke().ONE();
    }

    public static GrayλImage ZERO() {
	return invoke().ZERO();
    }

}
