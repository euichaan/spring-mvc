package hello.springmvc.basic.deserialize;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class GenericResponse<T> {

	private boolean status;
	private int code;
	private T data;

	@Override
	public String toString() {
		return "GenericResponse{" +
			"status=" + status +
			", code=" + code +
			", data=" + data +
			'}';
	}
}
