package clube_campo.model.passeioclube;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasseioClubeService {
    @Autowired
    private PasseioClubeRepository repository;

    public PasseioClube cadastrar(PasseioClube passeio) {
        return repository.save(passeio);
    }

    public List<PasseioClube> getAllPasseios() {
        return repository.findAll();
    }

    public PasseioClube getPasseioById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public PasseioClube atualizarPasseio(DadosAtualizacaoPasseioClube dados) {
        PasseioClube passeio = repository.findById(dados.idPasseio()).orElse(null);
        if (passeio != null) {
            passeio.atualizarPasseio(dados);
            return repository.save(passeio);
        }
        return null;
    }

    public void deletarPasseio(Long id) {
        repository.deleteById(id);
    }
}
