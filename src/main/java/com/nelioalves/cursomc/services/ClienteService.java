package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.dto.ClienteDTO;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.DataIntegrityException;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFaundException;

import net.bytebuddy.implementation.bytecode.Throw;



@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) throws ObjectNotFaundException {
		
			Optional<Cliente> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFaundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	
	public Cliente update(Cliente obj) {
		
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		
		find(id);
		
		try {
			
		repo.deleteById(id);
		
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao é possivel excluir porque ha entidades relacionadas FK");
		}
	}
	
	public List<Cliente> findAll(){
		
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
		
	}
	
	public Cliente fromDto(ClienteDTO objDto ) {
		
		 return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(),null,null);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
