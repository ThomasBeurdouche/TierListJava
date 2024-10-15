package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.TierList;
import java.io.IOException;

public class TierListMapper {
    public static TierList fromDto(TierListDto dto, Long id) throws IOException {
        return new TierList.Builder()
                .id(id)
                .votePour(dto.getVotePour())
                .voteContre(dto.getVoteContre())
                .creationDate(dto.getCreationDate())
                .tiers(dto.getTiers())
                .owner(dto.getOwner())
                .tierListTitle(dto.getTierListTitle())
                .publicTierList(dto.isPublicTierList())
                .build();

    }
    public static TierListDto toDto (TierList tierList){
        return TierListDto.builder()
                .votePour(tierList.getVotePour())
                .voteContre(tierList.getVoteContre())
                .creationDate(tierList.getCreationDate())
                .tiers(tierList.getTiers())
                .owner(tierList.getOwner())
                .tierListTitle(tierList.getTierListTitle())
                .publicTierList(tierList.isPublicTierList())
                .build();
    }
}
