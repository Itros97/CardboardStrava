package data.DTO;

import data.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ChallengeAssembler {
    private static ChallengeAssembler instance;

    private ChallengeAssembler() { }

    public static ChallengeAssembler getInstance() {
        if (instance == null) {
            instance = new ChallengeAssembler();
        }

        return instance;
    }

    public ChallengeDTO challengeToDTO(Challenge ch1) {
        ChallengeDTO dto = new ChallengeDTO();

        dto.setName(ch1.getName());
        dto.setDateOfStart(ch1.getDateOfStart());
        dto.setDateOfEnd(ch1.getDateOfEnd());
        dto.setSport(ch1.getSport());

        return dto;
    }

    public List<ChallengeDTO> challengeToDTO(List<Challenge> chs) {
        List<ChallengeDTO> dtos = new ArrayList<>();

        for (Challenge ch : chs) {
            dtos.add(this.challengeToDTO(ch));
        }

        return dtos;
    }
}