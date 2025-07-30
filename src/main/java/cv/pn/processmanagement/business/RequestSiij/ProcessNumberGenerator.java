package cv.pn.processmanagement.business.RequestSiij;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProcessNumberGenerator{

    public static String generateProcessNumber(String lastNumber, String prefix) {

            // Se não existir último número, começa com 001
            int nextSeq = 1;

            if (lastNumber != null && !lastNumber.isEmpty()) {
                // Extrai a parte numérica do último número (ex: "001/29072025/PN" -> 001)
                String seqPart = lastNumber.split("/")[0];
                nextSeq = Integer.parseInt(seqPart) + 1;
            }

            // Formata a sequência com 3 dígitos
            String sequence = String.format("%03d", nextSeq);

            // Obtém a data atual no formato dia/mês/ano (sem barras)
            String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));

            // Monta o número completo
            return String.format("%s/%s/%s", sequence, datePart, prefix);
        }

}
