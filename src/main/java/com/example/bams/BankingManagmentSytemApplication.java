package com.example.bams;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class BankingManagmentSytemApplication extends SpringBootServletInitializer/*implements CommandLineRunner*/{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BankingManagmentSytemApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(BankingManagmentSytemApplication.class, args);
		
	}
	
	/*
	 @Autowired
	    private JavaMailSender javaMailSender;
	
	
	 @Override
	    public void run(String... args) {

	        System.out.println("Sending Email...");

	        try {
	            sendEmail();
	          //  sendEmailWithAttachment();

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Done");

	    }

	    void sendEmail() throws MessagingException, IOException{

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("lokeshkumarsoft@gmail.com", "svlokesh.k@gmail.com");

	        msg.setSubject("Testing from Spring Boot");
	        msg.setText("Hello World \n Spring Boot Email");

	        javaMailSender.send(msg);

	    }

	    void sendEmailWithAttachment() throws MessagingException, IOException {

	        MimeMessage msg = javaMailSender.createMimeMessage();

	        // true = multipart message
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setTo("lokeshkumarsoft@gmail.com");

	        helper.setSubject("Testing from Spring Boot");

	        // default = text/plain
	        //helper.setText("Check attachment for image!");

	        // true = text/html
	        helper.setText("<h1>Check attachment for image!</h1>", true);

	        //FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

	        //Resource resource = new ClassPathResource("android.png");
	        //InputStream input = resource.getInputStream();

	        //ResourceUtils.getFile("classpath:android.png");

	      //  helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

	        javaMailSender.send(msg);

	    }
*/
}
