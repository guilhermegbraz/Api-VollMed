package med.voll.api.core.entities;

import javax.print.DocFlavor;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BusinessException(String msg) {
        super(msg);
    }

    public  BusinessException(Exception e) {
        super(e);
    }

    public static String getFullMessage(Throwable t) {
        StringBuilder result = new StringBuilder();

        while(t.getCause() != null) {
            result.append(t.getCause().getMessage());
            result.append("; ");
            t = t.getCause();
        }
        return result.toString();
    }
}
