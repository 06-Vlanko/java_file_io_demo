import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


public class AppendableObjectOutputStream extends ObjectOutputStream {

    public AppendableObjectOutputStream (OutputStream out) throws IOException {
        super(out);
        this.enableReplaceObject(true);
    }

    @Override
    protected void writeStreamHeader () throws IOException {
        // do not write a header, but reset:
        // this line added after another question
        // showed a problem with the original
        reset();
    }

}