package hello.springmvc.basic.jackson;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDateDeserializer extends StdDeserializer<Date> {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

	public CustomDateDeserializer() {
		this(null);
	}

	public CustomDateDeserializer(final Class<?> vc) {
		super(vc);
	}

	@Override
	public Date deserialize(final JsonParser parser, final DeserializationContext ctxt) throws
		IOException, JacksonException {
		final String date = parser.getText();
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
