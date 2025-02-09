public class Main {
    public static void main(String[] args) {
        String csvPath = "superhero_suits.csv";
        Model model = new Model(csvPath);
        View view = new View();
        new Controller(model, view);
    }
}
