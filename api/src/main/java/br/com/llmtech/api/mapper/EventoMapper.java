package br.com.llmtech.api.mapper;

import br.com.llmtech.api.dto.EventoRequestDTO;
import br.com.llmtech.api.dto.EventoResponseDTO;
import br.com.llmtech.api.model.Evento;
import br.com.llmtech.api.model.ModeloIA;
import br.com.llmtech.api.model.TipoEventoNatural;
import br.com.llmtech.api.model.RegiaoMonitorada;

public class EventoMapper {
    public static EventoResponseDTO toDTO(Evento evento) {
        EventoResponseDTO dto = new EventoResponseDTO();
        dto.setIdEvento(evento.getIdEvento());
        dto.setDataPrevista(evento.getDataPrevista());
        dto.setProbabilidade(evento.getProbabilidade());
        dto.setGeradoEm(evento.getGeradoEm());
        dto.setDescricao(evento.getDescricao());
        if (evento.getModelo() != null) dto.setIdModelo(evento.getModelo().getIdModelo());
        if (evento.getTipoEvento() != null) dto.setIdTipoEvento(evento.getTipoEvento().getIdTipoEvento());
        if (evento.getRegiao() != null) dto.setIdRegiao(evento.getRegiao().getIdRegiao());
        dto.setDataOcorrencia(evento.getDataOcorrencia());
        return dto;
    }

    public static Evento fromDTO(EventoRequestDTO dto, ModeloIA modelo, TipoEventoNatural tipoEvento, RegiaoMonitorada regiao) {
        Evento evento = new Evento();
        evento.setDataPrevista(dto.getDataPrevista());
        evento.setProbabilidade(dto.getProbabilidade());
        evento.setGeradoEm(dto.getGeradoEm());
        evento.setDescricao(dto.getDescricao());
        evento.setModelo(modelo);
        evento.setTipoEvento(tipoEvento);
        evento.setRegiao(regiao);
        evento.setDataOcorrencia(dto.getDataOcorrencia());
        return evento;
    }

    public static void updateEntityUsingDTO(Evento evento, EventoRequestDTO dto, ModeloIA modelo, TipoEventoNatural tipoEvento, RegiaoMonitorada regiao) {
        evento.setDataPrevista(dto.getDataPrevista());
        evento.setProbabilidade(dto.getProbabilidade());
        evento.setGeradoEm(dto.getGeradoEm());
        evento.setDescricao(dto.getDescricao());
        evento.setModelo(modelo);
        evento.setTipoEvento(tipoEvento);
        evento.setRegiao(regiao);
        evento.setDataOcorrencia(dto.getDataOcorrencia());
    }
}
