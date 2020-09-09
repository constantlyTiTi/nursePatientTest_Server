package ReactJavaProject.nursePatientTest.Models;

import javax.persistence.*;

@Entity
@Table(name="testItem")
public class TestItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="itemId")
    private long itemId;
    @Column(name="itemName")
    private String itemName;
    @Column(name="itemDescription")
    private String itemDescription;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public TestItem(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public TestItem() {
    }
}
