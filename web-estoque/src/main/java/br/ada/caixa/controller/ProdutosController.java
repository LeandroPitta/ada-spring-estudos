package br.ada.caixa.controller;

import br.ada.caixa.dto.request.ProdutoRequestDto;
import br.ada.caixa.dto.response.ProdutoResponseDto;
import br.ada.caixa.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("Atualizando produto: ");
        return ResponseEntity.ok(new ProdutoResponseDto());
    }

}
