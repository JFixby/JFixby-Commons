package com.jfixby.cmns.api.image;

public interface ImageProcessingComponent {

    ArrayColorMapSpecs newColorMapSpecs();

    ArrayColorMap newArrayColorMap(ArrayColorMapSpecs color_function_specs);

    ColorMapSpecs newLambdaColorMapSpecs();

    ColorMap newLambdaColorMap(ColorMapSpecs lambda_specs);

    ColoredλImageCache newImageCache(int width, int height);

}
