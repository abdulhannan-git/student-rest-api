package demo.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyScheduler {

	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void myScheduler() {
		System.out.println(new Date());
	}
	
	private static final String FILE_PATH = "C:\\Users\\abdul\\OneDrive\\Desktop\\Projects\\Eclipse\\CronJob\\demo-app-report.html";

    @Scheduled(cron = "0 0/2 * 1/1 * ?") // Every day at 9 AM
    public void generateHtmlReport() {
        String htmlContent = "<html><body>"
                + "<h1>Daily Report</h1>"
                + "<p>Generated at: " + LocalDateTime.now() + "</p>"
                + "<p>Status: OK</p>"
                + "</body></html>";
        System.out.println("The report generated..");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(htmlContent);
            System.out.println("Report generated: " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
