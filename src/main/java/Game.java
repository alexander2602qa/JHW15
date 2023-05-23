import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        if (!players.containsKey(playerName1) || !players.containsKey(playerName2)) {
            throw new NotRegisteredException("Не все участники зарегистрированы");
        };

        if (players.get(playerName1).getStrength() > players.get(playerName2).getStrength()) {
            return 1;
        } else if (players.get(playerName1).getStrength() < players.get(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }

    }
}
