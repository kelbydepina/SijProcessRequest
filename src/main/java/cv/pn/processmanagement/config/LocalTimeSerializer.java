/*package cv.pn.processmanagement.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeSerializer extends JsonSerializer<LocalTime> {

    private final DateTimeFormatter formatter;

    public LocalTimeSerializer(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public LocalTimeSerializer() {
        this(DateTimeFormatter.ofPattern("HH:mm:ss")); // Default
    }

    @Override
    public void serialize(LocalTime value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value != null) {
            jsonGenerator.writeString(value.format(formatter));
        } else {
            jsonGenerator.writeNull();
        }
    }

}*/
