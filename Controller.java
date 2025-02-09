class Controller {
    private Model model;
    private View view;
    private Suit currentSuit;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        this.view.addCheckListener(e -> checkSuit());
        this.view.addRepairListener(e -> repairSuit());
    }

    //เมื่อกดปุ่ม checksuit
    private void checkSuit() {
        try {
            int suitId = Integer.parseInt(view.getSuitIdInput());
            currentSuit = model.findSuitById(suitId);
            
            if (currentSuit == null) {
                view.setResultText("Suit not found.");
                view.enableRepairButton(false);
                view.setSuitInfo("");
                return;
            }
            
            view.setSuitInfo(currentSuit.getInfo());
            if (model.isDurabilityValid(currentSuit)) {
                view.setResultText("Suit is valid.");
                view.enableRepairButton(false);
            } else {
                view.setResultText("Suit durability is too low!");
                view.enableRepairButton(true);
            }
        } catch (NumberFormatException ex) {
            view.setResultText("Invalid suit ID format.");
            view.enableRepairButton(false);
        }
    }

    //เมื่อกดปุ่ม repairsuit
    private void repairSuit() {
        if (currentSuit != null) {
            model.repairSuit(currentSuit);
            view.setSuitInfo(currentSuit.getInfo());
            view.setResultText("Suit repaired. New durability: " + currentSuit.getDurability());
            view.enableRepairButton(false);
            view.setRepairCountText("Repairs: " + model.getRepairCount());
        }
    }
}
