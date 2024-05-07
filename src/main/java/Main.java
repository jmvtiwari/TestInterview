import DTO.NotificationDTO;
import java.util.ArrayList;
import java.util.List;
import service.NotificationService;

public class Main {

  public static void main(String[] args) {

    System.out.println("create Notification  .......");
    NotificationService notificationService = new NotificationService();
    notificationService.createNotification(1,2,3,4);
    notificationService.createNotification(4,5,6,8);
    System.out.println("Notification created .......");
    System.out.println("get Notification ....... ");
    List<NotificationDTO> tempList = notificationService.getList();
    System.out.println("send mail Notification and update status completed .......");
    List<String> emailId = new ArrayList<>();
    emailId.add("abc@gmail.com");
    notificationService.sendEmail(tempList.get(1),emailId);
    System.out.println("get Notification after mail .......");
    List<NotificationDTO> tempListAfterMail = notificationService.getList();
    for(NotificationDTO notificationDTOList : tempListAfterMail) {
      System.out.println(notificationDTOList.getId()+" "+notificationDTOList.getStatus());
    }
    System.out.println("Update status .................");
    boolean flag = notificationService.updateStatus(tempListAfterMail.get(0).getId(),"delete");
    System.out.println("Status updated : "+flag);

    List<NotificationDTO> tempListAfterUpdateStatus = notificationService.getList();
    System.out.println("get notification after udpate status .................");
    for(NotificationDTO notificationDTOList : tempListAfterUpdateStatus) {
      System.out.println(notificationDTOList.getId()+" "+notificationDTOList.getStatus());
    }

  }


}
