package br.com.nexuserp.modules.usuario.service;

import br.com.nexuserp.modules.usuario.dto.UsuarioRequest;
import br.com.nexuserp.modules.usuario.dto.UsuarioResponse;
import br.com.nexuserp.modules.usuario.entity.Usuario;
import br.com.nexuserp.modules.usuario.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponse cadastrar(UsuarioRequest request) {

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Já existe um usuário com esse e-mail.");
        }

        Usuario usuario = Usuario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .telefone(request.getTelefone())
                .ativo(true)
                .build();

        usuario = usuarioRepository.save(usuario);

        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .ativo(usuario.getAtivo())
                .build();
    }
}
