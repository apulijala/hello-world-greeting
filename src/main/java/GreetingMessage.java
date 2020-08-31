package hello;

public class GreetingMessage {
  
     private String message;
     private int hours;

     // constructor
     public GreetingMessage(){
      
      DateTime var = new DateTime();
        this.hours = var.dateTime();

      if (hours < 12)
      this.message = "Jaya Guru datta!";
      else if (hours < 17 && !(hours == 12))
      this.message = "Om Aim Hreem Shreem Kleem sree matre namaha!";
      else if (hours == 12)
      this.message = "Satya means truth but satya is evil.!";
      else
      this.message = "Good Evening!";
     }
      
     // return message 
     public String printMessage(){
        System.out.println(message);
        return message;
     }   
  } 
