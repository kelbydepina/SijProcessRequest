package cv.pn.processmanagement.business.fileRequest;

import java.io.Serializable;

public class FileRequestDto implements Serializable {

    private String content;  // Base64 encoded
    private String name;
    private String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
