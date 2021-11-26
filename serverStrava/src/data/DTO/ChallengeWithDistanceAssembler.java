package data.DTO;

import data.domain.Challenge;
import data.domain.ChallengeWithDistance;

public class ChallengeWithDistanceAssembler {
    private static ChallengeWithDistanceAssembler instance;

    private ChallengeWithDistanceAssembler() { }

    public staticChallengeWithDistanceAssembler getInstance() {
        if (instance == null) {
            instance = new ChallengeWithDistanceAssembler();
        }

        return instance;
    }

    public ChallengeWithDistanceDTO profileToDTO(ChallengeWithDistance ch1) {
        ChallengeWithDistanceDTO dto = new ChallengeWithDistanceDTO();

        dto.setName(ch1.getName());
        dto.setDateOfStart(ch1.getDateOfStart());
        dto.setDateOfEnd(ch1.getDateOfEnd());
        dto.setSport(ch1.getSport());
        dto.setObjectiveDistance(ch1.getObjectiveDistance());

        return dto;
    }
}