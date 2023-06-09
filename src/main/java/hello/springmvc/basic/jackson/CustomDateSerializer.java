package hello.springmvc.basic.jackson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomDateSerializer extends StdSerializer<Date> {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

	public CustomDateSerializer() {
		this(null);
	}

	public CustomDateSerializer(final Class<Date> t) {
		super(t);
	}

	@Override
	public void serialize(final Date value, final JsonGenerator gen, final SerializerProvider provider) throws
		IOException {
		gen.writeString(formatter.format(value));
	}
}
