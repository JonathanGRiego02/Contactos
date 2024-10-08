package org.dad;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter out, LocalDate value) throws IOException {
        out.value(value.getDayOfMonth() + "/" + value.getMonthValue() + "/" + value.getYear());
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        String[] date = in.nextString().split("/");
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        return LocalDate.of(year, month, day);
    }



}
