package lab3ee.Model;

public class Resource {

    private String name;
    private int quantity;
    private String exam;
    private String selectedQuantity;

    public Resource() {

    }

    public Resource(String name, int quantity, String exam, String selectedQuantity) {
        this.name = name;
        this.quantity = quantity;
        this.exam = exam;
        this.selectedQuantity = selectedQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getSelectedQuantity() {
        return selectedQuantity;
    }

    public void setSelectedQuantity(String selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }
}
