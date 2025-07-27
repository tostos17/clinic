package com.pioneers.clinic.participant.dto;

public class CommentRequest {
    private String comment;
    private long playerId;

    public CommentRequest() {
    }

    public CommentRequest(String comment, long playerId) {
        this.comment = comment;
        this.playerId = playerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    @Override
    public String toString() {
        return "CommentRequest{" +
                "comment='" + comment + '\'' +
                ", playerId=" + playerId +
                '}';
    }
}
