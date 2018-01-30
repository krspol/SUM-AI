package pl.pjatk.sum.artificial;

import java.io.UnsupportedEncodingException;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

public class TensorFlow {

	public static void main(String[] args) throws UnsupportedEncodingException {
	    try (Graph g = new Graph()) {
	        final String value = "Hello from " +  org.tensorflow.TensorFlow.version();

	        // Construct the computation graph with a single operation, a constant
	        // named "MyConst" with a value "value".
	        try (Tensor t = Tensor.create(value.getBytes("UTF-8"))) {
	          // The Java API doesn't yet include convenience functions for adding operations.
	          g.opBuilder("Const", "MyConst").setAttr("dtype", t.dataType()).setAttr("value", t).build();
	        }

	        // Execute the "MyConst" operation in a Session.
	        try (Session s = new Session(g);
	             Tensor output = s.runner().fetch("MyConst").run().get(0)) {
	          System.out.println(new String(output.bytesValue(), "UTF-8"));
	        }
	    }
	}
}
