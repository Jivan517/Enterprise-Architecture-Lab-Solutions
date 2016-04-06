package cs544.exercise7_1;

public interface IEmailSender {
	public void sendEmail(String email, String message);
	public String getOutgoingMailServer();
}