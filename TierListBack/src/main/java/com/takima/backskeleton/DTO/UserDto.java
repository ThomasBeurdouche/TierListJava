package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Tier;
import com.takima.backskeleton.models.TierList;
import com.takima.backskeleton.models.User;

import java.time.Instant;
import java.util.List;

public class UserDto {
    private List<TierList> tierLists;
    private String username;
    private String mail;
    private String mdp;

    public static UserDto builder() {
        return new UserDto();
    }

    public static UserDto builder(String mail, String mdp, List<TierList> tierLists, String username) {
        UserDto tierListDto = new UserDto();
        tierListDto.mail = mail;
        tierListDto.mdp = mdp;
        tierListDto.username = username;
        tierListDto.tierLists = tierLists;
        return tierListDto;

    }

    public UserDto username(String username) {
        this.username = username;
        return this;
    }

    public UserDto mail(String mail) {
        this.mail = mail;
        return this;
    }

    public UserDto mdp(String mdp) {
        this.mdp = mdp;
        return this;
    }

    public UserDto tierLists(List<TierList> tierLists) {
        this.tierLists = tierLists;
        return this;
    }

    public UserDto build() {
        return this;
    }

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getMdp() {
        return mdp;
    }

    public List<TierList> getTierLists() {
        return tierLists;
    }


}
