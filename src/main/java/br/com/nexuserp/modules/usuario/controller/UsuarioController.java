package br.com.nexuserp.modules.usuario.controller;

import br.com.nexuserp.modules.usuario.dto.UsuarioRequest;
import br.com.nexuserp.modules.usuario.dto.UsuarioResponse;
import br.com.nexuserp.modules.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse cadastrar(@RequestBody @Valid UsuarioRequest request) {

        return usuarioService.cadastrar(request);

    }

}
