package data.DTO;

import data.domain.*;
import data.DTO.*;

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
        dto.setHourOfStart(ts1.getHourOfStart());
        dto.setDuration(ts1.getDuration());

        return dto;
    }
}
