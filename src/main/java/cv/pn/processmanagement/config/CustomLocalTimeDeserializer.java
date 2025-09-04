/*package cv.pn.processmanagement.config;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalTime;

public class CustomLocalTimeDeserializer extends JsonDeserializer<LocalTime> {


    @Override
    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        System.out.println("DEBUG - Recebido horaDetencao: " + node.toString());

        // Se for um objeto {hour: 0, minute: 0, second: 0, nano: 0}
        if (node.isObject()) {
            int hour = node.has("hour") ? node.get("hour").asInt() : 0;
            int minute = node.has("minute") ? node.get("minute").asInt() : 0;
            int second = node.has("second") ? node.get("second").asInt() : 0;
            int nano = node.has("nano") ? node.get("nano").asInt() : 0;

            System.out.println("DEBUG - Convertendo objeto para LocalTime: " + hour + ":" + minute + ":" + second);
            return LocalTime.of(hour, minute, second, nano);
        }
        // Se for uma string "HH:mm:ss"
        else if (node.isTextual()) {
            String timeString = node.asText();
            if (timeString != null && !timeString.trim().isEmpty()) {
                try {
                    System.out.println("DEBUG - Convertendo string para LocalTime: " + timeString);
                    return LocalTime.parse(timeString);
                } catch (Exception e) {
                    throw new IOException("Formato de hora inválido: " + timeString, e);
                }
            }
        }

        System.out.println("DEBUG - horaDetencao é null ou inválido");
        return null;
    }

}*/
