package service;

import DTO.Notification;
import DTO.NotificationDTO;
import DTO.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class NotificationService implements Notification {

  static Map<UUID,NotificationDTO> notificationDTOMapTemp = new HashMap<>();

  @Override
  public NotificationDTO createNotification(int price, int volume, int high, int marketCap) {
    NotificationDTO notificationDTO = new NotificationDTO();
    notificationDTO.setId(UUID.randomUUID());
    notificationDTO.setPrice(price);

    if(Objects.nonNull(notificationDTO)) {
      notificationDTOMapTemp.put(notificationDTO.getId(),notificationDTO);
    }
    return notificationDTO;
  }

  @Override
  public boolean sendEmail(NotificationDTO notificationDTO, List<String> emailId) {
    //Email service need to introduce
    if(!emailId.isEmpty()) {
          for(String strMail : emailId) {
            System.out.println("Mail Sent to "+strMail);
            updateStatus(notificationDTO.getId(),"Complete");
            return true;
          }
    }
    return false;
  }

  @Override
  public boolean updateStatus(UUID id, String status) {
    if(id != null && notificationDTOMapTemp.containsKey(id)) {
      notificationDTOMapTemp.get(id).setStatus(Status.valueOf(status));
      return true;
    }
    return false;
  }

  @Override
  public List<NotificationDTO> getList() {
    List<NotificationDTO> notificationDTOS = new ArrayList<>();
    Set<UUID> keySet = notificationDTOMapTemp.keySet();
    for(UUID key : keySet) {
      notificationDTOS.add(notificationDTOMapTemp.get(key));
    }
    return notificationDTOS;
  }
}
