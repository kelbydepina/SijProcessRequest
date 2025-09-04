/*package cv.pn.processmanagement.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {

    private final DateTimeFormatter formatter;

    public LocalTimeDeserializer(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public LocalTimeDeserializer() {
        this(DateTimeFormatter.ofPattern("HH:mm:ss")); // Default
    }

    @Override
    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        // Se for um objeto {hour: 0, minute: 0, second: 0, nano: 0}
        if (node.isObject()) {
            int hour = node.has("hour") ? node.get("hour").asInt() : 0;
            int minute = node.has("minute") ? node.get("minute").asInt() : 0;
            int second = node.has("second") ? node.get("second").asInt() : 0;
            int nano = node.has("nano") ? node.get("nano").asInt() : 0;

            return LocalTime.of(hour, minute, second, nano);
        }
        // Se for uma string "HH:mm:ss"
        else if (node.isTextual()) {
            String timeString = node.asText();
            if (timeString != null && !timeString.trim().isEmpty()) {
                try {
                    // Tenta parse com o formatter específico
                    return LocalTime.parse(timeString, formatter);
                } catch (Exception e) {
                    // Fallback para formato ISO
                    return LocalTime.parse(timeString);
                }
            }
        }

        return null;
    }

}*/
