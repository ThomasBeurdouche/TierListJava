package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Tier;
import com.takima.backskeleton.models.TierList;

public class TierDto {
    private Long id;
    private String name;
    private TierList tierList;

    public TierDto() {
    }

    public TierDto(Long id, String name, TierList tierList) {
        this.id = id;
        this.name = name;
        this.tierList = tierList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TierList getTierList() {
        return tierList;
    }
}
