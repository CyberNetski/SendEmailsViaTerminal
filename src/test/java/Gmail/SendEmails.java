package Gmail;

import org.apache.commons.mail.SimpleEmail;

public class SendEmails {
       /*
            first Step:
                go to  :
                     https://myaccount.google.com/lesssecureapps?utm_source=google-account&utm_medium=web
                        Make sure that your google account allows third part app
         */

        public static void main(String[] args) {

            // in encapsulation - for getter and setter i need an object
            Credentials obj = new Credentials();
            String userName = obj.getUserName();
            String passWord = obj.getPassWord();

            String  MSG ="Hello !\n\t It's Olessya, How are you doing today, friend? :) ",
                    Subject ="New email from Terminal";

            String [] Receivers = {"anyemails.com","youremails.ru"};

int times = 2;
while (times >0) {
    for (String students : Receivers) {
        sendEmails(userName, passWord, students, MSG, Subject);
    }
    times--;
}

          //  sendEmails( userName, passWord, Receiver, MSG , Subject);
            System.out.println("Sent successfully");
        }

        public static void sendEmails(String username, String password, String Receiver, String MSG, String Subject){

            SimpleEmail email=new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthentication(username, password);
            email.setSSLOnConnect(true);
            email.setSubject(Subject);


            try {
                email.setFrom(username);
                email.setMsg(MSG);
                email.addTo(Receiver);
                email.send();
                Thread.sleep(3000);
            } catch (Exception e) {   }


        }


    }
