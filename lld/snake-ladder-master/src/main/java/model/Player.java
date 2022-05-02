package model;

import java.util.Objects;

public class Player {
    private int position;
    private final String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return position == player.position &&
                Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, playerName);
    }

    public Player(int position, String playerName) {
        this.position = position;
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "Player :" + playerName;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
