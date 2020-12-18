package com.nelioalves.cursomc.dto;

import java.io.Serializable;

import com.nelioalves.cursomc.domain.Estado;

public class EstadoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer Id;
	private String name;
	
	public EstadoDTO() {
		super();
	}

	public EstadoDTO(Estado obj) {
		super();
		
		Id = obj.getId();
		name = obj.getNome();
	}

	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
