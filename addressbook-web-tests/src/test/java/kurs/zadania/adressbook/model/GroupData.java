package kurs.zadania.adressbook.model;

public class GroupData {
  private final String name;
  private final String header;
  private final String footer;
                                                    // wygenerowane automatycznie metody Code - Generate - Equals and hashCode()
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
                                                    // wygenerowana automatycznie metoda Code - Generate - toString
  @Override
  public String toString() {

    return "GroupData{" +
            "name='" + name + '\'' +
            '}';
  }

  public GroupData(String name, String header, String footer) {
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }
}
