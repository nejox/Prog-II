package übungsaufgaben_klausur.twotter;

import java.net.URL;
import java.util.UUID;

public class DownloadJob implements Runnable{
	
	URL url;
	String jobId; 
	byte[] data;
	
	public DownloadJob(URL u) {
		url = u;
		jobId = UUID.randomUUID().toString();
	}

	public URL getUrl() {
		return url;
	}

	public String getJobId() {
		return jobId;
	}


	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public void run() {
		data = DownloadManager.downloadFromURL(getUrl());
		
	}
	
	

}
