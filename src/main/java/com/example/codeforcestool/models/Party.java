package com.example.codeforcestool.models;

public class Party {
    public static class Member {
        private String name,handle;
        public String getName() {
            return name;
        }
        public String getHandle() {
            return handle;
        }
    }
    public static enum ParticipantType{
        CONTESTANT, PRACTICE, VIRTUAL, MANAGER, OUT_OF_COMPETITION;
    }
    private int contestId;
    Member members[];
    private ParticipantType participantType;
    private int teamId;
    private String teamName;
    private boolean ghost;
    private int room;
    private int startTimeSeconds;

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    public ParticipantType getParticipantType() {
        return participantType;
    }

    public void setParticipantType(ParticipantType participantType) {
        this.participantType = participantType;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean isGhost() {
        return ghost;
    }

    public void setGhost(boolean ghost) {
        this.ghost = ghost;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getStartTimeSeconds() {
        return startTimeSeconds;
    }

    public void setStartTimeSeconds(int startTimeSeconds) {
        this.startTimeSeconds = startTimeSeconds;
    }
}
