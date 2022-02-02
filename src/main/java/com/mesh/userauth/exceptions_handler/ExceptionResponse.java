package com.mesh.userauth.exceptions_handler;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ExceptionResponse {
	private int status;
	private String message;
	private long timestamp;

}
