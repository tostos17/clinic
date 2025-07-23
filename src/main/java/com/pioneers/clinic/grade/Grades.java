package com.pioneers.clinic.grade;

public enum Grades {
    POOR(1),
    FAIR(2),
    AVERAGE(3),
    GOOD(4),
    EXCELLENT(5);

    private final int score;

    Grades(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
