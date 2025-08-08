package cv.pn.processmanagement.business.RequestSiij;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ProcessNumberGenerator{

    public static String generateProcessNumber(String lastNumber, String prefix) {


                int nextSeq = 1;

                if (lastNumber != null && !lastNumber.isEmpty()) {

                    String seqPart = lastNumber.split("/")[0];

                    nextSeq = Integer.parseInt(seqPart) + 1;
                }


                String sequence = String.format("%03d", nextSeq);

                String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
           // String sequence = "01012005".equals(datePart) ? "001" : String.format("%03d", nextSeq);

                return String.format("%s/%s/%s", sequence, datePart, prefix);
        }

}
