package clube_campo.model.areaclube;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaClubeService {
    @Autowired
    private AreaClubeRepository repository;

    public AreaClube cadastrar(AreaClube area) {
        return repository.save(area);
    }

    public List<AreaClube> getAllAreas() {
        return repository.findAll();
    }

    public AreaClube getAreaById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public AreaClube atualizarArea(DadosAtualizacaoArea dados) {
        AreaClube area = repository.findById(dados.idArea()).orElse(null);
        if (area != null) {
            area.atualizarArea(dados);
            return repository.save(area);
        }
        return null;
    }

    public void deletarArea(Long id) {
        repository.deleteById(id);
    }
}
