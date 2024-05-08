package br.ada.caixa.controller;

import br.ada.caixa.dto.request.ProdutoRequestDto;
import br.ada.caixa.dto.response.ProdutoResponseDto;
import br.ada.caixa.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired  //é para dar uma instancia da classe(parecido ao padrão singleton)
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> inserir(@RequestBody ProdutoRequestDto produtoRequestDto) {

        ProdutoResponseDto produtoResponseDto = produtoService.inserir(produtoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponseDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> atualizar(@PathVariable Long id, @RequestBody ProdutoRequestDto produto) {

        ProdutoResponseDto produtoResponseDto = produtoService.atualizar(id, produto);
        return ResponseEntity.ok(produtoResponseDto);

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        produtoService.excluir(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> getPorId(@PathVariable Long id) {

        return ResponseEntity.ok(new ProdutoResponseDto());

    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> listarTodos() {

        return ResponseEntity.ok(new ArrayList<>());

    }

}
