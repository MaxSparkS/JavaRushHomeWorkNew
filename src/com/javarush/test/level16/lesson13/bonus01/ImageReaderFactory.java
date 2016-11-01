package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by m.shkurko on 11/1/2016.
 */
public class ImageReaderFactory
    {
        public static ImageReader getReader(ImageTypes type){
            ImageReader imageReader;

            if (type==ImageTypes.JPG) imageReader=new JpgReader();
            else if (type==ImageTypes.BMP) imageReader=new BmpReader();
            else if (type==ImageTypes.PNG) imageReader=new PngReader();
            else throw new IllegalArgumentException();

            return imageReader;
        }
    }
