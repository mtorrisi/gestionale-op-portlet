/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP.pojos;

/**
 *
 * @author mario
 */
public class Response {

	public enum Code {
		OK, GET_PRIMARY_KEY_ERROR, INSERT_ERROR, PARSING_JSON_ERROR, SENDING_MAIL_ERROR, ALREADY_EXISTS, NOT_VALID, DATE_FORMAT_ERROR, GENERIC_ERROR
	}

	public int id;
	public int code;

	public Response() {
	}

	public Response(Code c, int id) {
		this.code = c.ordinal();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "Response{" + "id=" + id + '}';
	}
}
