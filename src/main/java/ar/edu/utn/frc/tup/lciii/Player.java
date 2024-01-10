package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.Enums.TeamColor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;

    private TeamColor teamColor;

    public Player(String name, TeamColor teamColor) {
        this.name = name;
        this.teamColor = teamColor;
    }

    public String getName() {
        return name;
    }

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player() {
    }

    @Override
    public String toString() {
        return "Players{" +
                "nombre='" + name + '\'' +
                '}';
    }
}

