package data.DTO;

import data.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ChallengeWithTimeAssembler {
    private static ChallengeWithTimeAssembler instance;

    private ChallengeWithTimeAssembler() { }

    public static ChallengeWithTimeAssembler getInstance() {
        if (instance == null) {
            instance = new ChallengeWithTimeAssembler();
        }

        return instance;
    }

    public ChallengeWithTimeDTO challengeWithTimeToDTO(ChallengeWithTime ch1) {
        ChallengeWithTimeDTO dto = new ChallengeWithTimeDTO();

        dto.setName(ch1.getName());
        dto.setDateOfStart(ch1.getDateOfStart());
        dto.setDateOfEnd(ch1.getDateOfEnd());
        dto.setSport(ch1.getSport());
        dto.setObjectiveTime(ch1.getObjectiveTime());
        dto.setEmailAceptante(ch1.getEmailAceptante());

        return dto;
    }

    public List<ChallengeWithTimeDTO> challengeWithTimeToDTO(List<ChallengeWithTime> chs) {
        List<ChallengeWithTimeDTO> dtos = new ArrayList<>();

        for (ChallengeWithTime ch : chs) {
            dtos.add(this.challengeWithTimeToDTO(ch));
        }

        return dtos;
    }
}