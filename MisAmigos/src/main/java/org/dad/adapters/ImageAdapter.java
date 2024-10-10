package org.dad.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import javafx.scene.image.Image;
import org.dad.utils.ImageUtils;

import java.io.IOException;

public class ImageAdapter extends TypeAdapter<Image> {

    @Override
    public void write(JsonWriter out, Image value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(ImageUtils.encodeImage(value));
        }
    }

    @Override
    public Image read(JsonReader in) throws IOException {
        if(in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        return ImageUtils.decodeImage(in.nextString());
    }



}
