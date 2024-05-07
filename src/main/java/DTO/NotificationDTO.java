package DTO;

import java.util.UUID;

//annotation todo
public class NotificationDTO {

  private UUID id;

  private int price;

  private int volume;

  private int marketCap;

  private int highVal;

  private Status status = Status.valueOf("IN_Progress");

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
