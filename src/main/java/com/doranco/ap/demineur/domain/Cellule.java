package com.doranco.ap.demineur.domain;


public class Cellule {
    private boolean revealed;
    private boolean hasMine;

    public Cellule() {
        this.revealed = false;
        this.hasMine = false;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean hasMine() {
        return hasMine;
    }

    public void setMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

}
