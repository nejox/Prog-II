package übungsaufgaben_klausur.twotter;

import java.net.URL;

public class DownloadManager {
	private URL url;

	DownloadManager configure(int maxThreads, long timeout) {
		return this;
	}

	String startDownload() throws Exception { // returns the JobId
		DownloadJob dj = new DownloadJob(new URL("http://example.com/resource"));
		Thread t1 = new Thread(dj);
		t1.start();
		return dj.getJobId();
	}

	void cancelDownload(String jobId) {
	}

	DownloadManager specifyDownloadLocation(URL url) {
		this.url = url;
		return this;
	}

	// nicht Teil des FluidInterfaces
	public static byte[] downloadFromURL(URL url) {
		return null;
	}

	public static void main(String[] args) throws Exception {
//		DownloadManager manager = new DownloadManager();
//		manager.configure(4, 4000);
//		manager.specifyDownloadLocation(new URL("http :// example.com/resource"));
//		String jobId = manager.startDownload();
//		System.out.println(jobId);
		
		DownloadManager manager = new DownloadManager()
				.configure(4, 4000)
				.specifyDownloadLocation(new URL("http://example.com/resource"));
		
		String jobId = manager.startDownload();
		System.out.println(jobId);
				
	}
}