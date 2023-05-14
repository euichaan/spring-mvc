package hello.springmvc.basic.deserialize;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericResponse<T> {

	public boolean status;
	public int code;
	public T data;

	@Override
	public String toString() {
		return "GenericResponse{" +
			"status=" + status +
			", code=" + code +
			", data=" + data +
			'}';
	}
}
