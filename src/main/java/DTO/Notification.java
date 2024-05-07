package DTO;

import java.util.List;
import java.util.UUID;

public interface Notification {

  NotificationDTO createNotification(int price,int volume, int high, int marketCap);

  boolean sendEmail(NotificationDTO notificationDTO, List<String> emailId);

  boolean updateStatus(UUID id,String status);

  List<NotificationDTO> getList();

}
