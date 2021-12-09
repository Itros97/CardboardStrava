package data.DTO;

import data.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ChallengeWithDistanceAssembler {
    private static ChallengeWithDistanceAssembler instance;

    private ChallengeWithDistanceAssembler() { }

    public static ChallengeWithDistanceAssembler getInstance() {
        if (instance == null) {
            instance = new ChallengeWithDistanceAssembler();
        }

        return instance;
    }

    public ChallengeWithDistanceDTO challengeWithDistanceToDTO(ChallengeWithDistance ch1) {
        ChallengeWithDistanceDTO dto = new ChallengeWithDistanceDTO();

        dto.setName(ch1.getName());
        dto.setDateOfStart(ch1.getDateOfStart());
        dto.setDateOfEnd(ch1.getDateOfEnd());
        dto.setSport(ch1.getSport());
        dto.setObjectiveDistance(ch1.getObjectiveDistance());
        dto.setAccepted(ch1.isAccepted());

        return dto;
    }

    public List<ChallengeWithDistanceDTO> challengeWithDistanceToDTO(List<ChallengeWithDistance> chs) {
        List<ChallengeWithDistanceDTO> dtos = new ArrayList<>();

        for (ChallengeWithDistance ch : chs) {
            dtos.add(this.challengeWithDistanceToDTO(ch));
        }

        return dtos;
    }
}