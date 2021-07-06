import java.text.DecimalFormat;

/** Normal table
 * ID
 * Name
 * Price
 * Stock qty
 * Active
 */

 /** DVD table       CD table
  * ID               Id
  * Name             Name
  * Price            Price
  * Stock qty        Stock qty
  * Active           Active
  * + Duration       + Artist
  * + Age rating     + Track number
  * + Studio         + Seal
  */

class Product {

  // Instance fields declaration
  private int id;
  private String name;
  private int qty;
  private double price;
  private boolean active;

  // Constructor with no parameters
  public Product() {
    this.active = true;
  }

  // Constructor with parameters
  public Product(int id, String name, int qty, double price) {
    this.id = id;
    this.name = name;
    this.qty = qty;
    this.price = price;
    this.active = true;
  }

  // Methods
  public String getInventoryValue() {
    DecimalFormat dec = new DecimalFormat("#0.00");
    return dec.format(this.qty * this.price);
  }

  public void addToInventory(int qty) {
    this.qty += qty;
  }

  public void deductFromInventory(int qty) {
    this.qty -= qty;
  }

  // Getters and setters for reading or writing data
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQty() {
    return this.qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isActive() {
    return this.active;
  }

  public boolean getActive() {
    return this.active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    String isActive = this.active ? "yes" : "no";

    return "{" +
      " ID:'" + getId() + "'" +
      ", Name:'" + getName() + "'" +
      ", Quantity:'" + getQty() + "'" +
      ", Price:'" + getPrice() + "'" +
      ", Inventory Value:'" + getInventoryValue() + "'" +
      ", Active:'" + isActive + "'" +
      "}";
  }
}

class DVD extends Product {
  private int duration;
  private int ageRating;
  private String studio;

  public DVD(int id, String name, int qty, double price , int duration, int ageRating, String studio) {
    super(id, name, qty, price);
    this.duration = duration;
    this.ageRating = ageRating;
    this.studio = studio;
  }

  public String getInventoryValue() {
    double grossValue = this.getQty() * this.getPrice();
    double priceWithTax = grossValue + (grossValue * 0.05);
    
    DecimalFormat dec = new DecimalFormat("#0.00");
    return dec.format(priceWithTax);
  }

  public int getDuration() {
    return this.duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public int getAgeRating() {
    return this.ageRating;
  }

  public void setAgeRating(int ageRating) {
    this.ageRating = ageRating;
  }

  public String getStudio() {
    return this.studio;
  }

  public void setStudio(String studio) {
    this.studio = studio;
  }

  @Override
  public String toString() {
    String isActive = this.getActive() ? "yes" : "no";

    return "{" +
      " ID:'" + getId() + "'" +
      ", Name:'" + getName() + "'" +
      ", Movie Duration='" + getDuration() + "'" +
      ", Age Rating='" + getAgeRating() + "'" +
      ", Studio='" + getStudio() + "'" +
      ", Quantity:'" + getQty() + "'" +
      ", Price:'" + getPrice() + "'" +
      ", Inventory Value:'" + getInventoryValue() + "'" +
      ", Active:'" + isActive + "'" +
      "}";
  }
}

class CD extends Product {
  private String artist;
  private int trackNumber;
  private String recordingSeal;

  public CD(int id, String name, int qty, double price, String artist, int trackNumber, String recordingSeal) {
    super(id, name, qty, price);
    this.artist = artist;
    this.trackNumber = trackNumber;
    this.recordingSeal = recordingSeal;
  }

  public String getArtist() {
    return this.artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public int getTrackNumber() {
    return this.trackNumber;
  }

  public void setTrackNumber(int trackNumber) {
    this.trackNumber = trackNumber;
  }

  public String getRecordingSeal() {
    return this.recordingSeal;
  }

  public void setRecordingSeal(String recordingSeal) {
    this.recordingSeal = recordingSeal;
  }

  @Override
  public String toString() {
    String isActive = this.getActive() ? "yes" : "no";

    return "{" +
      " ID:'" + getId() + "'" +
      ", Name:'" + getName() + "'" +
      ", Artist='" + getArtist() + "'" +
      ", Track Number='" + getTrackNumber() + "'" +
      ", Recording Seal='" + getRecordingSeal() + "'" +
      ", Quantity:'" + getQty() + "'" +
      ", Price:'" + getPrice() + "'" +
      ", Inventory Value:'" + getInventoryValue() + "'" +
      ", Active:'" + isActive + "'" +
      "}";
  }
}
