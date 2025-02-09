import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Model {
    private List<Suit> suits = new ArrayList<>();
    private Map<String, Integer> repairCount = new HashMap<>();

    public Model(String filename) {
        loadSuits(filename);
    }

    //เก็บข้อมูล csv เข้า list
    private void loadSuits(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String type = parts[1];
                int durability = Integer.parseInt(parts[2]);
                suits.add(new Suit(id, type, durability));
                repairCount.put(type, 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //หา suit ด้วย id
    public Suit findSuitById(int suitId) {
        return suits.stream().filter(s -> s.getId() == suitId).findFirst().orElse(null);
    }

    //ซ่อมชุด
    public void repairSuit(Suit suit) {
        if (suit.getDurability() < 100) {
            suit.setDurability(Math.min(suit.getDurability() + 25, 100));
            repairCount.put(suit.getType(), repairCount.get(suit.getType()) + 1);
        }
    }

    public Map<String, Integer> getRepairCount() {
        return repairCount;
    }
}