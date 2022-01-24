package data.DTO;

import data.domain.TrainingSession;

import java.util.ArrayList;
import java.util.List;

public class TraininigSessionAssembler {
    private static TraininigSessionAssembler instance;

    private TraininigSessionAssembler() { }

    public static TraininigSessionAssembler getInstance() {
        if (instance == null) {
            instance = new TraininigSessionAssembler();
        }

        return instance;
    }

    public TrainingSessionDTO trainingSessionToDTO(TrainingSession ts1) {
        TrainingSessionDTO dto = new TrainingSessionDTO();

        dto.setTitle(ts1.getTitle());
        dto.setSport(ts1.getSport());
        dto.setDistance(ts1.getDistance());
        dto.setDistance(ts1.getDistance());
        dto.setDistance(ts1.getDistance());
        dto.setDateOfStart(ts1.getDateOfStart());
        dto.setDuration(ts1.getDuration());
        dto.setCreatorEmail(ts1.getCreatorEmail());

        return dto;
    }

    public List<TrainingSessionDTO> trainingSessionToDTO(List<TrainingSession> tss) {
        List<TrainingSessionDTO> dtos = new ArrayList<>();

        for (TrainingSession ts : tss) {
            dtos.add(this.trainingSessionToDTO(ts));
        }

        return dtos;
    }
}
