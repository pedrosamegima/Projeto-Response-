package com.ProjetoResponse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoResponse.entities.Produto;
import com.ProjetoResponse.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	private final ProdutoService produtoService;

	@Autowired
	public ProdutoController (ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getProdutoControlId(@PathVariable Long id){
		Produto produto = produtoService.getProdutoById(id);
		if(produto != null) {
			return ResponseEntity.ok(produto);
		}

		else {
			return ResponseEntity.notFound().build();		
		}

	}
	@GetMapping
	public ResponseEntity<List<Produto>> buscaTodosProdutosControl(){
		List<Produto> produtos = produtoService.buscaTodosProduto();

		return ResponseEntity.ok(produtos);
	}
	
	@GetMapping("/")
	public ResponseEntity<Produto> saveProdutosControl(@RequestBody Produto produto){
		Produto saveProduto = produtoService.saveProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveProduto);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody Produto produto){
		Produto alteraProduto = produtoService.alteraProduto(id, produto);
		if(alteraProduto !=null) {
			return ResponseEntity.ok(produto);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarProdutoControl(@PathVariable Long id){
		boolean apagar = produtoService.apagarProduto(id);
		if(apagar) {
			return ResponseEntity.ok().body("O produto foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
